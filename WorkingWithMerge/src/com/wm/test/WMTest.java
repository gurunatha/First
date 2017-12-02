package com.wm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.wm.entities.AdEnquiry;
import com.wm.util.HibernateUtil;

public class WMTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Transaction transaction = null;
		Session session = null;
		AdEnquiry enquiry = null;
		boolean flag = false;

		try {

			/*
			 * enquiry = new AdEnquiry();
			 * enquiry.setDescription("Surya Steels"); enquiry.setDuration(60);
			 * enquiry.setEmail("surya@gmail.com");
			 * enquiry.setMobile("13393839384"); enquiry.setPlace("Ameerpet");
			 * enquiry.setOnTv(true); enquiry.setInternetMedia(true);
			 */
			sfactory = HibernateUtil.getSessionFactory();
			session = sfactory.openSession();
			transaction = session.beginTransaction();

			/* session.save(enquiry); */

			/*
			 * AdEnquiry enquiry1 = new AdEnquiry(); enquiry1.setId(2);
			 * enquiry1.setDuration(100); session.merge(enquiry1);
			 */
			enquiry = (AdEnquiry) session.get(AdEnquiry.class, 1);
			enquiry.setDescription("Surya Teja Steels");
			enquiry.setDuration(360);
			flag = true;
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
