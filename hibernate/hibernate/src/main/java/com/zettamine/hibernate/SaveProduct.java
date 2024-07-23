package com.zettamine.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zettamine.hibernate.entity.Product;
import com.zettamine.hibernate.utils.HibernateUtility;

public class SaveProduct {

	public static void main(String[] args) {
		
		SessionFactory sfactory = HibernateUtility.getSessionFactory();
		Session session = sfactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//Product prod = new Product(102L, "Mobile Phone", 75000f);
		Product prod = new Product("Computer", 48750f);
		
		session.save(prod);
				
		tx.commit();
		
		session.close();
		sfactory.close();
	}

}
