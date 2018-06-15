package it.focus.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;

import it.focus.model.CartBean;
import it.focus.model.UserBean;
import it.focus.model.UserBeanDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				UserBean userB = getUserPassword(request);

				if (userB == null) {    // no login e/o no password -> redirigo a login form 
					System.out.println("No data input");
					request.setAttribute("nodata", true);
					RequestDispatcher requestDispatcher = request.getRequestDispatcher("singinup.jsp");
					requestDispatcher.forward(request, response);
				}
				else {
					try{
						UserBeanDAO ubd = new UserBeanDAO();
						CartBean cart = new CartBean();
						UserBean ub = ubd.doRetriveByKey(userB.getUsr(), userB.getPwd());
						
						HttpSession session = request.getSession();

						if (ub==null) {    // login e/o password sbagliati -> chiamo login form  con messaggio errore
											// il nome login.jsp non si vedrà nel browser
							
							System.out.println("Invalid data");
							request.setAttribute("denied", true);
							RequestDispatcher requestDispatcher = request.getRequestDispatcher("singinup.jsp");
							requestDispatcher.forward(request, response);
						}else {
							// l'utente è ammesso al sito: inserisco dati di login in cookies e do risposta
							
							Cookie usrcookie = new Cookie("usr", ub.getUsr());
							Cookie namecookie = new Cookie("name", ub.getNome());
							Cookie pswcookie = new Cookie("psw", ub.getPwd());
							Cookie rolecookie = new Cookie("role", ub.getRole());
							
							usrcookie.setMaxAge(60*60*24);
							namecookie.setMaxAge(60*60*24);
							pswcookie.setMaxAge(60*60*24);
							rolecookie.setMaxAge(60*60*24);
							
							namecookie.setPath("/");
							usrcookie.setPath("/");
							pswcookie.setPath("/");
							rolecookie.setPath("/");

							response.addCookie(usrcookie);
							response.addCookie(pswcookie);
							response.addCookie(rolecookie);
							response.addCookie(namecookie);

							session.setAttribute("cart", cart);
							session.setAttribute("userBean", ub);  // l'output ha bisogno di queste informazioni
							session.setMaxInactiveInterval(60*60*24);
							System.out.println("Nome: " + ub.getNome());
							System.out.println("Cart: " + cart.isEmpty());

					

							RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");
							requestDispatcher.forward(request, response);
						}
					}
					catch(Exception e)
					{  
						request.setAttribute("exception", e);
						RequestDispatcher requestDispatcher = request.getRequestDispatcher("exception.jsp");
						requestDispatcher.forward(request, response);
					}
				}
			}

	
	
	private UserBean getUserPassword(HttpServletRequest request) {
		UserBean ub = null;
		String usr = null, pwd = null;
		
		Cookie[] c = request.getCookies();
		if(c!=null) {
			for(int i=0; i<c.length;i++) {
				if (c[i].getName().equals("usr"))
					usr = c[i].getValue();
				if(c[i].getName().equals("psw"))
					pwd = c[i].getValue();
			}
		}
		if (usr == null || pwd == null) {
			String tmp;
			tmp = request.getParameter("user");
			if(tmp!=null) {
				usr=tmp;
			tmp=request.getParameter("psw");
			if(tmp!=null)
				pwd=tmp;
			}
		}
		
		if(usr!=null && pwd!=null)
			ub = new UserBean(usr, pwd);
		
		return ub;
			
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
}


}
