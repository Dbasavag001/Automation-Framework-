package com.sdet44.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class VerifyBeforeUpdateDataIntoDatabase {

	public static void main(String[] args) throws SQLException {
		String mobileName = "Note 10";
		String brandName = "MI";
		String price = "20000";
		Driver dbdriver =new Driver(); 
		DriverManager.registerDriver(dbdriver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet44","root","root");
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("select * from mobiles;");
			List<String> list=new ArrayList<String>();
			while(result.next()) {
				list.add(result.getString("mobileName").toLowerCase()+" || "+result.getString("price").toLowerCase()+" || "+result.getString("brand").toLowerCase());
			}
			if(list.contains(mobileName.toLowerCase()+" || "+price.toLowerCase()+" || "+brandName.toLowerCase())) {
				System.out.println("Data Already Existed");
			}
			else {
				statement.executeUpdate("insert into mobiles values('"+mobileName+"',"+price+",'"+brandName+"');");
				System.out.println("Data Updated Successfully");
			}


		}
		finally {
			connection.close();
			System.out.println("Connection Closed Successfully");
		}

	}
}


