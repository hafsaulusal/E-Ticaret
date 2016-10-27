<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="wrapper">
	<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"></button>
			<a class="navbar-brand" href="index">Admin Paneli</a>
		</div>
		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i></a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="#" data-toggle="modal" data-target="#EditAdminModal"><i class="fa fa-gear fa-fw"></i>Parola Değiştir</a></li>
					<li class="divider"></li>
					<li><a href="AdminLogin"><i class="fa fa-sign-out fa-fw"></i>Güvenli Çıkış</a></li>
				</ul>
			</li>
		</ul>
		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li class="sidebar"></li>
					<li><a href="admin"><i class="fa fa-dashboard fa-fw"></i>Başlangıç</a></li>
					<li><a href="kategori"><i class="fa fa-list fa-fw"></i>Katagori İşlemleri</a></li>
					<li><a href="kargo"><i class="fa fa-truck fa-fw"></i>Kargo Servisi İşlemleri</a></li>
					<li><a href="musteri"><i class="fa fa-users  fa-fw"></i>Müşteri Bilgileri</a></li>
					<li><a href="odemesecenek"><i class="fa fa-credit-card fa-fw"></i>Ödeme Seçenekleri</a></li>
					<li><a href="siparis"><i class="glyphicon glyphicon-indent-left"></i>Siparişler</a></li>
					<li><a href="siparisdurum"><i class="glyphicon glyphicon-briefcase"></i>Sipariş Durum Ayarları</a></li>
					<li><a href="urun"><i class="fa fa-th fa-fw"></i>Ürünlerim</a></li>
					<li><a href="yetki"><i class="fa fa-cogs fa-fw"></i>Yetki Ayarları</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
