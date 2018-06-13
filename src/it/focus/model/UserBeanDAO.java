package it.focus.model;

import java.sql.Connection;
import java.sql.Date;
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
			prepstat = connection.prepareStatement("SELECT * FROM usr WHERE login = ? AND pwd = ?");
			prepstat.setString(1, usr);
			prepstat.setString(2, pwd);
			
			ResultSet res = prepstat.executeQuery();
			
			if(res.next())
			{
				ub.setId(res.getInt("id_usr"));
				ub.setNome(res.getString("name"));
				ub.setCognome(res.getString("surname"));
				ub.setRole(res.getString("role"));
				ub.setUsr(res.getString("login"));
				ub.setEmail(res.getString("email"));
				ub.setPwd(res.getString("pwd"));
				
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
	
	public synchronized UserBean userRegistration(String login, String nome, String cognome, String pwd, String email, String ldn, String phone)
	{ 
		
		Connection conn = null;
		PreparedStatement prepstat = null;
		
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			String sqlInsert = ("insert into usr (name, surname, login, pwd, email, city_born, , phone) values (?, ?, ?, ?, ?, ?, ?);");
			
			prepstat = conn.prepareStatement(sqlInsert);
			prepstat.setString(1, nome);
			prepstat.setString(2, cognome);
			prepstat.setString(3, login);
			prepstat.setString(4, pwd);
			prepstat.setString(5, email);
			prepstat.setString(6, ldn);
			prepstat.setString(8, phone);

			int state = prepstat.executeUpdate();
			
			
			if(state!=0)
			{
				UserBean ub = new UserBean(login, pwd);
				ub.setNome(nome);
				ub.setCognome(cognome);
				ub.setEmail(email);
				ub.setUsr(login);
				ub.setBirthplace(ldn);
				ub.setPhone(phone);
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
	/*
	public synchronized UserBean changePassword(String usr, String pwd)
	{
		Connection connection = null;
		PreparedStatement prepstat = null;
		
		try {
			UserBean ub = new UserBean(usr,pwd);
			connection = DriverManagerConnectionPool.getConnection();
			prepstat = connection.prepareStatement("");
			prepstat.setString(1, );
			prepstat.setString(2, );
			
			ResultSet res = prepstat.executeQuery();
			
			if(res.next())
			{
				
				ub.setUsr(res.getString("login"));
				ub.setPwd(res.getString("password"));
				
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
	}*/
}
