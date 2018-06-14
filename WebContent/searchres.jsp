<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="it.focus.model.ProductBean"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="meta.jsp" %>
<%@include file="head.jsp" %>
  <title>Search results - focus.it</title>
</head>
<body>
<%@include file="nav.jsp" %>
<div class="container-fluid bg-cont table-responsive">

  
	<% ArrayList<ProductBean> pList = (ArrayList<ProductBean>) request.getAttribute("prod"); 
	
		if(!pList.isEmpty()){
			out.print("<table class=\"table\">");
			out.print("<thead>");
			out.print("<tr>");
			out.print("<th scope=\"col\">Image</th>");
		    out.print("<th scope=\"col\">Name</th>");
		    out.print("<th scope=\"col\">Price</th>");
		    
			out.print(" <th scope=\"col\">Mpx</th>");
			out.print("</tr>");
			out.print("</thead>");
			out.print("<tbody>");
			for(ProductBean pb : pList)
			{
				if(/*pb.getPic()!=null*/false)
				out.print("<tr><th scope=\"row\">" + pb.getPic() +"</th>");	
				else
					out.print("<tr><th scope=\"row\"><img src=\"./images/notfound.png\" width=\"60px\" height=\"60px\"></th>");	
				out.print("<td class=\"td-prod\"><a href=\"generatePage?idProd="+ pb.getId() +"\">" + pb.getProduct() + " </a></td>");
				out.print("<td class=\"td-prod\">" + pb.getPrice() + "€ </td>");
				
				out.print("<td class=\"td-prod\">" + pb.getMpx() + "</td>");
				
				
				
			}
			out.print("</tbody>");
			out.print("</table>");
		}
		else
		{
			out.print("<p class=\"text-center nores \"> <h2> Spiacenti! La ricerca non ha protato risultati!</p>");
		}
	%>
	
	
	
	</div>
<%@ include file="footer.jsp" %>
</body>
</html>