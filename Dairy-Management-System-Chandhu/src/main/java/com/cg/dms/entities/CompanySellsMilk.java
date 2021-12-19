package com.cg.dms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.cg.dms.Milk;

@Entity
public class CompanySellsMilk extends Payment {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5903323702835773942L;
	

	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;
	
	private Milk milkType;
	
	@ManyToOne
	@JoinColumn(name="dealerId")
	private Dealer dealer;

	public CompanySellsMilk() {
		super();
	}

	public CompanySellsMilk(Company company, Milk milkType, Dealer dealer) {
		super();
		this.company = company;
		this.milkType = milkType;
		this.dealer = dealer;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Milk getMilkType() {
		return milkType;
	}

	public void setMilkType(Milk milkType) {
		this.milkType = milkType;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	@Override
	public String toString() {
		return "CompanySellsMilk [company=" + company + ", milkType=" + milkType + ", dealer=" + dealer + "]";
	}


		
	
}
