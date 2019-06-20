package it.lucaamoriello.focusit.model;

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
			prepstat = connection.prepareStatement("SELECT * FROM usr WHERE login = ? AND pwd = ?");
			prepstat.setString(1, usr);
			prepstat.setString(2, pwd);
			
			ResultSet res = prepstat.executeQuery();
			
			if(res.next())
			{
				ub.setNome(res.getString("name"));
				ub.setCognome(res.getString("surname"));
				ub.setRole(res.getString("role"));
				ub.setUsr(res.getString("login"));
				ub.setEmail(res.getString("email"));
				ub.setPhone(res.getString("phone"));
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
	
	public synchronized UserBean userRegistration(String login, String nome, String cognome, String pwd, String email, String phone)
	{ 
		
		Connection conn = null;
		PreparedStatement prepstat = null;
		
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			String sqlInsert = ("insert into usr (name, surname, login, pwd, email, phone) values (?, ?, ?, ?, ?, ?)");
			
			prepstat = conn.prepareStatement(sqlInsert);
			prepstat.setString(1, nome);
			prepstat.setString(2, cognome);
			prepstat.setString(3, login);
			prepstat.setString(4, pwd);
			prepstat.setString(5, email);
			prepstat.setString(6, phone);

			int state = prepstat.executeUpdate();
			
			
			if(state!=0)
			{
				UserBean ub = new UserBean(login, pwd);
				ub.setNome(nome);
				ub.setCognome(cognome);
				ub.setEmail(email);
				ub.setPhone(phone);
				System.out.print("Succesfully registered");
				return ub;

			} 
			
		}catch (SQLException e) {
			if(e.getErrorCode()==1062) {
				
		         return new UserBean("duplicate", "duplicate");
				
			}
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
	
	public synchronized UserBean changePassword(UserBean ub, String usr, String newPwd, String old)
	{
		Connection connection = null;
		PreparedStatement prepstat = null;
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			prepstat = connection.prepareStatement("SELECT * FROM usr WHERE login = ? AND pwd = ?");
			prepstat.setString(1, usr);
			prepstat.setString(2, old);
		
			
			ResultSet res = prepstat.executeQuery();
			String checkOld = null;
			
				if(res.next()) {
					 checkOld = res.getString("pwd");
				
					if(checkOld.contentEquals(old)) {
					PreparedStatement prepstat1 = connection.prepareStatement("UPDATE usr SET pwd = ? WHERE login = ? AND pwd = ?");
						prepstat1.setString(1, newPwd);
						prepstat1.setString(2, usr);
						prepstat1.setString(3, old);
						int state = prepstat1.executeUpdate();
						if(state!=0) {
							ub.setPwd(newPwd);
							System.out.println("Pwd updated");
		
							return ub;
						}
					}
				}
			else {
				System.out.println("No changes");
				return null;
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


public synchronized UserBean changeEmail(UserBean ub, String usr, String newEmail, String old) {
Connection connection = null;
PreparedStatement prepstat = null;

try {
	connection = DriverManagerConnectionPool.getConnection();
	prepstat = connection.prepareStatement("SELECT * FROM usr WHERE login = ? AND email = ?");
	prepstat.setString(1, usr);
	prepstat.setString(2, old);

	
	ResultSet res = prepstat.executeQuery();
	String checkOld = null;
	
		if(res.next()) {
			 checkOld = res.getString("email");
		
			if(checkOld.contentEquals(old)) {
			PreparedStatement prepstat1 = connection.prepareStatement("UPDATE usr SET email = ? WHERE login = ? AND email = ?");
				prepstat1.setString(1, newEmail);
				prepstat1.setString(2, usr);
				prepstat1.setString(3, old);
				int state = prepstat1.executeUpdate();
				if(state!=0) {
					ub.setEmail(newEmail);
					System.out.println("Email updated");

					return ub;
				}
			}
		}
	else {
		System.out.println("No changes");
		return null;
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
}
