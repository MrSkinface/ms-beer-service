package ua.mike.micro.beerservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class MicroBeerServiceApplicationTestsDto {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        System.out.println(context);
    }

}
