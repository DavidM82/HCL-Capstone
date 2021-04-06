package com.example.Capstone.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Capstone.entities.Product;
import com.example.Capstone.repositories.ProductRepository;

import java.util.Optional;

@Service
public class ProductService {
	private static Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	ProductRepository productRepository;
	
	public Product findProductById(int id) {
		return productRepository.findProductById(id);
	}

	public Iterable<Product> findAllProduct() {

		return productRepository.findAll();
	}

	public Optional<Product> getProductById(int id) throws Exception {
		Optional<Product> product = productRepository.findById(id);

		if (product != null) {
			logger.info("product: " + product.toString());
			return product;
		}

		logger.error("product is null");
		throw new Exception("product with " + id + " doesn't exist");

	}

	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	public boolean deleteProductById(Integer id) throws Exception {
		logger.info("deleting product with id: " + id);
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return true;
		}

		logger.error("product is null");
		throw new Exception("Product not found");
	}

	public Product findByProductName(String name) throws Exception {

		Product product = productRepository.findByProductName(name);

		if (product != null) {
			logger.info("album: " + product.toString());
			return product;
		}

		logger.error("product is null");
		throw new Exception("Product not found");
	}
	
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}

}
