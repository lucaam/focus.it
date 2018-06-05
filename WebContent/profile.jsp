<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="meta.jsp" %>  
<title>Your profile</title>
<%@ include file="head.jsp" %>  
</head>
<body>
    <%@ include file="nav.jsp" %> 
    	
    	
		<%if(!"admin".equals(rolecookie.getValue())) 
			response.sendRedirect("nopermission.jsp");
		%>
    
    <%@ include file="footer.jsp" %>  
</body>
</html>