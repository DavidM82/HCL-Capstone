package com.example.Capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Capstone.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsername(String username);
}
