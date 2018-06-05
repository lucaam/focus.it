package it.focus.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DriverManagerConnectionPool {
	
	private static List<Connection> freeConn;
	
	static {
		freeConn = new LinkedList<Connection>();
		try {
			Class.forName("com.mysql.jdbc.Driver");

;		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found:" + e.getMessage());
		}
	}

	private static synchronized Connection createDBConnection() throws SQLException {
		Connection newConnection = null;
		String host = "2.237.17.51";
		String port = "3306";
		String db = "focusit";
		String username = "root";
		String password = "Empirealice97root";
//		newConnection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" +db, username, password + "?autoReconnect=true&useSSL=false");

		
		   String url = "jdbc:mysql://2.237.17.51:3306/"+"focusit"+"?autoReconnect=true&useSSL=false";
		   newConnection = DriverManager.getConnection(url, username, password);
		   
		
		newConnection.setAutoCommit(true);
		
		return newConnection;
		
	}
	
	public static synchronized Connection getConnection() throws SQLException {
		Connection connection;
		
		if (!freeConn.isEmpty()) {
			connection = (Connection) freeConn.get(0);
			freeConn.remove(0);
			
			try {
				if (connection.isClosed())
					connection = getConnection();
			} catch (SQLException e) {
				connection.close();
				connection = getConnection();
			}
		} else {
			connection = createDBConnection();
		}
		return connection;
	}

	public static void releaseConnection(Connection connection) throws SQLException{
		// TODO Auto-generated method stub
		
		if(connection != null) 
			freeConn.add(connection);
	}


}
