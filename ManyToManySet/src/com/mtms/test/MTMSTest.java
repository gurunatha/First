package com.mtms.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mtms.entities.Journey;
import com.mtms.entities.Passenger;
import com.mtms.util.HibernateUtil;

public class MTMSTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Journey journey = null;
		Passenger passenger = null;
		Set<Passenger> passengers = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			passengers = new HashSet<Passenger>();
			passenger = new Passenger();
			passenger.setName("Subbarao");
			passenger.setGender("Male");
			passenger.setAge(24);
			passenger.setMobile("3938273");
			passenger.setEmergencyContactNo("000000000");

			passengers.add(passenger);

			passenger = new Passenger();
			passenger.setName("Aishwaraya");
			passenger.setGender("Female");
			passenger.setAge(2);
			passenger.setMobile("39383273");
			passenger.setEmergencyContactNo("108");
			passengers.add(passenger);

			journey = new Journey();
			journey.setSource("Hyderabad");
			journey.setDestination("Banglore");
			journey.setJourneyDate(new Date());
			journey.setFare(750.3f);
			journey.setDistance(567);
			journey.setPassengers(passengers);

			session.save(journey);

			//journey = (Journey) session.get(Journey.class, 1);
			//System.out.println(journey.getPassengers().size());
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
