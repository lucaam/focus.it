package it.focus.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Blob;

public class ProductBeanDAO {
	public synchronized ProductBean newProd (String product, String brand, Double price, Double mpx, String color, String desc, FileInputStream fis)
	{
		
		Connection conn = null;
		PreparedStatement prepstat = null;
		
		
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			String sqlInsert = ("insert into product (product_name, price, brand, description, colour, mpx, img) values (?, ?, ?, ?, ?, ?, ?);");
			
			prepstat = conn.prepareStatement(sqlInsert);
			prepstat.setString(1, product);
			prepstat.setDouble(2, price);
			prepstat.setString(3, brand);
			prepstat.setString(4, desc);
			prepstat.setString(5, color);
			prepstat.setDouble(6, mpx);
			prepstat.setBinaryStream(7, fis);
			int state = prepstat.executeUpdate();
			
			
			if(state!=0)
			{
				ProductBean pb = new ProductBean(/*id, */product, price, brand, desc, mpx, color);
				pb.setPic(fis);
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
	
	
	
	public synchronized ArrayList <ProductBean> searchId (String toQuery)
	{
		Connection conn = null;
		PreparedStatement prepstat = null;
		ArrayList<ProductBean> pList = new ArrayList<ProductBean>();
		
	
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			prepstat = conn.prepareStatement("SELECT * FROM product WHERE id_product = ?");
			prepstat.setString(1, toQuery);
			
			ResultSet res = prepstat.executeQuery();
			
			while(res.next())
			{		
					ProductBean npb = new ProductBean(/*res.getInt("id_product"),*/ res.getString("product_name"), res.getDouble("price"), res.getString("brand"), res.getString("description"), res.getDouble("mpx"), res.getString("colour")/*, res.getString("product_type")*/);
					npb.setId(res.getInt("id_product"));
					pList.add(npb);
					
				
					
			}
		
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
		return pList;
}
	public synchronized ArrayList <ProductBean> searchBrand (String toQuery)
{
	Connection conn = null;
	PreparedStatement prepstat = null;
	ArrayList<ProductBean> pList = new ArrayList<ProductBean>();
	

	try {
		
		conn = DriverManagerConnectionPool.getConnection();
		prepstat = conn.prepareStatement("SELECT * FROM product WHERE brand = ?");
		prepstat.setString(1, toQuery);
		
		ResultSet res = prepstat.executeQuery();
		
		while(res.next())
		{		
				ProductBean npb = new ProductBean(/*res.getInt("id_product"),*/ res.getString("product_name"), res.getDouble("price"), res.getString("brand"), res.getString("description"), res.getDouble("mpx"), res.getString("colour")/*, res.getString("product_type")*/);
				npb.setId(res.getInt("id_product"));
				pList.add(npb);
				
			
				
		}
	
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
	return pList;
}

	public synchronized ArrayList <ProductBean> getProducts(HttpSession session)
	{
		ArrayList<ProductBean> pList = new ArrayList<ProductBean>();
		int i=0;
		
		if(session != null) {
			for (ProductBean pb : pList )
			{
				
				pb = (ProductBean) session.getAttribute("prod" + i++);
				pList.add(pb);
				
				
			
		}
		
		if(pList.isEmpty()) {
			Connection conn = null;
			PreparedStatement prepstat = null;
			UserBean ub = (UserBean) session.getAttribute("userBean");
			
			
			try {
				conn = DriverManagerConnectionPool.getConnection();
				prepstat = conn.prepareStatement("SELECT * FROM cart WHERE id_cart = ?");
				prepstat.setInt(1, ub.getId());
				
				PreparedStatement ps = null;
				ps = conn.prepareStatement("SELECT * FROM product WHERE id_product = ?");
			
				ProductBean pb = null;
				
				ResultSet res = prepstat.executeQuery();
				
				while(res.next())
				{
				
					int pId = res.getInt("id_product");
					ResultSet rs = ps.executeQuery();
					
					for (ProductBean npb : pList )
					{
						npb = new ProductBean(/*res.getInt("id_product"),*/ res.getString("product_name"), res.getDouble("price"), res.getString("brand"), res.getString("description"), res.getDouble("mpx"), res.getString("colour")/*, res.getString("product_type")*/);
						pList.add(npb);	
					}
						
				}


				
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
		return pList;
	}

}

