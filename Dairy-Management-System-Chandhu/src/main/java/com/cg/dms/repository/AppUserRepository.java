package com.cg.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.dms.entities.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer>{

	AppUser findByUserName(String userName);

}
