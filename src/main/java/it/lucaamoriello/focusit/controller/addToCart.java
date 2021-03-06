package it.lucaamoriello.focusit.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.lucaamoriello.focusit.model.CartBean;
import it.lucaamoriello.focusit.model.CartBeanDAO;
import it.lucaamoriello.focusit.model.ProductBean;
import it.lucaamoriello.focusit.model.ProductBeanDAO;
import it.lucaamoriello.focusit.model.UserBean;

/**
 * Servlet implementation class addToCart
 */
@WebServlet("/addToCart")
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("-----------------------");
		System.out.println("Inizio metodo: doGet - Servlet: addToCart");
		System.out.println("-----------------------");
		
		HttpSession session = request.getSession();
		session.getAttribute("cart");
		
		String toGet = request.getParameter("idProd");
		System.out.println(toGet);
		
		CartBean cart = (CartBean) session.getAttribute("cart");
		if(cart==null)
			cart = new CartBean();
		ProductBeanDAO pbd = new ProductBeanDAO();
		ProductBean pb = pbd.searchId(toGet);
		
		cart.addItem(pb, 1);
		
		if(!cart.getUser().isEmpty())
			cart.saveCart(cart, pb, 1);
			

		session.removeAttribute("cart");
		session.setAttribute("cart", cart);
		
		//request.setAttribute("added", true); //to modify the page
		
		System.out.println("-----------------------");
		System.out.println("fine metodo: doGet - Servlet: addToCart");
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
