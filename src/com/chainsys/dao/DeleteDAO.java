package com.chainsys.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.chainsys.model.Book;
import com.chainsys.util.HibernateUtil;

public class DeleteDAO {

	public static void main(String[] args) {

		// Create session factory object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// getting session object from session factory
		Session session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();
		Book book = (Book) session.get(Book.class, 4L);
		if (book != null) {
			System.out.println("Deleted Successfully");
			session.delete(book);
		} else {
			System.out.println("No Record Found");
		}
		session.getTransaction().commit();
		sessionFactory.close();

	}

}
