package com.example.Capstone.repositories;
import org.springframework.data.repository.CrudRepository;

import com.example.Capstone.entities.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer> {
	public Admin findByUsername(String username);
	public Admin findAdminById(Integer id);

}
