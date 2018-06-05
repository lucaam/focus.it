package it.focus.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBeanDAO {
	
	public synchronized UserBean doRetriveByKey(String usr, String pwd)
	{
		Connection connection = null;
		PreparedStatement prepstat = null;
		
		try {
			UserBean ub = new UserBean(usr,pwd);
			connection = DriverManagerConnectionPool.getConnection();
			prepstat = connection.prepareStatement("SELECT * FROM user WHERE login = ? AND pwd = ?");
			prepstat.setString(1, usr);
			prepstat.setString(2, pwd);
			
			ResultSet res = prepstat.executeQuery();
			
			if(res.next())
			{
				ub.setNome(res.getString("nomeutente"));
				ub.setCognome(res.getString("cognomeutente"));
				ub.setRole(res.getString("ruolo"));
				ub.setNome(res.getString("nomeutente"));
				
				return ub;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
			prepstat.close();
			DriverManagerConnectionPool.releaseConnection(connection);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public synchronized UserBean userRegistration(String login, String nome, String cognome, String pwd, String email)
	{
		
		Connection conn = null;
		PreparedStatement prepstat = null;
		
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			String sqlInsert = ("insert into user (nomeutente, cognomeutente, pwd, email, login) values (?, ?, ?, ?, ?);");
			
			prepstat = conn.prepareStatement(sqlInsert);
			prepstat.setString(1, nome);
			prepstat.setString(2, cognome);
			prepstat.setString(3, pwd);
			prepstat.setString(4, email);
			prepstat.setString(5, login);

			int state = prepstat.executeUpdate();
			
			
			if(state!=0)
			{
				UserBean ub = new UserBean(login, pwd);
				ub.setNome(nome);
				ub.setCognome(cognome);
				ub.setEmail(email);
				System.out.print("Succesfully registered");
				return ub;

			} 
			
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				prepstat.close();
				DriverManagerConnectionPool.releaseConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return null;
	}
}
