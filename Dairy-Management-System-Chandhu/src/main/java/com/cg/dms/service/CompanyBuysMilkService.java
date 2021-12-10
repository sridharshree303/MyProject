package com.cg.dms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.repository.ICompanyBuysMilkRepository;

@Service
public class CompanyBuysMilkService implements ICompanyBuysMilkService {

	@Autowired
	private ICompanyBuysMilkRepository icompanybuysmilkrepository;
}
