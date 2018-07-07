package it.focus.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.omg.CORBA.portable.InputStream;

import it.focus.model.ProductBean;
import it.focus.model.ProductBeanDAO;


/**
 * Servlet implementation class Registration
 */

@WebServlet("/addProduct")
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB



public class addProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "images/cameras";

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String product = request.getParameter("product");
		Double price = Double.parseDouble(request.getParameter("price")); 
		String brand = request.getParameter("brand");
		String desc = request.getParameter("desc");
		String color = request.getParameter("color");
		Double mpx = Double.parseDouble(request.getParameter("mpx"));
		String appPath = request.getServletContext().getRealPath("");
		String savePath = appPath + File.separator + SAVE_DIR;
		String res = null;
		// creates the save directory if it does not exists
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}

		for (Part part : request.getParts()) {
			String fileName = extractFileName(part);
			if (fileName != null && !fileName.equals("")){
			// refines the fileName in case it is an absolute path
				fileName = new File(fileName).getName();
				part.write(savePath + File.separator + fileName);
				request.setAttribute("filename", fileName);
				res=fileName;
				File uploads = new File(appPath);

				File file = new File(uploads, fileName);

				try (java.io.InputStream input = part.getInputStream()) {
				    Files.copy(input, file.toPath());
				}
			}
			
		}
		

		
		try {
			
			ProductBeanDAO pbBeanDAO = new ProductBeanDAO();
			ProductBean pb = pbBeanDAO.newProd(product, brand, price, mpx, color, desc, "images/cameras/" + res);
			
			
			if(pb != null)
			{
				RequestDispatcher req = request.getRequestDispatcher("./servicepage/successadd.jsp");
				req.forward(request, response);
			}
			else
			{
				RequestDispatcher req = request.getRequestDispatcher("./servicepage/wrongadd.jsp");
				req.forward(request, response);
			}
		} catch (Exception e){
			request.setAttribute("exception", e);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("./servicepage/exception.jsp");
			requestDispatcher.forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		System.out.println("contentDisp= " + contentDisp);
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length()-1);
			}
		}
		return "";
	}

	private String replaceIfMissing (String orig, String replacement){
		if ((orig==null) || orig.trim().equals(""))
			return replacement;
		else
			return orig;
	}


}
