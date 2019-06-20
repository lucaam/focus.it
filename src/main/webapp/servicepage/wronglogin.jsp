<%@ page import="it.focus.model.UserBean" language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" isErrorPage="true"%>
  <!DOCTYPE html>
  <html>

  <head>

    <title>Warning - focus.it</title>
    <%@include file="../parts/meta.jsp" %>
      <%@include file="../parts/head.jsp" %>

        <meta http-equiv="refresh" content="5; surl=./.singinup.jsp" />

  </head>

  <body>
    <%@include file="../parts/nav.jsp" %>
      <div class="container bg-cont">
        <p>
          Qualcosa è andato storto, non ti sei loggato con successo. ID e/o password sono errati. Stai per essere reindirizzato alla pagina di registrazione.
        </p>
        <p>
          Nel caso non dovesse funzionare il reindirizzamento, clicca <a href="../singinup.jsp">qui</a>
        </p>

      </div>
      <%@include file="../parts/footer.jsp" %>
  </body>

  </html>
