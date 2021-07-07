<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>

	<h1>게시글 작성 화면</h1>
	
	<form action="insertFBoard.do"
		  method="post">
	
		
		작성자 ${loginUser.memberId }
		<input type="hidden" name="id" value="${loginUser.memberId }"><br><br>
		
		
		내용<br>
		<input type="text" name="content"><br><br>
		

		<button>저장하기</button>
	
	</form>
</body>
</html>