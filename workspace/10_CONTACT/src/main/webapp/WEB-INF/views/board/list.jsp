<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			$('#insert_btn').click(function(){
				location.href = 'insertBoardPage.do';
			})
		})
	</script>
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>이름</td>
				<td>전화</td>
				<td>주소</td>
				<td>이메일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="5">연락처가 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="board" items="${list}">
					<tr>
						<td>${board.no}</td>
						<td><a href="selectBoardByNo.do?no=${board.no}">${board.name}</a></td>				
						<td>${board.tel}</td>				
						<td>${board.addr}</td>				
						<td>${board.email}</td>				
									
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">
					<input type="button" value="새연락처 등록" id="insert_btn">
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>