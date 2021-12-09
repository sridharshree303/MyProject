package com.cg.dms.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dms.entities.Customer;
import com.cg.dms.exception.CustomerNotFoundException;
import com.cg.dms.service.CustomerService;

@RestController
public class CustomerController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CustomerService customerservice;
	
	
	@GetMapping("/customer/all")
	public List<Customer> viewCustomers() throws CustomerNotFoundException{
		LOG.info("VIEW_ALL_CUSTOMERS_CONTROLLER");
		List<Customer> list = customerservice.viewCustomers();
		return list;
	}
	
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> insertCustomer(@Valid @RequestBody Customer customer) throws CustomerNotFoundException {
		LOG.info("INSERT_CUSTOMER_CONTROLLER");
		Customer custom = customerservice.insertCustomer(customer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","new Customer data is added to database");
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(custom,headers,HttpStatus.OK);
		return response;
	}
	

	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer) throws CustomerNotFoundException {
		LOG.info("UPDATE_CUSTOMER_CONTROLLER");
		Customer custom = customerservice.updateCustomer(customer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","Customer data is Updated");
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(custom,headers,HttpStatus.OK);
		return response;
	}
	
	
	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<Customer> deleteCustomerById(@Valid @PathVariable int customerId) throws CustomerNotFoundException {
		LOG.info("DELETE_CUSTOMER_BY_ID_CONTROLLER");
		Customer custom = customerservice.deleteCustomer(customerId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Customer Data is removed successfully");
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(custom,headers,HttpStatus.OK);
		return response;
	}
	
	
	@GetMapping("/customer/_/{customerId}")
	public ResponseEntity<Customer> viewCustomerById(@Valid @PathVariable(name="customerId") int customerId) throws CustomerNotFoundException {
		LOG.info("VIEW_CUSTOMER_BY_ID");
		Customer custom = customerservice.viewCustomer(customerId);
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Customer> response;
		if(null != custom) {
			headers.add("message"," Customer data found in database");
			LOG.info(headers.toString());
			response = new ResponseEntity<Customer>(custom,headers,HttpStatus.OK);
			return response;
		}else {
			headers.add("message"," Customer data Not found in database");
			LOG.info(headers.toString());
			response = new ResponseEntity<Customer>(custom,headers,HttpStatus.NOT_FOUND);
			return response;
			
		}
	}
	
	
	
	

}
