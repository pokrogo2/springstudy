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
			$('#updatepage_btn').click(function(){
				$('#f').attr('action', 'updatePage.do');
				$('#f').submit();
			});
		}
		function fn_delete(){
			$('#delete_btn').click(function(){
				if (confirm('삭제할까요?')) {
					$('#f').attr('action', 'deleteBoard.do');
					$('#f').submit();
				}
			});
		}
		
	</script>
</head>
<body>

	<h1>게시글 보기 화면</h1>
	<table border="1">
		<tr>
			<td>게시글 번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>업로드날짜</td>
		</tr>
		<tr>
			<td>${board.gno}</td>
			<td>${board.gid}</td>
			<td>${board.gtitle}</td>
			<td>${board.postdate}</td>
		</tr>
		<tr><td colspan="4">설명</td></tr>
		<tr><td colspan="4">${board.gcontent}</td></tr>
		<tr>
			<td colspan="4">
			<img alt="${filename}" src="resources/archive/${filename}" style="width: 300px;">
			</td>
		</tr>
	</table>
	<c:if test="${loginUser.memberId == board.gid }">
	<form id="f" method="post">
	<input type="hidden"  name ="no" value="${board.gno}">
	<button id="updatepage_btn">수정하기</button>
	
	<button id="delete_btn">삭제하기</button>
	</form>
	</c:if>
	
	
	<%-- 댓글 입력창 --%>
<div class="reply_form">
	<form action="insertReply.do" >
		<input type="text" name="gboard_no" value="${board.gno}"> 
		<textarea name="content" placeholder="로그인을 하면 작성할 수 있습니다."></textarea>
		<c:if test="${loginUser != null and loginUser.status ==1}">
			<button>작성하기</button>
		</c:if>
	</form>
</div>

	<button id="back_btn" onclick="location.href='gBoard.do'">목록</button>

<div class="reply_list">

	<table>
		<tbody>
			<c:forEach var="replyDTO" items="${replyList}">
				<tr>
					<td>${replyDTO.gid}</td>
					<td>${replyDTO.gcontent}</td>
					<td>${replyDTO.postdate}</td>
					<td>
						<c:if test="${loginUser.memberId == replyDTO.gid}">   
							<a href="deleteReply.do?replyId=${replyDTO.gid}&gno=${replyDTO.gno}">삭제</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

</body>
</html>
