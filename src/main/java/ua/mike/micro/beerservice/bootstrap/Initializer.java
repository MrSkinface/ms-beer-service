package ua.mike.micro.beerservice.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.mike.micro.beerservice.models.Beer;
import ua.mike.micro.beerservice.models.BeerStyle;
import ua.mike.micro.beerservice.repo.BeerRepo;

import java.math.BigDecimal;

@Component
@Slf4j
public class Initializer implements CommandLineRunner {

    private final BeerRepo repo;

    public Initializer(BeerRepo repo) {
        this.repo = repo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repo.count() == 0) {
            loadBeers();
        } else
            log.warn("Repository is not empty, will not bootstrap anything");
    }

    private void loadBeers() {
        repo.save(Beer.builder()
                        .beerName("Obolon'")
                        .beerStyle(BeerStyle.LAGER)
                        .upc(878787L)
                        .price(new BigDecimal("25.50"))
                        .build());
        repo.save(Beer.builder()
                        .beerName("Velkopopovyzky Kozel")
                        .beerStyle(BeerStyle.STOUT)
                        .upc(121212L)
                        .price(new BigDecimal("29.50"))
                        .build());
        repo.save(Beer.builder()
                        .beerName("Budweiser")
                        .beerStyle(BeerStyle.ALE)
                        .upc(232323L)
                        .price(new BigDecimal("33.75"))
                        .build());
        log.info("Beers loaded: {}", repo.count());
    }
}
