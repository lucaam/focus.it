<%ProductBean pb = (ProductBean) request.getAttribute("prod"); %>

  <!DOCTYPE html>
  <html lang="en" dir="ltr">

  <head>
    <%@include file="./parts/meta.jsp" %>
      <%@include file="./parts/head.jsp" %>
        <title><%=pb.getProduct()%></title>
  </head>

  <body>
    <%@include file="./parts/nav.jsp" %>

      <div class="container bg-cont">
        <h2><%= pb.getProduct() %></h2>
        <div class="row">
          <div class="col-sm-7">
            <%if (pb.getPic()!="")
            	out.print("<img src=\"/"+ pb.getPic() +"\" class=\"img-prod img-fluid\" alt=\"img not found\">");
            else
              out.print("<img src=\"/images/notfound.jpg\" class=\"img-prod\" alt=\"img not found\" width=\"400px\" height=\"400px\">");
            %>

              <p class="text-muted text-small">
                Qui piccola descrizione della foto.
              </p>
          </div>
          <div class="col-sm-5">
            <h4><%= pb.getProduct() %></h4>
            <h5><%= pb.getPrice() %> &euro;</h5>
            <p class="text-justify">
              <%= pb.getDesc()%>
            </p>

          <!-- ("<a href=\"\" class=\"btn btn-dark\" id=\"addtocart\" onclick=\"added();\"><i class=\"fas fa-shopping-cart\"></i> Add to cart </a>") -->
            <button class="btn btn-dark" onclick="added(<%=pb.getId()%>)">Add to Cart</button>
            <span id="added" class="text-success"></span>



              <p class="text-justify">
                <ul style="list-style-type: none; padding:0;">
                  <li>
                    <%=pb.getMpx()%> Megapixels</li>
                  <li>
                    <%if(pb.getPrice()>50)
                	  out.print("Free shipping eigible on this product.");
                  else
                	  out.print("You can't get free shipping with this product.");

                  %>

                  </li>
                  <li>2 years of
                    <%= pb.getBrand()%> warranty!</li>

                </ul>
          </div>
          <div class="row rowdesc-margin">

          </div>
        </div>
      </div>
      <%@include file="./parts/footer.jsp" %>
  </body>

  </html>
