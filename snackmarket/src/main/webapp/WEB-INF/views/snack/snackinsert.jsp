<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/snack/add" method="post">
		<div>
			<label>상품명</label>
			<input name="name">
		</div>
		<div>
			<label>가격</label>
			<input name="price">
		</div>
		<div>
			<label>수량</label>
			<input name="quantity">
		</div>
		<button type="submit">등록</button>
	</form>
	
</body>
</html>