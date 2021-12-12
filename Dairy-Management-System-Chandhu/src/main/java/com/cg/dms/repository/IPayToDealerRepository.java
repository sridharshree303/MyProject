package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dms.entities.PayToDealer;

@Repository
public interface IPayToDealerRepository extends JpaRepository<PayToDealer, Integer> {

}
