<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <html>

  <head>

    <title>Warning - focus.it</title>
    <%@include file="../parts/meta.jsp" %>
      <%@include file="../parts/head.jsp" %>
        <meta http-equiv="refresh" content="5; url=../singinup.jsp" />

  </head>

  <body>
    <%@include file="../parts/nav.jsp" %>

      <div class="container boxmargin">
        <p>
          Qualcosa è andato storto, registrazione non avvenuta con successo. Stai per essere reindirizzato alla pagina di registrazione.
        </p>
        <p>
          Nel caso non dovesse funzionare il reindirizzamento, clicca <a href="../singinup.jsp">qui</a>
        </p>

      </div>
      <%@include file="../parts/footer.jsp" %>
  </body>

  </html>
