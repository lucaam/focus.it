package it.focus.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;

import it.focus.model.UserBean;
import it.focus.model.UserBeanDAO;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String login = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String ldn = request.getParameter("birthplace");
		String phone = request.getParameter("phone");

		
		try {
			
			UserBeanDAO ubBeanDAO = new UserBeanDAO();
			UserBean ub = ubBeanDAO.userRegistration(login, name, surname, password, email, ldn, phone);
			
			
			if(ub != null)
			{
				RequestDispatcher req = request.getRequestDispatcher("success.jsp");
				req.forward(request, response);
			}
			else
			{
				RequestDispatcher req = request.getRequestDispatcher("wrongreg.jsp");
				req.forward(request, response);
			}
		} catch (Exception e){
			request.setAttribute("exception", e);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("exception.jsp");
			requestDispatcher.forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
