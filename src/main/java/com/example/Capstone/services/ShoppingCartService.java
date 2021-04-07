package com.example.Capstone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Capstone.entities.Album;
import com.example.Capstone.entities.Music;
import com.example.Capstone.entities.Product;
import com.example.Capstone.entities.ShoppingCart;
import com.example.Capstone.entities.User;
import com.example.Capstone.repositories.ShoppingCartRepository;

@Service
public class ShoppingCartService {

	@Autowired
	ShoppingCartRepository cartRepo;
	
	
	public void saveMusic(Music music, User user) {
		ShoppingCart newItem = new ShoppingCart();
		newItem.setMusic(music);
		newItem.setUser(user);
		
		cartRepo.save(newItem);
	}
	
	public void saveProduct(Product product, User user) {
		ShoppingCart newItem = new ShoppingCart();
		newItem.setProduct(product);
		newItem.setUser(user);
	}
	
	public void saveAlbum(Album album, User user) {
		//pull all Music objects with this album, loop through Musics saving them.
	}
	
	public void purchase(User user) {
		//With the items purchased, delete all records involving this user.
	}
}
