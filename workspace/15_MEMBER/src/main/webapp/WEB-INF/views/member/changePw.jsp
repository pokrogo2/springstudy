<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>

	

</script>
</head>
<body>
	<h1>비밀번호 변경</h1>
	<form id="f">
			<input type="hidden" name="email" value="${email }">
			새비밀번호 <br>
			<input type="password" name="pw" id="pw"><br><br>
			새비밀번호 확인<br>
			<input type="password" name="pw2" id="pw2"><br><br>
		
			<input type="button" value="비밀번호 변경" id="change_pw_btn">
			<input type="button" value="돌아가기" onclick="location.href='index.do'">
			
	
	</form>
</body>
</html>