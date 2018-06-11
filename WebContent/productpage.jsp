<%@ page import="it.focus.model.ProductBean" %>
  <%ProductBean pb = (ProductBean) session.getAttribute("prod");
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
              <img src="#" class="img-prod">
            </div>
            <div class="col-sm-5">
              <h4><%= pb.getProduct() %></h4>
              <p class="text-justify"> <%= pb.getDesc()%>
              </p>
              <p class="text-justify">
                <ul>
                  <li>Opzione</li>
                  <li>Opzione</li>
                  <li>Opzione</li>
                  <li>Opzione</li>
                  <li>Opzione</li>
                  <li>Opzione</li>
                  <li>Opzione</li>
                </ul>
            </div>
            <div class="row rowdesc-margin">
             
              </div>
          </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>

    </html>
