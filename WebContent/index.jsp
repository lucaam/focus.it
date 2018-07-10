<%@ page import="java.util.Random"%>
  <!-- temporary -->
  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html lang="en">

    <head>
      <%@include file="./parts/meta.jsp" %>
        <%@include file="./parts/head.jsp" %>
          <title>Homepage - focus.it</title>

    </head>

    <body class="background">
      <%@include file="./parts/nav.jsp" %>

        <div class="container-fluid bg-cont">
        <div class="container">
          <p>
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
              <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
              </ol>
              <div class="carousel-inner">
                <div class="carousel-item active">
                  <a href="searchProduct?searchnav= "><img class="d-block w-100" src="./images/sales/sale1.jpg" alt="First slide"></a>
                </div>
                <div class="carousel-item">
                  <a href="searchProduct?searchnav= "><img class="d-block w-100" src="./images/sales/sale2.jpg" alt="Second slide" href="searchProduct?searchnav= "></a>
                </div>
                <div class="carousel-item">
                  <a href="searchProduct?searchnav= "><img class="d-block w-100" src="./images/sales/sale3.jpg" alt="Third slide" href="searchProduct?searchnav= "></a>
                </div>
              </div>
              <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
              <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
            </div>
            <p>


              <div class="container bg-cont text-center imcentered">
                <div class="row imcentered">
                  <%


   int i = 3;
   	while(i!=0){


   		Random rand = new Random();
   		int int1 = rand.nextInt(17)+1;
   		ProductBeanDAO pbd = new ProductBeanDAO();
   		ProductBean pb = pbd.searchId(""+int1);

   		out.print("<div class=\"col imcentered\">");
   	    out.print("<div class=\"card\" style=\"width: 18rem;\">");
   	    if(pb.getPic()!="")
   	 	out.print("<label for=\"prodbutton\"><img class=\"card-img-top\" src=\" "+ pb.getPic() + "\" alt=\"Card image cap\"></label>");
   	    else
   	 out.print("<label for=\"prodbutton\"><img class=\"card-img-top\" src=\"./images/notfound.jpg\" alt=\"Card image cap\"></label>");  
   	 	out.print("<div class=\"card-body\">");
   	 	out.print("<h5 class=\"card-title\">" + pb.getProduct() + "</h5>");
   	    out.print("<p class=\"card-text pmax\">"+ pb.getDesc() + "</p>");
   	    out.print("<a id=\"prodbutton\" href=\"generatePage?idProd="+ pb.getId() +"\" class=\"btn btn-dark\">" + pb.getProduct() + " </a>");
   	  	out.print("</div>");
   		out.print("</div>");
   	    out.print("</div>");
   	    i--;

   	}
   %>
                </div>
              </div>

              <div class="container">
                <p class="imcentered">
                  Condimentum id venenatis a condimentum vitae sapien pellentesque. Morbi blandit cursus risus at ultrices. Malesuada fames ac turpis egestas sed tempus. Porttitor eget dolor morbi non. Dolor morbi non arcu risus quis. Sit amet nisl suscipit adipiscing.
                  Viverra orci sagittis eu volutpat. Molestie nunc non blandit massa enim nec dui nunc. Suspendisse interdum consectetur libero id faucibus nisl tincidunt. At augue eget arcu dictum varius. Interdum velit laoreet id donec ultrices tincidunt.
                  Magna sit amet purus gravida quis. Ornare suspendisse sed nisi lacus sed viverra tellus. Volutpat est velit egestas dui. Curabitur gravida arcu ac tortor dignissim convallis aenean et tortor. In hac habitasse platea dictumst quisque
                  sagittis. Malesuada bibendum arcu vitae elementum curabitur. Turpis egestas sed tempus urna et pharetra pharetra massa massa. Quis enim lobortis scelerisque fermentum dui faucibus. Volutpat ac tincidunt vitae semper quis lectus nulla
                  at volutpat. In nibh mauris cursus mattis molestie a iaculis at. Sed risus pretium quam vulputate. Consequat semper viverra nam libero. Viverra orci sagittis eu volutpat odio. Aliquet eget sit amet tellus cras adipiscing. Blandit aliquam
                  etiam erat velit scelerisque in dictum non. Dignissim diam quis enim lobortis scelerisque. Gravida cum sociis natoque penatibus. Ut lectus arcu bibendum at varius vel. At augue eget arcu dictum varius duis. Purus sit amet luctus venenatis
                  lectus magna fringilla urna. Rhoncus mattis rhoncus urna neque viverra justo nec ultrices dui. Sed elementum tempus egestas sed sed. Praesent elementum facilisis leo vel fringilla est ullamcorper. Vitae aliquet nec ullamcorper sit. Porttitor
                  leo a diam sollicitudin tempor id eu nisl. Sagittis eu volutpat odio facilisis mauris sit amet. Sed viverra tellus in hac. Elit scelerisque mauris pellentesque pulvinar pellentesque habitant morbi tristique. Elementum sagittis vitae
                  et leo duis ut diam quam. Tortor aliquam nulla facilisi cras fermentum. Faucibus vitae aliquet nec ullamcorper sit. Rutrum tellus pellentesque eu tincidunt tortor aliquam nulla facilisi cras. Sed enim ut sem viverra.
                </p>
              </div>
			</div>
        </div>
        <%@ include file="./parts/footer.jsp" %>

    </body>

    </html>
