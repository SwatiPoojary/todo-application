package com.springboot.todoapp.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.todoapp.entity.CustomUserDetails;
import com.springboot.todoapp.entity.User;
import com.springboot.todoapp.repositories.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user= userRepository.findByUserName(username);
		
		user.orElseThrow(() -> new UsernameNotFoundException("User "+username+" not found"));
		
		return user.map(CustomUserDetails::new).get();
		
	}

	
}
