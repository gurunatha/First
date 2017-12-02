package com.tpcc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tpcc.entities.AccidentalInsurancePlan;
import com.tpcc.entities.InsurancePlan;
import com.tpcc.entities.LifeInsurancePlan;
import com.tpcc.util.HibernateUtil;

public class TPSCTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		InsurancePlan ip = null;
		LifeInsurancePlan lip = null;
		AccidentalInsurancePlan aip = null;

		try {

			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			/*ip = new InsurancePlan();
			ip.setPlanName("Jeevan Arogya");
			ip.setDescription("Arogyam plan");
			ip.setPlanProvider("icici lamboard");
			session.save(ip);

			lip = new LifeInsurancePlan();
			lip.setPlanName("Jeevan Abhaya");
			lip.setDescription("Life coverage policy");
			lip.setPlanProvider("lic");
			lip.setEligibleAge(60);
			lip.setPlanPeriod(360);
			lip.setPreMedicalCheckup(true);
			session.save(lip);

			aip = new AccidentalInsurancePlan();
			aip.setPlanName("Jeevan Anand");
			aip.setDescription("Risk coverage policy");
			aip.setPlanProvider("Bajaj Allianz");
			aip.setCoveragePeriod(365);
			aip.setPartialDisability(false);
			aip.setDeathCoverage(true);
			session.save(aip);*/
			
			/*lip = (LifeInsurancePlan) session.get(LifeInsurancePlan.class, 2);
			System.out.println(lip);*/
			
			ip = (InsurancePlan) session.get(InsurancePlan.class, 3);
			System.out.println(ip);

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





