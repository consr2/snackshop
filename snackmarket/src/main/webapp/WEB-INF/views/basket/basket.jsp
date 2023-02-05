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
				<td id="username">${ snack.username }</td>
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
	<div>
		<button id="tossPay">결재하기</button>
	</div>
	<a href="/">홈으로</a>
</body>
<script src="https://js.tosspayments.com/v1/payment"></script>
<script type="text/javascript">
	let sum 	= document.querySelectorAll("#sum")
	let total	= document.querySelector("#total")
	let username	= document.querySelector("#total").value
	let cal = 0
	
	sum.forEach(function(e){
		cal = cal + parseInt(e.innerHTML)
	})
	
	total.innerHTML = '총합 : ' + cal.toLocaleString('ko-KR') + '원'
	
	let tossPay = document.querySelector("#tossPay")
	var clientKey = 'test_ck_JQbgMGZzorzexGaGjW7Vl5E1em4d'
    var tossPayments = TossPayments(clientKey) // 클라이언트 키로 초기화하기
 	var today = new Date();
	var month 	= today.getMonth() 
	var date 	= today.getDate() 
	var hour	= today.getHours() 
	var minute	= today.getMinutes()
	var second	= today.getSeconds()
	var millisecond	= today.getMilliseconds()
	var orderTime = month + '-' +  date + hour + minute + second + millisecond
	
    tossPay.addEventListener('click', function(){
    	tossPayments.requestPayment('카드', {
    	  amount: cal,
    	  orderId: orderTime,
    	  orderName: '과자 구매',
    	  customerName: username,
    	  successUrl: 'http://localhost:8080/tosspay/success',
    	  failUrl: 'http://localhost:8080/tosspay/fail',
    	})
    	.catch(function (error) {
    	  if (error.code === 'USER_CANCEL') {
    	    console.log("에러1")
    	  } else if (error.code === 'INVALID_CARD_COMPANY') {
    	    // 유효하지 않은 카드 코드에 대한 에러 처리
    	    console.log("에러2")
    	  }
    	})
    	
    })
    		
    
    
    

</script>
</html>