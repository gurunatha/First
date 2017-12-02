package com.sh.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sh.entities.Workshop;

public class SHTest {
	public static void main(String[] args) {
		Configuration configuration = null;
		SessionFactory sfactory = null;
		Workshop workshop = null;
		Session session = null;

		try {
			configuration = new Configuration().configure();
			sfactory = configuration.buildSessionFactory();
			session = sfactory.openSession();
			Transaction transaction = session.beginTransaction();

			workshop = new Workshop();
			workshop.setNo(2);
			workshop.setName("Antony Workshop");
			workshop.setEstDate(new Date());
			workshop.setAddressLine1("Post Office");
			workshop.setAddressLine2("Madhapur");
			workshop.setCity("Hyderabad");
			workshop.setState("TS");
			workshop.setZip(35252);
			workshop.setCountry("India");
			workshop.setPrimaryContactNo("33838");
			workshop.setAltContactNo("39394");
			workshop.setEmail("antony@gmail.com");
			workshop.setFax("3939382938");
			workshop.setWebsiteAddress("www.antonyservice.com");

			session.save(workshop);
			transaction.commit();
		} finally {
			if (session != null) {
				session.close();
			}
			if (sfactory != null) {
				sfactory.close();
			}
		}
	}
}
