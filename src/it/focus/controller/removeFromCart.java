package it.focus.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.focus.model.CartBean;
import it.focus.model.ProductBean;
import it.focus.model.ProductBeanDAO;

/**
 * Servlet implementation class removeFromCart
 */
@WebServlet("/removeFromCart")
public class removeFromCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public removeFromCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.getAttribute("cart");
		
		String toGet = request.getParameter("idProd");
		
		
		CartBean cart = (CartBean) session.getAttribute("cart");
		if(cart==null)
			cart = new CartBean();
		ProductBeanDAO pbd = new ProductBeanDAO();
		ProductBean pb = pbd.searchId(toGet);
		
		cart.removeItem(pb);

		session.removeAttribute("cart");
		session.setAttribute("cart", cart);
		
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("./servicepage/cartsuccess.jsp");
		requestDispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}