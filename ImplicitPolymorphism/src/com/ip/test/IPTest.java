package com.ip.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ip.entities.AudioCd;
import com.ip.entities.Cd;
import com.ip.entities.VideoCd;
import com.ip.util.HibernateUtil;

public class IPTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			/*Cd cd = new Cd();
			cd.setTitle("Avatar");
			cd.setPrice(23);
			session.save(cd);

			AudioCd acd = new AudioCd();
			acd.setTitle("Dangerous");
			acd.setPrice(334);
			acd.setArtist("Micheal");
			acd.setTracks(10);
			session.save(acd);

			VideoCd vcd = new VideoCd();
			vcd.setTitle("IRobot");
			vcd.setPrice(383);
			vcd.setDirector("James");
			vcd.setDuration(243);
			session.save(vcd);*/

			Cd cd = (Cd) session.get(Cd.class, 2);
			System.out.println(cd);
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			HibernateUtil.closeSessionFactory();
		}

	}
}




