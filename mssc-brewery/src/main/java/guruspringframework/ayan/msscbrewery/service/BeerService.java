package guruspringframework.ayan.msscbrewery.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guruspringframework.ayan.msscbrewery.web.module.BeerDTO;


public interface BeerService {
	
	BeerDTO getBeerById(UUID beerId);
	
	
}
