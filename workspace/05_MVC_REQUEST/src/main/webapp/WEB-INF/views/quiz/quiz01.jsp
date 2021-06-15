<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>view01</h1>
	<!-- index에서 보낸 파라미터 -->
	${param.title }<br>
	${param.hit }<br>
	<!-- controller에 model이 저장한속성 -->
	${title }<br>
	${hit } <br>
	
</body>
</html>