<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/main/main.css">
<title>Hibernate Demo</title>
</head>
<body>
	<h1>這是一位後端人員作的網頁 QQ</h1>
	<h2>員工系統</h2>
	<a href="${pageContext.request.contextPath}/emp/emp.do?action=getAll">查詢所有員工</a>
	<br><br>
	<h3><b>複合查詢 (使用 Criteria Query)：</b></h3>
	<form action="${pageContext.request.contextPath}/emp/emp.do" method="post">
		<p><label>會員模糊查詢：</label></p>
		<input type="text" name="customerId"><br>
		<p><label>店家模糊查詢：</label></p>
		<input type="text" name="storeId"><br>
		
		<p><label>店家查詢：</label></p>
		<select size="1" name="storeId">
			<c:forEach var="likeStoreVO" items="${likeStoreSvc.all}">
				<option value="${likeStoreVO.storeId }">${likeStoreVO.storesVO.storeName }
			</c:forEach>
		</select>
		
		<p><label>收藏/黑名單：</label></p>
		<select size="1" name="likeUnlike">
			<c:forEach var="likeStoreVO" items="${likeStoreSvc.all}">
				<option value="${likeStoreVO.likeUnlike}">${likeStoreVO.likeUnlike }
			</c:forEach>
		</select>
		

		
		<p><input type="submit" value="送出"></p>
		<input type="hidden" name="action" value="compositeQuery">
	</form>
</body>
</html>