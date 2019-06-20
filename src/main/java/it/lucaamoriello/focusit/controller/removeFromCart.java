package it.lucaamoriello.focusit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.lucaamoriello.focusit.model.CartBean;
import it.lucaamoriello.focusit.model.ProductBean;
import it.lucaamoriello.focusit.model.ProductBeanDAO;

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
		
		System.out.println("-----------------------");
		System.out.println("Inizio metodo: doGet - Servlet: removeFromCart");
		System.out.println("-----------------------");
		
		HttpSession session = request.getSession();
		CartBean cart = (CartBean) session.getAttribute("cart");
		
		

		
		String toGet = request.getParameter("idProd");

		ProductBeanDAO pbd = new ProductBeanDAO();
		ProductBean pb = pbd.searchId(toGet);
		System.out.println("To delete: " + pb.getProduct());
		
		
		
		cart.removeItem(pb, 1);
		
		if(!cart.getUser().isEmpty())
		cart.deleteFromDb(pb, 1);

		
		session.removeAttribute("cart");
		session.setAttribute("cart", cart);
		
		
		//Debugging purpose
		ArrayList<ProductBean> tmp = cart.getItems();
		
		for(ProductBean pbtemp : tmp)
		{
			System.out.println("lista presenti dopo rimozione: " + pbtemp.getProduct());
		}
		
		//Debugging purpose

		RequestDispatcher req = request.getRequestDispatcher("./cart.jsp");
		req.forward(request, response);
		
		System.out.println("-----------------------");
		System.out.println("Fine metodo: doGet - Servlet: removeFromCart");
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
