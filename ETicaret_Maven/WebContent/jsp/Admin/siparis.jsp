<%@page import="java.util.ArrayList"%>
<%@page import="com.hafsa.model.SiparisDurum"%>
<%@page import="com.hafsa.model.Kullanici"%>
<%@page import="com.hafsa.model.Urun"%>
<%@page import="com.hafsa.model.Odeme"%>
<%@page import="com.hafsa.model.Kargo"%>
<%@page import="com.hafsa.model.Siparis"%>
<%@page import="com.hafsa.dao.SiparisDurumDao"%>
<%@page import="com.hafsa.dao.KullaniciDao"%>
<%@page import="com.hafsa.dao.UrunDao"%>
<%@page import="com.hafsa.dao.OdemeDao"%>
<%@page import="com.hafsa.dao.KargoDao"%>
<%@page import="com.hafsa.dao.SiparisDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setAttribute("siparisDurum", SiparisDurumDao.tumsiparisdurum());
	request.setAttribute("kargo", KargoDao.tumkargolar());
	request.setAttribute("siparis", SiparisDao.tumSiparisleriListele());

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
				<div class="row">
					<c:if test="${not empty stateSilme }">
						<div class="alert alert-warning alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<strong>${stateSilme}</strong>
						</div>
					</c:if>
					<c:if test="${not empty stateGuncelleme}">
						<div class="alert alert-warning alert-dismissible" role="alert">
							<button type="button" class="close" data-dismiss="alert"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<strong>${stateGuncelleme}</strong>
						</div>
					</c:if>
				</div>
			</div>
			<div class="col-lg-12">
				<div class="page-header" style="margin-top: -8px">
					<h1 style="color: #000000;">Tüm Siparişler</h1>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<table class="footable table table-bordered toggle-circle"
							id="derslikler">
							<thead>
								<tr>
									<th>Durum</th>
									<th>Adı- Soyadı</th>
									<th>UrunAdi</th>
									<th>Adet</th>
									<th>Fiyat</th>
									<th>OdemeTipi</th>
									<th>Kargo Şirketi</th>
									<th>Veriliş Tarihi</th>
									<th>Tahmini teslim Tarihi</th>
									<th>Teslim Edilecek Adres</th>
									<td data-sort-ignore="true"></td>
									<td data-sort-ignore="true"></td>
								</tr>
							</thead>
							<tbody>
							 <c:forEach items="${siparis}" var="siparis">
									<tr>
										<td>${siparis.getSiparisdurumid().getDurum()}</td>
										<td>${siparis.getKullaniciid().getKullaniciad()} - ${siparis.getKullaniciid().getKullanicisoyad()}</td>
										<td>${siparis.getUrunid().getUrunad()}</td>
										<td>${siparis.getAdet()}</td>
										<td>${siparis.getFiyat()}</td>
										<td>${siparis.getOdemeid().getOdemetip()}</td>
										<td>${siparis.getKargoid().getKargoad()}</td>
										<td>${siparis.getVerilistarih()}</td>
										<td>${siparis.getTeslimtarih()}</td>
										<td>${siparis.getAdres()}</td>
										<td><a href="#" data-toggle="modal"
											data-target="#EditSiparisModal" class="btn btn-primary"
											data-siparis-no="${siparis.getSiparisid()}"
											data-siparis-teslimtarihi="${siparis.getTeslimtarih()}">İşlem Yap
											<i class="glyphicon glyphicon-refresh" aria-hidden="true"></i>
										</a></td>
										<td><a
											data-href="SilSiparis?siparisid=${siparis.getSiparisid()}"
											data-toggle="modal" data-target="#deleteSiparisModal"
											class="btn btn-danger">İptal Et<i
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
		<div class="modal fade" id="EditSiparisModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Sipariş Bilgileri Güncelle</h4>
					</div>

					<div class="modal-body">
						<form action="GuncelleSiparis" id="siparisguncelle" method="post"
							class="form-horizontal">
							<div class="form-group">
								<div class="col-lg-5">
									<input type="hidden" class="form-control" name="siparisid"
										id="siparisID" value="${kullanici.kullaniciid}"/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-3 control-label">Sipariş Durumu Seç</label>
								<div class="col-lg-5">
									<select title="Sipariş Durumu Seçiniz" class="form-control"
										data-live-search="true" name="siparisDurum" id="siparisDurum">
										<option value="">Sipariş Durumu Seçiniz</option>
										<c:forEach items="${siparisDurum}" var="siparisDurum">
											<option value="${siparisDurum.getSiparisdurumid()}">${siparisDurum.getDurum()}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-3 control-label">Kargo Şirketi Seçiniz</label>
								<div class="col-lg-5">
									<select title="Kargo şirketi Seçiniz" class="form-control"
										data-live-search="true" name="kargo" id="kargo">
										<option value="">Kargo şirketi Seçiniz</option>
										<c:forEach items="${kargo}" var="kargo">
											<option value="${kargo.getKargoid()}">${kargo.getKargoad()}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-3 control-label">Tahmini Teslim Tarihi</label>
								<div class="col-lg-5">
									<input type="text" class="form-control" name="teslimtarih" id="siparisTeslimTarihi"
										required="required" />
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
		<div class="modal fade" id="deleteSiparisModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Uyarı !</h4>
					</div>

					<div class="modal-body">
						<p class="bg-danger">
							<b>Silme işlemini onaylıyor musunuz?</b>
						</p>
						<a href="#" class="btn btn-danger btn-lg" id="btnDeleteSiparis">Onayla</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>