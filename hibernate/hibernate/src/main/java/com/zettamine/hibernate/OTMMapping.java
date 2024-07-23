package com.zettamine.hibernate;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zettamine.hibernate.entity.Batch;
import com.zettamine.hibernate.entity.Faculty;
import com.zettamine.hibernate.utils.HibernateUtility;

public class OTMMapping {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtility.getSessionFactory();
		Session session = sfactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Faculty faculty = new Faculty();
		faculty.setFacultyId(101);
		faculty.setFacultyName("Sunil Joseph");
		
		Batch batch1 = new Batch("Java Certification", faculty);
		Batch batch2 = new Batch("Python Certification", faculty);
		Batch batch3 = new Batch("React Certification", faculty);
		
		Set<Batch> batches = new HashSet<>();
		batches.add(batch1);
		batches.add(batch2);
		batches.add(batch3);
		
		faculty.setBatches(batches);
		
		session.persist(faculty);
		
		tx.commit();
		session.close();
		sfactory.close();

	}

}
