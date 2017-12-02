package com.mb.test;

import com.mb.entities.AnnualServicePackage;

import com.mb.dao.ServiceTypeDao;

public class MBTest {
	public static void main(String[] args) {
		ServiceTypeDao dao = new ServiceTypeDao();
		AnnualServicePackage asPackage = dao.getAnnualServicePackage(1);
		System.out.println("Package  : " + asPackage.getPackageName());
	}
}
