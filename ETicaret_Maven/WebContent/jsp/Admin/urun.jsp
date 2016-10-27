<%@page import="com.hafsa.model.Urun"%>
<%@page import="com.hafsa.dao.UrunDao"%>
<%@page import="com.hafsa.dao.KategoriDao"%>
<%@page import="com.hafsa.model.Kategori"%>

<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	ArrayList<Urun> urunler = UrunDao.tumurunler();
	ArrayList<Kategori> kategoriler = KategoriDao.tumkategoriler();
	request.setAttribute("urunler", urunler);
	request.setAttribute("kategoriler", kategoriler);
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
					<h1 style="color: #000000;">Yeni Ürün Ekleme</h1>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									<strong>Ürün Ekle</strong>
								</h3>
							</div>
							<div class="panel-body">
								<form action="EkleUrun" id="urunekle" method="post"
									class="form-horizontal" enctype="multipart/form-data">
									<div class="form-group">
										<label class="col-lg-3 control-label">Ürünün
											Katagorisi</label>
										<div class="col-lg-5">
											<select title="Kategori Seçiniz" class="form-control"
												data-live-search="true" name="kategori" id="kategori">
												<option value="">Katagori Seçiniz</option>
												<c:forEach items="${kategoriler}" var="kategoriler">
													<option value="${kategoriler.kategoriid}">${kategoriler.kategoriad}</option>
												</c:forEach>
											</select>
										</div>
									</div>
									
									<div class="form-group">
										<label class="col-lg-3 control-label">Ürün Adı</label>
										<div class="col-lg-5">
											<input type="text" class="form-control" name="urunad"
												required="required" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-3 control-label">Ürün Açıklaması</label>
										<div class="col-lg-5">
											<input type="text" class="form-control" name="aciklama"
												required="required" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-3 control-label">Ürün Fiyatı</label>
										<div class="col-lg-5">
											<input type="text" class="form-control" name="fiyat"
												required="required" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-3 control-label">Ürün Stok
											Miktarı</label>
										<div class="col-lg-5">
											<input type="text" class="form-control" name="stok"
												required="required" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-3 control-label">Ürün Resmi</label>
										<div class="col-lg-5">
											<input type="file" name="marka_img" class="form-control"
												required="required"><br /> <input type="submit"
												class="form-control btn btn-success" name="ekle"
												value="EKLE">
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
					<h1 style="color: #000000;">Ürünler</h1>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<table class="footable table table-bordered toggle-circle"
							id="derslikler">
							<thead>
								<tr>
									
									<th>Adı</th>
									<th>Açıklaması</th>
									<th>Birim Fiyatı</th>
									<th>Stok Miktarı</th>
									<th>Resim</th>
									<td data-sort-ignore="true"></td>
									<td data-sort-ignore="true"></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${urunler}" var="urunler">
									<tr>
									
										<td>${urunler.getUrunad()}</td>
										<td>${urunler.getAciklama()}</td>
										<td>${urunler.getFiyat()}</td>
										<td>${urunler.getStok()}</td>
										<td><img class="img-thumbnail"
											style="width: 120px; height: 150px; float: right; margin-right: 10px;"
											src="AdminResimGetir?resim=${urunler.urunid}"
											alt="Resim Bulunamadı" /></td>
										<td><a href="#" data-toggle="modal"
											data-target="#EditUrunModal" class="btn btn-primary"
											data-urun-no="${urunler.getUrunid()}"
											data-urun-ad="${urunler.getUrunad()}"
											data-urun-aciklama="${urunler.getAciklama()}"
											data-urun-fiyat="${urunler.getFiyat()}"
											data-urun-stok="${urunler.getStok()}">Değiştir <i
												class="glyphicon glyphicon-refresh" aria-hidden="true"></i>
										</a></td>
										<td><a
											data-href="SilUrun?urunid=${urunler.getUrunid()}"
											data-toggle="modal" data-target="#deleteUrunModal"
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
		<div class="modal fade" id="EditUrunModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Ürün Bilgileri Güncelle</h4>
					</div>

					<div class="modal-body">
						<form action="GuncelleUrun" id="urunguncelle" method="post" class="form-horizontal" enctype="multipart/form-data">
							<div class="form-group">
								<div class="col-lg-5">
									<input type="hidden" class="form-control" name="urunid"
										id="urunID" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-3 control-label">Ürünün Katagorisi</label>
								<div class="col-lg-5">
									<select title="Katagori Seçiniz" class="form-control"
										data-live-search="true" name="kategori" id="kategori">
										<option value="">Katagori Seçiniz</option>
										<c:forEach items="${kategoriler}" var="kategoriler">
											<option value="${kategoriler.kategoriid}">${kategoriler.kategoriad}</option>
										</c:forEach>
									</select>
								</div>
							</div>
			
							<div class="form-group">
								<label class="col-lg-3 control-label">Ürün Adı</label>
								<div class="col-lg-5">
									<input type="text" class="form-control" name="urunad" id="urunad"
										required="required" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-3 control-label">Ürün Açıklaması</label>
								<div class="col-lg-5">
									<input type="text" class="form-control" name="aciklama" id="aciklama"
										required="required" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-3 control-label">Ürün Fiyatı</label>
								<div class="col-lg-5">
									<input type="text" class="form-control" name="fiyat" id="fiyat"
										required="required" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-3 control-label">Ürün Stok Miktarı</label>
								<div class="col-lg-5">
									<input type="text" class="form-control" name="stok" id="stok"
										required="required" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-3 control-label">Ürün Resmi</label>
								<div class="col-lg-5">
									<input type="file" name="marka_img" class="form-control" required="required"><br />
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
		<div class="modal fade" id="deleteUrunModal" tabindex="-1"
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
						<a href="#" class="btn btn-danger btn-lg" id="btnDeleteUrun">Onayla</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>