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
import com.cg.dms.exception.CompanyNotFoundException;
import com.cg.dms.service.CompanyService;

@RestController
@RequestMapping("/company")
@CrossOrigin(origins = "*")
public class CompanyController {

	private static final Logger LOG = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	private CompanyService iCompanyService;

	@PostMapping("/add")
	public ResponseEntity<Company> addcompany(@Valid @RequestBody Company company) throws CompanyNotFoundException {
		LOG.info("Controller addCompany");
		Company comp = iCompanyService.insertCompany(company);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", " New company is added to the Database");
		ResponseEntity<Company> response = new ResponseEntity<Company>(comp, headers, HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/delete/{companyid}")
	public ResponseEntity<Company> deletecompanyById(@Valid @PathVariable(name = "companyid") int companyid)
			throws CompanyNotFoundException {
		LOG.info("deletecompanybyid");
		Company company = iCompanyService.deleteCompany(companyid);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", " company is deleted from the Database");
		ResponseEntity<Company> response = new ResponseEntity<Company>(company, headers, HttpStatus.OK);
		return response;
	}

	@PutMapping("/update")
	public ResponseEntity<Company> updatecompany(@Valid @RequestBody Company company) throws CompanyNotFoundException {
		LOG.info("Controller company");
		Company comp = iCompanyService.updateCompany(company);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", " company data is updated in database.");
		ResponseEntity<Company> response = new ResponseEntity<Company>(comp, headers, HttpStatus.OK);
		return response;
	}

	@GetMapping("/get/{companyId}")
	public ResponseEntity<Company> getcompanyById(@Valid @PathVariable(name = "companyId") int companyId)
			throws CompanyNotFoundException {
		LOG.info("getcompanyById");
		Company company = iCompanyService.getCompanyById(companyId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "company is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Company> response = new ResponseEntity<Company>(company, headers, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Company>> getAllCompany(){
		LOG.info("get all Companies");
		List<Company> list = iCompanyService.getAllCompany();
		HttpHeaders headers = new HttpHeaders();
		headers.add("message"," Company Details are resulted");
		ResponseEntity<List<Company>> response = new ResponseEntity<List<Company>>(list,headers,HttpStatus.OK);
		return response;
	}
	
	
}












