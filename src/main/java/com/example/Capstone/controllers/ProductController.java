package com.example.Capstone.controllers;

import org.springframework.stereotype.Controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Capstone.entities.Album;
import com.example.Capstone.entities.Product;
import com.example.Capstone.services.ProductService;

@Controller
public class ProductController {
	private static Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductService productService;

	@PostMapping("/saveproduct")
	public ResponseEntity<Album> saveProduct(@RequestBody Product product){
		productService.addProduct(product);
		return new ResponseEntity<Album>(HttpStatus.OK);
	}
	
	@GetMapping("/product")
	public Iterable<Product> getProductDetails(){
		return productService.findAllProduct();
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Integer id) throws Exception{
		Optional<Product> product = productService.getProductById(id);
		
		return product.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	@GetMapping("/productname/{name}")
	public Product searchProductByName(@PathVariable String name) throws Exception {
		return productService.findByProductName(name);
	}
	
	@DeleteMapping("/deleteproduct/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer id) throws Exception{
		logger.info("Deleting product with id: "+ id);
		boolean isRemoved = productService.deleteProductById(id);
		
		if(!isRemoved) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Successfully Deleted "+ id, HttpStatus.OK);
	}
	
	@PutMapping("/updateproduct/{id}")
	public ResponseEntity<Product> updateCartProductItems(@PathVariable Integer id, @RequestBody Product product) throws Exception{
		logger.info("Updating product to: "+ product.toString());
		
		Product editedProduct = productService.findProductById(id);
		editedProduct.setProductName(product.getProductName());
		editedProduct.setDescription(product.getDescription());
		editedProduct.setImage(product.getImage());
		editedProduct.setPrice(product.getPrice());
		productService.updateProduct(editedProduct);
		
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
	
}
