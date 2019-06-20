package it.lucaamoriello.focusit.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.lucaamoriello.focusit.model.ProductBean;
import it.lucaamoriello.focusit.model.ProductBeanDAO;

/**
 * Servlet implementation class generatePage
 */
@WebServlet("/generatePage")
public class generatePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public generatePage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("-----------------------");
		System.out.println("Inizio metodo: doGet - Servlet: generatePage");
		System.out.println("-----------------------");
		String toGet = request.getParameter("idProd");
		
		
		ProductBeanDAO pbd = new ProductBeanDAO();
		ProductBean pb = pbd.searchId(toGet);
		
		request.setAttribute("prod", pb);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./productpage.jsp");
		requestDispatcher.forward(request, response);
		
		System.out.println("-----------------------");
		System.out.println("Fine metodo: doGet - Servlet: generatePage");
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
