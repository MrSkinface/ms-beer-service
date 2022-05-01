package ua.mike.microbeerservice.services;

import org.springframework.stereotype.Service;
import ua.mike.microbeerservice.models.Beer;

import java.util.UUID;

@Service
public interface BeerService {

    Beer get(UUID id);

    Beer save(Beer beer);

    Beer update(UUID id, Beer beer);
}
