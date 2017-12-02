package com.mtms.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mtm.dto.TripDetailsDto;
import com.mtms.entities.Journey;
import com.mtms.util.HibernateUtil;

public class HQLJPTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			/*
			 * Query query = session .createQuery(
			 * "Select p from Passenger p where 2 <= (Select count(jp.journeyId) from Passenger p1 inner join p1.journeys jp where p1.passengerId = p.passengerId)"
			 * ); List<Passenger> passengers = query.list(); for(Passenger p :
			 * passengers) { System.out.println(p); }
			 */

			/*
			 * Query query = session.createQuery(
			 * "Select p from Passenger p inner join fetch p.journeys");
			 * List<Passenger> passengers = query.list(); for(Passenger p :
			 * passengers) { System.out.println(p);
			 * System.out.println(p.getJourneys()); }
			 */

			/*
			 * Query query = session .createQuery(
			 * "Select p from Passenger p where p.age = (Select max(age) from Passenger)"
			 * ); List<Passenger> passengers = query.list();
			 * System.out.println(passengers.get(0).getName());
			 */

			/*
			 * Query query = session.createQuery(
			 * "Select count(p) from Passenger p inner join p.journeys j where j.source = ? and j.destination = ?"
			 * ); query.setString(0, "Hyderabad"); query.setString(1,
			 * "Banglore"); List<Long> passengers = query.list(); Long count =
			 * passengers.get(0); System.out.println(count);
			 */

			/*
			 * Query query = session.createQuery(
			 * "select p from Passenger p where p.journeys.size > 1");
			 * List<Passenger> rows = query.list(); for(Passenger row : rows) {
			 * System.out.println(row); }
			 */

			/*
			 * Query query = session
			 * .createQuery("Select j.journeyId, j.passengers.size from Journey j"
			 * ); List<Object[]> rows = query.list(); for (Object[] row : rows)
			 * { System.out.println("Journey : " + row[0] +
			 * " - noOfPassengers : " + row[1]); }
			 */

			/*Query query = session
					.createQuery("Select j.source, count(p.passengerId) from Journey j inner join j.passengers p group by (j.source)");
			List<Object[]> rows = query.list();
			for(Object[] row : rows) {
				System.out.println("Source : "+ row[0] + " - c : "+ row[1]);
			}*/
			
			/*Query query = session.createQuery("Select list(j.source, j.destination) from Journey j");
			List<List<String>> rows = query.list();*/
			/*for(Object[] row : rows) {
				System.out.println(row[0] + "-"+ row[1] );
			}*/
			
			/*Query query = session.createQuery("select new com.mtm.dto.TripDetailsDto(j.source, j.destination, j.journeyDate, j.passengers.size) from Journey j");
			List<TripDetailsDto> trips = query.list();
			for(TripDetailsDto trip : trips) {
				System.out.println(trip);
			}*/
			
			/*Query query = session.getNamedQuery("journeyById");
			query.setInteger(0, 1);
			List<Journey> journeys = query.list();
			for(Journey j : journeys) {
				System.out.println(j);
			}*/
			
			/**
			 * Eg: Native Sql Query
			 */

			SQLQuery query = session.createSQLQuery("select * from journey").addEntity(Journey.class);
			List<Journey> journeys = query.list();
			for(Journey j : journeys) {
				System.out.println(j);
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
}
