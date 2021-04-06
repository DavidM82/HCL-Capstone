package com.example.Capstone.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.Capstone.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	public Product findByProductName(String name);
	public Product findProductById(Integer id);

}
