package com.cg.dms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cg.dms.User;
import com.cg.dms.entities.UserLogin;
import com.cg.dms.exception.AppUserNotFoundException;
import com.cg.dms.exception.InvalidTransactionException;
import com.cg.dms.repository.IUserLoginRepository;

@Service
public class UserLoginService extends IUserLoginService {

	public boolean isLogged;

	private UserLogin tempUser;

	private static final Logger LOG = LoggerFactory.getLogger(UserLoginService.class);

	@Autowired
	private IUserLoginRepository iuserloginrepository;

	public UserLogin registerUser(UserLogin userLogin) {
		LOG.info("register User Service");
		UserLogin validUser = iuserloginrepository.findByUserName(userLogin.getUserName());
		if (null == validUser) {
			LOG.info("register new User");
			return iuserloginrepository.save(userLogin);
		} else {
			LOG.info("User already found");
			throw new InvalidTransactionException();
		}
	}

	public UserLogin loginUser(UserLogin userLogin) throws AppUserNotFoundException {
		LOG.info("Login Service");
		if (iuserloginrepository.findByUserName(userLogin.getUserName()) == null) {
			throw new AppUserNotFoundException("User name not valid..");
		} else {
			tempUser = iuserloginrepository.findByUserName(userLogin.getUserName());
			if (userLogin.getUserName().equals(tempUser.getUserName())) {
				if (userLogin.getPassword().equals(tempUser.getPassword())) {
					if (userLogin.getUserType().equals(tempUser.getUserType())) {
						LOG.info("UserLogin Successfully");
						LOG.info("obj :" + tempUser);
						isLogged = true;
						return tempUser;
					} else {
						throw new InvalidTransactionException();
					}
				}
			}
		}
		return null;
	}

	public String logoutUser(String userName) {
		LOG.info("LogOutUser Service");
		if (isLogged) {
			LOG.info("Logout successful");
			isLogged = false;
			return "User Logged out successfully";
		} else {
			LOG.info("Logout Failed");
			throw new InvalidTransactionException("LogOut Unsuccessful");
		}

	}

}
