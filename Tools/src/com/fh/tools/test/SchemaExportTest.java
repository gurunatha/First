package com.fh.tools.test;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class SchemaExportTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		/*
		 * SchemaExport schemaExport = new SchemaExport(configuration);
		 * schemaExport.execute(false, true, false, true);
		 */
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(configuration.getProperties());
		StandardServiceRegistry registry = builder.build();
		SessionFactory factory = configuration.buildSessionFactory(registry);
		factory.close();
	}
}
