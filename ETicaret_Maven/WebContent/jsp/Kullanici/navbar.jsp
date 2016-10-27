<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hafsa.model.Kategori"%>
<%@page import="com.hafsa.model.Urun"%>
<%@page import="com.hafsa.dao.KategoriDao"%>
<%@page import="com.hafsa.dao.UrunDao"%>

<%
	ArrayList<Kategori> kategoriler = KategoriDao.tumkategoriler();
	ArrayList<Urun> urunler = UrunDao.tumurunler();
	request.setAttribute("kategoriler", kategoriler);
	request.setAttribute("urunler", urunler);
%>

<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="index">Anasayfa</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="#">Hakkımızda</a></li>
				<li><a href="#">İletişim</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <span
						class="glyphicon glyphicon-search"></span> Ara<b class="caret"></b></a>
					<ul class="dropdown-menu" style="min-width: 300px;">
						<li>
							<div class="row">
								<div class="col-md-12">
									<form class="navbar-form navbar-left" role="search" method="post" action="UrunAra">
										<div class="input-group">
											<input type="text" name="urunad" class="form-control" required="required" />
											<span class="input-group-btn">
												<button class="btn btn-primary" type="submit">Ara</button>
											</span>
										</div>
									</form>
								</div>
							</div>
						</li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${empty kullanici}">
					<li><a href="#" data-toggle="modal" data-target="#UyeOlModal">Üye Ol<i aria-hidden="true"></i></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><span class="glyphicon glyphicon-user"></span>
							Giriş Yap <b class="caret"></b></a>
						<ul class="dropdown-menu" style="padding: 15px; min-width: 250px;">
							<li>
								<div class="row">
									<div class="col-md-12">
										<form class="form" role="form" method="post"
											action="Login" accept-charset="UTF-8" id="login-nav">
											<div class="form-group">
												<label class="sr-only" for="eposta">E-Posta
													Adresiniz</label> <input autofocus
													name="eposta" type="email" class="form-control"
													id="eposta" placeholder="E-Posta Adresiniz"
													required>
											</div>
											<div class="form-group">
												<label class="sr-only" for="parola">Parola</label> <input
													name="parola" type="password" class="form-control"
													id="inputPassword" placeholder="Parola" required>
											</div>
											<div class="form-group">
												<button type="submit" class="btn btn-success btn-block">Giriş
													Yap</button>
											</div>
										</form>
									</div>
								</div>
							</li>
						</ul></li>
				</c:if>
				<c:if test="${not empty kullanici}">
				<li><a href="sepet"><i class="glyphicon glyphicon-shopping-cart "></i>Sepetim</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i></a>
						<ul class="dropdown-menu dropdown-user">
							<li><a href="#" data-toggle="modal" data-target="#EditMusteriModal"><i class="fa fa-gear fa-fw"></i>Parola Değiştir</a></li>
							<li class="divider"></li>
							<li><a href="sepet"><i class="glyphicon glyphicon-shopping-cart "></i>Sepetim</a></li>
							<li><a href="Logout"><i class="fa fa-sign-out fa-fw"></i>Güvenli Çıkış</a></li>
						</ul></li>
				</c:if>
			</ul>
		</div>
	</div>
</nav>
<div class="modal fade" id="UyeOlModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Yeni Üye Kaydı</h4>
			</div>

			<div class="modal-body">
				<form action="SignUp" id="kayit" method="post"
					class="form-horizontal">
					<div class="form-group">
						<label class="col-lg-3 control-label">Adınız</label>
						<div class="col-lg-5">
							<input type="text" class="form-control" name="kullaniciad" id="ad"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">Soyadınız</label>
						<div class="col-lg-5">
							<input type="text" class="form-control" name="kullanicisoyad"
								id="soyad" required="required" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">TC Kimlik No</label>
						<div class="col-lg-5">
							<input type="text" pattern="^[0-9]{11}" class="form-control" name="tcno" id="tcNo"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">E-Posta Adresi</label>
						<div class="col-lg-5">
							<input type="email" class="form-control" name="eposta" id="ePosta"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">Parola</label>
						<div class="col-lg-5">
							<input type="password" class="form-control" name="parola"
								id="parola" required="required" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="col-lg-3 control-label">Cep No</label>
						<div class="col-lg-5">
							<input type="text" class="form-control" name="cepno" id="cepNo"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label">Adres</label>
						<div class="col-lg-5">
							<input type="text" class="form-control" name="adres" id="adres"
								required="required" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-5 col-lg-offset-3">
							<input type="submit" class="form-control btn btn-success"
								name="uyeOl" value="Üye Ol">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="EditMusteriModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Hesap Parolasını Değiştir</h4>
			</div>

			<div class="modal-body">
				<form action="parolaguncelle" id="parolaguncelle" method="post"
					class="form-horizontal">
					<div class="form-group">
						<label class="col-lg-4 control-label">Hesap</label>
						<div class="col-lg-5">
							<input type="text" class="form-control" disabled value=""/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-4 control-label">Yeni Parola</label>
						<div class="col-lg-5">
							<input type="password" class="form-control" name="parola" id="parola" required/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-4 control-label">Yeni Parola Tekrar</label>
						<div class="col-lg-5">
							<input type="password" class="form-control" name="parolatekrar" id="parolatekrar" required/>
						</div>
					</div>
					<div class="form-group">
						<div class="col-lg-5 col-lg-offset-3">
							<input type="submit" class="form-control btn btn-success"
								name="degistir" value="Hesap Bilgilerini Güncelle">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>


<div class="modal fade" id="UrunDetayModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title">Ürün Detayı</h4>
			</div>

			<div class="modal-body">
			<div class="container">
</div>
			
			</div>
		</div>
	</div>
</div>
