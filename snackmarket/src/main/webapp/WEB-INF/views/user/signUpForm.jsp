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
		<form action="/user" method="post">
			<div>
				<label>아이디</label>
				<input id="id" name="username">
			</div>
			<div>
				<label>비밀번호</label>
				<input id="pw1" name="password">
			</div>
			<div>
				<label>비밀번호 확인</label>
				<input id="pw2" name="password2">
			</div>
			<button id="btn" disabled="disabled" type="submit">회원가입</button>
		</form>
	</div>
</body>
<script type="text/javascript">
	let id = document.querySelector("#id")
	let pw1 = document.querySelector("#pw1")
	let pw2 = document.querySelector("#pw2")
	let btn = document.querySelector("#btn")
	
	let check = new Array();
	
	id.addEventListener('focusout', function(){
		if(id.value != ""){
			check[0] = 1
			console.log("check : " + check)
		}else{
			alert("빈칸입니다")
		}
	})
	
	pw1.addEventListener('focusout', function(){
		if(pw1.value != ""){
			check[1] = 1
			console.log("check : " + check)
		}else{
			alert("빈칸입니다")
		}
	})
	
	pw2.addEventListener('focusout', function(){
		if(pw2.value == ""){
			alert("빈칸입니다")
		}else if(pw1.value != pw2.value){
			alert("비밀번호 다름")
		}else{
			check[2] = 1
			console.log("check : " + check)
			btnCheck()
		}
	})
	
	let btnCheck = function(){
		var count = 0
		check.forEach(function(val){
			if(val == 1){
				count += 1
			}
		})
		if(count = 3){
			btn.disabled = false
		}
	}
	
</script>
</html>