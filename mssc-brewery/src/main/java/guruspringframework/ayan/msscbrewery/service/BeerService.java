package guruspringframework.ayan.msscbrewery.service;

import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import guruspringframework.ayan.msscbrewery.web.module.BeerDTO;


public interface BeerService {
	
	public BeerDTO getBeerById(UUID beerId);

	public BeerDTO saveNewBeer(BeerDTO beer);

	public void deleteBeer(UUID beerId);
	
	
}
