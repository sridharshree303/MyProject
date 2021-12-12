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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dms.entities.Company;
import com.cg.dms.entities.Farmer;
import com.cg.dms.exception.CompanyNotFoundException;
import com.cg.dms.exception.FarmerAlreadyExistsException;
import com.cg.dms.exception.FarmerNotFoundException;
import com.cg.dms.service.FarmerService;

@RestController
@RequestMapping("/farmer")
public class FarmerController {

	private static final Logger LOG = LoggerFactory.getLogger(FarmerController.class);

	@Autowired
	private FarmerService iFarmerService;

	@GetMapping("/all")
	public List<Farmer> getAllFarmer() {
		return iFarmerService.getAllFarmer();
	}

	@PostMapping("/add")
	public ResponseEntity<Farmer> addFarmer(@Valid @RequestBody Farmer farmer) throws FarmerAlreadyExistsException {
		LOG.info("Controller addfarmer");
		Farmer former = iFarmerService.addFarmer(farmer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", " New former is added to the Database");
		LOG.info(headers.toString());
		ResponseEntity<Farmer> response = new ResponseEntity<Farmer>(former, headers, HttpStatus.OK);
		return response;
	}

	@PutMapping("/update")
	public ResponseEntity<Farmer> updateFarmer(@Valid @RequestBody Farmer farmer) throws FarmerNotFoundException {
		LOG.info("Controller updatefarmer");
		Farmer former = iFarmerService.updateFarmer(farmer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", " farmer data is updated in database.");
		ResponseEntity<Farmer> response = new ResponseEntity<Farmer>(former, headers, HttpStatus.OK);
		return response;
	}

	@GetMapping("/get/{farmerId}")
	public ResponseEntity<Farmer> getFarmerById(@Valid @PathVariable(name = "farmerId") int farmerId)
			throws FarmerNotFoundException {
		LOG.info("getFarmer");
		Farmer farmer = iFarmerService.getFarmer(farmerId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Farmer Id is Found ");
		ResponseEntity<Farmer> response = new ResponseEntity<Farmer>(farmer, headers, HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/delete/{farmerId}")
	public ResponseEntity<Farmer> deleteFarmerById(@Valid @PathVariable(name = "farmerId") int farmerId)
			throws FarmerNotFoundException {
		LOG.info("deleteFarmerById controller");
		Farmer farmer = iFarmerService.deleteFarmer(farmerId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "farmer is deleted from the database");
		ResponseEntity<Farmer> response = new ResponseEntity<Farmer>(farmer, headers, HttpStatus.OK);
		return response;

	}

}
