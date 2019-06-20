package it.lucaamoriello.focusit.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class ProductBeanDAO {
	public synchronized ProductBean newProd (String product, String brand, Double price, Double mpx, String color, String desc, String pic)
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
			prepstat.setString(7, pic);
			int state = prepstat.executeUpdate();
			
			
			if(state!=0)
			{
				ProductBean pb = new ProductBean(/*id, */product, price, brand, desc, mpx, color, pic);
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
					npb = new ProductBean(res.getInt("id_product"),res.getString("product_name"), res.getDouble("price"), res.getString("brand"), res.getString("description"), res.getDouble("mpx"), res.getString("colour")/*, res.getString("product_type")*/, res.getString("img"));
					

					
				
					
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
				ProductBean npb = new ProductBean(/*res.getInt("id_product"),*/ res.getString("product_name"), res.getDouble("price"), res.getString("brand"), res.getString("description"), res.getDouble("mpx"), res.getString("colour")/*, res.getString("product_type")*/, res.getString("img"));
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

	public synchronized ArrayList <ProductBean> searchName (String toQuery)
	{
		Connection conn = null;
		PreparedStatement prepstat = null;
		ArrayList<ProductBean> pList = new ArrayList<ProductBean>();
		

		try {
			
			conn = DriverManagerConnectionPool.getConnection();
			prepstat = conn.prepareStatement("SELECT * FROM product WHERE product_name LIKE ?;");
			prepstat.setString(1, "%" + toQuery + "%");
			
			ResultSet res = prepstat.executeQuery();
			
			while(res.next())
			{		
					ProductBean npb = new ProductBean(/*res.getInt("id_product"),*/ res.getString("product_name"), res.getDouble("price"), res.getString("brand"), res.getString("description"), res.getDouble("mpx"), res.getString("colour")/*, res.getString("product_type")*/, res.getString("img"));
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

public synchronized boolean deleteById (String toQuery)
{
	Connection conn = null;
	PreparedStatement prepstat = null;
	PreparedStatement prepstat1 = null;

	

	try {
		
		conn = DriverManagerConnectionPool.getConnection();
		prepstat = conn.prepareStatement("DELETE FROM product WHERE id_product = ?");
		prepstat.setString(1, toQuery);
		
		int state = prepstat.executeUpdate();

		
		

		if(state!=0)
		{
			System.out.println("The product"+ toQuery +" is deleted form the db");
		
		
		prepstat1 = conn.prepareStatement("DELETE FROM cart WHERE id_product = ?");
		prepstat1.setString(1, toQuery);
		int state1 = prepstat1.executeUpdate();
		
		if(state1!=0) {
			System.out.println("The product"+ toQuery +" is deleted form the carts");
			return true;

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
	return false;
}
}
