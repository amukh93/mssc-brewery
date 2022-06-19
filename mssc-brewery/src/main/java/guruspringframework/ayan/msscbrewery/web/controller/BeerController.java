package guruspringframework.ayan.msscbrewery.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guruspringframework.ayan.msscbrewery.web.module.BeerDTO;

@RestController
@RequestMapping("api/v1/beer")
public class BeerController {

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BeerDTO> getBeer(){
		
		return new ResponseEntity<BeerDTO>(BeerDTO.builder().build(), HttpStatus.OK);

	}
	
		

}


