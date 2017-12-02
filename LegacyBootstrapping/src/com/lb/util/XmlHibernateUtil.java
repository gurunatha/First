package com.lb.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class XmlHibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration()
				.configure("com/lb/common/next-gen-auto-sys.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
