package com.revature.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productdata")
public class Product {
	
	@Id
	private int productId;
	private String productName;
	private int quantityOnHand;
	private int price;

}
