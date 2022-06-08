package ua.mike.micro.beerservice.dto.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ua.mike.micro.beerservice.dto.OrderDto;

/**
 * Created by mike on 31.05.2022 15:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValidateOrderRequest {

    private OrderDto order;
}
