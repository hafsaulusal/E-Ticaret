<%@page import="java.util.ArrayList"%>
<%@ page import="com.hafsa.model.Kargo"%>
<%@ page import="com.hafsa.dao.KargoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	ArrayList<Kargo> kargo = KargoDao.tumkargolar();
	request.setAttribute("kargo", kargo);
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
					<h1 style="color: #000000;">Yeni Kargo Ekleme</h1>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<strong>Kargo Ekle</strong>
								</h3>
							</div>
							<div class="panel-body">
								<form action="EkleKargo" id="kargoekle" method="post"
									class="form-horizontal">
									<div class="form-group">
										<label class="col-lg-3 control-label">Kargo Adı</label>
										<div class="col-lg-5">
											<input type="text" class="form-control" name="kargoad" /><br />
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-3 control-label">Şirket
											Açıklaması</label>
										<div class="col-lg-5">
											<input type="text" class="form-control" name="aciklama" /><br />
											<input type="submit" class="form-control btn btn-success"
												name="ekle" value="EKLE">
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
					<h1 style="color: #000000;">Kargo Şirketleri</h1>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<table class="footable table table-bordered toggle-circle"
							id="derslikler">
							<thead>
								<tr>
									<th>Kargo ID</th>
									<th>Kargo Adı</th>
									<th>Şirket Vizyon</th>
									<td data-sort-ignore="true"></td>
									<td data-sort-ignore="true"></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${kargo}" var="kargo">
									<tr>
										<td>${kargo.getKargoid()}</td>
										<td>${kargo.getKargoad()}</td>
										<td>${kargo.getAciklama()}</td>
										<td><a href="#" data-toggle="modal"
											data-target="#EditKargoModal" class="btn btn-primary"
											data-kargo-no="${kargo.getKargoid()}"
											data-kargo-ad="${kargo.getKargoad()}"
											data-kargo-aciklama="${kargo.getAciklama()}"> Değiştir <i
												class="glyphicon glyphicon-refresh" aria-hidden="true"></i>
										</a></td>
										<td><a
											data-href="silkargo?kargoid=${kargo.getKargoid()}"
											data-toggle="modal" data-target="#deleteKargoModal"
											class="btn btn-danger">Sil<i
												class="glyphicon glyphicon-trash"></i></a></td>
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
			<div class="modal fade" id="EditKargoModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Kargo Şirketi Güncelle</h4>
					</div>

					<div class="modal-body">
						<form action="guncellekargo" id="kargoguncelle" method="post"
							class="form-horizontal">
							<div class="form-group">
								<div class="col-lg-5">
									<input type="hidden" class="form-control" name="kargoid"
										id="kargoID" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-3 control-label">Yeni Kargo Adı</label>
								<div class="col-lg-5">
									<input type="text" class="form-control" name="kargoad"
										id="kargoAd" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-3 control-label">Yeni Açıklama</label>
								<div class="col-lg-5">
									<input type="text" class="form-control" name="aciklama"
										id="kargoAciklama" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-5 col-lg-offset-3">
									<input type="submit" class="form-control btn btn-success"
										name="degistir" value="DEĞİŞTİR">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="deleteKargoModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Uyarı !</h4>
					</div>

					<div class="modal-body">
						<p class="bg-danger"><b>Silme işlemini onaylıyor musunuz?</b></p>
						<a href="#" class="btn btn-danger btn-lg" id="btnDeleteKargo">Onayla</a>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>