package it.focus.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class CartBeanDAO {
	
	public synchronized void saveCart (CartBean toAdd)
	{
		Connection conn = null;
		PreparedStatement prepstat = null;
		

	
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			int i = 0;
			ProductBean pb = null;
			
			while((pb = toAdd.getItem(i++))!=null) {
			prepstat = conn.prepareStatement("INSERT INTO cart VALUES (?, ?");
			prepstat.setInt(1, toAdd.getId());
			prepstat.setInt(2, pb.getId());
			}
			
			ResultSet res = prepstat.executeQuery();
			
			if(res.next())
				System.out.println("tutto ok con l'update del carrello nel database");
			
			
		
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				prepstat.close();
				DriverManagerConnectionPool.releaseConnection(conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
	public synchronized void restore (CartBean toAdd)
	{
		
	}

}
