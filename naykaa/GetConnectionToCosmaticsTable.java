package com.naykaa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnectionToCosmaticsTable {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/first"; 
		String username="root";
		String password="rathish@06TA";
		
		try {
			Connection conn=DriverManager.getConnection(url,username,password);
			System.out.println(conn);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}