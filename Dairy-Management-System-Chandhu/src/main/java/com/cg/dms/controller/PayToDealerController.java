package com.cg.dms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dms.entities.PayToDealer;
import com.cg.dms.service.PayToDealerService;

@RestController
@RequestMapping("/paytodealer")
@CrossOrigin(origins = "*")
public class PayToDealerController {

	@Autowired
	private PayToDealerService paytodealerservice;
	
	private static final Logger LOG = LoggerFactory.getLogger(PayToDealerController.class);
	
	@PostMapping("/payment")
	public ResponseEntity<PayToDealer> customerPayToDealer(@RequestBody PayToDealer transaction){
		LOG.info("customerPayToDealer controller");
		PayToDealer pay = paytodealerservice.customerPayToDealer(transaction);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","Customer successfully paid to Dealer");
		ResponseEntity<PayToDealer> response = new ResponseEntity<PayToDealer>(pay,headers,HttpStatus.OK);
		LOG.info("Transaction is completed");
		return response;
	}
}
