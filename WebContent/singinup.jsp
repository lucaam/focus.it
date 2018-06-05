
<!DOCTYPE html>
<html lang="en">

<head>
<%@include file="meta.jsp" %>
<%@include file="head.jsp" %>


  <title>Singin or singup - focus.it</title>
</head>

<body>
  <%@include file="nav.jsp" %>
  
<div class="container boxmargin">
  <div class="row">
    <div class="col-sm-5">
      <h3>Accedi a focusit</h3>

      <% Boolean bad = (Boolean) request.getAttribute("denied");%>
      <% if(bad != null) { %>
        <h1>Access denied </h1>
        <h3> Please insert correct data </h3>
      <% } else %>

      <form action="Login" method="post">
        <div class="form-group">
          <label for="username">Username:</label>
          <input type="text" class="form-control" id="user" placeholder="Enter username" name="user" required="true">
        </div>

        <div class="form-group">
          <label for="password">Password:</label>
          <input type="password" class="form-control" id="psw" placeholder="Enter password" name="psw" required="true">
        </div>
        <div class="form-check">
          <label><input type="checkbox" class="form-check-input" id="remember"> Remember me</label>
        </div>
        <input type="submit" class="btn btn-default" value="Submit">
      </form>
    </div>

    <div class="col-sm-7">
      <h3>Registrati a focusit</h3>
      <form action="Registration" method="post" name="formRegistration">
        <!-- get username --->
        <div class="form-group">
          <label for="username">Username:</label>
          <input type="text" class="form-control" id="username" placeholder="Enter username" name="username" required="true">
        </div>
        <!-- get password --->
        <div class="form-group">
          <label for="password">Password:</label>
          <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required="true">
        </div>
        <!-- get name --->
        <div class="form-group">
          <label for="name">Name:</label>
          <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" required="true">
        </div>
        <!-- get surname --->
        <div class="form-group">
          <label for="surname">Surname:</label>
          <input type="text" class="form-control" id="surname" placeholder="Enter surname" name="surname" required="true">
        </div>
        <!-- get email --->
        <div class="form-group">
          <label for="email">Email:</label>
          <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required="true">
        </div>
        <input type="submit" class="btn btn-default" value="Submit"  onclick="return validateRegistration(this.form)">
      </form>
    </div>
  </div>
</div>

  <%@include file="footer.jsp" %>

</body>

</html>
