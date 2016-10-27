<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="navbar.jsp"%>
<div class="container">
		<div class="row">
			<div class="col-md-3">
				<p class="lead">Kategoriler</p>
				<div class="list-group">
					<c:forEach items="${kategoriler}" var="kategoriler">
						<a href="Kategoriurun?kategorino=${kategoriler.getKategoriid()}" class="list-group-item">${kategoriler.getKategoriad()}</a>
					</c:forEach>
				</div>
			</div>
			<div class="col-md-9">
					<c:choose>
					<c:when test="${not empty Kategoriurun}">
						<c:forEach items="${Kategoriurun}" var="Kategoriurun">
							<div class="col-sm-4 col-lg-4 col-md-4">
								<div class="thumbnail">
									<img class="img-thumbnail" style="width: 260px; height: 255px;" src="<c:url value="/Resimgetir?resim=${Kategoriurun.urunid} "/>" alt="Resim Bulunamadı" />
									<div class="caption">
										<h4 class="pull-right">${Kategoriurun.getFiyat()}TL</h4>
										<h4><a href="Urundetay?urunid=${Kategoriurun.urunid}">${Kategoriurun.getUrunad()}</a></h4>
										<p>${Kategoriurun.getAciklama()}</p>
										<c:if test="${not empty kullanici}">
											<p style="color: blue;">
												<a href="sepeteekle?urunid=${Kategoriurun.urunid}">Sepete Ekle<i class="fa fa-plus-square "></i> </a>
											</p>
										</c:if>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<c:forEach items="${urunler}" var="urunler">
							<div class="col-sm-4 col-lg-4 col-md-4">
								<div class="thumbnail">
									<img class="img-thumbnail" style="width: 260px; height:255px;" src="<c:url value="/Resimgetir?resim=${urunler.urunid} "/>" alt="Resim Bulunamadı" />
									<div class="caption">
										<h4 class="pull-right">${urunler.getFiyat()} TL</h4>
										<h4><a href="Urundetay?urunid=${urunler.urunid}"  data-src="<c:url value="/Resimgetir?resim=${urunler.urunid} "/>" data-aciklama="${urunler.getAciklama()}" data-urunadi="${urunler.getUrunad()}" data-urunfiyat="${urunler.getFiyat()}" data-target="#UrunDetayModal">${urunler.getUrunad()}</a></h4>
										<p>${urunler.getAciklama()}</p>
										<c:if test="${not empty kullanici}">
											<p style="color: blue;">
												<a href="sepeteekle?urunid=${urunler.urunid}">Sepete Ekle<i class="fa fa-plus-square "></i></a>
											</p>
										</c:if>
									</div>
								</div>
							</div>
						</c:forEach>
						</c:otherwise>
				</c:choose>
			</div>
			</div>
</div>
</body>
</html>