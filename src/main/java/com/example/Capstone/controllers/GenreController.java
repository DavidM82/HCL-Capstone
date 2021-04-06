package com.example.Capstone.controllers;

import org.springframework.stereotype.Controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Capstone.entities.Genre;
import com.example.Capstone.services.GenreService;

@Controller
public class GenreController {

private static Logger logger = LoggerFactory.getLogger(GenreController.class);
	
	@Autowired
	GenreService genreService;

	@PostMapping("/savegenre")
	public ResponseEntity<Genre> saveGenre(@RequestBody Genre genre){
		genreService.saveAndUpdateGenre(genre);
		return new ResponseEntity<Genre>(HttpStatus.OK);
	}
	
	@GetMapping("/genre")
	public Iterable<Genre> getGenreDetails(){
		return genreService.findAllGenre();
	}
	
	@GetMapping("/genre/{id}")
	public ResponseEntity<Genre> getGenreById(@PathVariable Integer id) throws Exception{
		Optional<Genre> genre = genreService.getGenreById(id);
		
		return genre.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	@DeleteMapping("/deletegenre/{id}")
	public ResponseEntity<String> deleteGenre(@PathVariable Integer id) throws Exception{
		logger.info("Deleting genre with id: "+ id);
		boolean isRemoved = genreService.deleteGenreById(id);
		
		if(!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Successfully Deleted "+ id, HttpStatus.OK);
	}
	
	@PutMapping("/updategenre/{id}")
	public ResponseEntity<Genre> updateGenre(@PathVariable Integer id, @RequestBody Genre genre) throws Exception{
		logger.info("Updating Genre to: "+ genre.toString());
		
		Genre editedGenre = genreService.findGenreById(id);
		editedGenre.setGenreName(genre.getGenreName());
		editedGenre.setImage(genre.getImage());
		genreService.updateGenre(editedGenre);
		
		return new ResponseEntity<Genre>(HttpStatus.OK);
	}
	
}
