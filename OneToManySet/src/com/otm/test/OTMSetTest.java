package com.otm.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otm.entities.Approval;
import com.otm.entities.Property;
import com.otm.util.HibernateUtil;

public class OTMSetTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		Approval approval = null;
		Property property = null;
		Set<Approval> approvals = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			approvals = new HashSet<Approval>();
			
			property = new Property();
			property.setPropertyName("Cyber Zone");
			property.setDescription("Gated Villas");
			property.setType("Gated");
			property.setArea(3552);
			property.setLocation("Madhapur");
			property.setAmount(3837232.34f);
			property.setApprovals(approvals);

			session.save(property);
			
			
			approval = new Approval();
			approval.setApprovalName("Waterboard approval");
			approval.setDescription("GHMC Approval");
			approval.setIssuedAuthority("GHMC");
			approval.setIssuedDate(new Date());
			approval.setProperty(property);
			approvals.add(approval);
			session.save(approval);

			approval = new Approval();
			approval.setApprovalName("Electricity Connection");
			approval.setDescription("Society Electricity Connection");
			approval.setIssuedAuthority("TSDPCL");
			approval.setIssuedDate(new Date());
			approval.setProperty(property);
			approvals.add(approval);
			session.save(approval);

			
			
			/*property = (Property) session.get(Property.class, 1);
			System.out.println(property);*/
			/*approval = (Approval) session.get(Approval.class, 1);
			System.out.println(approval.getProperty().getDescription());*/
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			HibernateUtil.closeSessionFactory();
		}

	}
}
