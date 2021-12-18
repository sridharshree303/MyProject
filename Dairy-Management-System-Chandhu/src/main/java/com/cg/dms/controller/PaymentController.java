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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dms.entities.CompanyBuysMilk;
import com.cg.dms.entities.CompanySellsMilk;
import com.cg.dms.entities.DealerSellsMilk;
import com.cg.dms.entities.Payment;
import com.cg.dms.exception.FarmerNotFoundException;
import com.cg.dms.exception.InvalidTransactionException;
import com.cg.dms.service.CompanyBuysMilkService;
import com.cg.dms.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*")
public class PaymentController {

	@Autowired
	private PaymentService paymentservice;

	@Autowired
	private CompanyBuysMilkService companybuysmilksservice;

	private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);

	@PostMapping("/company/buys")
	public ResponseEntity<Payment> companyBuyMilk(@Valid @RequestBody CompanyBuysMilk transaction)
			throws InvalidTransactionException {
		LOG.info("CompanyBuysMilkDataController");
		Payment pay = paymentservice.companyBuysMilkData(transaction);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Milk Buy Order Successfull");
		ResponseEntity<Payment> response = new ResponseEntity<Payment>(pay, headers, HttpStatus.OK);
		return response;
	}

	@PostMapping("/company/sells")
	public ResponseEntity<Payment> companySellMilk(@Valid @RequestBody CompanySellsMilk transaction)
			throws InvalidTransactionException {
		LOG.info("CompanySellsMilkDataController");
		Payment pay = paymentservice.companySellsMilkData(transaction);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Milk Sell Order Successfull");
		ResponseEntity<Payment> response = new ResponseEntity<Payment>(pay, headers, HttpStatus.OK);
		return response;
	}

	@PostMapping("/dealer/sells")
	public ResponseEntity<Payment> dealerSellMilk(@Valid @RequestBody DealerSellsMilk transaction)
			throws InvalidTransactionException {
		LOG.info("CompanySellsMilkDataController");
		Payment pay = paymentservice.dealerSellsMilkData(transaction);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Milk Sell Order Successfull");
		ResponseEntity<Payment> response = new ResponseEntity<Payment>(pay, headers, HttpStatus.OK);
		return response;
	}

	@GetMapping("/getallcompanybuys")
	public ResponseEntity<List<CompanyBuysMilk>> getAllCompanyBuyOrders(){
		LOG.info("getAllCompanyBuyOrders controller");
		List<CompanyBuysMilk> lst = paymentservice.getAllCompanyBuyOrders();
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","List of All Company Buy Orders");
		ResponseEntity<List<CompanyBuysMilk>> response = new ResponseEntity<List<CompanyBuysMilk>>(lst,headers,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getallcompanysells")
	public ResponseEntity<List<CompanySellsMilk>> getAllCompanySellOrders(){
		LOG.info("getAllCompanySellOrders controller");
		List<CompanySellsMilk> lst = paymentservice.getAllCompanySellOrders();
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","List of All Company Sell Orders");
		ResponseEntity<List<CompanySellsMilk>> response = new ResponseEntity<List<CompanySellsMilk>>(lst,headers,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getalldealerSells")
	public ResponseEntity<List<DealerSellsMilk>> getAllDealerSellOrders(){
		LOG.info("getAllDealerSellOrders controller");
		List<DealerSellsMilk> lst = paymentservice.getAllDealerSellOrders();
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","List of All Dealer Sell Orders");
		ResponseEntity<List<DealerSellsMilk>> response = new ResponseEntity<List<DealerSellsMilk>>(lst,headers,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/getListByFarmerId/{farmerId}")
	public ResponseEntity<List<CompanyBuysMilk>> getListByFarmerId(@PathVariable(name="farmerId")int farmerId) throws FarmerNotFoundException{
		LOG.info("getListByFarmerId controller");
		List<CompanyBuysMilk> list = paymentservice.getListByFarmerId(farmerId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message","List of All Farmer Details");
		ResponseEntity<List<CompanyBuysMilk>> response = new ResponseEntity<List<CompanyBuysMilk>>(list,headers,HttpStatus.OK);
		return response;
	}

}
