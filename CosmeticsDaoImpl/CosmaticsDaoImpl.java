package com.CosmeticsDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.CosmeticsDao.CosmaticsDao;
import com.Dto.Cosmatics;

public  class CosmaticsDaoImpl implements CosmaticsDao {
	
	public Connection getDBConnection() throws SQLException{
		String url="jdbc:mysql://localhost:3306/first"; 
		String username="root";
		String password="rathish@06TA";
		Connection conn=null;
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
			
			 conn=  (Connection) DriverManager.getConnection(url,username,password);
			    System.out.println(conn);
		return conn;
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			throw new SQLException();
	}
	
	@Override
	public boolean save(Cosmatics cosmatics) {
		
			try {
				Connection conn=getDBConnection();
			    System.out.println(conn);
			    Statement stmt=conn.createStatement();
			    int id=cosmatics.getCosmaticsId();
			    String name=cosmatics.getName();
			    double price=cosmatics.getPrice();
			    String brand=cosmatics.getBrand();
			    
			    String sqlQuery="insert into Cosmatics values("+id+" "+name+" "+price+" "+brand+");";
			    int result=stmt.executeUpdate(sqlQuery);
			    
			    conn.close();
			    if(result>=1)
			    {
			    	return true;
			    }
			    else
			    {
			    		return false;
			    }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		} 


	public  ArrayList<Cosmatics> readAllRecords() {
		ArrayList<Cosmatics> cosList=new ArrayList<Cosmatics>();
		try {
			Connection conn=getDBConnection();
			Statement stmt=conn.createStatement();
			String sqlQuery="select * from cosmatics;";
			ResultSet result=stmt.executeQuery(sqlQuery);
			
			while(result.next()) {
				Cosmatics cosmatics=new Cosmatics();
				
				int cosmaticsId=result.getInt(1);
				cosmatics.setCosmaticsId(cosmaticsId);
				
				
				String name=result.getString(2);
				cosmatics.setName(name);
				
				double price=result.getDouble(3);
				cosmatics.setPrice(price);
				
				String brand=result.getString(4);
				cosmatics.setBrand(brand);
				
				
				cosList.add(cosmatics);
			}conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cosList;
	}

	@Override
	public boolean updateRecord(Cosmatics cosmatics) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRecordBasedonBrand(double newPrice, String brand) {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = getDBConnection();
			stmt = conn.createStatement();

			String sqlQuery = "update cosmatics set price =" + newPrice + "where brand = '" + brand + "';";
			int rowsEffected = stmt.executeUpdate(sqlQuery);
			if (rowsEffected >= 1)
				return true;
			else
				return false;
			 } catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return false;
	
	}


	@Override
	public boolean deleteRecordBasedonCosmaticsId(int cosmaticsId) {

			Connection conn = null;
			Statement stmt = null;

			try {
				conn = getDBConnection();
				stmt = conn.createStatement();

				String sqlQuery = "delete from cosmatics where CosmaticsId =" + cosmaticsId;
				int rowsdeleted = stmt.executeUpdate(sqlQuery);
				if (rowsdeleted >= 1)
					return true;
				return false;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
			return false;
		}
		

	

	

}