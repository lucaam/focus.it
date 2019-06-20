<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>

  <head>

    <%@ include file="../parts/meta.jsp" %>
      <%@ include file="../parts/head.jsp" %>

        <!--         <meta http-equiv="refresh" content="1; url=../cart.jsp" />
 -->
  </head>

  <body>

    <%@ include file="../parts/nav.jsp" %>



      <div class="container bg-cont">
        <p>
          Aggiornamento del carrello eseguito con successo.
          <p>
            <%out.print("<a href=\"cart.jsp\" class=\"btn btn-dark\"><i class=\"fas fa-shopping-cart\"></i> Cart </a>"); %>
          </p>

      </div>
      <%@ include file="../parts/footer.jsp" %>

  </body>

  </html>
