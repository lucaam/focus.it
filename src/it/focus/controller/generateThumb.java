package it.focus.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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
	
		System.out.println("-----------------------");
		System.out.println("Inizio metodo: doGet - Servlet: generateThumb");
		System.out.println("-----------------------");
		
		ProductBeanDAO pbd = new ProductBeanDAO();

		String toSearch="";

		ArrayList<ProductBean> pList = pbd.searchName(toSearch);
		String appPath = request.getServletContext().getRealPath("");
		String savePath = appPath + File.separator + SAVE_DIR;
		
		File f = new File(savePath +  "prodList.json");
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

		
		mapper.writeValue(f, pList);
		

		System.out.println("-----------------------");
		System.out.println("Fine metodo: doGet - Servlet: generateThumb");
		System.out.println("-----------------------");

	}
	
		
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
