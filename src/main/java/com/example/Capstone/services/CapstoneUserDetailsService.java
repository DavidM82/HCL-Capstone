package com.example.Capstone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Capstone.entities.User;
import com.example.Capstone.entities.userdetails.CapstoneUserPrincipal;
import com.example.Capstone.repositories.UserRepository;

@Service
public class CapstoneUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
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
	
	public void setCreditCard(long creditcard, int month, int year) {
		user.setCreditcard(creditcard);
		String monthStr = Integer.toString(month);
		
		String yearStr = Integer.toString(year);
		String dateStr = monthStr+yearStr;
		int expirationdate = Integer.parseInt(dateStr);
		user.setExperation_date(expirationdate);
		
		userRepo.save(user);
	}
}
