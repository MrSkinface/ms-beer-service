package ua.mike.micro.beerservice.dto.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Created by mike on 08.06.2022 11:39
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NewInventoryRequest {

    private UUID beerId;
    private Long brewed;
}
