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
<div class="container">
<table class="table">
<thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
      <th scope="col">Description</th>
      <th scope="col">Megapixels</th>
    </tr>
  </thead>
  <tbody>
  
	<% ArrayList<ProductBean> pList = (ArrayList<ProductBean>) request.getAttribute("prod"); 
		
		for(ProductBean pb : pList)
		{
			out.print("<tr><th scope=\"row\">" + pb.getId() + "</th>");
			out.print("<td>" + pb.getProduct() +"</td>");		
			out.print("<td>" + pb.getPrice() + "€ </td>");
			out.print("<td>" + pb.getDesc() + "</td>");
			out.print("<td>" + pb.getMpx() + "</td>");
		}
	%>
	
	
	</tbody>
	</table>
	</div>
<%@ include file="footer.jsp" %>
</body>
</html>