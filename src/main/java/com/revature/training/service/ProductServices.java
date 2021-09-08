package com.revature.training.service;

import java.util.List;

import com.revature.training.model.Product;

public interface ProductServices {
	
	public boolean addProduct(Product product);
	public boolean deleteProduct(int productId);
	public boolean updateProduct(Product product);
	public Product getProductById(int productId);
	public List<Product> getProductByName(String productName);
	public List<Product> getAllProducts();
	public boolean isProductExists(int productId);
	public boolean deleteAllProducts();
	public List<Product> filterProductByPrice(int price1, int price2);
	public List<Product> findByQuantityOnHand(int quantity);
	public List<Product> findByNameAndRange(String name, int price1, int price2);

	
}
