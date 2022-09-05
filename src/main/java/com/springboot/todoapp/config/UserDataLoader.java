package com.springboot.todoapp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.springboot.todoapp.entity.User;
import com.springboot.todoapp.repositories.UserRepository;

@Component
public class UserDataLoader implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(UserDataLoader.class);
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		loadUserSeedData();
	}
	
	private void loadUserSeedData() {
		if(userRepository.count() == 0) {
			User user1 = new User("test", "pwd123", "USER");
			User user2 = new User("user", "pwd", "USER");

			userRepository.save(user1);
			userRepository.save(user2);
		}
		logger.info("Number of users: {}",userRepository.count());
	}
	
	
}
