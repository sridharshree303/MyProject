package com.cg.dms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.entities.Customer;
import com.cg.dms.entities.Farmer;
import com.cg.dms.exception.CustomerAlreadyExistsException;
import com.cg.dms.exception.CustomerNotFoundException;
import com.cg.dms.exception.FarmerNotFoundException;
import com.cg.dms.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService{

	private Customer tempCustomer;
	
	public boolean isLoggedIn;
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private ICustomerRepository icustomerRepository;

	public List<Customer>viewCustomers() throws CustomerNotFoundException{
		LOG.info("Get All Customer Services");
		return icustomerRepository.findAll();
	}

	public Customer insertCustomer(Customer customer) throws CustomerAlreadyExistsException {
		LOG.info("add New Customer Service");
		Optional<Customer> custom = icustomerRepository.findById(customer.getCustomerId());
		if(custom.isPresent())
			throw new CustomerAlreadyExistsException(customer.getCustomerId()+"is already present in Customer data");
		else
			LOG.info("added new Customer");
			return icustomerRepository.save(customer);		
	}

	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException {
		LOG.info("Update customer Service");
		if (icustomerRepository.existsById(customer.getCustomerId())) {
			LOG.info("Update customer service");
			return icustomerRepository.save(customer);
		}else {
		LOG.info(customer.getCustomerId()+" Customer data is Not updated");
		throw new CustomerNotFoundException("Customer data is Not updated");
		}
	}

	public Customer deleteCustomer(int customerId) throws CustomerNotFoundException {
		LOG.info("Delete Customer By CustomerId");
		Optional<Customer> customId = icustomerRepository.findById(customerId);
		if (customId.isPresent()) {
			LOG.info("Customer is available");
			icustomerRepository.deleteById(customerId);
			return customId.get();
		} else {
			LOG.info("Customer Data not Found");
			throw new CustomerNotFoundException(customerId + " --> customer Id not found ");
		}
	}

	public Customer viewCustomer(int customerId) throws CustomerNotFoundException {
		LOG.info("View customer by customerId");
		Optional<Customer> customId = icustomerRepository.findById(customerId);
		if (customId.isPresent()) {
			LOG.info("Customer Data Found");
			return customId.get();
		} else {
			LOG.info("Customer Data not Found");
			throw new CustomerNotFoundException(customerId + " --> customer Id not found ");
		}
	}


}
