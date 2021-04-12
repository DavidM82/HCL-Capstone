package com.example.Capstone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Capstone.entities.User;
import com.example.Capstone.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	 public User updateAndSaveUser(User user){
	        return userRepository.save(user);
	    }

}
