package com.example.Capstone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Capstone.entities.User;
import com.example.Capstone.entities.userdetails.CapstoneUserPrincipal;
import com.example.Capstone.repositories.UserRepository;

@Service
public class CapstoneUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	private User user;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		this.user = user;
		return new CapstoneUserPrincipal(user);
	}
	
	public User getUser() {
		return user;
	}
	
	public void updateCreditCard(long creditcard, int month, int year) {
		user.setCreditcard(creditcard);
		String monthStr = Integer.toString(month);
		
		String yearStr = Integer.toString(year);
		String dateStr = monthStr+yearStr;
		int expirationdate = Integer.parseInt(dateStr);
		user.setExperation_date(expirationdate);
		
		userRepo.save(user);
	}
	
	//Prepares the User object for saving
	public User prepUserForSave(User newuser, long creditcard, int month, int year) {
		newuser.setCreditcard(creditcard);
		String monthStr = Integer.toString(month);
		
		String yearStr = Integer.toString(year);
		String dateStr = monthStr+yearStr;
		int expirationdate = Integer.parseInt(dateStr);
		newuser.setExperation_date(expirationdate);
		
		newuser.setPassword(passwordEncoder.encode(newuser.getPassword()));
		
		newuser.setAdmin(false);
		
		return newuser;
	}
	
	 public User updateAndSaveUser(User user){
	        return userRepo.save(user);
	 }

}
