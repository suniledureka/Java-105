package com.zettamine.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zettamine.hibernate.entity.Student;
import com.zettamine.hibernate.utils.HibernateUtility;

public class UpdateStudent {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtility.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		/*
		//--- updating student - approach-1 ---
		Student st = new Student(101, "Sanjay Patil", "sanjay@hotmail.com");
		session.update(st);
		*/
		
		//---updating a student - approach-2 ---
		Student st = session.get(Student.class, 112);
		
		if(st != null) {
			System.out.println(st);
			st.setStudentName("Sunil Joseph"); //dirty object
		}else {
			System.out.println("--- no matching student found ----");
		}
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
