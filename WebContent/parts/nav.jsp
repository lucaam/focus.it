<span class="wb-sessto" data-wb-sessto='{"sessionalive": 86400000, "logouturl": "../index.jsp", "refreshCallbackUrl": "./"}'></span>
<!-- navbar-start -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
  <a class="navbar-brand" href="../index.jsp">
      <img src="../images/logo.png" width="30" height="30" alt="logo">
    </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="../index.jsp">Home</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Fotocamere
        </a>
        <ul class="dropdown-menu" aria-labelledby="navbarDropdown" id="brandList">
          <li><a class="dropdown-item" href="searchProduct?search=Canon">Canon</a></li>
          <li><a class="dropdown-item" href="searchProduct?search=Nikon">Nikon</a></li>
          <li><a class="dropdown-item" href="searchProduct?search=Leica">Leica</a></li>
          <li><a class="dropdown-item" href="searchProduct?search=Olympus">Olympus</a></li>
         
        </ul>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="about.jsp">About</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="https://github.com/lucaam/focus.it/commits/master">Changelog</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="https://www.paypal.me/LucaAmoriello">Donate</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="../servicepage/wip.jsp">Feedback</a>
      </li>
    </ul>

    <form class="form-inline my-2 my-lg-0" action="searchProduct" method="get">
      <input class="form-control mr-sm-2" id="searchnav" name="searchnav" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-secondary my-2 my-sm-0" type="submit">Search</button>
    </form>




    <ul class="navbar-nav navbar-right bg-dark navbar-dark">

      <%@ include file="./cookie.jsp" %>



        <%  if (user != null) {%>
          <li class="nav-item">
            <a class="nav-link" href="profile.jsp">Welcome back, <%=user.getNome()%></a>
          </li>
          <li>
            <form class="nav-link" action="Logout" method="post">
              <button type="submit" id="logout" class="fabutton">
     			 <i class="fas fa-sign-out-alt nav-link"></i>
				</button>
            </form>
          </li>
          <% } else{ %>
            <li>
              <a class="nav-link" href="../singinup.jsp"><i class="nav-link fas fa-user-plus"></i></a>
            </li>
            <li class="navbar-item active">
              <a class="nav-link" href="#" onclick="openLogin()"><i class="nav-link fas fa-sign-in-alt"></i></a>
            </li>



            <% } %>
              <li class="navbar-item active">
                <a class="nav-link" href="../cart.jsp"><i class="nav-link fas fa-shopping-cart"></i></a>
              </li>
    </ul>
  </div>

</nav>



<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Accedi a focusit</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <h3>Accedi a focusit</h3>
            <h6 class="text-small text-muted">if you want to test -> id: guesterino password: guesterino</h6>

            <% Boolean denied = (Boolean) request.getAttribute("denied");%>
              <% Boolean nodata = (Boolean) request.getAttribute("nodata");%>
                <% Boolean duplicate = (Boolean) request.getAttribute("duplicate");%>

                  <form action="Login" method="post">
                    <div class="form-group">
                      <% if(denied != null) { %>
                        <span class="text-small text-danger"> Wrong data - Please insert correct data  </span>

                        <% }if(nodata != null) { %>
                          <h6 class="text-small text-danger"> No data inserted - Please insert data  </h6>


								</form>
                  <% }else { %>
                    <form action="Login" method="post">
                      <div class="form-group">
                        <label for="username">Username:</label>
                        <input type="text" class="form-control" id="user" placeholder="Enter username" name="user"  >
                      </div>

                      <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" class="form-control" id="psw" placeholder="Enter password" name="psw"  >
                      </div>
                      <div class="form-check">
                        <label><input type="checkbox" class="form-check-input" id="remember"> Remember me</label>
                      </div>
                      <input type="submit" class="btn btn-dark" value="Submit" onclick="return validateLogin(this.form)">
                    </form>


                    <%} %>
          </div>

                    
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<!-- navbar-end -->
