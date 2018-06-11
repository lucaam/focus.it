<%@ page import="it.focus.model.UserBean" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" isErrorPage="true"%>
  <%UserBean user = (UserBean) request.getAttribute("userBean"); %>
    <!DOCTYPE html>
    <html>

    <head>

      <title>Warning - focus.it</title>
      <%@include file="meta.jsp" %>
        <%@include file="head.jsp" %>
          <meta http-equiv="refresh" content="5; url=./singinup.jsp" />

    </head>

    <body>
      <%@include file="nav.jsp" %>

        <div class="container boxmargin">
          <p>
            Qualcosa ï¿½ andato storto, registrazione non avvenuta con successo. Stai per essere reindirizzato alla pagina di registrazione.
          </p>
          <p>
            Nel caso non dovesse funzionare il reindirizzamento, clicca <a href="./singinup.jsp">qui</a>
          </p>

        </div>
        <%@include file="footer.jsp" %>
    </body>

    </html>
