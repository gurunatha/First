package com.fa.test;

import java.util.Date;

import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fa.entities.Event;
import com.fa.util.HibernateUtil;

public class FATest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sfactory = HibernateUtil.getSessionFactory();
			session = sfactory.openSession();
			transaction = session.beginTransaction();

			Event event = new Event();
			event.setId(1);
			event.setDescription("Web Service Sessions");
			event.setEventDate(new Date());
			event.setPlace("Mithrivanam");
			event.setPriority(1);
			event.setReminder(false);

			session.save(event);
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag == false) {
					transaction.rollback();
				} else {
					transaction.commit();
				}
			}
			if (session != null) {
				session.close();
			}
			HibernateUtil.closeSessionFactory();

		}

	}
}
