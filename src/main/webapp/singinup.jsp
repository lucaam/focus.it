<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <html lang="en">

  <head>
    <%@include file="./parts/meta.jsp" %>
      <%@include file="./parts/head.jsp" %>


        <title>Singin or singup - focus.it</title>
  </head>

  <body>
    <%@include file="./parts/nav.jsp" %>

      <div class="container bg-cont">
        <div class="row">
          <div class="col-sm-5">
            <h3>Accedi a focusit</h3>
            <h6 class="text-small text-muted">if you want to test -> id: guesterino password: guesterino</h6>

            <% denied = (Boolean) request.getAttribute("denied");%>
              <%  nodata = (Boolean) request.getAttribute("nodata");%>
                <% duplicate = (Boolean) request.getAttribute("duplicate");%>

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

        <div class="col-sm-7">
          <h3>Registrati a focusit</h3>
          <h6 class="text-small text-muted">if you want to test -> id: guest password: guest</h6>
          <form action="Registration" method="post" name="formRegistration">
            <!-- get username --->
            <% if(duplicate != null) { %>
            <div class="form-group">
              <span class="text-small text-danger"> Username/email already exists  </span>
              <br>
              <label for="username">Username:</label>
              <input type="text" class="form-control is-invalid" id="username" placeholder="Enter username" name="username"  >
            </div>
              <%}else{ %>
              <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username" placeholder="Enter username" name="username"  >
              </div>
              <%}%>
                <!-- get password --->
                <div class="form-group">
                  <label for="password">Password:</label>
                  <input type="password" class="form-control" id="password" placeholder="Enter password" name="password"  >
                </div>
                <!-- get name --->
                <div class="form-group">
                  <label for="name">Name:</label>
                  <input type="text" class="form-control" id="name" placeholder="Enter name" name="name"  >
                </div>
                <!-- get surname --->
                <div class="form-group">
                  <label for="surname">Surname:</label>
                  <input type="text" class="form-control" id="surname" placeholder="Enter surname" name="surname"  >
                </div>
                <!-- get email --->
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" class="form-control" id="email" placeholder="Enter email" name="email"  >
                </div>

                <div class="form-group">
                  <label for="username">Phone number:</label>
                  <input type="text" class="form-control" id="phone" placeholder="Enter phone number" name="phone"  >
                </div>
                <input type="submit" class="btn btn-dark" value="Register" onclick="return validateRegistration(this.form)">
          </form>
        </div>
      </div>
      </div>

      <%@include file="./parts/footer.jsp" %>

  </body>

  </html>
