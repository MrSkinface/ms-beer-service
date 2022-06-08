package ua.mike.micro.beerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MicroBeerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroBeerServiceApplication.class, args);
    }

}
