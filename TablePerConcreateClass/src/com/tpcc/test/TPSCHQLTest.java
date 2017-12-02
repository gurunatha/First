package com.tpcc.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tpcc.entities.InsurancePlan;
import com.tpcc.util.HibernateUtil;

public class TPSCHQLTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			Query query = session
					.createQuery("Select i from InsurancePlan i where i.uPlanNo = ?");
			query.setInteger(0, 23);
			List<InsurancePlan> plans = query.list();
			System.out.println(plans.get(0).getPlanName());
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
