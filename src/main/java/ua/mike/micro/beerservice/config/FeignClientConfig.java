package ua.mike.micro.beerservice.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mike on 20.06.2022 10:12
 */
@Configuration
public class FeignClientConfig {

    @Value("${ms.inventory.service.user}")
    private String inventoryUser;
    @Value("${ms.inventory.service.pass}")
    private String inventoryPass;

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor(inventoryUser, inventoryPass);
    }
}
