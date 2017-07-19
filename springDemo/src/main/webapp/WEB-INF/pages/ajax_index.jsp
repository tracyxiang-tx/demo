<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ajax test</title>
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

document.getElementById("search").onclick = function(){
	//发送Ajax查询
	var xmlhttp;
	if(window.XMLHttpRequest){
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp = new XMLHttpRequest();
	}    
	else{
		// IE6, IE5 浏览器执行代码
		xml = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("GET","/springDemo/admin/users/show/"+document.getElementById("id").value);
	xmlhttp.send();

	xmlhttp.onreadystatechange = function(){
	    if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
	    
	        document.getElementById("searchResult").innerHTML = xmlhttp.responseText;
	    }
	}
}

document.getElementById("create").onclick = function(){
	//发送Ajax查询
	var xmlhttp;
	if(window.XMLHttpRequest){
		// IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		xmlhttp = new XMLHttpRequest();
	}    
	else{
		// IE6, IE5 浏览器执行代码
		xml = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("POST","/springDemo/admin/users/addP");
	var data = "nickname=" + document.getElementById("nickname").value
			+ "&firstName=" + document.getElementById("firstName").value
			+ "&lastName=" + document.getElementById("lastName").value
			+ "&password=" + document.getElementById("password").value
	xmlhttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	xmlhttp.send(data);

	xmlhttp.onreadystatechange = function(){
	    if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
	    
	        document.getElementById("createResult").innerHTML = xmlhttp.responseText;
	    }
	}
}

</script>
</body>
</html>