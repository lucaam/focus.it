<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>

  <head>
    <%@ include file="meta.jsp" %>
      <title>Your profile - focus.it</title>
      <%@ include file="head.jsp" %>
  </head>

  <body>
    <%@ include file="nav.jsp" %>



      <%UserBean user = (UserBean) session.getAttribute("userBean");
	if(user==null){
	  	response.sendRedirect("singinup.jsp");
	return;
	}
	%>
        <div class="container bg-cont">
          <h2>Benvenuto
      <%= user.getNome() %>
      </h2>
          <h4>Questa è la tua area utente!</h4>

          <p>
            Nome e cognome:
            <%= user.getNome() %>
              <%= user.getCognome() %> <br> Hai i permessi da:
                <%= user.getRole() %> <br> Il tuo username è:
                  <%= user.getUsr() %> <br> L'email di registrazione è:
                    <%= user.getEmail() %> <br>
          </p>
        </div>


        <%@ include file="footer.jsp" %>
  </body>

  </html>
