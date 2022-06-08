package ua.mike.micro.beerservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import ua.mike.micro.beerservice.models.BeerStyle;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto implements Serializable  {

    @Null
    private UUID id;
    @NotBlank
    @Length(min = 3, max = 100)
    private String beerName;
    @NotNull
    private BeerStyle beerStyle;
    @NotNull
    @Pattern(regexp = "\\d+")
    private String upc;
    @Positive
    @NotNull
    private BigDecimal price;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer quantityOnHand;

}
