<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>

  <head>

    <%@include file="../parts/meta.jsp" %>
      <%@include file="../parts/head.jsp" %>
        <title>Welcome - focus.it</title>

        <meta http-equiv="refresh" content="5; url=../index.jsp" />


  </head>

  <body>

    <%@include file="../parts/nav.jsp" %>

      <div class="container bg-cont">
        <%  if (user != null) {%>
        <p>
          Benvenuto, <%=user.getNome()%>! Stai per essere reindirizzato alla homepage.
        </p>
        <p>


          Nel caso non dovesse funzionare il reindirizzamento, clicca <a href="../index.jsp">qui</a>
        </p>
        <%} else {%>
        <p>Benvenuto! Stai per essere indirizzato alla homepage.</p>
        <p>


          Nel caso non dovesse funzionare il reindirizzamento, clicca <a href="../index.jsp">qui</a>
        </p>
        <%}%>
      </div>

      <%@include file="../parts/footer.jsp" %>

  </body>

  </html>
