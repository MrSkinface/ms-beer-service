package ua.mike.micro.beerservice.dto.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import ua.mike.micro.beerservice.dto.BeerDto;
import ua.mike.micro.beerservice.models.Beer;
import ua.mike.micro.beerservice.services.InventoryService;

public abstract class BeerMapperDecorator implements BeerMapper {

    private InventoryService service;
    private BeerMapper mapper;

    @Autowired
    public void setService(InventoryService service) {
        this.service = service;
    }

    @Autowired
    public void setMapper(BeerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BeerDto toDto(Beer beer, Boolean withInventory) {
        final var dto = mapper.toDto(beer);
        if (withInventory) dto.setQuantityOnHand(service.getQtyOnHand(beer.getId()));
        return dto;
    }
}
