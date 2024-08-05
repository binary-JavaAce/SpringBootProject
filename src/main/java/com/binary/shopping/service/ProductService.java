package com.binary.shopping.service;

import java.util.List;

import com.binary.shopping.entity.Product;

public interface ProductService {
	
	public List<Product> getProducts();
	
	public Product findProductById(int id);
	
	public Product saveProduct(Product product);

	public String deleteProductById(int id);
	
	public Product updateProduct(int id, Product product);

}
