package com.otm.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.otm.entities.Property;
import com.otm.util.HibernateUtil;

public class CriteriaPATest {
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
			 * Get all Properties
			 */
			/*
			 * Criteria getAllPropertiesCriteria = session
			 * .createCriteria(Property.class); List<Property> allProperties =
			 * getAllPropertiesCriteria.list(); printProperties(allProperties);
			 */

			/*
			 * Criteria getPropertiesByType = session.createCriteria(
			 * Property.class).add(Restrictions.like("type", "Gated"));
			 * List<Property> allProperties = getPropertiesByType.list();
			 * printProperties(allProperties);
			 */

			/*
			 * Criteria getPropertiesHasApprovals = session.createCriteria(
			 * Property.class).createCriteria("approvals"); List<Property>
			 * allProperties = getPropertiesHasApprovals.list();
			 * printProperties(allProperties);
			 */

			/*
			 * Criteria getPropertiesByApprovalType = session
			 * .createCriteria(Property.class) .createAlias("approvals", "a")
			 * .add(Restrictions.like("a.issuedAuthority", "GHMC"));
			 * List<Property> allProperties =
			 * getPropertiesByApprovalType.list();
			 * printProperties(allProperties);
			 */

			/*
			 * org.hibernate.criterion.Property amountProperty =
			 * org.hibernate.criterion.Property .forName("amount"); Criteria
			 * getPropertyByAmount = session.createCriteria(
			 * Property.class).add( amountProperty.between(2000000f,
			 * 35000000f)); List<Property> properties =
			 * getPropertyByAmount.list(); printProperties(properties);
			 */
			Projection projection = Projections.property("propertyName");

			/*
			 * Criteria getAllPropertyNames = session.createCriteria(
			 * Property.class).setProjection(projection); List<String>
			 * propertyNames = getAllPropertyNames.list(); for (String name :
			 * propertyNames) { System.out.println(name); }
			 */

			Projection projection1 = Projections.projectionList()
					.add(Projections.property("propertyName"))
					.add(Projections.property("amount"));
			/*
			 * Criteria getNameAndAmountProperties = session.createCriteria(
			 * Property.class).setProjection(projection1); List<Object[]> rows =
			 * getNameAndAmountProperties.list(); for (Object[] row : rows) {
			 * System.out .println("name : " + row[0] + " - amount : " +
			 * row[1]); }
			 */

			/*
			 * Projection groupByType = Projections.groupProperty("type");
			 * Projection countProperty = Projections.count("propertyName");
			 * Projection countAndGroupProjection = Projections.projectionList()
			 * .add(countProperty).add(groupByType); Criteria
			 * getNoOfPropertiesByType = session.createCriteria(
			 * Property.class).setProjection(countAndGroupProjection);
			 * 
			 * List<Object[]> rows = getNoOfPropertiesByType.list(); for
			 * (Object[] row : rows) { System.out .println("name : " + row[0] +
			 * " - no : " + row[1]); }
			 */

			DetachedCriteria dc = buildPropertyByIdCriteria(1);
			Criteria c = dc.getExecutableCriteria(session);
			List<Property> properties = c.list();
			for(Property p : properties) {
				System.out.println(p);
			}

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

	public static DetachedCriteria buildPropertyByIdCriteria(int propertyId) {
		DetachedCriteria dc = DetachedCriteria.forClass(Property.class);
		dc.add(Restrictions.eq("propertyId", propertyId));
		return dc;
	}

	private static void printProperties(List<Property> properties) {
		for (Property property : properties) {
			System.out.println(property.getPropertyName());
		}
	}

}
