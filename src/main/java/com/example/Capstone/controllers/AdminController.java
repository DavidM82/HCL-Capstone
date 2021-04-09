package com.example.Capstone.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Capstone.entities.Admin;
import com.example.Capstone.entities.Product;
import com.example.Capstone.services.AdminService;
import com.example.Capstone.services.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	ProductService productService;

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

	
	@GetMapping("/admin")
	public String showAdmin() {
		return "adminHome";
	}
	
	@RequestMapping(value = "/adminInventory", method = RequestMethod.GET)
	public String adminProducts(Model model) {
		
		Iterable<Product> product = productService.findAllProduct();
		
		model.addAttribute("product", product);
		
		return "adminInventory";
		
		
	}
	
	@GetMapping("/adminOrders")
	public String showAdminOrders() {
		return "adminOrders";
	}
	
	@GetMapping("/adminCreateItem")
	public String adminCreate() {
		return "adminCreateItem";
	}
	
}
