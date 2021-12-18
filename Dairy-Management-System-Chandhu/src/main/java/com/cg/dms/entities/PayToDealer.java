package com.cg.dms.entities;

import java.time.Month;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cg.dms.Bank;
import com.cg.dms.Status;

@Entity
@Table(name = "customerDealerPayments")
public class PayToDealer extends AbstractTransaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7418960213799458447L;

	private Bank bankName;

	private Month month;
	
	@ManyToOne
	@JoinColumn(name = "dealerId")
	private Dealer dealer;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	public PayToDealer() {
		super();
		
	}

	public PayToDealer( Bank bankName, Month month, Dealer dealer, Customer customer) {
		super();
		
		this.bankName = bankName;
		this.month = month;
		this.dealer = dealer;
		this.customer = customer;
	}


	public Bank getBankName() {
		return bankName;
	}

	public void setBankName(Bank bankName) {
		this.bankName = bankName;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "PayToDealer [ bankName=" + bankName + ", month=" + month + ", dealer=" + dealer
				+ ", customer=" + customer + "]";
	}
 

}
