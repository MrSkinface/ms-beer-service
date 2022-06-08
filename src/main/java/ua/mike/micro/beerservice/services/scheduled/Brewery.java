package ua.mike.micro.beerservice.services.scheduled;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ua.mike.micro.beerservice.dto.events.BrewBeerRequest;
import ua.mike.micro.beerservice.services.BeerService;
import ua.mike.micro.jms.Queue;

/**
 * Created by mike on 08.06.2022 11:24
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class Brewery {

    private static final long initDelay = 10 * 1000;
    private static final long fixedRate = 15 * 1000;

    private final BeerService beer;
    private final JmsTemplate jms;

    @Scheduled(initialDelay = initDelay, fixedRate = fixedRate)
    public void searchForEmptyInventoryAndBrew() {
        beer.list(true).stream().filter(beer -> beer.getQuantityOnHand() == 0).forEach(beer -> {
            jms.convertAndSend(Queue.BREW_BEER_QUEUE, BrewBeerRequest.builder().beer(beer).build());
            log.debug("Sent brew beer request for: {}", beer.getBeerName());
        });
    }
}
