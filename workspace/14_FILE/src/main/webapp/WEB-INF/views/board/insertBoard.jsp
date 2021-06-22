<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>화면</h1>
	<form action = "insertBoard.do" method = "post" enctype="multipart/form-data">
		작성자<br>
		<input type="text" name= "writer"><br>
		제목<br>
		<input type="text" name= "title"><br>
		내용<br>
		<input type="text" name= "content"><br>
		첨부<br>
		<input type="file" name= "files" multiple><br>
	</form>
</body>
</html>