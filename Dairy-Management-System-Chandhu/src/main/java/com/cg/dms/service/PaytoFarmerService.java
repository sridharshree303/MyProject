package com.cg.dms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.entities.PayToFarmer;
import com.cg.dms.exception.InvalidTransactionException;
import com.cg.dms.repository.ICompanyRepository;
import com.cg.dms.repository.IFarmerRepository;
import com.cg.dms.repository.IPayToFarmerRepository;

@Service
public class PaytoFarmerService implements IPaytoFarmerService  {

	@Autowired
	private IPayToFarmerRepository ipaytofarmerrepository;
	@Autowired
	private ICompanyRepository iCompanyRepository;
	@Autowired
	private IFarmerRepository iFarmerRepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(PaytoFarmerService.class);
	
	public PayToFarmer companyPayToFarmer(PayToFarmer payment) {
		LOG.info("Company pays Bill to farmer");
		boolean cmp = iCompanyRepository.existsById(payment.getCompany().getCompanyId());
		boolean frm = iFarmerRepository.existsById(payment.getFarmer().getFarmerId());

		if (cmp && frm) {
			LOG.info("companyId/farmerId Found in Database");
			LOG.info("Payment initiated");
			return ipaytofarmerrepository.save(payment);
			
		} else {
			LOG.info("companyId/farmerId not Found in Database");
			throw new InvalidTransactionException("Payment is failed due to Invalid details");
		}
	}
	
}
