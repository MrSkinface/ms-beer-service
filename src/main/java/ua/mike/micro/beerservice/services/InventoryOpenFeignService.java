package ua.mike.micro.beerservice.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by mike on 13.06.2022 13:42
 */
@Slf4j
@Service
@Profile("local-discovery")
@RequiredArgsConstructor
public class InventoryOpenFeignService implements InventoryService {

    private final InventoryOpenFeignClient feign;

    @Override
    public Integer getQtyOnHand(UUID beerId) {
        final var qty = feign.getQtyOnHand(beerId);
        log.trace("FeignClient: qty-on-hand {} for beer: {}", qty, beerId);
        return qty;
    }
}
