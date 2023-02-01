<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>장바구니</h1>
	<table border="1">
		<tr>
			<td>상품명</td>
			<td>가격</td>
			<td>수량</td>
			<td>구매자</td>
			<td>합계</td>
			<td>삭제</td>
		</tr>
		<c:forEach var="snack" items="${ basketList }">
			<tr>
				<td>${ snack.name }</td>
				<td><fmt:formatNumber value="${ snack.price }" pattern="#,###"/></td>
				<td>${ snack.quantity }</td>
				<td>${ snack.username }</td>
				<td id="sum">${ snack.price * snack.quantity }</td>
				<td>
					<button onclick="location.href='/basket/delete/${snack.idx}'">삭제</button>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<div id="total"></div>
	</div>
	<a href="/">홈으로</a>
</body>
<script type="text/javascript">
	let sum 	= document.querySelectorAll("#sum")
	let total	= document.querySelector("#total")
	let cal = 0
	
	sum.forEach(function(e){
		cal = cal + parseInt(e.innerHTML)
	})
	
	total.innerHTML = '총합 : ' + cal.toLocaleString('ko-KR') + '원'
	

</script>
</html>