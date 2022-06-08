package ua.mike.micro.beerservice.services.jms;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ua.mike.micro.beerservice.dto.events.BrewBeerRequest;
import ua.mike.micro.beerservice.dto.events.NewInventoryRequest;
import ua.mike.micro.beerservice.dto.events.ValidateOrderRequest;
import ua.mike.micro.beerservice.dto.events.ValidateOrderResult;
import ua.mike.micro.beerservice.repo.BeerRepo;
import ua.mike.micro.jms.JmsConsumerActions;
import ua.mike.micro.jms.Queue;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * Created by mike on 31.05.2022 16:30
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class Listeners {

    private final JmsTemplate jms;
    private final BeerRepo repo;
    private final JmsConsumerActions actions;

    @JmsListener(destination = Queue.VALIDATE_ORDER_QUEUE)
    public void validateOrderListener(String data) {
        actions.consume(data, ValidateOrderRequest.class, request -> {
            final var order = request.getOrder();
            log.debug("Validating order {}", order.getId());
            final var errors = new HashSet<String>();
            // validating
            order.getLines().forEach(line -> {
                repo.findById(line.getBeerId()).ifPresentOrElse(beer -> {}, () -> {
                    errors.add("Beer " + line.getBeerId() + " not exist");
                });
            });
            jms.convertAndSend(Queue.VALIDATE_ORDER_RESPONSE_QUEUE, ValidateOrderResult.builder()
                    .orderUUID(order.getId())
                    .isValid(errors.size() == 0)
                    .errors(errors).build());
            log.debug("Results: err_cnt: {} errors: {}", errors.size(), errors);
        });
    }

    @JmsListener(destination = Queue.BREW_BEER_QUEUE)
    public void brewery(String data) {
        actions.consume(data, BrewBeerRequest.class, request -> {
            log.debug("Got brew-request. Brewing {} .....", request.getBeer().getBeerName());
            TimeUnit.SECONDS.sleep(5);
            jms.convertAndSend(Queue.NEW_INVENTORY_QUEUE, NewInventoryRequest.builder()
                    .beerId(request.getBeer().getId()).brewed(75L).build());
            log.debug("Sent new-inventory-request");
        });
    }
}
