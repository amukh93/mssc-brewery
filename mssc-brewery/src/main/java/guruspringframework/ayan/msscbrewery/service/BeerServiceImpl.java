package guruspringframework.ayan.msscbrewery.service;

import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import guruspringframework.ayan.msscbrewery.web.module.BeerDTO;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDTO getBeerById(UUID beerId) {
		// TODO Auto-generated method stub
		return BeerDTO.builder().uid(UUID.randomUUID())
				.beerName("Kingfisher Premium")
				.beerStyle("Single Mault")
				.upc(new Random().nextLong())
				.build();
	}

	@Override
	public BeerDTO saveNewBeer(BeerDTO beer) {
		// TODO Auto-generated method stub
		return BeerDTO.builder().beerName(beer.getBeerName()).beerStyle(beer.getBeerStyle()).uid(UUID.randomUUID()).upc(beer.getUpc()).build();
	}

	@Override
	public void deleteBeer(UUID beerId) {
		log.info("deleting with "+beerId);
		
	}
	
	

}
