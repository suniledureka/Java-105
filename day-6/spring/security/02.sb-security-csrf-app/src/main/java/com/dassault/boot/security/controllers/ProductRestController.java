package com.dassault.boot.security.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dassault.boot.security.models.Product;
import com.dassault.boot.security.repository.ProductsRepository;

@RestController
public class ProductRestController {
	private static final Logger logger = LoggerFactory.getLogger(ProductRestController.class);
	private List<Product> productsList = ProductsRepository.getProducts();
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){  
		return productsList; 
	}
	 
	@GetMapping("/products/{pid}")
	public Product getProductByProductId(@PathVariable("pid") Integer pid) {
	   Product product = productsList.stream().filter(prod -> prod.productId().equals(pid)).findFirst().orElse(null);
	   return product; 
	}
	
	@PostMapping("/products/new")
	public void addNewProduct(@RequestBody Product product) {
	   productsList.add(product);
	   logger.info("saving new product {}", product);
	 }
	
}
