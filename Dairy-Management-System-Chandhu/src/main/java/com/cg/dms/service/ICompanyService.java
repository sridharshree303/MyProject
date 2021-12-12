package com.cg.dms.service;

import com.cg.dms.entities.Company;
import com.cg.dms.exception.CompanyNotFoundException;

public interface ICompanyService {

	public Company insertCompany(Company company);

	public Company updateCompany(Company company) throws CompanyNotFoundException;

	public Company deleteCompany(int company) throws CompanyNotFoundException;
	

}
