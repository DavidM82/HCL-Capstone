package com.example.Capstone.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Capstone.entities.Album;
import com.example.Capstone.entities.Item;
import com.example.Capstone.entities.Music;
import com.example.Capstone.entities.Product;
import com.example.Capstone.entities.ShoppingCart;
import com.example.Capstone.entities.User;
import com.example.Capstone.repositories.ShoppingCartRepository;

@Service
public class ShoppingCartService {

	@Autowired
	ShoppingCartRepository cartRepo;
	
	@Autowired
	CapstoneUserDetailsService userService;
	
	public void saveMusic(Music music) {
		ShoppingCart newItem = new ShoppingCart();
		newItem.setMusic(music);
		newItem.setUser(userService.getUser());
		
		cartRepo.save(newItem);
	}
	
	public void saveProduct(Product product) {
		ShoppingCart newItem = new ShoppingCart();
		newItem.setProduct(product);
		newItem.setUser(userService.getUser());
		
		cartRepo.save(newItem);
	}
	
	public void saveAlbum(Album album) {
		//pull all Music objects with this album, loop through Musics saving them.
	}
	
	public void purchase() {
		//With the items purchased, delete all records involving this user.
		cartRepo.deleteAllByUser(userService.getUser());
	}
	
	public Iterable<Item> showItems() {
		 Iterable<ShoppingCart> cart = cartRepo.findAllByUser(userService.getUser());
		 ArrayList<Item> items = new ArrayList<Item>();
		 for (ShoppingCart i: cart) {
			 Item j = null;
			 if (i.getMusic() == null) {
				 j = new Item(i.getProduct().getProductName(), i.getProduct().getPrice());
			 } else {
				 j = new Item(i.getMusic().getName(), i.getMusic().getPrice());
			 }
			 items.add(j);
		 }
		 return items;
	}
}
