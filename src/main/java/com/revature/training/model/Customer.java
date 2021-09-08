package com.revature.training.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
	
	private String customerName;
	private int cutsomerId;
	private String phoneNumber;
	private String address;
	

}
