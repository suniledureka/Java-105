package com.zettamine.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zettamine.hibernate.entity.Student;
import com.zettamine.hibernate.utils.HibernateUtility;

public class SearchStudent1 {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtility.getSessionFactory();
		Session session = sf.openSession();
		
		Student st = new Student();
		System.out.println(st);
		try {
			//session.load(st, 101);
			session.load(st, 1015);
		}catch(Exception ex) {
			System.out.println(ex);
		}
		System.out.println(st);
		session.close();
		sf.close();
	}

}
