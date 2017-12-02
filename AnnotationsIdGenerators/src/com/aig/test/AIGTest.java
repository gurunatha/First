package com.aig.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.aig.entities.Plan;
import com.aig.util.HibernateUtil;

public class AIGTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		Plan plan = null;
		boolean flag = false;

		try {

			plan = new Plan();
			plan.setPlanName("Night116CPlan");
			plan.setType("prepaid");
			plan.setDescription("Client Plan");
			plan.setAmount(99f);
			plan.setValidityInDays(30);

			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(plan);
			System.out.println("plan id : " + plan.getId());
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
