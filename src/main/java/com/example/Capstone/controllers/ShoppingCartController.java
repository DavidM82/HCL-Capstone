package com.example.Capstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.Capstone.entities.Item;
import com.example.Capstone.entities.Music;
import com.example.Capstone.entities.Product;
import com.example.Capstone.entities.User;
import com.example.Capstone.services.CapstoneUserDetailsService;
import com.example.Capstone.services.ShoppingCartService;

@Controller
public class ShoppingCartController {

	
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	CapstoneUserDetailsService userService;
	
	@PostMapping("/saveproductincart")
	public void saveProductInCart(@RequestBody Product product, User user) {
		shoppingCartService.saveProduct(product);
	}
	
	@PostMapping("/savemusicincart")
	public void saveMusicInCart(@RequestBody Music music, User user) {
		shoppingCartService.saveMusic(music);
	}
	
	@GetMapping("/shoppingcart")
	public String getShoppingCart(Model model) {
		ArrayList<Item> items = (ArrayList<Item>) shoppingCartService.showItems();
		BigDecimal total = BigDecimal.ZERO;
		for (Item i: items) {
			total = total.add(i.getPrice());
		}
		
		model.addAttribute("item", items);
		model.addAttribute("total", total);
		return "shopping_cart";
	}
	
	@PostMapping("/checkout")
	public String getCheckOut(Model model, @RequestParam("totalcost") BigDecimal total) {
		
		model.addAttribute("total", total);
		model.addAttribute("user", userService.getUser());
		return "checkout";
	}
	
	@PostMapping("/buy")
	public String purchase() {
		shoppingCartService.purchase();
		return "shopping_cart";
	}
}
