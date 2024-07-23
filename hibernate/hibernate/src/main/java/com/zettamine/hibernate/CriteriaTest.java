package com.zettamine.hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.zettamine.hibernate.entity.Student;
import com.zettamine.hibernate.utils.HibernateUtility;

public class CriteriaTest {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtility.getSessionFactory();
		Session session = sfactory.openSession();
		/*
		Criteria criteria = session.createCriteria(Student.class);
		criteria.setFirstResult(0);
		criteria.setMaxResults(50);
		//criteria.addOrder(Order.asc("studentName"));
		//criteria.add(Restrictions.between("studentId", 105, 120));

		criteria.addOrder(Order.desc("studentName"));
		criteria.add(Restrictions.like("studentName", "S%"));
		
		List<Student> students = criteria.list();
		*/
		
		//-- from Hibernate 5.2+
		// Create javax.persistence.criteria.CriteriaBuilder
		 CriteriaBuilder builder = session.getCriteriaBuilder();
		// Create javax.persistence.criteria.CriteriaQuery
		 CriteriaQuery<Student> criter = builder.createQuery(Student.class);

		 criter.from(Student.class);//to specify query roots
				
		 Query<Student> q= session.createQuery(criter);

		 List<Student> students = q.getResultList();
		printStudents(students);
		
		session.close();
		sfactory.close();
	}
	
	private static void printStudents(List<Student> students) {
		for(Student st : students) {
			System.out.println(st);
		}
		
	}
}
