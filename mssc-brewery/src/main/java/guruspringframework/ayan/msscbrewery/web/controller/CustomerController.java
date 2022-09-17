package guruspringframework.ayan.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import guruspringframework.ayan.msscbrewery.service.CustomerService;
import guruspringframework.ayan.msscbrewery.web.module.CustomerDTO;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
	
	
	private CustomerService customerService;
	
	/*
	 * note : if only constructor present, spring autowires it itself and @Autowired
	 * not needed, the program will run fine if @Autowire removed
	 */
	@Autowired
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	@GetMapping({"/{custId}"})
	private ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("custId") UUID custId){
		return new ResponseEntity<CustomerDTO>(customerService.getCustomerByID(custId), HttpStatus.OK);
		
		
	}
	
	
	

}
