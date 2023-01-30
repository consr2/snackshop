<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
	<div>
		<h1> 스낵마켓 </h1>
		<c:if test="${login == null }">
			<a href="/login">로그인</a>
			<a href="/user">회원가입</a>
		</c:if>
		<c:if test="${login != null }">
			<c:out value="${ login }님 안녕하세요"/>
			<a href="/logout">로그아웃</a>
			<a href="/basket">장바구니</a>
			
		</c:if>
		
		
	</div>
	<a href="/snack/add">상품 추가하기</a>
	<a href="/snack/list">상품 목록보기</a>
</body>

<script>

</script>
</html>
