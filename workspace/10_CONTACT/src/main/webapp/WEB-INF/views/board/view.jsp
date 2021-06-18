<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			$('#update_page_btn').click(function(){
				$('#f').attr('action', 'updateBoard.do');
				$('#f').submit();
			})
			$('#delete_btn').click(function(){
				if (confirm('삭제할까요?')) {
					location.href = 'deleteBoard.do?no=${board.no}';
				}else{
					alert('삭제 취소');
				}
			})
			$('#list_btn').click(function(){
				location.href = 'selectBoardList.do';
			})
		})
	</script>
</head>
<body>
	
	<h1>연락처 보기</h1>
	<form id="f" method="post">
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
		<input type="hidden" name="no" value="${board.no }">
		<input type="button" value="수정하기" id="update_page_btn">
		<input type="button" value="삭제하기" id="delete_btn">
		<input type="button" value="목록으로이동" id="list_btn">
	</form>
	</body>
</html>