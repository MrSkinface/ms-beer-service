package ua.mike.microbeerservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.mike.microbeerservice.models.Beer;


import java.util.UUID;

public interface BeerRepo extends JpaRepository<Beer, UUID> {

}
