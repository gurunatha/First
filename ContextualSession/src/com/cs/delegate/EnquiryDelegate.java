package com.cs.delegate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.context.internal.ManagedSessionContext;

import com.cs.dao.EnquiryDao;
import com.cs.entities.AdEnquiry;
import com.cs.util.HibernateUtil;
import com.cs.vo.EnquiryVo;

public class EnquiryDelegate {
	public int storeEnquiry(EnquiryVo vo) {
		boolean flag = false;
		int enquiryId = 0;
		AdEnquiry adEnquiry = null;
		EnquiryDao enquiryDao = null;
		Transaction transaction = null;

		try {
			adEnquiry = new AdEnquiry();
			adEnquiry.setDescription(vo.getDescription());
			adEnquiry.setPlace(vo.getPlace());
			adEnquiry.setDuration(vo.getDuration());
			adEnquiry.setCustomer(vo.getCustomer());

			enquiryDao = new EnquiryDao();
			/*Session session = HibernateUtil.getSessionFactory().openSession();
			ManagedSessionContext.bind(session);*/

			transaction = HibernateUtil.getSessionFactory().getCurrentSession()
					.beginTransaction();
			enquiryId = enquiryDao.saveEnquiry(adEnquiry);

			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			/*ManagedSessionContext.unbind(HibernateUtil.getSessionFactory());*/
		}
		return enquiryId;
	}
}
