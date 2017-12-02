package com.ig.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ig.entities.Policy;
import com.ig.util.HibernateUtil;

public class ConcurrencyTest1 {
	public static void main(String[] args) throws InterruptedException {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		Policy policy = null;
		boolean flag = false;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			for (int i = 0; i < 50; i++) {
				policy = new Policy();
				policy.setPolicyName("Policy");
				policy.setDescription("Life coverage policy");
				policy.setType("life-coverage");
				policy.setMinTenure(24);
				policy.setMaxTenure(120);
				policy.setEligibleAge(60);

				session.save(policy);
				Thread.sleep(100L);
			}
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
