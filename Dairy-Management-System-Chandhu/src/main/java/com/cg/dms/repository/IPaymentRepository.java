
package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dms.entities.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Integer> {

}