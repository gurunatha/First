package com.flc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.flc.entities.Mobile;
import com.flc.util.HibernateUtil;

public class FLCTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Transaction transaction = null;
		Session session = null;
		Mobile mobile = null;
		boolean flag = false;

		mobile = new Mobile();
		mobile.setId(6);
		mobile.setModelName("OnePlus Three");
		mobile.setDescription("OnePlus Three HD");
		mobile.setManufacturer("OnePlus");
		mobile.setType("s");
		mobile.setNetworkType("GSM");
		mobile.setAmount(32000);

		try {
			sfactory = HibernateUtil.getSessionFactory();
			session = sfactory.openSession();
			mobile = (Mobile) session.get(Mobile.class, 1);
			System.out.println(mobile);
			//session.evict(mobile);
			session.clear();
			mobile = (Mobile) session.get(Mobile.class, 1);
			System.out.println(mobile);
			/*
			 * transaction = session.beginTransaction(); session.save(mobile);
			 * System.out.println("mobile saved..."); session.flush();
			 * System.out.println("session flushed...");
			 */flag = false;
			/*
			 * mobile = (Mobile) session.get(Mobile.class, 1);
			 * System.out.println(mobile); session.close(); session =
			 * sfactory.openSession(); Mobile mobile1 = (Mobile)
			 * session.get(Mobile.class, 1); System.out.println(mobile1);
			 * System.out .println("mobile 1 == mobile 2 ?: " + (mobile ==
			 * mobile1));
			 */
		} finally {

			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}

			if (session != null) {
				session.close();
			}
			HibernateUtil.closeSessionFactory();
		}

	}

}
