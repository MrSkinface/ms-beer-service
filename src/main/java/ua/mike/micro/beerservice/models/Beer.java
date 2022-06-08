package ua.mike.micro.beerservice.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Beer implements Serializable {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;
    @CreationTimestamp
    @Column(updatable = false)
    private OffsetDateTime createDateTime;
    @UpdateTimestamp
    private OffsetDateTime updateDateTime;
    @Column(columnDefinition = "varchar(255)")
    private String beerName;
    @Enumerated(EnumType.STRING)
    private BeerStyle beerStyle;
    @Column(unique = true)
    private Long upc;
    private BigDecimal price;
}
