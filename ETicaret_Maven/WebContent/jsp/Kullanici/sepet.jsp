<%@page import="com.hafsa.model.Urun"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hafsa.model.Odeme"%>
<%@page import="com.hafsa.model.Kargo"%>
<%@page import="com.hafsa.dao.OdemeDao"%>
<%@page import="com.hafsa.dao.KargoDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setAttribute("odemeSecenek", OdemeDao.tumodemeler());
	request.setAttribute("kargo", KargoDao.tumkargolar());
%>
<!DOCTYPE html>
<html>
	<%@ include file="header.jsp"%>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Ürün Resmi</th>
							<th>Ürün Adı</th>
							<th>Açıklaması</th>
							<th>Ürün Fiyatı</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
				<%if(session.getAttribute("sepet")!=null){%>
						<%ArrayList<Urun> urun=(ArrayList<Urun>)session.getAttribute("sepet");%>
						<%int i=0;%>
						<%int toplam=0;%>
						<%for(Urun urun2:urun) { %>
						<%toplam+=urun2.getFiyat();%>						
						<tr>
							<td class="cart_product">
								<a href=""><img style="width: 120px; height:120px;"  src="Resimgetir?resim=<%=urun2.getUrunid()%>" alt="" /></a>
							</td>
							<td class="cart_description">
								<h4><a href=""><%=urun2.getUrunad()%></a></h4>
								
							</td>
							<td class="cart_description">
							<p><%=urun2.getAciklama()%></p>
							</td>
							<td class="cart_price">
								<p><%=urun2.getFiyat()%> TL</p>
							</td>														
							<td class="cart_delete">
							<a href="SiparisSil?urunid=<%=i%>"
									type="submit" class="btn btn-danger"> <span
										class="glyphicon glyphicon-remove"></span>Ürünü Sil
								</a>
						
							</td>
						</tr>
							<%i++;
							}
						}%>		
						<td><a href="index" class="btn btn-default"><i
									class="glyphicon glyphicon-shopping-cart"></i>Alış verişe devam et</a></td>
							<td><a href="#" data-toggle="modal"
								data-target="#SiparisVer" class="btn btn-success">Siparişi
									Tamamla <i class="glyphicon glyphicon-play" aria-hidden="true"></i>
							</a></td>				
					</tbody>					
				</table>
				<c:if test="${not empty siparisSonuc}">
					<div class="alert alert-warning alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>${siparisSonuc}</strong>
					</div>
				</c:if>
			</div>
		</div>
	</div>
		<div class="modal fade" id="SiparisVer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Sipariş İşlemini Tamamla</h4>
				</div>

				<div class="modal-body">
					<form action="SiparisVer" id="siparisver" method="post"
						class="form-horizontal">
						<div class="form-group">
							<label class="col-lg-5 control-label">Ödeme Seçenek Tipini Seçiniz</label>
							<div class="col-lg-6">
								<select title="Ödeme Seçenek Tipini Seçiniz" class="form-control" data-live-search="true" name="odemeSecenek" id="odemeSecenek">
									<option value="">Ödeme Seçenek Tipini Seçiniz</option>
									<c:forEach items="${odemeSecenek}" var="odemeSecenek">
										<option value="${odemeSecenek.getOdemeid()}">${odemeSecenek.getOdemetip()}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-5 control-label">Kargo Şirketi Seçiniz</label>
							<div class="col-lg-6">
								<select title="Kargo şirketi Seçiniz" class="form-control" data-live-search="true" name="kargo" id="kargo">
									<option value="">Kargo şirketi Seçiniz</option>
									<c:forEach items="${kargo}" var="kargo">
										<option value="${kargo.getKargoid()}">${kargo.getKargoad()}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-lg-5 control-label">Teslim Edilecek Adresi Giriniz</label>
							<div class="col-lg-5">
								<input type="text" class="form-control" name="adres" id="teslimAdres" required="required" />
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-5 col-lg-offset-3">
								<input type="submit" class="form-control btn btn-success" name="degistir" value="Ödeme İşlemini tamamla">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>