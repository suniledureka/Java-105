package com.zettamine.hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.zettamine.hibernate.entity.Student;
import com.zettamine.hibernate.utils.HibernateUtility;

public class HQLTest {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateUtility.getSessionFactory();
		Session session = sfactory.openSession();
		/*
		//String hql = "from com.zettamine.hibernate.entity.Student";
		//String hql = "from com.zettamine.hibernate.entity.Student where studentName='Suraj'";
		//String hql = "from com.zettamine.hibernate.entity.Student where studentName like 'S%'";
		//String hql = "from com.zettamine.hibernate.entity.Student where studentId in (101,200,105,205,106)";
		//String hql = "from com.zettamine.hibernate.entity.Student order by studentName";
		String hql = "from com.zettamine.hibernate.entity.Student order by studentName desc";
		Query<Student> q = session.createQuery(hql, Student.class);
		//List<Student> students = q.list();
		List<Student> students = q.getResultList();
		printStudents(students);
		*/
		
		/*
		String hql = "from com.zettamine.hibernate.entity.Student where studentId between ?1 and ?2"; //positional parameters
		Query<Student> q = session.createQuery(hql, Student.class);
		q.setParameter(1, 101);
		q.setParameter(2, 105);
		List<Student> students = q.getResultList();
		printStudents(students);
		*/
		
		/*
		String hql = "from com.zettamine.hibernate.entity.Student where studentId between :minsid and :maxsid"; //named parameters
		Query<Student> q = session.createQuery(hql, Student.class);
		q.setParameter("minsid", 105);
		q.setParameter("maxsid", 200);
		List<Student> students = q.getResultList();
		printStudents(students);
		*/
		
		/*
		// applying pagination
		String hql = "from com.zettamine.hibernate.entity.Student"; 
		Query<Student> q = session.createQuery(hql, Student.class);
		q.setFirstResult(0);
		q.setMaxResults(4);
		List<Student> students = q.getResultList();
		printStudents(students);
		*/
		
		/*
		//applying aggregate functions - count
		String hql = "select count(*) from com.zettamine.hibernate.entity.Student";
		//Query query = session.createQuery(hql);
		//System.out.println(query.getSingleResult());
		
		Query<Long> query = session.createQuery(hql, Long.class);
		long noOfStudents = query.getSingleResult();
		System.out.println("no of students = " + noOfStudents);
		*/
		
		//fetching specific fields
		String hql = "select stud.studentId, stud.studentName from com.zettamine.hibernate.entity.Student stud";
		Query<Object[]> query = session.createQuery(hql, Object[].class);
		List<Object[]> list = query.list();
		for(Object[] obj : list) {
			System.out.println(Arrays.toString(obj));
		}

		//--- DML operations with HQL
		/*
		session.beginTransaction();
		String hql = "update com.zettamine.hibernate.entity.Student set studentName='Sai Kumar', studentEmail='sai.kumar@zetta.com' where studentId=104";
		Query query = session.createQuery(hql);
		int rowsUpdated = query.executeUpdate();
		System.out.println("no of rows updated = " + rowsUpdated);
		session.getTransaction().commit();
		*/
		/*
		session.beginTransaction();
		String hql = "delete from com.zettamine.hibernate.entity.Student stud where studentId=112";
		Query query = session.createQuery(hql);
		int rowsUpdated = query.executeUpdate();
		System.out.println("no of rows deleted = " + rowsUpdated);
		//session.getTransaction().rollback();
		session.getTransaction().commit();
		*/

		session.close();
		sfactory.close();
	}

	private static void printStudents(List<Student> students) {
		for(Student st : students) {
			System.out.println(st);
		}
		
	}

}
