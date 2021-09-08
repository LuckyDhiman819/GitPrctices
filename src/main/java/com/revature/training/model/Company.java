package com.revature.training.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ConfigurationProperties("company")
@Component
public class Company {

	
	private String companyname;
	private String companylocation;
	private String companyaddress;

}
