package com.otm.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.otm.entities.Property;
import com.otm.util.HibernateUtil;

public class HQLPATest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			/**
			 * Get all properties
			 */
			/*
			 * Query getAllPropertiesQuery =
			 * session.createQuery("from Property"); List<Property>
			 * allProperties = getAllPropertiesQuery.list(); for (Property
			 * property : allProperties) { System.out.println("Property : " +
			 * property.getPropertyName() + " approval : " +
			 * property.getApprovals()); }
			 */

			/**
			 * Eg: Where clause Get Properties based on type
			 */
			/*
			 * Query getPropertiesByTypeQuery = session
			 * .createQuery("from Property p where p.type = ?");
			 * getPropertiesByTypeQuery.setString(0, "Independent");
			 * List<Property> propertiesByType =
			 * getPropertiesByTypeQuery.list();
			 * printProperties(propertiesByType);
			 */

			/**
			 * Eg: Inner Join Get Properties who has approvals
			 */
			/*
			 * Query getPropertiesHasApprovalsQuery = session .createQuery(
			 * "Select distinct p from Property p inner join p.approvals");
			 * List<Property> propertiesWithApprovals =
			 * getPropertiesHasApprovalsQuery.list();
			 * printProperties(propertiesWithApprovals); flag = true;
			 */

			/**
			 * Eg: Where clause on Join tables Get Properties which are of type
			 * 'Gated' and has approval of GHMC
			 */
			/*
			 * Query getPropertiesBasedOnTypeAndApprovalQuery =
			 * session.createQuery(
			 * "Select p from Property p inner join p.approvals a where p.type = ? and a.issuedAuthority = ?"
			 * ); getPropertiesBasedOnTypeAndApprovalQuery.setString(0,
			 * "Gated"); getPropertiesBasedOnTypeAndApprovalQuery.setString(1,
			 * "GHMC"); List<Property> properties =
			 * getPropertiesBasedOnTypeAndApprovalQuery.list();
			 * printProperties(properties);
			 */

			/**
			 * Eg: Left outer join
			 */
			/*Query getPropertyAndApproval = session
					.createQuery("Select p.propertyName, a.approvalName from Property p left outer join p.approvals a where p.amount > ?");
			getPropertyAndApproval.setFloat(0, 2000000f);
			List<Object[]> rows = getPropertyAndApproval.list();
			for (Object[] row : rows) {
				System.out.println("PName : " + row[0] + " - approval : "
						+ row[1]);
			}*/
			
			
			
			
			
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

	private static void printProperties(List<Property> properties) {
		for (Property property : properties) {
			System.out.println(property.getPropertyName());
		}
	}
}
