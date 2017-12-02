package com.msf.test;

import com.msf.dao.ServiceTypeDao;
import com.msf.entities.ServiceType;
import com.msf.util.HibernateUtil;

public class MSFTest {
	public static void main(String[] args) {
		ServiceTypeDao dao = null;
		try {
			ServiceType serviceType = new ServiceType();
			serviceType.setServiceTypeId(7);
			serviceType.setServiceName("Denting");

			dao = new ServiceTypeDao();
			dao.saveServiceType(serviceType);
			System.out.println("saved service type");
			
			serviceType = dao.getServiceType(6);
			System.out
					.println("Service Name : " + serviceType.getServiceName());
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
