package com.cg.dms.entities;

import java.time.Month;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cg.dms.Bank;
import com.cg.dms.Status;

@Entity
@Table(name = "dealerCompanyPayments")
public class PayToCompany extends AbstractTransaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8103130774414467963L;


	private Bank bankName;

	private Month month;
	
	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;

	@ManyToOne
	@JoinColumn(name = "dealerId")
	private Dealer dealer;

	public PayToCompany() {
		super();
		
	}



	public PayToCompany(Bank bankName, Month month, Company company, Dealer dealer) {
		super();
		this.bankName = bankName;
		this.month = month;
		this.company = company;
		this.dealer = dealer;
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}

	@Override
	public String toString() {
		return "PayToCompany [ bankName=" + bankName + ", month=" + month + ", company=" + company
				+ ", dealer=" + dealer + "]";
	}
	
}
