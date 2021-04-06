package com.example.Capstone.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Capstone.entities.Genre;
import com.example.Capstone.repositories.GenreRepository;

import java.util.Optional;

@Service
public class GenreService {
    private static Logger logger = LoggerFactory.getLogger(GenreService.class);

    @Autowired
    GenreRepository genreRepository;
    
    public Genre findGenreById(int id) {
    	return genreRepository.findGenreById(id);
    }

    public Iterable<Genre> findAllGenre(){
        return genreRepository.findAll();
    }

    public Optional<Genre> getGenreById(int id) throws Exception{
        Optional<Genre> genre = genreRepository.findById(id);

        if(genre!= null) {
            logger.info("genre: "+genre.toString());
            return genre;
        }

        logger.error("genre is null");
        throw new Exception("genre with " + id + " doesn't exist");
    }
    
    public Genre saveAndUpdateGenre(Genre genre) {
		return genreRepository.save(genre);
	}
	
	public boolean deleteGenreById(Integer id) throws Exception{
		logger.info("deleting genre with id: "+id);
		if(genreRepository.existsById(id)) {
			genreRepository.deleteById(id);
			return true;
		}
		
		logger.error("genre is null");
		throw new Exception("Genre not found");
    }
	
	public Genre updateGenre(Genre genre) {
		return genreRepository.save(genre);
	}

}
