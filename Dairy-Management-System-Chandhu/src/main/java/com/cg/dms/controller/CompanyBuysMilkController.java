package com.cg.dms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dms.service.CompanyBuysMilkService;

@RestController
public class CompanyBuysMilkController {

	@Autowired
	private CompanyBuysMilkService companyPaymentService;
}
