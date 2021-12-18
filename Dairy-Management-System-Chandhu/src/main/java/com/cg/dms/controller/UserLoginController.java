package com.cg.dms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dms.entities.UserLogin;
import com.cg.dms.exception.AppUserNotFoundException;
import com.cg.dms.service.UserLoginService;

@RestController
@CrossOrigin(origins = "*")
public class UserLoginController {

	private static final Logger LOG = LoggerFactory.getLogger(UserLoginController.class);

	@Autowired
	private UserLoginService userloginservice;

	//http://localhost:8082/registeruser
	@PostMapping("/registeruser")
	public ResponseEntity<UserLogin> registerUser(@RequestBody UserLogin userLogin) {
		LOG.info("registerUser controller");
		UserLogin user = userloginservice.registerUser(userLogin);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "User registered successfully");
		ResponseEntity<UserLogin> response = new ResponseEntity<UserLogin>(user, headers, HttpStatus.CREATED);
		return response;
	}

	@PostMapping("/loginuser")
	public ResponseEntity<UserLogin> loginUser(@RequestBody UserLogin userLogin) throws AppUserNotFoundException {
		LOG.info("loginUser Controller");
		UserLogin user = userloginservice.loginUser(userLogin);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "User Logined successfully");
		ResponseEntity<UserLogin> response = new ResponseEntity<UserLogin>(user, headers, HttpStatus.OK);
		return response;
	}

	@PostMapping("/logoutuser")
	public ResponseEntity<String> logoutUser(@RequestBody String userName) {
		LOG.info("Logout User controller");
		HttpHeaders headers = new HttpHeaders();
		String str = userloginservice.logoutUser(userName);
		headers.add("message", "User logged out successfully");
		ResponseEntity<String> response = new ResponseEntity<String>(str, headers, HttpStatus.OK);
		return response;

	}

}
