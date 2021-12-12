package com.cg.dms.entities;

import java.time.Month;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cg.dms.Bank;
import com.cg.dms.Status;

@Entity
@Table(name="companyFarmerPayments")
public class PayToFarmer extends AbstractTransaction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5836082741974167052L;

	private Status status;

	private Bank bankName;

	private Month month;
	
	@ManyToOne
	@JoinColumn(name = "farmerId")
	private Farmer farmer;

	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;


	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "PayToFarmer [status=" + status + ", bankName=" + bankName + ", month=" + month + ", farmer=" + farmer
				+ ", company=" + company + "]";
	}

}
