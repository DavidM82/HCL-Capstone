package com.example.Capstone.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Capstone.entities.ShoppingCart;
import com.example.Capstone.entities.User;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Integer>{


	Iterable<ShoppingCart> findAllByUser(User user);
	
	void deleteAllByUser(User user);
}
