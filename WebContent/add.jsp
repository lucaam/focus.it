<%@ page import="it.focus.model.UserBean" %>


<!DOCTYPE html>
<html lang="en">

<head>
	  <%@include file="meta.jsp" %>
	  <%@include file="head.jsp" %>
  <title>Pagina riservata - focus.it</title>
</head>

<body>
	  <%@include file="nav.jsp" %>
		<%if(!"admin".equals(rolecookie.getValue())) 
			response.sendRedirect("nopermission.jsp");
		%>
   
  <div class="container boxmargin">

    <h2>Add a new product</h2>
    <form action="addProduct" method="post" name="addProductForm" enctype="multipart/form-data">

      <div class="form-group">
        <label for="product">Product name:</label>
        <input type="text" class="form-control" id="product" placeholder="Enter a product" name="product" required="true">
      </div>

      <div class="form-group">
        <label for="price">Price:</label>
        <input type="number" step="0.01" class="form-control" id="price" placeholder="Enter price" name="price" required="true">
      </div>

      <div class="form-group">
        <label for="brand">Brand:</label>
        <input type="text" class="form-control" id="brand" placeholder="Enter brand" name="brand" required="true">
      </div>

      <div class="form-group">
        <label for="desc">Description:</label>
        <input type="text" class="form-control" id="desc" placeholder="Enter description" name="desc" required="false">
      </div>

      <div class="form-group">
        <label for="color">Color:</label>
        <input type="text" class="form-control" id="color" placeholder="Enter color" name="color" required="false">
      </div>
      <div class="form-group">
        <label for="mpx">Megapixels:</label>
        <input type="number" step="0.01" class="form-control" id="mpx" placeholder="Enter megapixels" name="mpx" required="false">
      </div>

      <label for="pic">Pic:</label>
      <div class="input-group mb-3">
        <div class="custom-file">
          <input type="file" class="custom-file-input" id="pic">
          <label class="custom-file-label" for="pic">Choose file</label>
        </div>
      </div>
      <input type="submit" class="btn btn-default" value="Add">
    </form>
  </div>

	  <%@include file="footer.jsp" %>

</body>

</html>
