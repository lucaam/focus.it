<%@ page import="it.focus.model.UserBean" %>
      <%UserBean user = (UserBean) request.getAttribute("userBean");
      %>
<!DOCTYPE html>
<html>

<head>
 
  <title>Warning- focus.it</title>
  <%@include file="meta.jsp" %>
  <%@include file="head.jsp" %>
  <meta http-equiv="refresh" content="5; url=./add.jsp" />

</head>
<body>
  <%@include file="nav.jsp" %>
<div class="container boxmargin">
    <p>
    Spiacente! Prodotto NON aggiunto con successo al database.
    I campi non sono ancora tutti sotto controllo quindi
    per il momento ricorda di inserire i parametri in modo corretto.

    Stai per essere reindirizzato alla pagina di aggiunta del prodotto.
    </p>
    <p>
    Nel caso non dovesse funzionare il reindirizzamento, clicca <a href="./add.jsp">qui</a>
    </p>

  </div>
<%@include file="footer.jsp" %>
</body>

</html>
