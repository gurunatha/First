package com.mtmm.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mtmm.entities.Project;
import com.mtmm.entities.Resource;
import com.mtmm.util.HibernateUtil;

public class MTMMTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Project project = null;
		Resource resource = null;
		Map<String, Resource> assignedResources = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			/*assignedResources = new HashMap<String, Resource>();
			resource = new Resource();
			resource.setResourceName("Raja K");
			resource.setRole("Lead");
			assignedResources.put("C-1938", resource);

			resource = new Resource();
			resource.setResourceName("Sumith");
			resource.setRole("Developer");
			assignedResources.put("C-1998", resource);

			project = new Project();
			project.setTitle("BMS System");
			project.setDescription("Banking Management System");
			project.setStartDate(new Date());
			project.setKeyTechnologies("Java");
			project.setClient("BOA");
			project.setAssignedResources(assignedResources);

			session.save(project);*/
			project = (Project) session.get(Project.class, 1);
			System.out.println(project);
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
