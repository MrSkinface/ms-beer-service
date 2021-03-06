package ua.mike.micro.beerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCaching
@EnableFeignClients
@EnableHystrix
@SpringBootApplication
public class MicroBeerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroBeerServiceApplication.class, args);
    }

}
