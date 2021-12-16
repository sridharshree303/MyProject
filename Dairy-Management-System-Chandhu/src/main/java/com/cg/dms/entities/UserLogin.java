package com.cg.dms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.cg.dms.User;

@Entity
public class UserLogin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	//@NotEmpty(message ="Please input your username")
	private String userName;
	
	//@NotEmpty(message="please enter your password")
	//@Size(min = 4, max = 10)
	private String password;
	
	private User userType;

	public UserLogin() {
		super();
	}

	public UserLogin(int userId, @NotEmpty(message = "Please input your username") String userName,
			@NotEmpty(message = "please enter your password") @Size(min = 4, max = 10) String password, User userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUserType() {
		return userType;
	}

	public void setUserType(User userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "UserLogin [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userType="
				+ userType + "]";
	}
}
