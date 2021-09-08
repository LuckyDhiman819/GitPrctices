package com.revature.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.training.model.Product;
import com.revature.training.service.ProductServices;

@RestController
@RequestMapping("product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	@Autowired
	ProductServices productServices;
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProduct(){
		System.out.println("All Products Details....");
		ResponseEntity<List<Product>> responseEntity = null;
		List<Product> allProduct = productServices.getAllProducts();
		
		if(allProduct.size()==0) {
			responseEntity = new ResponseEntity<List<Product>>(allProduct, HttpStatus.NO_CONTENT);
		}
		else {
			
			responseEntity = new ResponseEntity<List<Product>>(allProduct, HttpStatus.OK);
		}
		
		
		return responseEntity;	
	}
	
	
	@GetMapping("{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId")int productId){
		System.out.println("Product Details By id "+ productId);
		ResponseEntity<Product> responseEntity = null;
		Product product = new Product();
		
		if(productServices.isProductExists(productId)) {
			product = productServices.getProductById(productId);
			responseEntity = new ResponseEntity<Product>(product, HttpStatus.OK);
					}
		else {
			
			responseEntity = new ResponseEntity<Product>(product, HttpStatus.NOT_FOUND);
		}
		
		return responseEntity;	
	}
	
	
	@GetMapping("/QuantityOnHand/{quantityOnHand}")
	public List<Product> getProductByQuantity(@PathVariable("quantityOnHand")int quantity){
		System.out.println("Product Details By id "+ quantity);
		
		return (List<Product>) productServices.findByQuantityOnHand(quantity) ;	
	}
	
	
	@GetMapping("/ProductName/{productName}")
	public List<Product> getProductByName(@PathVariable("productName")String PName){
		System.out.println("Product Details By Name "+ PName);
		
		return (List<Product>) productServices.getProductByName(PName);	
	}
	
	
	@GetMapping("/filterProductByPrice/{price1}/{price}")
	public List<Product> getProductByPrice(@PathVariable("price1")int price1, @PathVariable("price")int price2){
		System.out.println("Product price "+ price1+" "+price2 );
		
		return (List<Product>)productServices.filterProductByPrice(price1, price2);
	}
	
	
	@GetMapping("/{productName}/range/{price1}/{price}")
	public List<Product> getByNameAndRange(@PathVariable("productName")String name ,@PathVariable("price1")int price1, @PathVariable("price")int price2){
		System.out.println("Product price "+ price1+" "+price2 );
		
		return (List<Product>)productServices.findByNameAndRange(name, price1, price2);
	}
	
	
	@PostMapping
	public ResponseEntity<String> setProduct(@RequestBody Product product){
		
		ResponseEntity<String> responseEntity = null;
		String message = null;
		System.out.println("All Products Called....");
		
		int productId = product.getProductId();
		
		if(productServices.isProductExists(productId)) {
			
			message = "This Product with product Id - "+productId+" already Exist";
			responseEntity = new ResponseEntity<String>(message, HttpStatus.CONFLICT);
			
		}
		else {
			message = "This Product with product Id - "+productId+" Susscessfully Created";
			responseEntity = new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
			
			productServices.addProduct(product);
		}
//		System.out.println(product);
		return responseEntity;	
	}
	
	
	@PutMapping
	public ResponseEntity<String> putProduct(@RequestBody Product product){
		ResponseEntity<String> responseEntity = null;
		String message = null;
		System.out.println("All Products Called....");
		
		int productId = product.getProductId();
		
		if(productServices.isProductExists(productId)) {
			
			message = "This Product with product Id - "+productId+" updated SuccesFully";
			responseEntity = new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
			productServices.updateProduct(product);
			
		}
		else {
			message = "This Product with product Id - "+productId+" not  fount";
			responseEntity = new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
			
		}
//		System.out.println(product);
		return responseEntity;		
	}
	
	
	@DeleteMapping
	public ResponseEntity<String> deleteProduct(@RequestBody Product product){
		ResponseEntity<String> responseEntity = null;
		List<Product> allProduct = productServices.getAllProducts();
		String message = null;
		if(allProduct.size()==0) {
			message = "All Products-  Not found";
			responseEntity = new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
		}
		else {
			message = "All Products-   deleted";
			responseEntity = new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
		}
		
		
		return responseEntity;	
	}
	
	
	@DeleteMapping("{productId}")
	public ResponseEntity<String> deleteProductById(@PathVariable("productId")int productId){
		ResponseEntity<String> responseEntity = null;
		String message = null;
		
				
		if(productServices.isProductExists(productId)) {
			
			message = "This Product with product Id - "+productId+"  deleted";
			responseEntity = new ResponseEntity<String>(message, HttpStatus.OK);
			productServices.deleteProduct(productId);
			System.out.println("Delete Called");
			
			
		}
		else {
			message = "This Product with product Id - "+productId+" not  found";
			responseEntity = new ResponseEntity<String>(message, HttpStatus.NO_CONTENT);
			
		}
//		System.out.println(product);
		return responseEntity;
			
	}
	
}
