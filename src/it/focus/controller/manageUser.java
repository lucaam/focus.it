package it.focus.controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.focus.model.DriverManagerConnectionPool;
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

		HttpSession session= request.getSession();
		UserBean userB= (UserBean) session.getAttribute("userBean");
		if (userB== null) {
			RequestDispatcher reqDis= request.getRequestDispatcher("./servicepage/nopermission.jsp");
			reqDis.forward(request, response);
		}
		else {
			try {
				String oldPSW= request.getParameter("oldPass");
				String newPSW= request.getParameter("newPass");
				UserBeanDAO ubd= new UserBeanDAO();

				userB= ubd.changePassword(userB, userB.getUsr(), newPSW, oldPSW);
				
				RequestDispatcher reqDis= request.getRequestDispatcher("./servicepage/success.jsp");
				reqDis.forward(request, response);
			}
			catch (Exception e) {
				session.setAttribute("exeption", e);
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
