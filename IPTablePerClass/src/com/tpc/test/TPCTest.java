package com.tpc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tpc.entities.AccidentalInsurancePlan;
import com.tpc.entities.InsurancePlan;
import com.tpc.entities.LifeInsurancePlan;
import com.tpc.util.HibernateUtil;

public class TPCTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		// entities
		InsurancePlan ip = null;
		LifeInsurancePlan lip = null;
		AccidentalInsurancePlan aip = null;

		try {
			ip = new InsurancePlan();
			ip.setPlanName("Jeevan Anand");
			ip.setDescription("Risk/Life coverage plan");
			ip.setPlanProvider("Uhg");

			lip = new LifeInsurancePlan();
			lip.setPlanName("Jeevan Abhay");
			lip.setDescription("Life Coverage Plan");
			lip.setPlanProvider("Uhg");
			lip.setEligibleAge(60);
			lip.setPlanPeriod(120);
			lip.setPreMedicalCheckup(true);

			aip = new AccidentalInsurancePlan();
			aip.setPlanName("Risk Coverage");
			aip.setDescription("Accidental Coverage Plan");
			aip.setPlanProvider("aithena");
			aip.setCoveragePeriod(60);
			aip.setPartialDisability(true);
			aip.setDeathCoverage(true);

			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			session.save(ip);
			session.save(lip);
			session.save(aip);

			/*InsurancePlan plan = (InsurancePlan) session.get(InsurancePlan.class, 2);
			System.out.println(plan);*/
			
			/*lip = (LifeInsurancePlan) session.get(LifeInsurancePlan.class, 3);
			System.out.println(lip);*/
			
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
