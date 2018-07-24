package it.focus.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.focus.model.ProductBean;
import it.focus.model.ProductBeanDAO;

/**
 * Servlet implementation class removeProd
 */
@WebServlet("/genereteProdListJson")
public class generateProdListJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "jsonfiles/";//server 

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public generateProdListJson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
