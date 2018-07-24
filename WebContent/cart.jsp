<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>

  <head>
    <%@include file="./parts/meta.jsp" %>
      <%@include file="./parts/head.jsp" %>
        <title>Cart - focus.it</title>
  </head>

  <body>
    <%@include file="./parts/nav.jsp" %>

      

	


        <%
	if (session==null){
		out.print("<div class=\"container bg-cont\"><p class=\"text-center\"><h2>Your cart is empty right now!</p>");
	return;
	}

	if (cart==null){
		out.print("<div class=\"container bg-cont\"><p class=\"text-center\"><h2>Your cart is empty right now!</p>");
	return;
	}


		
				
				if(!cart.isEmpty()){

			out.print("<div class=\"table-responsive\">");
			
			out.print("<table class=\"table\">");
			out.print("<thead>");
			out.print("<tr>");
			out.print("<th scope=\"col\">Image</th>");
		    out.print("<th scope=\"col\">Name</th>");
		    out.print("<th scope=\"col\">Price</th>");

			out.print(" <th scope=\"col\">Mpx</th>");
			out.print(" <th scope=\"col\">Qta</th>");

			out.print("</tr>");
			out.print("</thead>");
			out.print("<tbody>");
			
			if(cart.getUser()!=null && cart.getUser()!=""){
				cart = cart.restoreCart();
			}
			ArrayList<ProductBean> pList = cart.getItems();
			ArrayList<Integer> qList = cart.getQtas();
			int i = 0;
			
			for(ProductBean pb : pList)
			{
				if (pb.getPic()!="")
	            	out.print("<tr><th scope=\"row\"><img src=\"/"+ pb.getPic() +"\" class=\"img-fluid\" width=\"60px\" height=\"60px\"></th>");
	            
				else
					out.print("<tr><th scope=\"row\"><img src=\"./images/notfound.png\" class=\"img-fluid\" width=\"60px\" height=\"60px\"></th>");
				out.print("<td class=\"td-prod\"><a href=\"generatePage?idProd="+ pb.getId() +"\" class=\"text-dark\">" + pb.getProduct() + " </a></td>");
				out.print("<td class=\"td-prod\">" + pb.getPrice() + "€ </td>");
				out.print("<td class=\"td-prod\">" + pb.getMpx() + "</td>");
				out.print("<td class=\"td-prod\">" + qList.get(i++) + "</td>");

	            out.print("<td class=\"td-prod\"><a href=\"removeFromCart?idProd="+ pb.getId() +" \" class=\"btn btn-dark\"><i class=\"fas fa-shopping-cart\"></i> Remove from cart </a></td>");
			}
			out.print("</tbody>");
			out.print("</table>");
			out.print("<div class=\"alert alert-secondary\">Total: " + cart.getTotal() + "€</div>");

			out.print("</div>");
			
		}
				
		
		else
		{
			out.print("<p class=\"text-center\"><h2>Your cart is empty right now!</p>");
		}
	%>



      </div>

      <%@include file="./parts/footer.jsp" %>
  </body>

  </html>
