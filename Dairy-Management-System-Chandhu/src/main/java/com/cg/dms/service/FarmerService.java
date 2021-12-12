package com.cg.dms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.dms.entities.Dealer;
import com.cg.dms.entities.Farmer;
import com.cg.dms.exception.CustomerNotFoundException;
import com.cg.dms.exception.DealerNotFoundException;
import com.cg.dms.exception.FarmerAlreadyExistsException;
import com.cg.dms.exception.FarmerNotFoundException;
import com.cg.dms.repository.IFarmerRepository;

@Service
public class FarmerService implements IfarmerService {

	private static final Logger LOG = LoggerFactory.getLogger(FarmerService.class);
	@Autowired
	private IFarmerRepository iFarmerRepository;

	public List<Farmer> getAllFarmer() {
		LOG.info("Get_All_Formers");
		return iFarmerRepository.findAll();
	}

	@Override
	public Farmer addFarmer(Farmer user) throws FarmerAlreadyExistsException {
		LOG.info("Service add Farmer");
		if (!iFarmerRepository.existsById(user.getFarmerId())) {
			LOG.info("New Farmer is Added");
			return iFarmerRepository.save(user);
		} else {
			LOG.info("Farmer Data is already exists");
			throw new FarmerAlreadyExistsException("Farmer already exists");
		}
	}

	@Override
	public Farmer updateFarmer(Farmer user) throws FarmerNotFoundException {
		LOG.info("Service update Farmer");
		if (iFarmerRepository.existsById(user.getFarmerId())) {
			LOG.info(" Farmer Data is Updated");
			return iFarmerRepository.save(user);
		} else {
			LOG.info(user.getFarmerId() + "  Farmer data is Not updated");
			throw new FarmerNotFoundException(" Farmer Data is not updated");
		}
	}
	
	public Farmer getFarmer(int farmerId) throws  FarmerNotFoundException{
		LOG.info("Get Farmer By Id");
		Optional<Farmer> farmer = iFarmerRepository.findById(farmerId);
		if(farmer.isPresent()) {
			LOG.info("Farmer is found");
			return farmer.get();
		}else {
			LOG.info("Farmer is Not Found");
			throw new FarmerNotFoundException(farmerId+" --> farmerId is not Found ");
		}
	}
	
	public Farmer deleteFarmer(int farmerId) throws FarmerNotFoundException {
		LOG.info("Delete farmerId service");
		Optional<Farmer> farm = iFarmerRepository.findById(farmerId);
		if(farm.isPresent()) {
			LOG.info("Farmer is Available to delete");
			iFarmerRepository.deleteById(farmerId);
			return farm.get();
		}else {
			LOG.info("farmerId is not available");
			throw new FarmerNotFoundException(farmerId+" is not found in database");
		}
		
	}




}