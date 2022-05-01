package ua.mike.microbeerservice.services;

import org.springframework.stereotype.Service;
import ua.mike.microbeerservice.models.Beer;
import ua.mike.microbeerservice.repo.BeerRepo;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepo repo;

    public BeerServiceImpl(BeerRepo repo) {
        this.repo = repo;
    }

    @Override
    public Beer get(UUID id) {
        return repo.getById(id);
    }

    @Override
    public Beer save(Beer beer) {
        return repo.save(beer);
    }

    @Override
    public Beer update(UUID id, Beer beer) {
        beer.setId(id);
        return this.save(beer);
    }
}
