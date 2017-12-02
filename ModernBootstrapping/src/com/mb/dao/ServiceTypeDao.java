package com.mb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mb.entities.AnnualServicePackage;
import com.mb.util.HibernateUtil;

public class ServiceTypeDao {
	public AnnualServicePackage getAnnualServicePackage(
			int annualServicePackageNo) {
		AnnualServicePackage asPackage = null;
		SessionFactory sfactory = null;
		Session session = null;

		try {
			sfactory = HibernateUtil.getSessionFactory();
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
