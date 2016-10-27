<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html">
<html>
 <head>
 <meta charset="UTF-8" />
<link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet" type="text/css" />
<link href="<c:url value="/css/shop-homepage.css" />" rel="stylesheet">
<script src="<c:url value="/js/jquery.js" />"></script>
<script src="<c:url value="/js/bootstrap.js" />"></script>
<meta name="generator" content="Bootply" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
  </head>

<body>
  
  <div class="container-fluid">
	<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4" style="text-aling:center;">
		
		 <form action="SignUp" class="form-signin" method="post" >
        <h3 class="form-signin-heading">Müşteri Sistemine Kayıt</h3>
        <label for="inputad" class="sr-only">Ad</label>
        <input type="text" name="kullaniciad" class="form-control" placeholder="Müşteri Ad" required autofocus>
        <br>
         <label for="inputsoyad" class="sr-only">Soyad</label>
        <input type="text" name="kullanicisoyad" class="form-control" placeholder="Müşteri Soyad" required>
        <br>
        <label for="inputtcno" class="sr-only">Tc No</label>
        <input type="text" name="tcno" class="form-control" placeholder="Tc Kimlik No" required>
        <br>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" name="eposta" class="form-control" placeholder="Email Adres" required >
        <br>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="parola" class="form-control" placeholder="Parola" required>
        <br>
         <label for="inputcepno" class="sr-only">Cep No</label>
        <input type="tel" name="cepno" class="form-control" placeholder="Cep No" required>
        <br>
         <label for="inputadres" class="sr-only">Tc No</label>
        <input type="text" name="adres" class="form-control" placeholder="Adres" required>
        <br>
        
        <button class="btn btn-lg btn-success btn-block" type="submit">Kayıt Ol</button>
      </form>
		</div>
		<div class="col-md-4">
		</div>
	</div>
		<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4">
			<c:if test="${not empty state}">
				<div class="alert alert-danger alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<strong>${state}</strong>
				</div>
			</c:if>
		</div>
		<div class="col-md-4">
		</div>
	</div>
	
</div>
  </body>
</body>
</html>