package com.example.Capstone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Capstone.entities.User;
import com.example.Capstone.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/save_user", method=RequestMethod.POST)
	public String saveUserInfo(@ModelAttribute User user) {
		userService.updateAndSaveUser(user);
		return "redirect:/userHomepage";
	}
}
