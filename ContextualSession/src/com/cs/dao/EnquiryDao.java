package com.cs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cs.entities.AdEnquiry;
import com.cs.util.HibernateUtil;

public class EnquiryDao {
	public int saveEnquiry(AdEnquiry enquiry) {
		SessionFactory sfactory = null;
		Session session = null;
		int id = 0;

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.getCurrentSession();
		id = (Integer) session.save(enquiry);
		return id;
	}
}
