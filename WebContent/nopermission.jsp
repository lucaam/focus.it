<%@ page import="it.focus.model.UserBean" %>

<!DOCTYPE html>

<html lang="en" dir="ltr">
	<head>
<%@include file="meta.jsp" %>
<%@include file="head.jsp" %>
  <title>Warning - focus.it</title>
</head>

<body>
<%@include file="nav.jsp" %>
	<div class="container boxmargin text-center">
		<h1>Non hai i permessi sufficienti per accedere a questa pagina.
		Controlla di essere loggato o di essere amministratore.
			
		</h1>

		
		<br />
		<br />
		
		<br>
		<a href='index.jsp'>Torna alla home</a>
	</div>
<%@include file="footer.jsp" %>
</body>
</html>
