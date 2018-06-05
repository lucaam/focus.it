<%@ page import="it.focus.model.UserBean" %>


<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <link rel="stylesheet" href="./css/custom.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp" crossorigin="anonymous">


  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>


  <title>Homepage - focus.it</title>
</head>

<body>

         
    <!-- navbar-start -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
    <a class="navbar-brand" href="#">
      <img src="./images/logo.png" width="30" height="30" alt="logohere">
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Fotocamere
        </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="#">Canon</a>
            <a class="dropdown-item" href="#">Nikon</a>
            <a class="dropdown-item" href="#">Leica</a>
            <a class="dropdown-item" href="#">Olympus</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="add.jsp">Add product</a>
  </div>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">About</a>
        </li>
      </ul>

      <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
      </form>
	  

		
       
          <ul class="navbar-nav navbar-right bg-dark navbar-dark">
            <li class="navbar-item active mr-auto">
    
              
                            <%     
			Cookie [] cookies = request.getCookies();
             Cookie usrcookie =null;
             Cookie pswcookie=null;
             Cookie rolecookie=null;
             Cookie namecookie=null;
		      if(cookies != null){
		      	for (Cookie temp : cookies){
		      		if("usr".equals(temp.getName())){
		      			 usrcookie = temp;}
		      		 if("psw".equals(temp.getName())){
		      		 	 pswcookie = temp;}
		      		 if("role".equals(temp.getName())){
		      		 	 rolecookie = temp;}
		      		if("name".equals(temp.getName())){
		      		 	 namecookie = temp;}
      	}
      }
		      if(rolecookie==null)
					response.sendRedirect("nopermission.jsp");

             if (usrcookie != null) {%>
           
              <a class="nav-link" href="#">Benvenuto <%out.println(namecookie.getValue());%></a>
            </li>
            <form class="nav-link" action="Logout" method="post">
            	<button type="submit" id="logout" class="fabutton">
     			 <i class="fas fa-sign-out-alt nav-link"></i>
				</button>
            </form>
        <% } else{ %>
            <a class="nav-link" href="singinup.jsp"><i class="nav-link fas fa-user-plus"></i></a>
          </li>
          <li class="navbar-item active">
            <a class="nav-link" href="singinup.jsp"><i class="nav-link fas fa-sign-in-alt"></i></a>
          </li>
          <% } %>
        </ul>
    </div>
    

  </nav>
  <!-- navbar-end -->
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

  <div class="footer bg-dark text-light fot1">
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-4">
          <ul>Sezione
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
          </ul>
        </div>
        <div class="col-sm-4">
          <ul>Sezione
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
          </ul>
        </div>
        <div class="col-sm-4">
          <ul>Sezione
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
            <li>link</li>
          </ul>
        </div>
      </div>
    </div>
  </div>

  <div class="footer bg-light text-dark fot2">
    <div class="container-fluid">
      <p class="text-center small">
        Copyright © 2018 - Focus.it P.IVA 0000000000000000 - Capitale sociale interamente versato € 200.000 - Reg #00000 <br> Funzione di ricerca basata su nulla per adesso - All Rights Reserved - Housing and Web Design by Alessio Cuccurullo, Luca Amoriello

    </div>
  </div>





</body>

</html>
