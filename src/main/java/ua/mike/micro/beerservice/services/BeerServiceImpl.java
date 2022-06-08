package ua.mike.micro.beerservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ua.mike.micro.beerservice.dto.BeerDto;
import ua.mike.micro.beerservice.dto.mappers.BeerMapper;
import ua.mike.micro.beerservice.exceptions.UniqueConstraintException;
import ua.mike.micro.beerservice.repo.BeerRepo;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepo repo;
    private final BeerMapper mapper;

    @Override
    @Cacheable(cacheNames = "cache", condition = "#showInventory == false")
    public List<BeerDto> list(Boolean showInventory) {
        return repo.findAll().stream()
                .map(beer -> mapper.toDto(beer, showInventory))
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable(cacheNames = "cache", condition = "#showInventory == false")
    public BeerDto get(UUID id, Boolean showInventory) {
        return repo.findById(id).map(beer -> mapper.toDto(beer, showInventory)).orElse(null);
    }

    @Override
    public BeerDto save(BeerDto dto) {
        repo.findByUpc(Long.parseLong(dto.getUpc())).ifPresent(beer -> {
            throw new UniqueConstraintException("Beer with upc " + dto.getUpc() + " already exist: " + beer.getId());
        });
        return mapper.toDto(repo.save(mapper.fromDto(dto)));
    }

    @Override
    public BeerDto update(UUID id, BeerDto dto) {
        dto.setId(id);
        return this.save(dto);
    }
}
