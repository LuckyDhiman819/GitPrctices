package com.revature.training.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.revature.training.model.Product;

public interface ProductRepositry extends CrudRepository<Product, Integer> {
	
	public List<Product> findByProductName(String productName);
	
	public List<Product> findByQuantityOnHand(int quantityOnHand);
	
	public List<Product> findByQuantityOnHandGreaterThan(int quantityOnHand);
	
	public List<Product> findByQuantityOnHandLessThan(int quantityOnHand);
	
	public List<Product> findByPriceBetween(int price1, int price2);
	
	public List<Product> findByProductNameLikeAndPriceBetween(String name,int price1, int price2);
	
	

}
