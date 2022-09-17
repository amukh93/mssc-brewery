package guruspringframework.ayan.msscbrewery;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import guruspringframework.ayan.msscbrewery.web.controller.BeerController;
import guruspringframework.ayan.msscbrewery.web.module.BeerDTO;

@WebMvcTest(BeerController.class)

class BeerControllerTest {

	@Autowired
	MockMvc mock;
	
	@Autowired
	ObjectMapper objmapr;
	
	@Test
	void testGetBeer() throws Exception {
		mock.perform(get("/api/v1/beer/"+ UUID.randomUUID())
											.accept(MediaType.APPLICATION_JSON_VALUE))
											.andExpect(status().isOk());
		
		
	}

	@Test
	void testCreateBeerEntry() throws Exception {
		
		BeerDTO beerDto = BeerDTO.builder().uid(UUID.randomUUID()).beerName("Carlsburg").beerStyle("Lager").upc(new Random().nextLong()).build();
		
		String beerDtoJson = objmapr.writeValueAsString(beerDto);
		
		mock.perform(post("/api/v1/beer/create").accept(MediaType.APPLICATION_JSON_VALUE).contentType(MediaType.APPLICATION_JSON_VALUE).content(beerDtoJson)).andExpect(status().isCreated());
	}

}