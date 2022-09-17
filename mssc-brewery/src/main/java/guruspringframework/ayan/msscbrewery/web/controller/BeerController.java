package guruspringframework.ayan.msscbrewery.web.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	
	
	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Objects> createBeerEntry(@RequestBody BeerDTO beer, @RequestHeader HttpHeaders header){
		BeerDTO newBeer = beerService.saveNewBeer(beer);
		
		header.add("UUID", newBeer.getUid().toString());
		if (header.getHost() != null) {
			header.add("getPathURL", "http://" + header.getHost().getHostName()+":"+header.getHost().getPort()+"/api/v1/beer/"+newBeer.getUid());
		}
		
		URI location = header.getLocation();
		
		return ResponseEntity.created(location).headers(header).build();
		
	}

	
	
	@DeleteMapping("/{beerId}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT, reason = "Delete Operation with no content to show")
	public void deleteBeer(@PathVariable UUID beerId) {
		
		beerService.deleteBeer(beerId);
		
	}
	
	
	
	
		

}


