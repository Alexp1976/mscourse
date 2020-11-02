package com.devsuperior.hroauth.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.devsuperior.hroauth.entities.User;
import com.devsuperior.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public List<User> findByEmail(String email) {
		List<User> users = userFeignClient.findByEmail(email).getBody();
		
		if (users.size() == 0) {
			logger.error("Email not found: " + email);
			throw new IllegalArgumentException("Email not found");
		}
		
		logger.info("Email found: " + email);
		return users;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<User> users = userFeignClient.findByEmail(username).getBody();
		
		if (users.size() == 0) {
			logger.error("Email not found: " + username);
			throw new IllegalArgumentException("Email not found");
		}
		
		logger.info("Email found: " + username);
		
		return users.get(0);
	}
}
