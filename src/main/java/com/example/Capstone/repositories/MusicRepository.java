package com.example.Capstone.repositories;

import com.example.Capstone.entities.Album;
import com.example.Capstone.entities.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends CrudRepository<Music, Integer>{
	public Music findMusicByName(String name);
	public Music findMusicById(Integer id);
	
	Iterable<Music> findAllByAlbum(Album album);
}