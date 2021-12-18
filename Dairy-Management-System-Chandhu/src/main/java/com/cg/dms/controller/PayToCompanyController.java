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

import com.cg.dms.entities.PayToCompany;
import com.cg.dms.service.PayToCompanyService;

@RestController
@RequestMapping("/paytocompany")
@CrossOrigin(origins = "*")
public class PayToCompanyController {

	private static final Logger LOG = LoggerFactory.getLogger(PayToFarmerController.class);
	@Autowired
	private PayToCompanyService paytocompanyservice;
	
	@PostMapping("/payment")
	public ResponseEntity<PayToCompany> dealerPayToCompany(@Valid @RequestBody PayToCompany transaction){
		
		LOG.info("dealerPayToCompany controller");
		PayToCompany pay = paytocompanyservice.dealerPayToCompany(transaction);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","Dealer successfully paid to company");
		ResponseEntity<PayToCompany> response = new ResponseEntity<PayToCompany>(pay,headers,HttpStatus.OK);
		LOG.info("Transaction is completed");
		return response;
	}
	
	
	
}
