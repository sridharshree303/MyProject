package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dms.entities.CompanySellsMilk;
import com.cg.dms.entities.DealerSellsMilk;

@Repository
public interface IDealerSellsMilkRepository extends JpaRepository<DealerSellsMilk, Integer> {

}
