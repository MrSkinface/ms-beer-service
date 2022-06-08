package ua.mike.micro.beerservice.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class InventoryServiceImpl implements InventoryService {

    private static final String INVENTORY_PATH = "/api/inventory/beer/{id}";

    @Value("${ms.inventory.service.host}")
    private String INVENTORY_URL;

    private final RestTemplate rest;

    public InventoryServiceImpl(RestTemplateBuilder builder) {
        this.rest = builder.build();
    }

    @Override
    public Integer getQtyOnHand(UUID beerId) {
        return rest.getForObject(INVENTORY_URL + INVENTORY_PATH, Integer.class, beerId);
    }
}
