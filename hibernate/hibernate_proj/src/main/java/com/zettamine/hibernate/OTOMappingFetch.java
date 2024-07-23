package com.zettamine.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zettamine.hibernate.entities.Address;
import com.zettamine.hibernate.entities.Employee;
import com.zettamine.hibernate.utils.HibernateUtils;

public class OTOMappingFetch {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session session = sfactory.openSession();
				
		Employee emp = session.get(Employee.class, 101);
		System.out.println(emp.getEmployeeId() + " | " + emp.getEmployeeName());
		
		System.out.println("---------------------------------------------");
		
		Address addr = emp.getAddress();
		System.out.println(addr.getAddressId() + " , " + addr.getStreet());
		
		session.close();
		sfactory.close();
	}

}
