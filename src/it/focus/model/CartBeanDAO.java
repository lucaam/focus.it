package it.focus.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CartBeanDAO {
	
	
	public synchronized void deleteFromCart (String usr, int id)
	{
		Connection conn = null;
		PreparedStatement prepstat = null;
	
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			prepstat = conn.prepareStatement("DELETE FROM cart where id_usr = ? AND id_product = ?");
			prepstat.setString(1, usr);
			prepstat.setInt(2, id);

			prepstat.executeUpdate();
			
		
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
	public synchronized CartBean restore (String usr)
	{
		Connection conn = null;
		PreparedStatement prepstat = null;
		

		
		try {
			
		conn = DriverManagerConnectionPool.getConnection();
		prepstat = conn.prepareStatement("SELECT * FROM cart WHERE id_usr = ?");
		prepstat.setString(1, usr);
		
		ResultSet res = prepstat.executeQuery();
		CartBean cart = new CartBean();
		
			
			while(res.next()) {
				ProductBeanDAO pbd = new ProductBeanDAO();
				ProductBean pb = pbd.searchId(res.getString("id_product"));
				cart.addItem(pb);
				System.out.println(pb.getProduct());
			}
			
			if(cart.getTotal()!=0)
			cart.setUser(usr);
			
			return cart;
		
		
	} catch (SQLException e) {
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
	
	public synchronized void saveCart (UserBean ub, ProductBean pb)
	{
		Connection conn = null;
		PreparedStatement prepstat = null;
	
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			prepstat = conn.prepareStatement("INSERT INTO cart (id_usr, id_product) VALUES (?, ?);");
			System.out.println(ub.getUsr());
			prepstat.setString(1, ub.getUsr());
			prepstat.setInt(2, pb.getId());
			
			
			int state = prepstat.executeUpdate();
			
			if(state!=0)
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

}
