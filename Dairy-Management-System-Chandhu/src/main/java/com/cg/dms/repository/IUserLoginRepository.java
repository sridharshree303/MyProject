package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dms.User;
import com.cg.dms.entities.UserLogin;

@Repository
public interface IUserLoginRepository extends JpaRepository<UserLogin, Integer> {

	public abstract UserLogin findByUserName(String userName);
	
//	public abstract List<UserLogin> findByUser(User userType); 
}
