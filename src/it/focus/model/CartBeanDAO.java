package it.focus.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CartBeanDAO {
	
	
	public synchronized void deleteFromCart (String usr, int id)
	{
		System.out.println("-----------------------");
		System.out.println("Inizio metodo: deleteFromCart");
		System.out.println("-----------------------");
		Connection conn = null;
		PreparedStatement prepstat = null;
	
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			prepstat = conn.prepareStatement("DELETE FROM cart where id_usr = ? AND id_product = ?");
			prepstat.setString(1, usr);
			prepstat.setInt(2, id);

			prepstat.executeUpdate();
			
			System.out.println("-----------------------");
			System.out.println("Fine metodo: saveCart");
			System.out.println("-----------------------");
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
		System.out.println("-----------------------");
		System.out.println("Inizio metodo: restore");
		System.out.println("-----------------------");
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
			
			System.out.println("-----------------------");
			System.out.println("Fine metodo: restrore");
			System.out.println("-----------------------");
		
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
	
	public synchronized void saveCart (CartBean cb, ProductBean pb)
	{
		System.out.println("-----------------------");
		System.out.println("Inizio metodo: saveCart");
		System.out.println("-----------------------");

		Connection conn = null;
		PreparedStatement prepstat1 = null;
		PreparedStatement prepstat = null;
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			prepstat1 = conn.prepareStatement("SELECT * FROM cart WHERE id_usr = ? AND id_product = ?");
			prepstat1.setString(1, cb.getUser());
			prepstat1.setInt(2, pb.getId());
			ResultSet res = prepstat1.executeQuery();
			if(res.next()) {
				prepstat = conn.prepareStatement("UPDATE cart SET qta = ? WHERE id_usr = ? and id_product = ?");
				 prepstat.setInt(1, cb.getQta(pb));
				 prepstat.setString(2, cb.getUser());
				 prepstat.setInt(3, pb.getId());
				 
				int state = prepstat.executeUpdate();
				
				if(state!=0)
					System.out.println("tutto ok con l'update del carrello nel database, quantità aggiornata");
				else {
					System.out.println("non bene");

				}
			
	}
			else {
			 
			prepstat = conn.prepareStatement("INSERT INTO cart (id_usr, id_product, qta) VALUES (?, ?, ?);");
			System.out.println(cb.getUser());
			prepstat.setString(1, cb.getUser());
			prepstat.setInt(2, pb.getId());
			prepstat.setInt(3, cb.getQta(pb));
			
			
			int state = prepstat.executeUpdate();
			if(state!=0)
				System.out.println("tutto ok con l'update del carrello nel database, aggiunto per la prima volta");
			
		}
			System.out.println("-----------------------");
			System.out.println("Fine metodo: saveCart");
			System.out.println("-----------------------");
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
