package com.cg.dms.controller;

import javax.validation.Valid;

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

import com.cg.dms.entities.PayToFarmer;
import com.cg.dms.service.PaytoFarmerService;

@RestController
@RequestMapping("/paytofarmer")
@CrossOrigin(origins = "*")
public class PayToFarmerController {

	@Autowired
	private PaytoFarmerService paytofarmerservice;
	
	
	private static final Logger LOG = LoggerFactory.getLogger(PayToFarmerController.class);
	
	@PostMapping("/payment")
	public ResponseEntity<PayToFarmer> companyPayToFarmer(@Valid @RequestBody PayToFarmer payment) {
		LOG.info("companyPayToFarmer controller");
		PayToFarmer pay = paytofarmerservice.companyPayToFarmer(payment);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","Company successfully paid to farmer");
		ResponseEntity<PayToFarmer> response = new ResponseEntity<PayToFarmer>(pay,headers,HttpStatus.OK);
		LOG.info("Transaction is completed");
		return response;
	}

}
