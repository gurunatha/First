package com.ig.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ig.entities.Policy;
import com.ig.util.HibernateUtil;

public class IGTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		Policy policy = null;
		boolean flag = false;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			policy = new Policy();
			policy.setPolicyName("Jeevan Safal");
			policy.setDescription("life coverage policy");
			policy.setType("life coverage");
			policy.setMinTenure(20);
			policy.setMaxTenure(100);
			policy.setEligibleAge(2);

			session.save(policy);
			System.out.println("id : "+ policy.getId());
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag == true) {
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
