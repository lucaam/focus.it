package it.lucaamoriello.focusit.model;

//package it.focus.model;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class OrderBeanDAO {
//	public synchronized void newOrder (CartBean cart)
//	{
//		
//		Connection conn = null;
//		PreparedStatement prepstat = null;
//		
//		
//		try {
//			
//			conn = DriverManagerConnectionPool.getConnection();
//			
//			String sqlInsert = ("insert into order (id_userorder, id_product, price, usr_login, total_userorder, id_addr) values (?, ?, ?, ?, ?, ?);");
//			
//			prepstat = conn.prepareStatement(sqlInsert);
//			
//			
//			int state = prepstat.executeUpdate();
//			
//			
//			if(state!=0)
//			{
//				
//
//			} 
//			
//		}catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				prepstat.close();
//				DriverManagerConnectionPool.releaseConnection(conn);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//		}
//	
//		
//	}
//
//}
