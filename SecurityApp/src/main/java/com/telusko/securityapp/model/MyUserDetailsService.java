package com.telusko.securityapp.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.telusko.securityapp.UserPrincipal;
import com.telusko.securityapp.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user=repo.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("user 404");
		
		return new UserPrincipal(user);
	}

}
