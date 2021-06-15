<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<title>Insert title here</title>
<script>

	$(document).ready(function(){
		fn1();
		
	})
	function fn1(){
		$('#btm').click(function(){
			$.ajax({
				url:'v01', //@requ(value="v01")
				type:'get',//@requ(method=requestmethod.get)
				data: 'name=' +$('#name').val() + "&age=" +$('#age'),
				dataType : 'json',
				success: function(responseData){
					console.log(responseData);
				},
				error :function(xhr,text,error){
					console.log(xhr.responseText+", " +text+", " + error);
				}
			})
		})
	}
</script>
</head>
<body>
	<form id ="f">
		<input type="text" name="name" id="name" placeholder="이름"><br>
		<input type="text" name= "age" id="age" placeholder="나이"><br>
		<button id="btn">전송</button>
		
	</form>

</body>
</html>