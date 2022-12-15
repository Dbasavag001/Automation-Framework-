package com.sdet44.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseCreate {

	public static void main(String[] args) throws SQLException {

		
//	Create the object for driver implementation class and register driver to jdbc
		String mobileName="Note 11";
		String brandName="MI";
		int price=16080;
		
		Driver dbdriver= new Driver();// Load the database
		DriverManager.registerDriver(dbdriver);// Register database to jdbc
//		get/ establish database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet44","root","root");
		try {
//		create statement/environment
		Statement statement = connection.createStatement();
//		execute query
		//int result = statement.executeUpdate("insert into mobiles values('"+mobileName+"',"+price+",'"+brandName+"')");
		
		ResultSet table = statement.executeQuery("select * from mobiles");		//fetch the data
//		validating data wheather updated or not
		statement.executeUpdate("insert into mobiles values('"+mobileName+"',"+price+",'"+brandName+"');");
		System.out.println("data added");
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}  
//		finally {
//			connection.close();
//			
//		}
		
		
	}

}
