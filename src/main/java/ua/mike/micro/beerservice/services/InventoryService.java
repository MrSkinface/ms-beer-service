package ua.mike.micro.beerservice.services;

import java.util.UUID;

public interface InventoryService {

    String INVENTORY_PATH = "/api/inventory/beer/{id}";

    Integer getQtyOnHand(UUID beerId);
}
