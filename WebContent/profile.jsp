<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%@ include file="./parts/meta.jsp"%>
<title>Your profile - focus.it</title>
<%@ include file="./parts/head.jsp"%>
</head>

<body>
	<%@ include file="./parts/nav.jsp"%>



	<%
		if (user == null) {
			response.sendRedirect("./singinup.jsp");
			return;
		}
	%>
	<div class="container bg-cont ">
		<div class="row">
			<div class="col-sm-3">
				<!-- List group -->
				<div class="list-group " id="myList" role="tablist">
					<a
						class="list-group-item list-group-item-action list-group-item-dark active"
						data-toggle="list" href="#home" role="tab">Home</a> <a
						class="list-group-item list-group-item-action list-group-item-dark"
						data-toggle="list" href="#profile" role="tab">Profile</a> <a
						class="list-group-item list-group-item-action list-group-item-dark"
						data-toggle="list" href="#orders" role="tab">Orders</a> <a
						class="list-group-item list-group-item-action list-group-item-dark"
						data-toggle="list" href="#settings" role="tab">Settings</a>
				</div>
			</div>
			<div class="col-sm-9">

				<!-- Tab panes -->
				<div class="tab-content">
					<div class="tab-pane active" id="home" role="tabpanel">
						<h4>
							Welcome
							<%=user.getNome()%>!
						</h4>
						<br>

						<div class="progress">
							<div class="progress-bar bg-dark" role="progressbar"
								style="width: 100%" aria-valuenow="100" aria-valuemin="0"
								aria-valuemax="100"></div>
						</div>
						<br> Here you can find tabs to get and modify your
						information. <br> Try to complete your profile to get best
						tips while you are browsing our website.
					</div>
					<div class="tab-pane" id="profile" role="tabpanel">

						<h4>Your information</h4>
						<br>

						<div class="progress">
							<div class="progress-bar bg-dark" role="progressbar"
								style="width: 100%" aria-valuenow="100" aria-valuemin="0"
								aria-valuemax="100"></div>
						</div>
						<br> First name and lastname:
						<%=user.getNome()%>
						<%=user.getCognome()%><br> Email:
						<%=user.getEmail()%><br> Phone:
						<%=user.getPhone()%><br>
					</div>
					<div class="tab-pane" id="orders" role="tabpanel">
						<h4>Your orders</h4>
						<br>
						<div class="progress">
							<div class="progress-bar bg-dark" role="progressbar"
								style="width: 100%" aria-valuenow="100" aria-valuemin="0"
								aria-valuemax="100"></div>
						</div>

						<br> No orders are avaible.
					</div>
					<div class="tab-pane" id="settings" role="tabpanel">
						<h4>Settings</h4>
						<br>
						<div class="progress">
							<div class="progress-bar bg-dark" role="progressbar"
								style="width: 100%" aria-valuenow="100" aria-valuemin="0"
								aria-valuemax="100"></div>
						</div>
						<br>

						<%
							if ("admin".contentEquals(user.getRole())) {
						%>
						<h4>Admin reserved</h4>
						
						<a href="../add.jsp" class="btn btn-dark">Add product</a> <a
							href="#" class="btn btn-dark" onclick="deleteProd()">DeleteProd</a>
						<div id="deleteDiv"></div>
						<br>
						<div class="progress">
							<div class="progress-bar bg-dark" role="progressbar"
								style="width: 100%" aria-valuenow="100" aria-valuemin="0"
								aria-valuemax="100"></div>
						</div>
						<br>
						<%
							}
						%>
						<!-- INIZIO FORM CAMBIO CREDENZIALI -->

						<div class="container">
						<h4>Cambia credenziali d'accesso</h4>
							
							<form action="manageUser" method="post">
								<label for="changePass">Cambia password:</label>
								<br>
									<input type="password" class="form-control" id="old" placeholder="Enter old password" name="old">
									<br>
									<input type="password" class="form-control" id="new" placeholder="Enter new password" name="new">
															<br>
								
							<input type="submit" class="btn btn-dark" value="Submit" onclick="return validatePsw(this.form)">


							</form>

							<br>

							<h4>Cambia credenziali d'accesso</h4>
							
							<form action="manageUser" method="post">
								<label for="changeEmail">Cambia Email:</label>
								<br>
									<input type="email" class="form-control" id="oldemail" placeholder="Enter old email" name="oldemail">
									<br>
									<input type="email" class="form-control" id="oldemail" placeholder="Enter new email" name="newemail">
															<br>
								
							<input type="submit" class="btn btn-dark" value="Submit" onclick="return validateEmail(this.form)">


							</form>
							<br>
						</div>

						<!-- FINE FORM CAMBIO CREDENZIALI -->

						
					</div>
				</div>
			</div>
		</div>
	</div>





	<%@ include file="./parts/footer.jsp"%>
	<script src="./scripts/formValidator.js"></script>
</body>

</html>
