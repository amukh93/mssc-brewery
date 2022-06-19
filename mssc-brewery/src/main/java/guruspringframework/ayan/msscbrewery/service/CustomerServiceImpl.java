package guruspringframework.ayan.msscbrewery.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guruspringframework.ayan.msscbrewery.web.module.CustomerDTO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public CustomerDTO getCustomerByID(UUID custId) {
		
		return CustomerDTO.builder().id(custId)
									.name("Chandler").build();
	}

}
