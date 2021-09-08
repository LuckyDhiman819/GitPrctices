package com.revature.training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.training.model.Product;
import com.revature.training.repository.ProductRepositry;

@Service
public class ProductServicesImp implements ProductServices {
	
	@Autowired
	ProductRepositry productRepositry;

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		
		productRepositry.save(product);
		
		return true;
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		
		productRepositry.deleteById(productId);
		
		return true;
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		
		productRepositry.save(product);
		
		
		return false;
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		
		Optional<Product> productData = productRepositry.findById(productId);
		
		Product product = productData.get();
		
		return product;
	}

	@Override
	public List<Product> getProductByName(String productName) {
		// TODO Auto-generated method stub
		return (List<Product>)productRepositry.findByProductName(productName);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		
		return (List<Product>) productRepositry.findAll();
	}

	@Override
	public boolean isProductExists(int productId) {
		
		Optional<Product> productData = productRepositry.findById(productId);
		return productData.isPresent();
		
	}

	@Override
	public boolean deleteAllProducts() {
		// TODO Auto-generated method stub
		
		productRepositry.deleteAll();
		
		return true;
	}

	@Override
	public List<Product> filterProductByPrice(int price1, int price2) {
		// TODO Auto-generated method stub
		
		return (List<Product>)productRepositry.findByPriceBetween(price1, price2);
	}

	@Override
	public List<Product> findByQuantityOnHand(int quantity) {
		// TODO Auto-generated method stub
		return (List<Product>) productRepositry.findByQuantityOnHand(quantity);
	}

	@Override
	public List<Product> findByNameAndRange(String name, int price1, int price2) {
		// TODO Auto-generated method stub
		
		
		
		return (List<Product>) productRepositry.findByProductNameLikeAndPriceBetween(name, price1, price2);
	}
	
	

}
