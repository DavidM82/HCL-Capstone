package com.example.Capstone.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Capstone.entities.Album;
import com.example.Capstone.entities.ShoppingCart;
import com.example.Capstone.entities.User;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Integer>{


	Iterable<ShoppingCart> findAllByUser(User user);
		
	@Transactional
	void deleteAllByUser(User user);
	
}
