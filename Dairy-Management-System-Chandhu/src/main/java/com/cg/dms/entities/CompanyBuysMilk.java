package com.cg.dms.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cg.dms.Milk;

@Entity
@Table
public class CompanyBuysMilk extends Payment{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6450820627942528950L;
	@ManyToOne
	@JoinColumn(name ="farmerId")
	private Farmer farmer;
	
	private Milk milkType;

	@ManyToOne
	@JoinColumn(name="companyId")
	private Company company;

	public CompanyBuysMilk() {
		super();
		
	}

	public CompanyBuysMilk(Farmer farmer, Milk milkType, Company company) {
		super();
		this.farmer = farmer;
		this.milkType = milkType;
		this.company = company;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	public Milk getMilkType() {
		return milkType;
	}

	public void setMilkType(Milk milkType) {
		this.milkType = milkType;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "CompanyBuysMilk [farmer=" + farmer + ", milkType=" + milkType + ", company=" + company + "]";
	}

}
