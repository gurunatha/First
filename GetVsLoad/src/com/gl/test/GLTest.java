package com.gl.test;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gl.entities.IServiceType;
import com.gl.entities.ServiceType;
import com.gl.util.HibernateUtil;

public class GLTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		IServiceType serviceType = null;
		Session session = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			serviceType = (IServiceType) session.load(ServiceType.class, 1);
			System.out.println(serviceType.getClass().getName());
			try {
				System.out.println("Type Id : "
						+ serviceType.getServiceTypeId());

				System.out.println("Service Name : "
						+ serviceType.getServiceName());
			} catch (ObjectNotFoundException e) {
				// supress the exception
				serviceType = null;
			}
			if (serviceType == null) {
				System.out.println("Object not found");
			}

		} finally {
			if (session != null) {
				session.close();
			}
			HibernateUtil.closeSessionFactory();
		}

	}
}
