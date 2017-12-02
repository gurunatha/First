package com.cs.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.AbstractCurrentSessionContext;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

public class GlobalSessionContext extends AbstractCurrentSessionContext {
	private Session session;

	public GlobalSessionContext(SessionFactoryImplementor factory) {
		super(factory);

	}

	@Override
	public Session currentSession() throws HibernateException {
		System.out.println("currentSession()");
		if (session == null || (session != null && session.isOpen() == false)) {
			session = super.factory().openSession();
		}
		return session;
	}

}
