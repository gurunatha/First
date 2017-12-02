package com.lb.test;

import com.lb.dao.ServiceTypeDao;
import com.lb.entities.AnnualServicePackage;
import com.lb.util.ManualHibernateUtil;

public class LBTest {
	public static void main(String[] args) {
		try {
			ServiceTypeDao dao = new ServiceTypeDao();
			AnnualServicePackage asPackage = dao.getAnnualServicePackage(1);
			System.out.println("Package Name : " + asPackage.getPackageName());
		} finally {
			ManualHibernateUtil.closeSessionFactory();
		}
	}
}
