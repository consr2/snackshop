<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="/login" method="post">
			<div>
				<label>아이디</label>
				<input name="username">
			</div>
			<div>
				<label>비밀번호</label>
				<input name="password">
			</div>
			<button type="submit">로그인</button>
		</form>
	</div>
</body>
</html>