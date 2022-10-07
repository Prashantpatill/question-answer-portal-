package edu.deakin.sit218.coachwebapp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import edu.deakin.sit218.coachwebapp.entity.*;

public class TestJDBC {
	
	public static void main(String[] args)
	{
		String jdbcStringURL = "jdbc:mysql://localhost/questionandanswerschema?"
								+"user=teacher&password=Ggmutofd1878!";	
		
		
		try {
			System.out.println("Connecting to database");
			Connection connection = DriverManager.getConnection(jdbcStringURL);
			System.out.println("Connection Successful");
			connection.close();
		} catch (SQLException e) {
			System.out.println("Connecting to database failed "+e.getMessage());
					System.out.println("State"+e.getSQLState());
					System.out.println("Error"+e.getErrorCode());
		}
		
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Client.class)
				.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		try {
		Client client = new Client("What is the Course Id","SIT218","General");
		session.beginTransaction();
		
		//save the client object
		session.save(client);
		
		//commit transaction 
		session.getTransaction().commit();
		}
		finally {
			session.close();
			sessionFactory.close();
		}
	}

}

