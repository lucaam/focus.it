<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>

  <head>

    <title>Warning- focus.it</title>
    <%@include file="../parts/meta.jsp" %>
      <%@include file="../parts/head.jsp" %>
        <meta http-equiv="refresh" content="5; url=../add.jsp" />

  </head>

  <body>
    <%@include file="../parts/nav.jsp" %>
      <%if(!"admin".equals(user.getRole())){
			response.sendRedirect("./nopermission.jsp");
        return;}
		%>
        <div class="container bg-cont">
          <p>
            Spiacente! Prodotto NON aggiunto con successo al database. I campi non sono ancora tutti sotto controllo quindi per il momento ricorda di inserire i parametri in modo corretto. Stai per essere reindirizzato alla pagina di aggiunta del prodotto.
          </p>
          <p>
            Nel caso non dovesse funzionare il reindirizzamento, clicca <a href="../add.jsp">qui</a>
          </p>

        </div>
        <%@include file="../parts/footer.jsp" %>
  </body>

  </html>
