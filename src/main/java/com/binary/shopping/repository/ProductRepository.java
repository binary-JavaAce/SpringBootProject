package com.binary.shopping.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.binary.shopping.entity.Product;


@Repository
public interface ProductRepository  extends CrudRepository<Product,Integer> {
	
		
}
