package it.focus.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductBeanDAO {
	public synchronized ProductBean newProd (String product, String brand, Double price, Double mpx, String color, String desc, InputStream pic)
	{
		
		Connection conn = null;
		PreparedStatement prepstat = null;
		
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			String sqlInsert = ("insert into product (nomeprodotto, prezzo, marca, descrizione, colore, mpx, foto) values (?, ?, ?, ?, ?, ?, ?);");
			
			prepstat = conn.prepareStatement(sqlInsert);
			prepstat.setString(1, product);
			prepstat.setDouble(2, price);
			prepstat.setString(3, brand);
			prepstat.setString(4, desc);
			prepstat.setString(5, color);
			prepstat.setDouble(6, mpx);
			prepstat.setBlob(7, pic);
			int state = prepstat.executeUpdate();
			
			
			if(state!=0)
			{
				ProductBean pb = new ProductBean(product, price, brand);
				pb.setDesc(desc);
				pb.setColor(color);
				pb.setMpx(mpx);
				pb.setPic(pic);
				return pb;

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
