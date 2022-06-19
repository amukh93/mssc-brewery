package guruspringframework.ayan.msscbrewery.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import guruspringframework.ayan.msscbrewery.web.module.BeerDTO;

@Service
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

}
