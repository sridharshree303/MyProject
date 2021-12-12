package com.cg.dms.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.dms.entities.CompanyBuysMilk;

@Repository
public interface ICompanyBuysMilkRepository extends JpaRepository<CompanyBuysMilk, Integer>{

//	@Query("select u from CompanyBuysMilk u where u.company=:c and u.farmer=:n")
//	public abstract List<CompanyBuysMilk> getListByCompanyIdAndFarmerId(@Param("c")int companyId,@Param("n")int farmerId);
	
	@Query("select u from CompanyBuysMilk u where u.company=:c and u.farmer=:n")
	public abstract List<CompanyBuysMilk> getListByCompanyIdAndFarmerId(@Param("c")int companyId,@Param("n")int farmerId);

	@Query("select u from CompanyBuysMilk u where u.farmer=:n")
	public abstract List<CompanyBuysMilk> getListByFarmerId(@Param("n")int farmerId);
}