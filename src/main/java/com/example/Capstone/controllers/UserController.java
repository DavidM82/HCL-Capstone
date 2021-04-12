package com.example.Capstone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Capstone.entities.User;
import com.example.Capstone.services.CapstoneUserDetailsService;

@Controller
public class UserController {

	@Autowired
	private CapstoneUserDetailsService userService;
	
	@RequestMapping(value= "/newuser")
    public String userRegistration(Model model) {
    	
		User user = new User();
		model.addAttribute("user", user);
		model.addAttribute("month", 1);
		model.addAttribute("year", 2021);
    	return "newUser";
	}
	
	@RequestMapping(value="/save_user", method=RequestMethod.POST)
	public String saveUserInfo(@ModelAttribute User user, @RequestParam int month, @RequestParam int year) {
		user = userService.prepUserForSave(user, user.getCreditcard(), month, year);
		userService.updateAndSaveUser(user);
		return "redirect:/";
	}
}
