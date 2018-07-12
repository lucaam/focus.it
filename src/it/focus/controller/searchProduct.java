package it.focus.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.focus.model.ProductBean;
import it.focus.model.ProductBeanDAO;

/**
 * Servlet implementation class searchProduct
 */
@WebServlet("/searchProduct")
public class searchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-----------------------");
		System.out.println("Inizio metodo: doGet - Servlet: searchProduct");
		System.out.println("-----------------------");
		
		ProductBeanDAO pbd = new ProductBeanDAO();
		ArrayList<ProductBean> pList = null;
		String toSearch = null;
		
		if((toSearch=request.getParameter("searchnav"))==null)
		{
			toSearch = request.getParameter("search");
			pList = pbd.searchBrand(toSearch);
		}
		
		pList = pbd.searchName(toSearch);
				
		request.setAttribute("prod", pList);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./searchres.jsp");
		requestDispatcher.forward(request, response);
		
		System.out.println("-----------------------");
		System.out.println("Fine metodo: doGet - Servlet: searchProduct");
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
