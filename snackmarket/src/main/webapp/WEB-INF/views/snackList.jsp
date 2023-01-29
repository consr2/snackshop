<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<div>
		<div>판매 과자 목록</div>
		<table border="1">
			<tr>
				<td>상품명</td>
				<td>가격</td>
				<td>재고수</td>
				<c:if test="${login != null }">
					<td>버튼</td>
				</c:if>
			</tr>
			<c:forEach var="snack" items="${ snackList }">
				<tr>
					<td>${ snack.name }</td>
					<td>${ snack.price }</td>
					<td>${ snack.quantity }</td>
					<c:if test="${login != null }">
						<td>
							<button>
								<a href="/basket/add/${snack.idx}">담기</a>
							</button>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<a href="/">홈으로</a>
	</div>
</body>
</html>