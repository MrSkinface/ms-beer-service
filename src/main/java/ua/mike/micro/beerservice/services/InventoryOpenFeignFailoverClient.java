package ua.mike.micro.beerservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

/**
 * Created by mike on 13.06.2022 13:45
 */
@FeignClient("ms-inventory-failover")
public interface InventoryOpenFeignFailoverClient {

    @RequestMapping(method = RequestMethod.GET, path = InventoryService.FALLBACK_PATH)
    Integer getQtyOnHand();

}
