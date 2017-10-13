package com.game.hibernate;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateUserTable {
	public static void main(String[] args) {
		// Get a session factory object
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// Create a session object from session factory object, this is request specific
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		try {
			String create_table = readFile("queries/create_table.sql", Charset.defaultCharset());
			session.createSQLQuery(create_table).executeUpdate();
		} catch (IOException e) {
			e.printStackTrace();
		}

		session.getTransaction().commit(); // commit the database entry
		session.close();
		System.out.println("Create table successfully");

	}

	static String readFile(String path, Charset encoding) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}
