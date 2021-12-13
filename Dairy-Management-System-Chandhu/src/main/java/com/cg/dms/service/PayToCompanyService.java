package com.cg.dms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.entities.PayToCompany;
import com.cg.dms.exception.InvalidTransactionException;
import com.cg.dms.repository.ICompanyRepository;
import com.cg.dms.repository.IDealerRepository;
import com.cg.dms.repository.IPayToCompanyRepository;

@Service
public class PayToCompanyService implements IPayToCompanyService {

	@Autowired
	private IPayToCompanyRepository ipaytocompanyrepository;
	@Autowired
	private IDealerRepository iDealerRepository;
	@Autowired
	private ICompanyRepository iCompanyRepository;
	private static final Logger LOG = LoggerFactory.getLogger(PayToCompanyService.class);

	public PayToCompany dealerPayToCompany(PayToCompany transaction) {
		LOG.info("Dealer pays Bill to Company");
		boolean cmp = iCompanyRepository.existsById(transaction.getCompany().getCompanyId());
		boolean deal = iDealerRepository.existsById(transaction.getDealer().getDealerId());
		if (cmp && deal) {
			LOG.info("dealerTd/companyId found in Database");
			LOG.info("Payment initiated");
			return ipaytocompanyrepository.save(transaction);

		} else {
			LOG.info("dealerTd/companyId not found in Database");
			throw new InvalidTransactionException("Payment is failed due to Invalid details");
		}
	}

}
