<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html>

  <head>
    <%@include file="./parts/meta.jsp" %>
      <%@include file="./parts/head.jsp" %>
        <title>Search results - focus.it</title>
  </head>

  <body>
    <%@include file="./parts/nav.jsp" %>
      <div class="table-responsive">


        <% ArrayList<ProductBean> pList = (ArrayList<ProductBean>) request.getAttribute("prod");

		if(!pList.isEmpty()){
			out.print("<table class=\"table\">");
			out.print("<thead>");
			out.print("<tr>");
			out.print("<th scope=\"col\">Image</th>");
		    out.print("<th scope=\"col\">Name</th>");
		    out.print("<th scope=\"col\">Price</th>");
			out.print(" <th scope=\"col\">Mpx</th>");
			out.print(" <th scope=\"col\">Buy</th>");

			out.print("</tr>");
			out.print("</thead>");
			out.print("<tbody>");
			for(ProductBean pb : pList)
			{
				if (pb.getPic()!="")
	            	out.print("<tr><th scope=\"row\"><img src=\"/"+ pb.getPic() +"\" width=\"60px\" height=\"60px\" class=\"img-fluid\"></th>");

				else
					out.print("<tr><th scope=\"row\"><img src=\"./images/notfound.png\" width=\"60px\" height=\"60px\"></th>");
				out.print("<td class=\"td-prod\"><a href=\"generatePage?idProd="+ pb.getId() +"\" class=\"text-dark\">" + pb.getProduct() + " </a></td>");
				out.print("<td class=\"td-prod\">" + pb.getPrice() + "€ </td>");

				out.print("<td class=\"td-prod\">" + pb.getMpx() + "</td>");
				out.print("<td class=\"td-prod\"><button class=\"btn btn-dark\" id=\"added"+pb.getId() +"\" onclick=\"addFromSearch( "+pb.getId()+ ")\" >Cart</button></td>");

			}
			out.print("</tbody>");
			out.print("</table>");
			out.print("<div id=\"dialog\" title=\"Confirmation\">");

			out.print("</div>​");
		}
		else
		{
			out.print("<p class=\"text-center nores \"> <h2> Spiacenti! La ricerca non ha portato risultati!</p>");
		}
	%>



      </div>
      <%@ include file="./parts/footer.jsp" %>
  </body>

  </html>
