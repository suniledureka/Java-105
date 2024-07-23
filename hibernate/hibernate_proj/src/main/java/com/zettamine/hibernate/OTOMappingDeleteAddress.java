package com.zettamine.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zettamine.hibernate.entities.Address;
import com.zettamine.hibernate.entities.Employee;
import com.zettamine.hibernate.utils.HibernateUtils;

public class OTOMappingDeleteAddress {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session session = sfactory.openSession();
		session.beginTransaction();
		
		Address addr = session.get(Address.class, 1);
		System.out.println(addr.getStreet() +", " +addr.getCity()+", "+addr.getState());
		
		session.remove(addr);
		
		session.getTransaction().commit();
		session.close();
		sfactory.close();
	}

}
