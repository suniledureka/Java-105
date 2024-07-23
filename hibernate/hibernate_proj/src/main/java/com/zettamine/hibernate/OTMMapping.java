package com.zettamine.hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.zettamine.hibernate.entities.Batch;
import com.zettamine.hibernate.entities.Faculty;
import com.zettamine.hibernate.utils.HibernateUtils;

public class OTMMapping {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtils.getSessionFactory();
		Session session = sfactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Faculty faculty = new Faculty();
		faculty.setFacultyId(101);
		faculty.setFacultyName("Sunil Joseph");
		
		Batch batch1 = new Batch("Java Certification", faculty);
		Batch batch2 = new Batch("Python Certification", faculty);
		Batch batch3 = new Batch("React Certification", faculty);
		
		List<Batch> batches = Arrays.asList(batch1, batch2, batch3);
				
		faculty.setBatches(null);
		
		session.persist(faculty);
		
		tx.commit();
		session.close();
		sfactory.close();

	}

}
