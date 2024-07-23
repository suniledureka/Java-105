package com.zettamine.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zettamine.hibernate.entity.Student;
import com.zettamine.hibernate.utils.HibernateUtility;

public class SearchStudent3 {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtility.getSessionFactory();
		Session session = sf.openSession();
		

		Student st = session.load(Student.class, 1015);
		System.out.println(st);
		session.close();
		sf.close();
	}

}
