package com.msf.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.msf.entities.ServiceType;
import com.msf.util.HibernateUtil;

public class ServiceTypeDao {
	public void saveServiceType(ServiceType serviceType) {
		SessionFactory sfactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sfactory = HibernateUtil.getSessionFactory();
			session = sfactory.openSession();
			transaction = session.beginTransaction();
			session.save(serviceType);
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
		}
	}

	public ServiceType getServiceType(int serviceTypeId) {
		ServiceType serviceType = null;
		SessionFactory sfactory = null;
		Session session = null;

		try {
			sfactory = HibernateUtil.getSessionFactory();
			session = sfactory.openSession();
			serviceType = (ServiceType) session.get(ServiceType.class,
					serviceTypeId);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return serviceType;
	}
}
