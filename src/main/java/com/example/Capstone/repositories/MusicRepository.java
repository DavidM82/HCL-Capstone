package com.example.Capstone.repositories;

import com.example.Capstone.entities.Admin;
import com.example.Capstone.entities.Music;
import org.springframework.data.repository.CrudRepository;

public interface MusicRepository extends CrudRepository<Music, Integer>{
	public Admin findByUsername(String username);
	public Admin findAdminById(Integer id);
}