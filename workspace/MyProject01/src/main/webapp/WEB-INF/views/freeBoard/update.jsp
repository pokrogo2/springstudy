<%@page import="java.net.URLEncoder"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(function(){
			fn_update();
			fn_delete();
		});
		function fn_update(){
			$('#update_btn').click(function(){
				$('#f').attr('action', 'updateFBoard.do');
				$('#f').submit();
			});
		}
		function fn_delete(){
			$('#delete_btn').click(function(){
				if (confirm('삭제할까요?')) {
					$('#f').attr('action', 'deleteFBoard.do');
					$('#f').submit();
				}
			});
		}
	</script>
</head>
<body>

	<h1>게시글 보기 화면</h1>
	
	<form id="f" method="post" >
		
		<input type="button" value="수정하기" id="update_btn">
		<input type="button" value="삭제하기" id="delete_btn"><br><br>

		<input type="hidden" name="no" value="${board.fno}">


		작성자<br>
		${board.fid}<br><br>
		

		내용<br>
		<input type="text" name="content" value="${board.fcontent}"><br><br>
		
	</form>
	
</body>
</html>
