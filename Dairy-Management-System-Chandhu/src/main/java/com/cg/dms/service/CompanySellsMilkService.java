package com.cg.dms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.repository.ICompanySellsMilkRepository;
import com.cg.dms.repository.IDealerSellsMilkRepository;

@Service
public class CompanySellsMilkService implements ICompanySellsMilkService {
	
	@Autowired
	private ICompanySellsMilkRepository icompanysellsmilkrepository;

}
