package com.otmm.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otmm.entities.Incident;
import com.otmm.entities.SupportEngineer;
import com.otmm.util.HibernateUtil;

public class OTMMTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Incident incident = null;
		SupportEngineer supportEngineer = null;
		Map<String, Incident> assignedIncidents = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			assignedIncidents = new HashMap<String, Incident>();
			incident = new Incident();
			incident.setDescription("Lost/Stolen Card");
			incident.setPriority(1);
			incident.setReportedDate(new Date());
			incident.setStatus("new");

			assignedIncidents.put("CASE_LOG_1", incident);

			incident = new Incident();
			incident.setDescription("Report mis-use of card");
			incident.setPriority(1);
			incident.setReportedDate(new Date());
			incident.setStatus("new");

			assignedIncidents.put("CASE_LOG_2", incident);

			supportEngineer = new SupportEngineer();
			supportEngineer.setName("Rakesh");
			supportEngineer.setDesignation("Engineer");
			supportEngineer.setLevel(1);
			supportEngineer.setContactNo("3393844");
			supportEngineer.setEmail("rakesh@gmail.com");

			supportEngineer.setAssignedIncidents(assignedIncidents);
			session.save(supportEngineer);
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
