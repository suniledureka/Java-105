package com.zettamine.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
//@Table(name = "PRODUCT_DTLS")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	//@Column(name = "PROD_ID")
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pid_generator")
	//@SequenceGenerator(name = "pid_generator", sequenceName = "prod_sequence", initialValue = 101, allocationSize = 1)
	private Long productId;
	
	//@Column(name = "PROD_NAME")
	private String productName;
	
	//@Column(name = "PROD_PRICE", length = 10, precision = 2)
	private Float productPrice;

	public Product(String productName, Float productPrice) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
	}
	
	
}
