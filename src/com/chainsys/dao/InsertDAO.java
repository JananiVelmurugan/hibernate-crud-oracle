package com.chainsys.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.chainsys.model.Author;
import com.chainsys.model.Book;
import com.chainsys.util.HibernateUtil;

public class InsertDAO {
	public static void main(String[] args) {
		// Create student entity object
		Book book = new Book();
		book.setName("Java");

		Author author = new Author();
		author.setName("Herbert");
		book.setAuthor(author);

		// Create session factory object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// getting session object from session factory
		Session session = sessionFactory.openSession();
		// getting transaction object from session object
		session.beginTransaction();

		session.save(book);
		System.out.println("Inserted Successfully");
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
