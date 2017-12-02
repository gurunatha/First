package com.cs.test;

import com.cs.delegate.EnquiryDelegate;
import com.cs.util.HibernateUtil;
import com.cs.vo.EnquiryVo;

public class CSTest {
	public static void main(String[] args) {
		EnquiryVo vo = null;
		EnquiryDelegate delegate = null;

		try {
			vo = new EnquiryVo();
			vo.setDescription("Surya Kiran General Stores Advertisement");
			vo.setPlace("ameerpet");
			vo.setDuration(60);
			vo.setCustomer("surya");

			delegate = new EnquiryDelegate();
			int id = delegate.storeEnquiry(vo);
			System.out.println("id: " + id);
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}
}
