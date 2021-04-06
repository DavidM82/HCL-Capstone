package com.example.Capstone.repositories;

import com.example.Capstone.entities.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Integer>{
	public Album findByAlbumName(String name);
	public Album findAlbumById(Integer id);
}