package ua.mike.micro.beerservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ua.mike.micro.beerservice.dto.BeerDto;
import ua.mike.micro.beerservice.services.BeerService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/beer")
public class BeerController {

    private final BeerService service;

    public BeerController(BeerService service) {
        this.service = service;
    }

    @GetMapping
    public List<BeerDto> list(@RequestParam(required = false) boolean showInventory) {
        return service.list(showInventory);
    }

    @GetMapping("/{id}")
    public BeerDto get(@PathVariable("id") UUID id, @RequestParam(required = false) boolean showInventory) {
        return service.get(id, showInventory);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> save(@Valid @RequestBody BeerDto beer) {
        final var saved = service.save(beer);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri()).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable("id") UUID id, @Valid @RequestBody BeerDto beer) {
        service.update(id, beer);
    }
}
