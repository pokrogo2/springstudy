<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			$('#insert_btn').click(function(){
				location.href = 'insertFBoardPage.do';
			})
		})
	</script>
</head>
<body>
	<h1>게시판 목록</h1>
	<table border="1">
		<thead>
			<tr>
				<td>게시글번호</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
			
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="5">없음</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="board" items="${list}">
					<tr>
						<td>${board.fno}</td>
						<td>${board.fid}</td>
						<td><a href="selectFBoardByNo.do?no=${board.fno}">${board.fcontent}</a></td>
						<td>${board.postdate}</td>
					
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">
				<c:if test="${loginUser != null and loginUser.status ==1}">
					<input type="button" value="새글작성하러가기" id="insert_btn">
					</c:if>
					<c:if test="${loginUser == null}">
						로그인필요
					</c:if>
				</td>
			</tr>
		<tr>
			<td>
				${paging}
				</td>
			</tr>
		</tfoot>
	</table>
	<a href="index.do">돌아가기</a>
</body>
</html>