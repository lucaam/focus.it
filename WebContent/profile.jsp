<%@ page import="it.focus.model.UserBean"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="meta.jsp" %>
<title>Your profile - focus.it</title>
<%@ include file="head.jsp" %>
</head>
<body>
    <%@ include file="nav.jsp" %>


		
<%UserBean user = (UserBean) request.getAttribute("userBean");%>

    <div class="container bg-cont">
      <h2>Benvenuto 
      <%= user.getNome() %>
      </h2>
      <h4>Questa è la tua area utente!</h4>

	</div>
    <%@ include file="footer.jsp" %>
</body>
</html>
