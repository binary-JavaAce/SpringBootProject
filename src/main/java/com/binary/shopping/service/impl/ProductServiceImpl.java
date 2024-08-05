package com.binary.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.binary.shopping.entity.Product;
import com.binary.shopping.repository.ProductRepository;
import com.binary.shopping.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	
	@Autowired
	ProductRepository repository;
	
	
	public List<Product> getProducts() {
		Iterable<Product> products= repository.findAll();
		List<Product> list= new ArrayList<>();
		products.forEach(list::add);
		return list;		
	}
	
	public Product findProductById(int id) {
		
		Optional<Product> product= repository.findById(id);
		
			return product.get();		
		
	}
	
	public Product saveProduct(Product product) {
	 Product p=repository.save(product);
	 return p;
	}
	
	
	public String deleteProductById(int id) {
		
		Optional<Product> product=repository.findById(id);
		if(product.isPresent()) {
			repository.delete(product.get());
			return "Product Deleted Successfully.";
		}
		return "Something went wrong !! Product not available for deletion.";
		
		
	}
	
	
	public Product updateProduct(int id, Product product) {
		
		Optional<Product> prod=repository.findById(id);
		
		if(prod !=null) {
			Product p=prod.get();
			if(product.getProductName() != null ) {
				p.setProductName(product.getProductName());
			}
			if(product.getProductDescription() != null ) {
				p.setProductDescription(product.getProductDescription());
			}
			repository.save(p);
			return p;
		}
		return product;
		
	}
	
	

}
