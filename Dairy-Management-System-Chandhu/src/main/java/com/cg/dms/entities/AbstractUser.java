package com.cg.dms.entities;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@MappedSuperclass
public abstract class AbstractUser {
	
	@NotEmpty(message ="Please input your username")
	private String userName;
	
	@NotEmpty(message="please input your first name")
	private String firstName;
	
	@NotEmpty(message="please input your last name")
	private String lastName;
	
	@NotEmpty(message="please enter your password")
	@Size(min = 4, max = 10)
	private String password;
	

	@Pattern(regexp="^\\d{10}$", message="Enter Valid Mobile Number")
	private String mobileNumber;
	

	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="Enter Valid Mail Id")
	private String email;
	
	


	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
