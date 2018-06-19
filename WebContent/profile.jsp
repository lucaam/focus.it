<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>

  <head>
    <%@ include file="./parts/meta.jsp" %>
      <title>Your profile - focus.it</title>
      <%@ include file="./parts/head.jsp" %>
  </head>

  <body>
    <%@ include file="./parts/nav.jsp" %>



<%	if(cookies==null){
	  	response.sendRedirect("./singinup.jsp");
	return;
	}
	%>
        <div class="container bg-cont">
          <h2>Benvenuto
      <%= namecookie.getValue() %>
      </h2>
          <h4>Questa è la tua area utente!</h4>

          <p>
            Nome e cognome:
            <%= namecookie.getValue()%>
              <%= surnamecookie.getValue()%> <br> Hai i permessi da:
                <%= rolecookie.getValue() %> <br> Il tuo username è:
                  <%= usrcookie.getValue() %> <br> L'email di registrazione è:
                    <%= emailcookie.getValue() %> <br> Il tuo numero di telefono è:
                    <%= phonecookie.getValue() %> <br>
                    
          </p>
          
          
        </div>


        <%@ include file="./parts/footer.jsp" %>
  </body>

  </html>
