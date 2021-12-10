package com.cg.dms.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.entities.CompanyBuysMilk;
import com.cg.dms.entities.Payment;
import com.cg.dms.exception.InvalidTransactionException;
import com.cg.dms.exception.PaymentAlreadyFoundException;
import com.cg.dms.repository.ICompanyBuysMilkRepository;
import com.cg.dms.repository.ICompanySellsMilkRepository;
import com.cg.dms.repository.IDealerSellsMilkRepository;
import com.cg.dms.repository.IPaymentRepository;

@Service
public class PaymentService {

	private static final Logger LOG = LoggerFactory.getLogger(PaymentService.class);
	@Autowired
	private IPaymentRepository ipaymentrepository;
	@Autowired
	private IDealerSellsMilkRepository idealersellsmilkrepository;
	@Autowired
	private ICompanyBuysMilkRepository icompanybuysmilkrepository;
	@Autowired
	private ICompanySellsMilkRepository icompanysellsmilkrepository;

	public Payment companyBuysMilkData(CompanyBuysMilk transaction) throws InvalidTransactionException,PaymentAlreadyFoundException {
		LOG.info("Company Buys Milk From Farmer ");
		Optional<CompanyBuysMilk> company = icompanybuysmilkrepository.findById(transaction.getPaymentId());
		if (company.isPresent()) {
			throw new InvalidTransactionException(transaction.getPaymentId() + " Invalid Buy Order ");
		} else {
			LOG.info("Company  into farmer payment");
			return icompanybuysmilkrepository.save(transaction);
		}

	}

////	public Payment insertDealerToComapnyPayment(Payment payment)throws PaymentNotFoundException;
//	public Payment insertDealerToComapnyPayment(DealerSellsMilk payment) throws PaymentAlreadyFoundException {
//		LOG.info("Insert Dealer to Company Payment");
//		Optional<DealerSellsMilk> dealer = idealerpaymentrepo.findById(payment.getPaymentId());
//		if (dealer.isPresent()) {
//			throw new PaymentAlreadyFoundException(payment.getPaymentId() + " PaymentId already found");
//		} else {
//			LOG.info("Insert dealer into company payment");
//			return ipaymentrepository.save(payment);
//		}
//
//	}    
//	            
//	public Payment insertCompanyToFarmerPayment(CompanyBuysMilk payment) throws PaymentAlreadyFoundException {
//
//		LOG.info("Insert Comapany To Farmer ");
//		Optional<CompanyBuysMilk> company = icompanybuysmilkrepository.findById(payment.getPaymentId());
//		if (company.isPresent()) {
//			throw new PaymentAlreadyFoundException(payment.getPaymentId() + "PaymentId already found ");
//		} else {
//			LOG.info("Insert company into farmer payment");
//			return icompanybuysmilkrepository.save(payment);
//		}
//
//	}
//
//	public Payment insertCustomerToDelearPayment(CompanySellsMilk payment) throws PaymentAlreadyFoundException {
//		LOG.info("Insert Customer to Dealer ");
//		Optional<CompanySellsMilk> customer = icustomerpaymentrepository.findById(payment.getPaymentId());
//		if (customer.isPresent()) {
//			throw new PaymentAlreadyFoundException(payment.getPaymentId() + "PaymentId already found");
//		} else {
//			LOG.info("Insert Customer into Dealer ");
//			return icustomerpaymentrepository.save(payment);
//		}
//	}

}
