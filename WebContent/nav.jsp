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
        <li class="nav-item">
          <a class="nav-link" href="index.jsp">Home</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Fotocamere
        </a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="searchProduct?search=Canon" >Canon</a>
            <a class="dropdown-item" href="searchProduct?search=Nikon">Nikon</a>
            <a class="dropdown-item" href="searchProduct?search=Leica">Leica</a>
            <a class="dropdown-item" href="searchProduct?search=Olympus">Olympus</a>
            <div class="dropdown-divider"></div>
         
            <a class="dropdown-item" href="add.jsp">Add product</a>
        
        
          </div>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">About</a>
        </li>
      </ul>

      <form class="form-inline my-2 my-lg-0" action="searchProduct" method="get">
        <input class="form-control mr-sm-2" id="search" name="search" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
      </form>
	  
	  
		
       
          <ul class="navbar-nav navbar-right bg-dark navbar-dark">
            
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

             if (namecookie != null) {%>
           <li class="nav-item">
              <a class="nav-link" href="profile.jsp">Benvenuto <%out.println(namecookie.getValue());%></a>
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