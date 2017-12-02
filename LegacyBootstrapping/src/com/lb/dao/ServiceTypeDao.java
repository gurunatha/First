package com.lb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.lb.entities.AnnualServicePackage;
import com.lb.util.ManualHibernateUtil;

public class ServiceTypeDao {
	public AnnualServicePackage getAnnualServicePackage(
			int annualServicePackageNo) {
		AnnualServicePackage asPackage = null;
		SessionFactory sfactory = null;
		Session session = null;

		try {
			sfactory = ManualHibernateUtil.getSessionFactory();
			session = sfactory.openSession();
			asPackage = (AnnualServicePackage) session.get(
					AnnualServicePackage.class, annualServicePackageNo);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return asPackage;
	}
}
