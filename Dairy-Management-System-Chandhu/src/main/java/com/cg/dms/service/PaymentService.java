package com.cg.dms.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.entities.Company;
import com.cg.dms.entities.CompanyBuysMilk;
import com.cg.dms.entities.Farmer;
import com.cg.dms.entities.Payment;
import com.cg.dms.exception.InvalidTransactionException;
import com.cg.dms.exception.PaymentAlreadyFoundException;
import com.cg.dms.repository.ICompanyBuysMilkRepository;
import com.cg.dms.repository.ICompanyRepository;
import com.cg.dms.repository.ICompanySellsMilkRepository;
import com.cg.dms.repository.IDealerSellsMilkRepository;
import com.cg.dms.repository.IFarmerRepository;
import com.cg.dms.repository.IPaymentRepository;

@Service
public class PaymentService {

	private static final Logger LOG = LoggerFactory.getLogger(PaymentService.class);
	@Autowired
	private IPaymentRepository ipaymentrepository;
	@Autowired
	private IFarmerRepository iFarmerRepository;
	@Autowired
	private ICompanyRepository iCompanyRepository;
	@Autowired
	private IDealerSellsMilkRepository idealersellsmilkrepository;
	@Autowired
	private ICompanyBuysMilkRepository icompanybuysmilkrepository;
	@Autowired
	private ICompanySellsMilkRepository icompanysellsmilkrepository;

	public Payment companyBuysMilkData(CompanyBuysMilk transaction)//,Company companyId,Farmer farmerId
			throws InvalidTransactionException, PaymentAlreadyFoundException {
//		Optional<Company> cmp = iCompanyRepository.findById(company.getCompanyId());
//		Optional<Farmer> frm = iFarmerRepository.findById(farmer.getFarmerId());
		boolean cmp = iCompanyRepository.existsById(transaction.getCompany().getCompanyId());
		boolean frm = iFarmerRepository.existsById(transaction.getFarmer().getFarmerId());	
		LOG.info("company : "+cmp);
		LOG.info("farmer : "+frm);
		
		
		if (frm&&cmp) {
			LOG.info("Transaction Successful ");
			return icompanybuysmilkrepository.save(transaction);
		} else {
			LOG.info("Transaction unsuccessfu;");
			throw new InvalidTransactionException(transaction.getPaymentId() + " Invalid Buy Order ");
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



////Company ce = new Company();
//Farmer fm = new Farmer();
//LOG.info("Company Buys Milk From Farmer ");
//boolean cmp = iCompanyRepository.existsById(company.getCompanyId());
//LOG.info("boolean :"+cmp);
//boolean frm = iFarmerRepository.existsById(fm.getFarmerId());	
