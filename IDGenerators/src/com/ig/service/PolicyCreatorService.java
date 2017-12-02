package com.ig.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ig.entities.Policy;
import com.ig.util.HibernateUtil;

public class PolicyCreatorService implements Runnable {

	@Override
	public void run() {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		Policy policy = null;
		boolean flag = false;

		try {
			policy = new Policy();
			policy.setPolicyName("Policy");
			policy.setDescription("Life coverage policy");
			policy.setType("life-coverage");
			policy.setMinTenure(24);
			policy.setMaxTenure(120);
			policy.setEligibleAge(60);

			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(policy);
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
			//HibernateUtil.closeSessionFactory(sessionFactory);
		}
	}

}
