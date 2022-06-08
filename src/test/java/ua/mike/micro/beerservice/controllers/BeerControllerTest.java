package ua.mike.micro.beerservice.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ua.mike.micro.beerservice.dto.BeerDto;
import ua.mike.micro.beerservice.models.BeerStyle;
import ua.mike.micro.beerservice.services.BeerService;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class BeerControllerTest {

    @Autowired
    private MockMvc mvc;

    private BeerDto beer;
    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private BeerService service;

    @BeforeEach
    void setUp() {
        beer = BeerDto.builder()
                .beerName("Some beer")
                .beerStyle(BeerStyle.GOSE)
                .price(new BigDecimal("100.05"))
                .upc("12121212")
                .build();
    }

    @Test
    void getTest() throws Exception {
        when(service.get(any(), anyBoolean())).thenReturn(beer);
        mvc.perform(get("/api/beer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void save() throws Exception {
        when(service.save(any())).thenReturn(beer);
        mvc.perform(post("/api/beer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(beer)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("location"));
    }

    @Test
    void update() throws Exception {
        mvc.perform(put("/api/beer/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(beer)))
                .andExpect(status().isNoContent());
    }
}