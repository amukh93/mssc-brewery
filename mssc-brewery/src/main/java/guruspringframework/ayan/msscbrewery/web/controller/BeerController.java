package guruspringframework.ayan.msscbrewery.web.controller;

import java.util.UUID;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import guruspringframework.ayan.msscbrewery.service.BeerService;
import guruspringframework.ayan.msscbrewery.web.module.BeerDTO;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
	
	@Autowired
	private BeerService beerService;

	@GetMapping( {"/{beerId}"})
	public ResponseEntity<BeerDTO> getBeer(@PathVariable("beerId") UUID beerID){
		
		return new ResponseEntity<BeerDTO>(beerService.getBeerById(beerID), HttpStatus.OK);

	}

	
	
		

}


