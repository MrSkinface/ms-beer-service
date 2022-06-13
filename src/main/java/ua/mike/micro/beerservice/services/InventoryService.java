package ua.mike.micro.beerservice.services;

import java.util.UUID;

public interface InventoryService {

    String INVENTORY_PATH = "/api/inventory/beer/{id}";
    String FALLBACK_PATH = "/inventory/failover";

    Integer getQtyOnHand(UUID beerId);
}
