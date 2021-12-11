package com.cg.dms.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dms.entities.Company;
import com.cg.dms.entities.CompanyBuysMilk;
import com.cg.dms.entities.CompanySellsMilk;
import com.cg.dms.entities.DealerSellsMilk;
import com.cg.dms.entities.Farmer;
import com.cg.dms.entities.Payment;
import com.cg.dms.exception.InvalidTransactionException;
import com.cg.dms.service.CompanyBuysMilkService;
import com.cg.dms.service.PaymentService;

import springfox.documentation.service.Header;

@RestController
@RequestMapping("/payment")
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
	
	@GetMapping("/list/company/orders")
	public ResponseEntity<CompanyBuysMilk> getAllCompanyBuyOrders(){
		LOG.info("getAllCompanyBuyOrders");
		CompanyBuysMilk cbm = new CompanyBuysMilk();
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "List of All Transactions");
		LOG.info(headers.toString());
		return new ResponseEntity<CompanyBuysMilk>(cbm,headers,HttpStatus.OK);
	}

//	@PostMapping("/payment/insert/dealer")
//	public ResponseEntity<Payment> insertDealerToCompanyPayment(@Valid @RequestBody DealerSellsMilk payment){
//		LOG.info("insert Dealer to company");
//		Payment pay = paymentservice.insertDealerToComapnyPayment(payment);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "New dealer Payment is added");
//		ResponseEntity<Payment> response = new ResponseEntity<Payment>(pay,headers,HttpStatus.OK);
//		return response;
//	}
//	
//	@PostMapping("/payment/insert/company")
//	public ResponseEntity<Payment> insertCompanyToFarmerPayment(@Valid @RequestBody CompanyBuysMilk payment){
//		LOG.info("insert company to farmer");
//		Payment pay = paymentservice.insertCompanyToFarmerPayment(payment);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "New Farmer payment is added");
//		ResponseEntity<Payment> response = new ResponseEntity<Payment>(pay,headers,HttpStatus.OK);
//		return response;
//	}
//	
//	@PostMapping("/payment/insert/customer")
//	public ResponseEntity<Payment> insertCustomerToDealer(@Valid @RequestBody CompanySellsMilk payment){
//		LOG.info("insert customer to Dealer");
//		Payment pay = paymentservice.insertCustomerToDelearPayment(payment);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "New Customer Payment is added");
//		ResponseEntity<Payment> response = new ResponseEntity<Payment>(pay,headers,HttpStatus.OK);
//		return response;
//	}
//	

}
