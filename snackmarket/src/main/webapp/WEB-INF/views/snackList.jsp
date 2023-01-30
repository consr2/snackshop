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
				<td>재고</td>
				<c:if test="${login != null }">
					<td>선택수량</td>
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
							<a id="down"> < </a>
							<a id="quantity">1</a>
							<a id="up"> > </a>
						</td>
						<td>
							<button id="basket">
								<a id=url href="/basket/add/${ snack.idx }">담기</a>
							</button>
						</td>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<a href="/">홈으로</a>
	</div>
</body>
<script type="text/javascript">
	let quantity = document.querySelectorAll("#quantity")
	let up = document.querySelectorAll("#up")
	let down = document.querySelectorAll("#down")
	let baskets = document.querySelectorAll("#basket")
	let url = document.querySelectorAll("#url")
	
	//수량 조절
	up.forEach((u,index) =>{
		u.addEventListener('click', function(){
			var currentNum = parseInt(quantity[index].innerHTML)
			quantity[index].innerHTML = currentNum + 1
		})
	})
	
	down.forEach((d,index) =>{
		d.addEventListener('click', function(){
			var currentNum = parseInt(quantity[index].innerHTML)
			if(currentNum > 1){
				quantity[index].innerHTML = currentNum - 1
			}
		})
	})
	
	
	//구매하기
	baskets.forEach((basket, index)=>{
		basket.addEventListener('click', function(){
			url[index].href += '?quantity=' + quantity[index].innerHTML
		})
	})
	
</script>

</html>