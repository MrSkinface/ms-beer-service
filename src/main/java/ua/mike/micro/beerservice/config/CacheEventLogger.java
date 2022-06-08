package ua.mike.micro.beerservice.config;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CacheEventLogger implements CacheEventListener<Object, Object> {

    @Override
    public void onEvent(CacheEvent<?, ?> event) {
        log.info("CacheEventListener [{}]: [{}] => [{}]", event.getType(), event.getOldValue(), event.getNewValue());
    }
}
