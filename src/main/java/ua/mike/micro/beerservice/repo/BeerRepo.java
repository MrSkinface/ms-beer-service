package ua.mike.micro.beerservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mike.micro.beerservice.models.Beer;


import java.util.Optional;
import java.util.UUID;

public interface BeerRepo extends JpaRepository<Beer, UUID> {

    Optional<Beer> findByUpc(Long upc);
}
