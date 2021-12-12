package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dms.entities.PayToFarmer;

@Repository
public interface IPayToFarmerRepository extends JpaRepository<PayToFarmer, Integer>{

}
