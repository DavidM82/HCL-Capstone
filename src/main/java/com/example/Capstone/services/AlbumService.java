package com.example.Capstone.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Capstone.entities.Album;
import com.example.Capstone.repositories.AlbumRepository;

@Service
public class AlbumService {
	private static Logger logger = LoggerFactory.getLogger(AlbumService.class);

	@Autowired
	AlbumRepository albumRepository;

	public Iterable<Album> getAllAlbum() {
		return albumRepository.findAll();
	}
	
	public Album findAlbumById(int id) {
		return albumRepository.findAlbumById(id);
	}

	public Optional<Album> getAlbum(int id) throws Exception {
		Optional<Album> album = albumRepository.findById(id);

		if (album != null) {
			logger.info("album: " + album.toString());
			return album;
		}

		logger.error("album is null");
		throw new Exception("Album not found");
	}

	public Album findByAlbumName(String name) throws Exception {
		
		Album album = albumRepository.findByAlbumName(name);
		
		if (album != null) {
			logger.info("album: " + album.toString());
			return album;
		}
		
		logger.error("album is null");
		throw new Exception("Album not found");
	}
	
	public Album saveAlbum(Album album) {
		return albumRepository.save(album);
	}
	
	public void updateAlbum(Album album) {
		albumRepository.save(album);
	}
	
	public boolean deleteAlbumById(Integer id) throws Exception{
		logger.info("deleting album with id: "+id);
		if(albumRepository.existsById(id)) {
			albumRepository.deleteById(id);
			return true;
		}
		
		logger.error("album is null");
		throw new Exception("Album not found");
    }

}
