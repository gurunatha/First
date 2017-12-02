package com.oto.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.oto.entities.Mobile;
import com.oto.entities.Specification;
import com.oto.util.HibernateUtil;

public class OTOTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		Mobile mobile = null;
		Specification specification = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			/*mobile = new Mobile();
			mobile.setModelNo("m-9372");
			mobile.setModelName("Samsung Galaxy S7");
			mobile.setDescription("Galaxy series");
			mobile.setManufacturer("Samsung");
			mobile.setType("smart");
			mobile.setAmount(55448.0f);
			session.save(mobile);

			specification = new Specification();
			specification.setDualSim(false);
			specification.setMobileData("LTE");
			specification.setNetworkType("GSM");
			specification.setProcessor("Snapdragon");
			specification.setStorage("32 gb");
			specification.setRam("4 gb");
			specification.setMobile(mobile);
			session.save(specification);*/
			
			specification = (Specification) session.get(Specification.class, 1);
			System.out.println(specification);

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
