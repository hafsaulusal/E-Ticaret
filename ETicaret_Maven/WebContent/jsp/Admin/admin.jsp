<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.hafsa.model.Admin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hafsa.dao.AdminDao"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="Header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div id="page-wrapper" class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="list-group">
					<h1 class="page-header">Başlangıç</h1>
				</div>
			</div>
			<div class="col-md-12">
				<c:if test="${AdminDao.siparisBeklemeVarMi()}">
					<div class="alert alert-warning alert-dismissible" role="alert">
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<strong>İşlem yapılması beklenen siparişleriniz var..</strong>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</body>
</html>