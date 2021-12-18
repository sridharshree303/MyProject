package com.cg.dms.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dms.entities.Company;
import com.cg.dms.entities.Dealer;
import com.cg.dms.exception.DealerNotFoundException;
import com.cg.dms.service.CompanyService;
import com.cg.dms.service.DealerService;

@RestController
@RequestMapping("/dealer")
@CrossOrigin(origins = "*")
public class DealerController {

	private static final Logger LOG = LoggerFactory.getLogger(DealerController.class);

	@Autowired
	private DealerService idealerService;
	

	@PostMapping("/add")
	public ResponseEntity<Dealer> adddealer(@Valid @RequestBody Dealer dealer) throws DealerNotFoundException {
		LOG.info("Controller addDealer");
		Dealer deal = idealerService.insertDealer(dealer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", " New Dealer is added to the Database");
		ResponseEntity<Dealer> response = new ResponseEntity<Dealer>(deal, headers, HttpStatus.OK);
		return response;
	}

	@GetMapping("/get/{dealerId}")
	public ResponseEntity<Dealer> getDealById(@Valid @PathVariable(name = "dealerId") int dealerId)
			throws DealerNotFoundException {
		LOG.info("getdealById");
		Dealer deal = idealerService.getDealer(dealerId);
		LOG.info(deal.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", " dealer is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Dealer> response = new ResponseEntity<Dealer>(deal, headers, HttpStatus.OK);
		return response;
	}

	@PutMapping("/update")
	public ResponseEntity<Dealer> updateEmp(@Valid @RequestBody Dealer dealer) throws DealerNotFoundException {
		LOG.info("Controller updatedealer");
		Dealer deal = idealerService.updateDealer(dealer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", " dealer data is updated in database.");
		ResponseEntity<Dealer> response = new ResponseEntity<Dealer>(deal, headers, HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/delete/{dealerid}")
	public ResponseEntity<Dealer> deletedealById(@Valid @PathVariable(name = "dealerid") int dealerid)
			throws DealerNotFoundException {
		LOG.info("deletedealerbyid");
		Dealer dealer = idealerService.deleteDealer(dealerid);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", " dealer is deleted from the Database");
		LOG.info(headers.toString());
		ResponseEntity<Dealer> response = new ResponseEntity<Dealer>(dealer, headers, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Dealer>> getAllDealers(){
		LOG.info("get All Dealers");
		List<Dealer> list = idealerService.getAllDealers();
		HttpHeaders headers = new HttpHeaders();
		headers.add("message"," Dealer Details are resulted");
		ResponseEntity<List<Dealer>> response = new ResponseEntity<List<Dealer>>(list,headers,HttpStatus.OK);
		return response;
	}
}
