package com.example.Capstone.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.Capstone.entities.Music;
import com.example.Capstone.entities.Product;
import com.example.Capstone.entities.User;
import com.example.Capstone.services.ShoppingCartService;

@Controller
public class ShoppingCartController {

	
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@PostMapping("/saveproductincart")
	public void saveProductInCart(@RequestBody Product product, User user) {
		shoppingCartService.saveProduct(product, user);
	}
	
	@PostMapping("/savemusicincart")
	public void saveMusicInCart(@RequestBody Music music, User user) {
		shoppingCartService.saveMusic(music, user);
	}
	
	
}
