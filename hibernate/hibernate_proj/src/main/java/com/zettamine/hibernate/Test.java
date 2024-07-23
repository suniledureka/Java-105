package com.zettamine.hibernate;

import com.zettamine.hibernate.entities.Customer;

public class Test {

	public static void main(String[] args) {
		Customer cust = new Customer(101,"Sanjay");
		System.out.println(cust);
	}

}
