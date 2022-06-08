package ua.mike.micro.beerservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by mike on 08.06.2022 11:24
 */
@Configuration
@EnableScheduling
@EnableAsync
public class ScheduledTasksConfig {
}
