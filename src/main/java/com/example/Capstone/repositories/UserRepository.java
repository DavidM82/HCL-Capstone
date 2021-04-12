package com.example.Capstone.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.Capstone.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
}
