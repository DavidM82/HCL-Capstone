package com.example.Capstone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.Capstone.entities.Item;
import com.example.Capstone.entities.Music;
import com.example.Capstone.entities.Product;
import com.example.Capstone.entities.User;
import com.example.Capstone.services.CapstoneUserDetailsService;
import com.example.Capstone.services.MusicService;
import com.example.Capstone.services.ShoppingCartService;

@Controller
public class ShoppingCartController {

	
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	CapstoneUserDetailsService userService;
	
	@Autowired
	MusicService musicService;
	
	@PostMapping("/saveproductincart")
	public void saveProductInCart(@RequestBody Product product, User user) {
		shoppingCartService.saveProduct(product);
	}
	
	@PostMapping("/savemusicincart")
	public String saveMusicInCart(@ModelAttribute(value="item") Music music) {
		Optional<Music> getmusic = musicService.GetMusicById(music.getId());
		shoppingCartService.saveMusic(getmusic.get());
		
		return "redirect:music_catalog";
	}
	
	@PostMapping("/deleteShoppingItem")
	public String deleteShoppingItem(@ModelAttribute(value="cartItem") Item item, Model model) {
		shoppingCartService.deleteItem(item.getId());
		
		ArrayList<Item> items = (ArrayList<Item>) shoppingCartService.showItems();
		BigDecimal total = BigDecimal.ZERO;
		for (Item i: items) {
			total = total.add(i.getPrice());
		}
		
		model.addAttribute("item", items);
		model.addAttribute("total", total);
		
		return "redirect:shoppingcart";
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
		User user = userService.getUser();
		if (user.getExperation_date() == 0) {
			model.addAttribute("month", 0);
			model.addAttribute("year", 2020);
		} else {
			String date = Integer.toString(user.getExperation_date());
			String monthStr, yearStr;
			if (date.length() == 5) {
				monthStr = date.substring(0,1);
				yearStr = date.substring(1);
			} else {
				monthStr = date.substring(0, 2);
				yearStr = date.substring(2);
			}
			model.addAttribute("month", monthStr);
			model.addAttribute("year", yearStr);
		}
		model.addAttribute("credit", user.getCreditcard());
		model.addAttribute("name", user.getUsername());
		model.addAttribute("total", total);
		return "checkout";
	}
	
	@PostMapping("/buy")
	public String purchase(@RequestParam("credit") long credit, @RequestParam("savePurchase") boolean save,
							@RequestParam("expiration_month") int month, @RequestParam("expiration_year") int year) {
		
		shoppingCartService.purchase();
		if (save) {
			userService.updateCreditCard(credit, month, year);
		}
		
		return "shopping_cart";
	}
}
