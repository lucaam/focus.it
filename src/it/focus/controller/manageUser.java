package it.focus.controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.focus.model.UserBean;
import it.focus.model.UserBeanDAO;

/**
 * Servlet implementation class manageUserPass
 */
@WebServlet("/manageUser")
public class manageUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("-----------------------");
		System.out.println("Inizio metodo: doGet - Servlet: manageUserPass");
		System.out.println("-----------------------");

		HttpSession session = request.getSession();
		UserBean userB = (UserBean) session.getAttribute("userBean");
		System.out.println("Nome: " + userB.getNome());
		System.out.println("Cognome: " + userB.getCognome());
		System.out.println("ID: " + userB.getUsr());
		System.out.println("Email: " + userB.getEmail());
		System.out.println("Pass: " + userB.getPwd());

		if (userB == null) {
			RequestDispatcher reqDis= request.getRequestDispatcher("./servicepage/nopermission.jsp");
			reqDis.forward(request, response);
		}
		else {
			try {
				String oldPSW = request.getParameter("old");
				System.out.println("Vecchia: " + oldPSW);
				String newPSW = request.getParameter("new");
				System.out.println("Nuova: " + newPSW);
				
				if(oldPSW==null && newPSW==null) {
					String oldmail = request.getParameter("oldemail");
					System.out.println("Vecchia: " + oldmail);

					String newmail = request.getParameter("newemail");
					System.out.println("Nuova: " + newmail);
					
					UserBeanDAO ubd = new UserBeanDAO();

					userB = ubd.changeEmail(userB, userB.getUsr(), newmail, oldmail);
					
					session.setAttribute("userBean", userB);
					
					System.out.println("Email presa dopo update: " + userB.getEmail());
				}
				
				else {
					UserBeanDAO ubd = new UserBeanDAO();

					userB = ubd.changePassword(userB, userB.getUsr(), newPSW, oldPSW);
					
					session.setAttribute("userBean", userB);
					
					System.out.println("Password presa dopo update: " + userB.getPwd());
				}

				RequestDispatcher reqDis= request.getRequestDispatcher("./servicepage/success.jsp");
				reqDis.forward(request, response);
			}
			catch (Exception e) {
				request.setAttribute("exception", e);
				RequestDispatcher reqDis= request.getRequestDispatcher("./servicepage/exception.jsp");
				reqDis.forward(request, response);
			}

		}	


		System.out.println("-----------------------");
		System.out.println("Fine metodo: doGet - Servlet: manageUserPass");
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
