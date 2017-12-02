package com.lb.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManualHibernateUtil {
	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		configuration.setProperty("hibernate.connection.driver_class",
				"oracle.jdbc.driver.OracleDriver");
		configuration.setProperty("hibernate.connection.url",
				"jdbc:oracle:thin:@localhost:1521:xe");
		configuration.setProperty("hibernate.connection.username",
				"next_gen_auto_sys");
		configuration.setProperty("hibernate.connection.password", "welcome1");
		configuration
				.addResource("com/lb/entities/AnnualServicePackage.hbm.xml");

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
