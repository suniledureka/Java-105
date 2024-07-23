package com.zettamine.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zettamine.hibernate.entities.Address;
import com.zettamine.hibernate.entities.Employee;
import com.zettamine.hibernate.utils.HibernateUtils;

public class OTOMappingDelete {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session session = sfactory.openSession();
		session.beginTransaction();
		
		Employee emp = session.get(Employee.class, 103);
		System.out.println(emp.getEmployeeId() + " | " + emp.getEmployeeName() + " | "
				+ emp.getAddress().getStreet());
		
		session.remove(emp);
		
		session.getTransaction().commit();
		session.close();
		sfactory.close();
	}

}
