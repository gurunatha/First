package com.sp.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sp.entities.Person;
import com.sp.util.HibernateUtil;

public class SPTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		Person person = null;
		boolean flag = false;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			person = new Person();
			person.setId(1);
			person.setFirstName("Rod");
			person.setLastName("Andrew");
			person.setGender("Male");
			person.setAge(10);
			session.saveOrUpdate(person);
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					System.out.println("commited...");
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			HibernateUtil.closeSessionFactory();
		}
	}
}
