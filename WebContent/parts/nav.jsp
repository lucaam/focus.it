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
              <a class="nav-link" href="../singinup.jsp"><i class="nav-link fas fa-sign-in-alt"></i></a>
            </li>




            <% } %>
              <li class="navbar-item active">
                <a class="nav-link" href="../cart.jsp"><i class="nav-link fas fa-shopping-cart"></i></a>
              </li>
    </ul>
  </div>

</nav>
<br>
<div class="container-fluid text-center text-danger">
  <h6 class="text-small text-center text-danger"> Added fully working cart. Stay tuned, functionality to make order is coming!</h6>
  <h5 class="text-small"><a href="../servicepage/wip.jsp" class="text-dark">Send a feedback</a></h5>
</div>
<script src="../scripts/navAnimation.js"></script>
<!-- navbar-end -->
