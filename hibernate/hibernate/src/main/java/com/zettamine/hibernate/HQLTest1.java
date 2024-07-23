package com.zettamine.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zettamine.hibernate.entity.Student;
import com.zettamine.hibernate.utils.HibernateUtility;

public class HQLTest1 {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtility.getSessionFactory();
		Session session = sfactory.openSession();
		session.beginTransaction();
		
		/*
		NativeQuery<?> query = session.createNativeQuery("insert into student values(112,'Sunil','sunil@gmail.com')", Student.class);
		System.out.println(query.executeUpdate());
		*/
		
		//String hql = "insert into com.zettamine.hibernate.entity.Student(studentName, studentEmail) select stud.studentName, stud.studentEmail from com.zettamine.hibernate.entity.Student stud where studentId=101";
		//Query q = session.createQuery(hql); 
		//System.out.println(q.executeUpdate());
		
				
		session.getTransaction().commit();
		session.close();
		sfactory.close();
	}

}
