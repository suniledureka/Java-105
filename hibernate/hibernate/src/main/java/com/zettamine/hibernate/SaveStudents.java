package com.zettamine.hibernate;

import java.io.Serializable;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zettamine.hibernate.entity.Student;
import com.zettamine.hibernate.utils.HibernateUtility;

public class SaveStudents {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtility.getSessionFactory();
		Session session = sfactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Scanner sc = new Scanner(System.in);
		String req = "";
		
		do {
			System.out.println("enter student name & email:");
			String name = sc.next();
			String email = sc.next();
			
			Student st = new Student(name, email);			
			Serializable id = session.save(st);

			System.out.printf("student with student id: %d saved\n\n", id);
			
			System.out.print("do you want to save more students?[Y/N]: ");
			req = sc.next();
		}while(req.equalsIgnoreCase("Y"));
		
		
		tx.commit();
		session.close();
		sfactory.close();
	}
}
