<%@ page import="it.focus.model.ProductBean" %>
  <%ProductBean pb = (ProductBean) request.getAttribute("prod");
  	
      %>
    <!DOCTYPE html>
    <html lang="en" dir="ltr">

    <head>
      <%@include file="meta.jsp" %>
        <%@include file="head.jsp" %>
          <title>Test page - focus.it</title>
    </head>

    <body>
      <%@include file="nav.jsp" %>
        <div class="container boxmargin">
          <h2><%= pb.getProduct() %></h2>
          <div class="row">
            <div class="col-sm-7">
            <%if (false/*pd.getPic()*/) 
            	out.print("img qui");
            else
              out.print("<img src=\"/images/notfound.jpg\" class=\"img-prod\" alt=\"img not found\" width=\"400px\" height=\"400px\">");
            %>
           
              <p class="text-muted text-small">
              	Qui piccola descrizione della foto.
              </p>
            </div>
            <div class="col-sm-5">
              <h4><%= pb.getProduct() %></h4> <h5><%= pb.getPrice() %> &euro;</h5>
              <p class="text-justify"> <%= pb.getDesc()%>
              </p>
              				<%out.print("<a href=\"addToCart?idProd="+ pb.getId() +" \" class=\"btn btn-dark\"> Add to cart </a>"); %>
              
              <p class="text-justify">
                <ul style="list-style-type: none; padding:0;">
                  <li><%= pb.getMpx()%> Megapixels</li>
                  <li><%if(pb.getPrice()>50)
                	  out.print("Free shipping eigible on this product.");
                  else
                	  out.print("You can't get free shipping with this product.");

                  %>
                  
                  </li>
                  <li>2 years of <%= pb.getBrand()%> warranty!</li>
              
                </ul>
            </div>
            <div class="row rowdesc-margin">
             
              </div>
          </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>

    </html>
