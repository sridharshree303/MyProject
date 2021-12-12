package com.cg.dms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;

	@NotEmpty(message = "Enter your company name")
	private String companyName;

	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter Valid Mail Id")
	private String email;

	@Size(min = 4, max = 16, message = "Enter valid password")
	private String password;

	@Pattern(regexp = "^\\d{10}$", message = "Enter Valid Mobile Number")
	private String mobileNumber;

	@NotEmpty(message = "please enter your address")
	private String address;

	public Company() {
		super();
	}

	public Company(int companyId, @NotEmpty(message = "Enter your company name") String companyName,
			@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Enter Valid Mail Id") String email,
			@Size(min = 4, max = 16, message = "Enter valid password") String password,
			@Pattern(regexp = "^\\d{10}$", message = "Enter Valid Mobile Number") String mobileNumber,
			@NotEmpty(message = "please enter your address") String address) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", email=" + email + ", password="
				+ password + ", mobileNumber=" + mobileNumber + ", address=" + address + "]";
	}

}