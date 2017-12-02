package com.mtml.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mtml.entities.Invoice;
import com.mtml.entities.Product;
import com.mtml.util.HibernateUtil;

public class MTMLTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = false;
		Invoice invoice = null;
		Product product = null;
		List<Product> products = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			transaction = session.beginTransaction();

			/*products = new ArrayList<Product>();
			product = new Product();
			product.setName("IPhone 6s");
			product.setDescription("Apple smart phone");
			product.setManufacturer("Apple");
			product.setPrice(65000);

			products.add(product);

			product = new Product();
			product.setName("Samsung Galaxy S7");
			product.setDescription("Samsung smart phone");
			product.setManufacturer("Samsung");
			product.setPrice(50000);

			products.add(product);

			invoice = new Invoice();
			invoice.setInvoiceDate(new Date());
			invoice.setCustomerName("John");
			invoice.setMobile("3378495");
			invoice.setEmail("john@gmail.com");
			invoice.setAmount(109304);
			invoice.setProducts(products);

			session.save(invoice);*/
			
			invoice = (Invoice) session.get(Invoice.class, 1);
			System.out.println(invoice.getProducts().size());

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
