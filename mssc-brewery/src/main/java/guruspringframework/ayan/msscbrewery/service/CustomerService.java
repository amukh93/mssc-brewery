package guruspringframework.ayan.msscbrewery.service;

import java.util.UUID;

import guruspringframework.ayan.msscbrewery.web.module.CustomerDTO;

public interface CustomerService {
	CustomerDTO getCustomerByID(UUID custId);
}
