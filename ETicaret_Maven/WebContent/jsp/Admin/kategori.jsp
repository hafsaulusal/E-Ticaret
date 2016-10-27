<%@page import="java.util.ArrayList"%>
<%@ page import="com.hafsa.model.Kategori"%>
<%@ page import="com.hafsa.dao.KategoriDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	ArrayList<Kategori> kategori = KategoriDao.tumkategoriler();
	request.setAttribute("kategori", kategori);
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="Header.jsp"%>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div id="page-wrapper" class="container">
		<div class="row">
			<div class="col-lg-12">
				<div class="page-header" style="margin-top: -8px">
					<h1 style="color: #000000;">Yeni Katagori Ekleme</h1>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<strong>Katagori Ekle</strong>
								</h3>
							</div>
							<div class="panel-body">
								<form action="eklekategori" id="katagoriekle" method="post" class="form-horizontal">
									<div class="form-group">
										<label class="col-lg-3 control-label">Katagori Adı</label>
										<div class="col-lg-5">
											<input type="text" class="form-control" name="kategoriad" /><br />
											<input type="submit" class="form-control btn btn-success" name="ekle" value="EKLE">
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="row">
					<c:if test="${not empty stateEkleme}">
						<div class="alert alert-warning alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<strong>${stateEkleme}</strong>
						</div>
					</c:if>
					<c:if test="${not empty stateSil}">
						<div class="alert alert-warning alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<strong>${stateSil}</strong>
						</div>
					</c:if>
					<c:if test="${not empty stateGuncelle}">
						<div class="alert alert-warning alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<strong>${stateGuncelle}</strong>
						</div>
					</c:if>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="page-header" style="margin-top: -8px">
					<h1 style="color: #000000;">Kategoriler</h1>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<table class="footable table table-bordered toggle-circle" id="derslikler">
							<thead>
								<tr>
									<th>Katagori ID</th>
									<th>Katagori Adı</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${kategori}" var="kategori">
									<tr>
										<td>${kategori.getKategoriid()}</td>
										<td>${kategori.getKategoriad()}</td>
										<td><a href="#" data-toggle="modal" data-target="#EditKatagoriModal" class="btn btn-primary" data-katagori-no="${kategori.getKategoriid()}" data-katagori-ad="${kategori.getKategoriad()}"> Değiştir <i class="glyphicon glyphicon-refresh" aria-hidden="true"></i>
										</a></td>
										<td><a data-href="silkategori?kategoriid=${kategori.kategoriid}" data-toggle="modal" data-target="#deleteKatagoriModal" class="btn btn-danger">Sil<i class="glyphicon glyphicon-trash"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>

							<tfoot>
								<tr>
									<td colspan="10">
										<div class="pagination pagination-centered hide-if-no-paging"></div>
									</td>
								</tr>
							</tfoot>
						</table>

					</div>
				</div>
			</div>

		</div>
		<div class="modal fade" id="EditKatagoriModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">Katagori Adı Güncelle</h4>
					</div>

					<div class="modal-body">
						<form action="guncellekategori" id="katagoriguncelle" method="post" class="form-horizontal">
							<div class="form-group">
								<div class="col-lg-5">
									<input type="hidden" class="form-control" name="kategoriid" id="katagoriID" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-3 control-label">Yeni Katagori Adı</label>
								<div class="col-lg-5">
									<input type="text" class="form-control" name="kategoriad" id="katagoriAd" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-5 col-lg-offset-3">
									<input type="submit" class="form-control btn btn-success" name="degistir" value="DEĞİŞTİR">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="deleteKatagoriModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
						<h4 class="modal-title">Uyarı !</h4>
					</div>

					<div class="modal-body">
						<p class="bg-danger"><b>Silme işlemini onaylıyor musunuz?</b></p>
						<a href="#" class="btn btn-danger btn-lg" id="btnDeleteKatagori">Onayla</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>