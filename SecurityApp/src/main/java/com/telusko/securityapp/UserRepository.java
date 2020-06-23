package com.telusko.securityapp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.securityapp.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	
	Users findByUsername(String username);

}
