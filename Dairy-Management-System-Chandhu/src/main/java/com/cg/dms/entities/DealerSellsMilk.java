package com.cg.dms.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cg.dms.Milk;

@Entity
public class DealerSellsMilk extends Payment {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7267766373145125579L;
	@ManyToOne
	@JoinColumn(name = "dealerId")
	private Dealer dealer;
	
	private Milk milkType;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	public DealerSellsMilk() {
		super();
	}

	public DealerSellsMilk(Dealer dealer, Milk milkType, Customer customer) {
		super();
		this.dealer = dealer;
		this.milkType = milkType;
		this.customer = customer;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	public Milk getMilkType() {
		return milkType;
	}

	public void setMilkType(Milk milkType) {
		this.milkType = milkType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "DealerSellsMilk [dealer=" + dealer + ", milkType=" + milkType + ", customer=" + customer + "]";
	}

}
