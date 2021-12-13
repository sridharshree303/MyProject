package com.cg.dms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.entities.PayToDealer;
import com.cg.dms.exception.InvalidTransactionException;
import com.cg.dms.repository.ICustomerRepository;
import com.cg.dms.repository.IDealerRepository;
import com.cg.dms.repository.IPayToDealerRepository;

@Service
public class PayToDealerService implements IPayToDealerService {

	@Autowired
	private IPayToDealerRepository ipaytodealerrepository;
	@Autowired
	private IDealerRepository iDealerRepository;
	@Autowired
	private ICustomerRepository icustomerRepository;

	private static final Logger LOG = LoggerFactory.getLogger(PayToDealerService.class);

	public PayToDealer customerPayToDealer(PayToDealer transaction) {
		LOG.info("customer pays Bill to Dealer");
		boolean cmp = icustomerRepository.existsById(transaction.getCustomer().getCustomerId());
		boolean deal = iDealerRepository.existsById(transaction.getDealer().getDealerId());
		if (deal && cmp) {
			LOG.info("dealerTd/customerId found in Database");
			LOG.info("Payment initiated");
			return ipaytodealerrepository.save(transaction);
			
		}else {
			LOG.info("dealerTd/customerId not found in Database");
			throw new InvalidTransactionException("Payment is failed due to Invalid details");		
			}
		
	}

}
