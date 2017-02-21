<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.js"></script>
<script>
	$(document).ready(function() {
		$('#myselect').change(function() {
			var output = '';
			var choose = $('#myselect > option:selected').val();
			$.ajax({
				/*
				jQuery.ajax( url [, settings] ) [ 1.5 이상버젼 ]/ jQuery.ajax( settings ) [ 1.0 이상버젼 ]
				data : 서버로 데이터를 전송할 때 이 옵션을 사용한다. 
				dataType : 서버측에서 전송한 데이터를 어떤 형식의 데이터로 해석할 것인가를 지정한다. 값으로 올 수 있는 것은 xml, json, script, html이다. 형식을 지정하지 않으면 jQuery가 알아서 판단한다.
				success : 성공했을 때 호출할 콜백을 지정한다.
					Function( PlainObject data, String textStatus, jqXHR jqXHR )
				type : 데이터를 전송하는 방법을 지정한다. get, post를 사용할 수 있다.
				*/
				type : 'POST',
				url : '/aurorarion/table',
				data : JSON.stringify({
					table : choose,
					limit : 8
				}),
				contentType : "application/json; charset=utf-8",
				dataType : 'json',
				success : function(obj) {
					//   alert(obj[0].name);
					//   for(var key in obj) {
					//    	alert(obj[key].name);
					//   }
					output += "<table border = 1>";
					$.each(obj, function(i, item) {
						output += '<tr><td>' + item.name + '</td></tr>'
					});
					output += '</table>'
					$('#demo').html(output);
				}
			});
		});
	});
</script>
</head>
<body>
	<h2>Make a table based on the value of a drop down menu.</h2>

	<select id="myselect">
		<option value="">Choose an option:</option>
		<option value="customers">Customers</option>
		<option value="products">Products</option>
		<option value="suppliers">Suppliers</option>
	</select>

	<p id="demo"></p>
</body>
</html>