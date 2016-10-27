<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
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
						<a href="Kategoriurun?katagorino=${kategoriler.getKategoriid()}" class="list-group-item">${kategoriler.getKategoriad()}</a>
					</c:forEach>
				</div>
			</div>
			<div class="col-md-9">
				<c:if test="${not empty seciliUrun}">
					<div class="col-sm-4">
						<div class="thumbnail">
							<img class="img-thumbnail" style="width: 150px; height: 150px;" src="<c:url value="/Resimgetir?resim=${seciliUrun.urunid} "/>" alt="Resim Bulunamadı" />
						</div>
					</div>
					<div class="col-sm-6">
						<div class="thumbnail">
							<div class="caption">
								<h4><a href="#">Ürünün Adı: ${seciliUrun.getUrunad()}</a></h4>
								<p>Ürün Hakkında: ${seciliUrun.getAciklama()}</p>
								<h4 class="pull-right">Ürün fiyatı: ${seciliUrun.getFiyat()}TL</h4><br/>
								<c:if test="${not empty kullanici}">
									<p style="color: blue;">
										<a href="sepeteekle?urunid=${seciliUrun.urunid}">Sepete Ekle<i class="fa fa-plus-square "></i> </a>
									</p>
								</c:if>
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>