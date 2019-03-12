package com.chainsys.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.chainsys.model.Book;
import com.chainsys.util.HibernateUtil;

public class SelectDAO {

	public static void main(String[] args) {
		// Create session factory object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// getting session object from session factory
		Session session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();

		List<Book> books = session.createQuery("from Book", Book.class).list();
		books.forEach(b -> {
			System.out.println(b.getId());
			System.out.println(b.getName());
			System.out.println(b.getAuthor());
		});

		/*
		 * Query<Book> query = session.createQuery("from books", Book.class);
		 * List<Book> books = query.list(); for (Book b : books) {
		 * System.out.println(b.getId()); System.out.println(b.getName()); }
		 */
		session.getTransaction().commit();
		sessionFactory.close();
	}

}
