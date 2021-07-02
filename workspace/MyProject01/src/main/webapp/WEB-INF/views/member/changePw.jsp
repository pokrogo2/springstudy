<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			fn_pwCheck();
			fn_pwCheck2();
			fn_changePw();
		});
		var pwPass = false;
		function fn_pwCheck(){
			$('#pw').keyup(function(){  // keyup : 비밀번호를 입력할때마다
				var regPW = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/; // 나중에 수정해서 사용
				if (regPW.test($('#pw').val())){
					$('#pw_result').text('사용 가능한 비밀번호입니다.').css('color', 'blue');
					pwPass = true;
				} else {
					$('#pw_result').text('비밀번호는 숫자,특문,영문을 사용한 8자리 이상이어야합니다.').css('color', 'red');
					pwPass = false;
				}
			});
		}
		// 비밀번호 입력 확인 함수
		var pwPass2 = false;
		function fn_pwCheck2(){
			$('#pw2').keyup(function(){  // keyup : 비밀번호를 입력할때마다
				if ($('#pw').val() == $('#pw2').val()){
					$('#pw2_result').text('비밀번호 일치').css('color', 'blue');
					pwPass2 = true;
				} else {
					$('#pw2_result').text('비밀번호를 확인하세요.').css('color', 'red');
					pwPass2 = false;
				}
			});
		}
		function fn_changePw() {
			$('#change_pw_btn').click(function(){
					$('#f').attr('action', 'changePw.do');
					$('#f').submit();
				
			});
		}
	</script>
</head>
<body>
	
	<h1>비밀번호 변경</h1>
	
	<form id="f" method="post">
		<input type="hidden" name="email" value="${email}">
		새 비밀번호<br>
		<input type="password" name="pw" id="pw"><br>
		<span id="pw_result"></span><br><br>
		비밀번호 확인<br>
		<input type="password" name="pw2" id="pw2"><br>
		<span id="pw2_result"></span><br><br>
		<input type="button" value="비밀번호 변경" id="change_pw_btn">
		<input type="button" value="돌아가기" onclick="location.href='index.do'">
	</form>
	
</body>
</html>