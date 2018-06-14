package it.focus.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Blob;

public class ProductBeanDAO {
	public synchronized ProductBean newProd (String product, String brand, Double price, Double mpx, String color, String desc)
	{
		
		Connection conn = null;
		PreparedStatement prepstat = null;
		
		
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			
			String sqlInsert = ("insert into product (product_name, price, brand, description, colour, mpx) values (?, ?, ?, ?, ?, ?);");
			
			prepstat = conn.prepareStatement(sqlInsert);
			prepstat.setString(1, product);
			prepstat.setDouble(2, price);
			prepstat.setString(3, brand);
			prepstat.setString(4, desc);
			prepstat.setString(5, color);
			prepstat.setDouble(6, mpx);
//			prepstat.setBlob(7, fis);
			int state = prepstat.executeUpdate();
			
			
			if(state!=0)
			{
				ProductBean pb = new ProductBean(/*id, */product, price, brand, desc, mpx, color);
//				pb.setPic(fis);
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
	
	
	
	public synchronized ProductBean searchId (String toQuery)
	{
		Connection conn = null;
		PreparedStatement prepstat = null;
		ProductBean npb = null;
	
		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			prepstat = conn.prepareStatement("SELECT * FROM product WHERE id_product = ?");
			prepstat.setString(1, toQuery);
			
			ResultSet res = prepstat.executeQuery();
			
			while(res.next())
			{		
					npb = new ProductBean(/*res.getInt("id_product"),*/ res.getString("product_name"), res.getDouble("price"), res.getString("brand"), res.getString("description"), res.getDouble("mpx"), res.getString("colour")/*, res.getString("product_type")*/);
					npb.setId(res.getInt("id_product"));

					
				
					
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
		return npb;
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

}

