package ua.mike.micro.beerservice.services;

import java.util.UUID;

public interface InventoryService {

    Integer getQtyOnHand(UUID beerId);
}
