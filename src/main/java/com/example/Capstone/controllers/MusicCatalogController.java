	package com.example.Capstone.controllers;

import com.example.Capstone.entities.Music;
import com.example.Capstone.services.MusicService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.ui.Model;


@Controller
public class MusicCatalogController {


    @Autowired
    MusicService musicService;


    @RequestMapping(value = "/music_catalog", method = RequestMethod.GET)
    public String greeting(Model model) {

        Iterable<Music> Music = musicService.GetAllMusic();

        model.addAttribute("music", musicService.GetAllMusic());
        return "music_catalog";
    }
    
    
    @RequestMapping(value= "/newuser")
    public String userRegistration() {
    	
    	return "newUser";
    }

    @GetMapping("/musicname")
	public String searchMusicByName(@RequestParam String name, ModelMap map) throws Exception {
		 Music music = musicService.findByMusicName(name);
		 
		 List<Music> listMusic = new ArrayList<>(); 
		 listMusic.add(music);
		 map.addAttribute("music", listMusic);
		 return "music_catalog";
	}


}
