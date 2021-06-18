<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			$('#insert_btn').click(function(){
				$('#f').attr('action', 'insertBoard.do');
				$('#f').submit();
			})
			$('#list_btn').click(function(){
				location.href = 'selectBoardList.do';
			})
		})
	</script>
</head>
<body>
	
	<h1>연락처 보기</h1>
	<form id="f">
		<p>이름</p>
		<input type="text" name="name" value="${board.name}">
		<p>전화</p>
		<input type="text" name="tel" value="${board.tel}">
		<p>주소</p>
		<input type="text" name="addr" value="${board.addr}">
		<p>이메일</p>
		<input type="text" name="email" value="${board.email}">
		<p>비고</p>
		<input type="text" name="note" value="${board.note}">
		<br><br>
		<input type="button" value="연락처 저장하기" id="insert_btn">
		<input type="button" value="전체연락처" id="list_btn">
	</form>
</body>
</html>