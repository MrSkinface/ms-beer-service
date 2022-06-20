package ua.mike.micro.beerservice.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@Profile("!cloud")
public class InventoryRestTemplateService implements InventoryService {
    @Value("${ms.inventory.service.host}")
    private String INVENTORY_URL;
    @Value("${ms.inventory.service.user}")
    private String inventoryUser;
    @Value("${ms.inventory.service.pass}")
    private String inventoryPass;

    private final RestTemplate rest;

    public InventoryRestTemplateService(RestTemplateBuilder builder) {
        this.rest = builder
                .basicAuthentication(inventoryUser, inventoryPass)
                .build();
    }

    @Override
    public Integer getQtyOnHand(UUID beerId) {
        return rest.getForObject(INVENTORY_URL + INVENTORY_PATH, Integer.class, beerId);
    }
}
