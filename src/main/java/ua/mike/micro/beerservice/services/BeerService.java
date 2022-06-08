package ua.mike.micro.beerservice.services;

import ua.mike.micro.beerservice.dto.BeerDto;

import java.util.List;
import java.util.UUID;

public interface BeerService {

    List<BeerDto> list(Boolean showInventory);

    BeerDto get(UUID id, Boolean showInventory);

    BeerDto save(BeerDto dto);

    BeerDto update(UUID id, BeerDto dto);
}
