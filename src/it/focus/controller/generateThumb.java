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
	private static final String SAVE_DIR = "WebContent/jsonfiles/";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String toSearch = request.getParameter("idProd");
		System.out.println(toSearch);
		ProductBeanDAO pbd = new ProductBeanDAO();
		ProductBean pb = pbd.searchId(toSearch);
		
		ObjectMapper mapper = new ObjectMapper();

		mapper.writeValue(new File(SAVE_DIR + "generateThumb.json"), pb);

	}
	
		
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
