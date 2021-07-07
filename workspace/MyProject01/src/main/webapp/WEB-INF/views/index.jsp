<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

	<style>
		#leave_link:hover {
			cursor: pointer;
		}
	</style>
</head>
<body>

	<h1>홈페이지</h1>
	
	<a href="loginPage.do">로그인</a>
	<a href="gBoard.do">갤러리 게시판</a>
	<a href="fBoard.do">자유 게시판</a>
</html>