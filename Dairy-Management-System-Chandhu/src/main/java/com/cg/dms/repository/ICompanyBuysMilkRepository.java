package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dms.entities.CompanyBuysMilk;

@Repository
public interface ICompanyBuysMilkRepository extends JpaRepository<CompanyBuysMilk, Integer>{

}