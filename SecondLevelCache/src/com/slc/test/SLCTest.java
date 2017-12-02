package com.slc.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.slc.entities.Job;
import com.slc.util.HibernateUtil;

public class SLCTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Job job = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			/*job = new Job();
			job.setJobDescription("Jee 3 Years Experience Developer");
			job.setLevel("Level-2");
			job.setPostedDate(new Date());
			job.setTechnology("Java");
			job.setLocation("Hyderabad");

			session.save(job);*/

			job = (Job) session.get(Job.class, 1);
			System.out.println("First Level Cache Hit : "
					+ sessionFactory.getStatistics().getEntityFetchCount());
			System.out.println("Second Level Cache Hit : "
					+ sessionFactory.getStatistics()
							.getSecondLevelCacheHitCount());
			System.out.println(job);

			job = (Job) session.get(Job.class, 1);
			System.out.println("First Level Cache Hit : "
					+ sessionFactory.getStatistics().getEntityFetchCount());
			System.out.println("Second Level Cache Hit : "
					+ sessionFactory.getStatistics()
							.getSecondLevelCacheHitCount());
			System.out.println(job);
			transaction.commit();

			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
			job = (Job) session.get(Job.class, 1);
			System.out.println("First Level Cache Hit : "
					+ sessionFactory.getStatistics().getEntityFetchCount());
			System.out.println("Second Level Cache Hit : "
					+ sessionFactory.getStatistics()
							.getSecondLevelCacheHitCount());

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
