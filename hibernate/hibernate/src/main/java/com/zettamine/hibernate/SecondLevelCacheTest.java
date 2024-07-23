package com.zettamine.hibernate;

import java.util.concurrent.TimeUnit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zettamine.hibernate.entity.Student;
import com.zettamine.hibernate.utils.HibernateUtility;

public class SecondLevelCacheTest {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtility.getSessionFactory();
		Session session1 = sfactory.openSession();
		Session session2 = sfactory.openSession();
		
		Student st1 = session1.get(Student.class, 1);
		System.out.println(st1);
		System.out.println();
		
		try {
			TimeUnit.SECONDS.sleep(4);
		}catch(Exception ex) {}
		
		Student st2 = session2.get(Student.class, 1);
		System.out.println(st2);
		
		session1.close();
		session2.close();
		sfactory.close();
	}

}
