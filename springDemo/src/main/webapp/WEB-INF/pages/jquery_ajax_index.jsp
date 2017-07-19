<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<title>jquery ajax test</title>
</head>
<body>
<h1>新建用户</h1>
<label>请输入id:</label>
<input type="text" id="id">
<button id="search">查询</button>

<p id="searchResult"></p>

<h1>新建用户</h1>
<label>nickname:</label>
<input type="text" id="nickname">
<label>firstName:</label>
<input type="text" id="firstName">
<label>lastName:</label>
<input type="text" id="lastName">
<label>password:</label>
<input type="text" id="password">
<button id="create">新建</button>

<p id="createResult"></p>

<script>
$(document).ready(function() {
	$("#search").click(function() {
		$.ajax({
			type:"GET",
			url:"/springDemo/admin/users/show/"+$("#id").val(),
			dataType:"html",
			success:function(data){
				$("#searchResult").html(data);
				//if(data.success){
				//	$("#searchResult").html(data.responseText);
				//}
			},
			error:function(jqXHR){
				alert("error"+jqXHR.status);
			}
			
		});
	});
	
	$("#create").click(function() {
		$.ajax({
			type:"POST",
			url:"/springDemo/admin/users/addP",
			dataType:"html",
			data:{
				nickname: $("#nickname").val(),
				firstName: $("#firstName").val(),
				lastName: $("#lastName").val(),
				password: $("#password").val()
			},
			success:function(data){
				$("#createResult").html(data);
				//if(data.success){
				//	$("#searchResult").html(data.responseText);
				//}
			},
			error:function(jqXHR){
				alert("error"+jqXHR.status);
			}
			
		});
	});
	
});


</script>
</body>
</html>