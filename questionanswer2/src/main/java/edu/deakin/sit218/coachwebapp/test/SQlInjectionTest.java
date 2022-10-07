package edu.deakin.sit218.coachwebapp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.naming.java.javaURLContextFactory;

import java.sql.*;
import java.sql.Statement;


public class SQlInjectionTest {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the area of Knowledge");
		String areaofKnowledge = scanner.next();
		String jdbcStringURL = "jdbc:mysql://localhost/questionandanswerschema?"
				+"user=teacher&password=Ggmutofd1878!";	
		try {
			System.out.println("Connecting to a database");
			
			Connection connection = DriverManager.getConnection(jdbcStringURL);
			System.out.println("Connection is sucessful");
			//Statement statement = connection.createStatement();
			//String queryString = "select * from viva where areaofknowledge ='"+areaofKnowledge+"' Or 1=1 --";
			
			
			String queryString = "select * from viva where areaofknowledge = ?";
			PreparedStatement statement= connection.prepareStatement(queryString);
			statement.setString(1, areaofKnowledge);
			
			System.out.println(queryString);
			ResultSet resultset =statement.executeQuery();
			
			while(resultset.next())
			{
				int no= resultset.getInt("no");
				String questioString = resultset.getNString("question");
				String anString = resultset.getNString("answer");
				String areaofknwldgString = resultset.getNString("areaofknowledge");
				System.out.println(no+","+questioString+", "+anString+" , "+ queryString);
			}
			
			
		} catch (SQLException e) {
			System.out.println("Connecting to database failed "+e.getMessage());
			System.out.println("State"+e.getSQLState());
			System.out.println("Error"+e.getErrorCode());
		}
		
	}

}
