<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <html lang="en" dir="ltr">

  <head>
    <%@include file="../parts/meta.jsp" %>
      <%@include file="../parts/head.jsp" %>
        <title>Warning - focus.it</title>
  </head>

  <body>
    <%@include file="../parts/nav.jsp" %>
      <div class="container bg-cont text-center">
        <h1>Non hai i permessi sufficienti per accedere a questa pagina.
					Controlla di essere loggato o di essere amministratore.
	<br><a href='../singinup.jsp' class="btn btn-dark">Login</a>
		</h1>


        <br />
        <br />

        <br>
        <a href='../index.jsp' class="text-dark">Torna alla home</a>
      </div>
      <%@include file="../parts/footer.jsp" %>
  </body>

  </html>
