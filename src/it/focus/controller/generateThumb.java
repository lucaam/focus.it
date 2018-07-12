package it.focus.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.focus.model.ProductBean;
import it.focus.model.ProductBeanDAO;

/**
 * Servlet implementation class generateThumb
 */
@WebServlet("/generateThumb")
public class generateThumb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String SAVE_DIR = "WebContent/jsonfiles/";//local in eclipse
	private static final String SAVE_DIR = "jsonfiles/";//server 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String appPath = request.getServletContext().getRealPath("");
		String savePath = "/root/server/webapps/focus.it/"+ SAVE_DIR;
		System.out.println("app path: " + appPath);
		System.out.println("savepath: " + savePath);

		String toSearch = request.getParameter("idProd");
		System.out.println("Creazione del file Json per il prodotto con ID :" + toSearch);
		ProductBeanDAO pbd = new ProductBeanDAO();
		ProductBean pb = pbd.searchId(toSearch);
		
		File f = new File(savePath +  "generateThumb.json");
		if(f.exists() && !f.isDirectory()) { 
			System.out.println("Esiste");
			f.delete();
			f.createNewFile();	
		}
		else {
			System.out.println("non esiste");
			System.out.println("Creazione del file qui:" + f.getAbsolutePath());
			f.createNewFile();	
			
		}
		
		
		ObjectMapper mapper = new ObjectMapper();

		
		mapper.writeValue(f, pb);

	}
	
		
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
