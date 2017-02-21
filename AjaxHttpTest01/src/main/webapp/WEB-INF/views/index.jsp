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