package ua.mike.micro.beerservice.dto.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.mike.micro.beerservice.dto.BeerDto;

/**
 * Created by mike on 08.06.2022 11:32
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrewBeerRequest {

    private BeerDto beer;
}
