package com.binary.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.binary.shopping.entity.Product;
import com.binary.shopping.service.ProductService;

@RestController
@RequestMapping("/api")
public class ShoppingController {
	
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello Everyone !!";
	}
	
	
	 @GetMapping("/products") 
	 public ResponseEntity<List<Product>> getProducts() {
		 	return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
	 
	}
	 
	 @PostMapping("/product")
	 public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		 	return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
	 
	}
	
	 @PutMapping("/product/{id}")
	 public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
		 	return new ResponseEntity<>(productService.updateProduct(id, product), HttpStatus.ACCEPTED);
	 
	}
	 
	 @DeleteMapping("/product/{id}")
	 public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		 	return new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.OK);
	 
	}
	
}
