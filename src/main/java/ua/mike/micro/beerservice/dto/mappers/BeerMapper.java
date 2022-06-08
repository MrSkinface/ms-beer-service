package ua.mike.micro.beerservice.dto.mappers;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import ua.mike.micro.beerservice.dto.BeerDto;
import ua.mike.micro.beerservice.models.Beer;

@Mapper
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {

    Beer fromDto(BeerDto dto);

    default BeerDto toDto(Beer beer) {
        return this.toDto(beer, false);
    }

    BeerDto toDto(Beer beer, Boolean withInventory);
}
