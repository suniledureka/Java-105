package com.zettamine.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zettamine.hibernate.entities.Address;
import com.zettamine.hibernate.entities.Employee;
import com.zettamine.hibernate.utils.HibernateUtils;

public class OTOMapping {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session session = sfactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Employee emp = new Employee();
		emp.setEmployeeId(103);
		emp.setEmployeeName("Mark");
		  
		Address addr = new Address(); 
		addr.setStreet("Banjara Hilld");
		addr.setCity("Hyderabad"); 
		addr.setState("Telangana");		  
		  
		emp.setAddress(addr);
		
		session.persist(emp);
		
		tx.commit();
		session.close();
		sfactory.close();
	}

}
