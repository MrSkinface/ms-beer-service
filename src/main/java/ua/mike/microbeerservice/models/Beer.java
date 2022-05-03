package ua.mike.microbeerservice.models;

import lombok.*;
import lombok.extern.jackson.Jacksonized;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Jacksonized
public class Beer {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    @Version
    private Integer version;
    @Null
    @CreationTimestamp
    @Column(updatable = false)
    private OffsetDateTime createDateTime;
    @Null
    @UpdateTimestamp
    private OffsetDateTime updateDateTime;
    @NotBlank
    @Length(min = 3, max = 100)
    @Column(columnDefinition = "varchar(255)")
    private String beerName;
    @NotNull
    private BeerStyle beerStyle;
    @Positive
    @Column(unique = true)
    private Long upc;
    @NotNull
    @Positive
    private BigDecimal price;
    private Long qtyOnStock;
    private Long qtyToBrew;
}
