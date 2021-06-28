<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			fn_selectMemberList();
			fn_paging();
			fn_selectMemberByNo();
			fn_insertMember();
			fn_updateMember();
			fn_deleteMember();
		});
		// 1. 회원 목록
		var page = 1;
		function fn_selectMemberList() {
			var obj = {
				page: page
			};
			$.ajax({
				url: 'selectMemberList.do',
				type: 'post',
				contentType: 'application/json',
				data: JSON.stringify(obj),
				dataType: 'json',
				success: function(resultMap) {
					$('#member_list').empty();  // 기존 회원 목록을 모두 지움
					if (resultMap.exists) {
						// resultMap.list 출력
						$.each(resultMap.list, function(i, member){
							$('<tr>')
							.append('<td>' + member.id + '</td>')  // .append('<td>').text(member.id)
							.append('<td>' + member.name + '</td>')
							.append('<td>' + member.address + '</td>')
							.append('<td>' + member.gender + '</td>')
							.append('<td><input type="button" value="조회" id="view_btn"></td>')
							.appendTo('#member_list');
						});
					} else {
						$('<tr>')
						.append('<td colspan="5">등록된 회원이 없습니다.</td>')
						.appendTo('#member_list');
					}
				}
			});
		}
		// 2. 회원 목록 페이징
		function fn_paging() {
			
		}
		// 3. 회원 정보 보기
		function fn_selectMemberByNo() {
			
		}
		// 4. 회원 삽입
		function fn_insertMember() {
			$('#insert_btn').click(function(){
				var member = {
					id: $('#id').val(),
					name: $('#name').val(),
					address: $('#address').val(),
					gender: $('input:radio[name="gender"]:checked').val()
				};
				$.ajax({
					url: 'insertMember.do',
					type: 'post',
					contentType: 'application/json',
					data: JSON.stringify(member),  // JSON 전달
					dataType: 'json',
					success: function(resultMap) {
						if (resultMap.result > 0) {
							alert('새로운 회원이 등록되었습니다.');
							fn_selectMemberList();
						}
					},
					error: function(xhr, textStatus, errorThrown) {
						switch (xhr.status) {
						case 1001:
							alert(xhr.responseText);
							break;
						}
					}
				});
			});
		}
		// 5. 회원 수정
		function fn_updateMember() {
			
		}
		// 6. 회원 삭제
		function fn_deleteMember() {
			
		}
	</script>
</head>
<body>
	
	<h1>회원 관리</h1>
	
	아이디 <input type="text" name="id" id="id"><br>
	이름 <input type="text" name="name" id="name"><br>
	주소 <input type="text" name="address" id="address"><br>
	성별
	<input type="radio" name="gender" value="남" id="male"><label for="male">남</label>
	<input type="radio" name="gender" value="여" id="feale"><label for="female">여</label><br>
	<input type="button" value="등록" id="insert_btn"><br>
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>주소</td>
				<td>성별</td>
				<td></td>
			</tr>
		</thead>
		<tbody id="member_list">
		
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5">
					<div id="paging"></div>
				</td>
			</tr>
		</tfoot>
	</table>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>