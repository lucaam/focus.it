<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>

  <head>

    <%@ include file="meta.jsp" %>
      <%@ include file="head.jsp" %>

        <meta http-equiv="refresh" content="5; url=./cart.jsp" />

  </head>

  <body>

    <%@ include file="nav.jsp" %>

      <%CartBean cart = (CartBean) session.getAttribute("cart");
		request.setAttribute("cart", cart);%>

        <div class="container boxmargin">
          <p>
            Prodotto aggiunto con successo al carrello. Stai per essere reindirizzato al carrello.
            <p>
              Se vuoi tornare all pagina home clicca <a href="./index.jsp">qui</a>.
            </p>

        </div>
        <%@ include file="footer.jsp" %>

  </body>

  </html>
