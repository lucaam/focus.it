<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>

  <head>
    <%@include file="meta.jsp" %>
      <%@include file="head.jsp" %>
        <title>Cart - focus.it</title>
  </head>

  <body>
    <%@include file="nav.jsp" %>

      <div class="container-fluid bg-cont">




        <%
	if (session==null){
	  	response.sendRedirect("nopermission.jsp");
	return;
	}
	CartBean cart = (CartBean) session.getAttribute("cart");
	if (cart==null){
	  	response.sendRedirect("nopermission.jsp");
	return;
	}


		if(!cart.isEmpty()){
			out.print("<div class=\"row\">");
			out.print("<div class=\"col-sm-10\">");
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
			ArrayList<ProductBean> pList = cart.getItems();


			for(ProductBean pb : pList)
			{
				if(/*pb.getPic()!=null*/false)
				out.print("<tr><th scope=\"row\">" + pb.getPic() +"</th>");
				else
					out.print("<tr><th scope=\"row\"><img src=\"./images/notfound.png\" width=\"60px\" height=\"60px\"></th>");
				out.print("<td class=\"td-prod\"><a href=\"generatePage?idProd="+ pb.getId() +"\" class=\"text-dark\">" + pb.getProduct() + " </a></td>");
				out.print("<td class=\"td-prod\">" + pb.getPrice() + "€ </td>");

				out.print("<td class=\"td-prod\">" + pb.getMpx() + "</td>");



			}
			out.print("</tbody>");
			out.print("</table>");
			out.print("</div>");
			out.print("<div class=\"col-sm-2\">");
			out.print("<div class=\"alert alert-secondary\">Total: " + cart.getTotal() + "</div>");
			out.print("<a href=\"#\" class=\"btn btn-secondary\">Buy</a>");
			out.print("</div>");
			out.print("</div>");
		}
		else
		{
			out.print("<p class=\"text-center\"><h2>Your cart is empty right now!</p>");
		}
	%>



      </div>

      <%@include file="footer.jsp" %>
  </body>

  </html>
