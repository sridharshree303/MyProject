package com.cg.dms.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import com.cg.dms.PaymentMethod;

@MappedSuperclass
public abstract class AbstractTransaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;

	private double totalMilkunits;

	private double avgUnitPrice;

	private double billAmount = totalMilkunits*avgUnitPrice;
	
	private LocalDateTime paymentDate;

	private PaymentMethod paymentmethod;
	
	
	private long AccountNumber;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getTotalMilkunits() {
		return totalMilkunits;
	}

	public void setTotalMilkunits(double totalMilkunits) {
		this.totalMilkunits = totalMilkunits;
	}

	public double getAvgUnitPrice() {
		return avgUnitPrice;
	}

	public void setAvgUnitPrice(double avgUnitPrice) {
		this.avgUnitPrice = avgUnitPrice;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentMethod getPaymentmethod() {
		return paymentmethod;
	}

	public void setPaymentmethod(PaymentMethod paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public long getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		AccountNumber = accountNumber;
	}

//	public double getBillAmount() {
//		return billAmount;
//	}
//
//	public void setBillAmount(double billAmount) {
//		this.billAmount = billAmount;
//	}

	
}
