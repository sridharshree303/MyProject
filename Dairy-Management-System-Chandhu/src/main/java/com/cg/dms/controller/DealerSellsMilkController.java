package com.cg.dms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dms.service.DealerSellsMilkService;

@RestController
@CrossOrigin(origins = "*")
public class DealerSellsMilkController {
	
	@Autowired
	private DealerSellsMilkService dealersellsmilkservice;

}
