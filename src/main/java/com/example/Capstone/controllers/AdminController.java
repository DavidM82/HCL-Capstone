package com.example.Capstone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;


import org.springframework.web.bind.annotation.RequestParam;

import com.example.Capstone.entities.Admin;
import com.example.Capstone.services.AdminService;

import org.springframework.stereotype.Controller;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping(value="/admin/login")
	public ResponseEntity<?> adminLogin(@RequestParam String username, @RequestParam String password){

		Admin admin = adminService.findByUsername(username);

		if(adminService.validateAdmin(admin)) {
			if(admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
				return ResponseEntity.ok(admin);
			}
		}

		return ResponseEntity.badRequest().body("Wrong credentials");
	}

}
