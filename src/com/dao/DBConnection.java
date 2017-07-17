package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public Connection getconnection(){
		
		Connection conn= null;
		String DB_URL ="jdbc:mysql://localhost:3306/MarketPlace";
		try {
		Class.forName("com.mysql.jdbc.Driver");
			// System.out.println("Connecting to database...");
			 
		      conn = DriverManager.getConnection(DB_URL,"root","admin321");
		      
		      
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	
	}

}
