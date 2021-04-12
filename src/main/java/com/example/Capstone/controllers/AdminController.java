package com.example.Capstone.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Capstone.entities.Admin;
import com.example.Capstone.entities.Music;
import com.example.Capstone.entities.Product;
import com.example.Capstone.services.AdminService;
import com.example.Capstone.services.MusicService;
import com.example.Capstone.services.ProductService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@Autowired
	ProductService productService;

	@Autowired
	MusicService musicService;
	
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
		
		//Iterable<Product> product = productService.findAllProduct();
		Iterable<Music> music = musicService.GetAllMusic();
		
		model.addAttribute("music", music);
		
		return "adminInventory";
		
		
	}
	
    @GetMapping("/Adminmusicname")
	public String searchMusicByName(@RequestParam String name, ModelMap map) throws Exception {
    	

		 Iterable<Music> listMusic = musicService.SearchKeywordMusic(name); 
		
		 map.addAttribute("music", listMusic);
		 return "adminInventory";
	}
	
	@GetMapping("/adminOrders")
	public String showAdminOrders() {
		return "adminOrders";
	}
	
	@GetMapping("/adminEditMusic")
	public String editMusic(@ModelAttribute(value="editThis") Music song, Model model){
		
		Optional<Music> music = musicService.GetMusicById(song.getId());
		
		model.addAttribute("music", music.get());
		
		return "adminCreateItem";
	}
	
	@PostMapping("/adminEditMusic")
	public String editMusic(Model model, @ModelAttribute(value="music") Music music) {
		
		musicService.AddMusic(music);
		
		Iterable<Music> musics = musicService.GetAllMusic();
		model.addAttribute("music", musics);
		
		return "adminInventory";
	}
	
	@PostMapping("/adminDeleteMusic")
	public String deleteMusic(@ModelAttribute(value="song") Music song, Model model) {
		
		musicService.DeleteMusic(song);
		
		Iterable<Music> music= musicService.GetAllMusic();
		model.addAttribute("music", music);
		
		return "redirect:adminInventory";
	}
	
	@GetMapping("/adminCreateItem")
	public String adminCreate() {
		return "adminCreateItem";
	}
	
}
