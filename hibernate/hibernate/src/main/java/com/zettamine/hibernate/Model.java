package com.zettamine.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zettamine.hibernate.utils.HibernateUtility;

public class Model {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtility.getSessionFactory();
		Session session = sfactory.openSession();
		
		session.close();
		sfactory.close();

	}

}
