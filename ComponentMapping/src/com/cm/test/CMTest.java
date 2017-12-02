package com.cm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cm.entities.MobilePlan;
import com.cm.entities.TarrifDetails;
import com.cm.util.HibernateUtil;

public class CMTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		MobilePlan mobilePlan = null;
		TarrifDetails tarrifDetails = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			mobilePlan = new MobilePlan();
			mobilePlan.setPlanName("Vodafone 199");
			mobilePlan.setDescription("Post paid 199 monthly plan");
			mobilePlan.setBillingDayOfMonth(10);
			mobilePlan.setRentalAmount(199);

			tarrifDetails = new TarrifDetails();
			tarrifDetails.setLocalCallCost(0.50f);
			tarrifDetails.setStdCallCost(1);
			tarrifDetails.setIsdCallCost(3.50f);
			tarrifDetails.setLocalMessageCost(0.25f);

			mobilePlan.setTarrifDetails(tarrifDetails);
			session.save(mobilePlan);

			mobilePlan = (MobilePlan) session.get(MobilePlan.class, 1);
			System.out.println(mobilePlan.getTarrifDetails().getLocalCallCost());
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
