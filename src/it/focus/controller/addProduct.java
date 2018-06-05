package it.focus.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import it.focus.model.ProductBean;
import it.focus.model.ProductBeanDAO;
import it.focus.model.UserBean;
import it.focus.model.UserBeanDAO;


/**
 * Servlet implementation class Registration
 */
@MultipartConfig
@WebServlet("/addProduct")
public class addProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String product = request.getParameter("product");
		Double price = Double.parseDouble(request.getParameter("price")); 
		String brand = request.getParameter("brand");
		String desc = request.getParameter("desc");
		String color = request.getParameter("color");
		Double mpx = Double.parseDouble(request.getParameter("mpx"));
		InputStream pic = null;
		Part filePart = request.getPart("pic");
		
		if(filePart != null) {
			System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            
            pic = filePart.getInputStream();
		}
		
		try {
			
			ProductBeanDAO pbBeanDAO = new ProductBeanDAO();
			ProductBean pb = pbBeanDAO.newProd(product, brand, price, mpx, color, desc, pic);
			
			
			if(pb != null)
			{
				RequestDispatcher req = request.getRequestDispatcher("successadd.jsp");
				req.forward(request, response);
			}
			else
			{
				RequestDispatcher req = request.getRequestDispatcher("wrongadd.jsp");
				req.forward(request, response);
			}
		} catch (Exception e){
			request.setAttribute("exception", e);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("exception.jsp");
			requestDispatcher.forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
