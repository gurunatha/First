package com.fh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fh.entities.Customer;

public class FHTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sfactory = configuration.buildSessionFactory();
		Session session = sfactory.openSession();
		Customer customer = (Customer) session.get(Customer.class, 1);
		System.out.println("firstName : " + customer.getFirstName());
		session.close();
		sfactory.close();
	}
}
