package com.cg.dms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.repository.ICompanySellsMilkRepository;
import com.cg.dms.repository.IDealerSellsMilkRepository;

@Service
public class DealerSellsMilkService implements IDealerSellsMilkService {
	
	@Autowired
	private IDealerSellsMilkRepository idealersellsmilkrepository;

	private static final Logger LOG = LoggerFactory.getLogger(DealerSellsMilkService.class);
	
	
}
