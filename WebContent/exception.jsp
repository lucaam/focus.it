<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <%UserBean user = (UserBean) request.getAttribute("userBean"); %>

    <html lang="en">

    <head>
      <%@include file="meta.jsp" %>
        <%@include file="head.jsp" %>
          <title>Exception - focus.it</title>
    </head>

    <body>
      <%@include file="nav.jsp" %>
        <div class="container boxmargin text-center">
          <h1>Errore - Exception</h1> Qualcosa è andato storto!
          <br />
          <br />
          <% Exception e = (Exception) request.getAttribute("exception");%>
            <%= e.toString()%>
              <br>
              <a href='index.jsp' class="text-dark">Torna alla home</a>
        </div>
        <%@include file="footer.jsp" %>
    </body>

    </html>
