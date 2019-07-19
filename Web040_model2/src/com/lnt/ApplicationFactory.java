package com.lnt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ApplicationFactory {
	private static Connection connect;
	
	public static Connection getConnection() {
		try {
			if(connect==null) {
				Class.forName("oracle.jdbc.OracleDriver");//loading driver class
				connect= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return connect;
	}
	
}
