package com.oto.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ono.util.HibernateUtil;
import com.oto.entities.Card;
import com.oto.entities.CardHolder;

public class OTOTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		CardHolder holder = null;
		Card card = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();
/*
			holder = new CardHolder();
			holder.setFirstName("John");
			holder.setLastName("P");
			holder.setAge(24);
			holder.setGender("Male");
			holder.setRelationShip("Father");
			holder.setMobile("3938293733");
			holder.setEmail("john@gmail.com");
			session.save(holder);

			card = new Card();
			card.setCardNumber("4321454534211231");
			card.setType("Credit Card");
			card.setExpiryMonth(9);
			card.setExpiryYear(2017);
			card.setCvv(453);
			card.setIssuedDate(new Date());
			card.setNameOnCard("John Philip");
			card.setHolder(holder);
			session.save(card);
*/
			card = (Card) session.get(Card.class, 1);
			System.out.println(card);

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
