package com.ck.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ck.entities.RationCard;
import com.ck.entities.RationCardPK;
import com.ck.util.HibernateUtil;

public class CKTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		RationCard card = null;
		boolean flag = false;

		try {
			/*card = new RationCard();
			card.setRationCardNo(1);
			card.setWardNo(34);
			card.setCardHolderName("John");
			card.setGender("Male");
			card.setDateOfBirth(new Date());*/

			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			RationCardPK pk = new RationCardPK();
			pk.setRationCardNo(1);
			pk.setWardNo(34);
			
			card = (RationCard) session.get(RationCard.class, pk);
			System.out.println("name : "+ card.getCardHolderName());
			//session.save(card);
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
			}
			if (session != null) {
				session.close();
			}
			HibernateUtil.closeSessionFactory();
		}

	}
}
