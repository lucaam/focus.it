package it.focus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie usrcookie = new Cookie("usr" , "");
		usrcookie.setMaxAge(0);
		usrcookie.setPath("/");

		response.addCookie(usrcookie);
		
		Cookie pswcookie = new Cookie("psw" , "");
		pswcookie.setMaxAge(0);
		pswcookie.setPath("/");
		response.addCookie(pswcookie);
		
		Cookie rolecookie = new Cookie("role" , "");
		rolecookie.setMaxAge(0);
		
		
		rolecookie.setPath("/");
		response.addCookie(rolecookie);
		
		Cookie namecookie = new Cookie("name" , "");
		namecookie.setMaxAge(0);
		namecookie.setPath("/");
		response.addCookie(namecookie);
		
		request.getSession().invalidate();
		
		response.sendRedirect("singinup.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
