package com.revature.training.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.training.model.Customer;


@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@GetMapping
	public List<Customer> getAllProduct(){
		System.out.println("All Customer Details....");
		return null;	
	}
	@GetMapping("{customerId}")
	public List<Customer> getProduct(@PathVariable("customerId")int pid){
		System.out.println("Customer Details By id "+ pid);
		return null;	
	}
	@GetMapping("/ProductName/{customerName}")
	public List<Customer> getProductByName(@PathVariable("customerName")String PName){
		System.out.println("Customer Details By Name "+ PName);
		return null;	
	}
	@PostMapping
	public String setProduct(@RequestBody Customer customer){
		System.out.println("All Customer Called....");
		System.out.println(customer);
		return null;	
	}
	@PutMapping
	public String putProduct(@RequestBody Customer customer){
		System.out.println("put Method Customer Called....");
		System.out.println(customer);
		return null;	
	}
	@DeleteMapping
	public String deleteProduct(@RequestBody Customer customer){
		System.out.println("Delete Customer Called....");
		System.out.println(customer);
		return null;	
	}
	@DeleteMapping("{productId}")
	public String deleteProductById(@PathVariable("customerId")int pid){
		System.out.println("Delete Customer using by id is:- "+ pid);
//		System.out.println(product);
		return null;	
	}
	
}
