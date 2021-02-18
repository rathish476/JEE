package com.flightDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.flightDto.FlightDTO;

public class FlightDAOImpl implements FlightDAO {

	private static final String AirTime = null;

	@Override
	public Connection getDbConnection() throws SQLException {

		String url = "jdbc:mysql://localhost:3306/flightdetails";
		String username = "root";
		String password = "rathish@06TA";
		Connection connection = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			System.out.println(connection);
			return connection;

		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		throw new SQLException();
	}

	@Override
	public boolean insertRecord(FlightDTO flightDTO) {
		
		Connection connection=null;
		PreparedStatement prepStatement=null;

		try {
			 connection = getDbConnection();

			String sqlQuery = "insert into flights values(?,? ,? ,? ,? ,?);";

			 prepStatement = connection.prepareStatement(sqlQuery);

			prepStatement.setInt(1, flightDTO.getFlightId());
			prepStatement.setString(2, flightDTO.getName());
			prepStatement.setInt(3, flightDTO.getFuelCapacity());
			prepStatement.setDouble(4, flightDTO.getAirTime());
			prepStatement.setString(5, flightDTO.getSource());
			prepStatement.setString(6, flightDTO.getDestination());

			int res = prepStatement.executeUpdate();

			if (res >= 1) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
			if(prepStatement!=null)
				prepStatement.close();
			if(connection != null)
				connection.close();
			}catch(SQLException e2) {
				e2.printStackTrace();
			}
		}

		return false;
	}

	@Override
	public boolean updateRecordByFlightId(String newFlightName, String destination) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try {
			
			connection = getDbConnection();

			String sqlQuery = "update flights set flightName=? where destination=? ;";

			preparedStatement = connection.prepareStatement(sqlQuery);

			preparedStatement.setString(1,newFlightName);
			preparedStatement.setString(2, destination);

			int res = preparedStatement.executeUpdate();

			if (res >= 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
			if(preparedStatement!=null)
			   preparedStatement.close();
			if(connection != null)
			   connection.close();
			}catch(SQLException e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deleteByFlightId(int FlightId) {

		Connection connection=null;
		PreparedStatement preparedStatement=null;

		try {
			connection = getDbConnection();

			String sqlQuery = "delete from flights where flightId=? ;";

			preparedStatement = connection.prepareStatement(sqlQuery);

			preparedStatement.setInt(1,FlightId);

			int res = preparedStatement.executeUpdate();

			if (res >= 1) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
			if(preparedStatement!=null)
			   preparedStatement.close();
			if(connection != null)
			   connection.close();
			}catch(SQLException e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public void insertListOfRecords(ArrayList<FlightDTO> flightDTOs) {
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try {
			connection = getDbConnection();

			String sqlQuery = "insert into flights values(?,?,?,?,?,?); ";

			preparedStatement = connection.prepareStatement(sqlQuery);

			for (FlightDTO flightDTO : flightDTOs) {

				preparedStatement.setInt(1, flightDTO.getFlightId());
				preparedStatement.setString(2, flightDTO.getName());
				preparedStatement.setInt(3, flightDTO.getFuelCapacity());
				preparedStatement.setDouble(4, flightDTO.getAirTime());
				preparedStatement.setString(5, flightDTO.getSource());
				preparedStatement.setString(6, flightDTO.getDestination());

				preparedStatement.addBatch();
			}

			int[] res = preparedStatement.executeBatch();
			System.out.println("results are :");
			for (int i : res) {
				
				System.out.println(i);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
			if(preparedStatement!=null)
			   preparedStatement.close();
			if(connection != null)
			   connection.close();
			}catch(SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public void insertMultipleRecords(ArrayList<FlightDTO> flightDTOs) {
		
		Connection connection=null;
		
		Statement statement=null;
		
		try {
			
			connection=getDbConnection();
			
		    statement=connection.createStatement();
			
			for (FlightDTO flightDTO2 : flightDTOs) {
				
			int id=flightDTO2.getFlightId();
			String name=flightDTO2.getName();
			int fuel=flightDTO2.getFuelCapacity();
			Double airTime=flightDTO2.getAirTime();
			String source=flightDTO2.getSource();
			String destination=flightDTO2.getDestination();
				
			String sqlQuery= "insert into flights values("+id+ ",'"+name+"', "+fuel+","+AirTime+",'"+source+"','"+destination+"');";
		
			statement.addBatch(sqlQuery);
			}
			int[] res=statement.executeBatch();
			System.out.println("results are: ");
			for (int i : res) {
				System.out.println(i);
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			try {
			if(statement!=null)
			   statement.close();
			if(connection != null)
			   connection.close();
			}catch(SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
