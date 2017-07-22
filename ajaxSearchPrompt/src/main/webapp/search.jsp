<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>

<title>Ajax Search</title>
<style type="text/css">
#mydiv {
	position: absolute;
	left: 50%;
	top: 50%;
	margin-left: -200px;
	margin-top: -50px;
}
.mouseover{
	background: #708090;
	color:#FFFAFA;
}

.mouseout{
	background: #FFFAFA;
	color:#000000;
}
</style>

<script type="text/javascript">

	var xmlHttp;
	
	function getMoreContents(){
		var content = document.getElementById("keyword");
		if(content.value == ""){
			clearContent();
			return;
		}
	
		xmlHttp = createXmlHttp();
		var url="search?keyword=" + escape(content.value);
		xmlHttp.open("GET",url,true);
		xmlHttp.onreadystatechange = callback;
		xmlHttp.send();
		
	}
	
	function createXmlHttp(){
		var xmlHttp;
		if(window.XMLHttpRequest){
			xmlHttp = new XMLHttpRequest();
		}else{
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		return xmlHttp;
	}
	
	function callback(){
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			var result = xmlHttp.responseText;
			var json = eval("("+result+")");
			setContent(json);
		}
	}
	
	function setContent(contents) {
		clearContent();
		setLocation();
		var size = contents.length;
		for(var i=0; i<size; i++ ){
			var nextNode = contents[i];
			var tr = document.createElement("tr");
			var td = document.createElement("td");
			td.setAttribute("border", "0");
			td.setAttribute("bgcolor", "#FFFAFA");
			td.onmouseover = function(){
				this.className='mouseover';
			}; 
			td.onmouseout = function(){
				this.className='mouseout'; 
			};
			td.onclick = function(){
			};
			
			var text = document.createTextNode(nextNode);
			td.appendChild(text);
			tr.appendChild(td);
			document.getElementById("content_table_body").appendChild(tr);
		}
	}
	function clearContent(){
		var contentTableTbody = document.getElementById("content_table_body");
		var size = contentTableTbody.childNodes.length;
		for(i=size-1; i>=0; i--){
			contentTableTbody.removeChild(contentTableTbody.childNodes[i]);
		}
		document.getElementById("popDiv").style.border = "none";
	}
	
	function keywordBlur(){
		clearContent();
	}
	
	function setLocation(){
		var content = document.getElementById("keyword");
		var width = content.offsetWidth;
		var left = content["offsetLeft"];
		var top = content["offsetTop"] + content.offsetHeight;
		var popDiv = document.getElementById("popDiv");
		popDiv.style.border="black 1px soild";
		popDiv.style.left = left + "px";
		popDiv.style.top = top + "px";
		popDiv.style.width = width + "px";
		document.getElementById("content_table").style.width = width + "px";
		
	}
</script>
</head>
<body>
	<div id="mydiv">
		<input type="text" size="50" id="keyword" onkeyup="getMoreContents()" onblur="keywordBlur()" onfocus="getMoreContents()">
		
		<input type="button" value="搜索" value="50px">
		
		<div id="popDiv">
			<table id="content_table" bgcolor="#FFFAFA" border="0" cellspacing="0" cellpadding="0">
				<tbody id="content_table_body">
				</tbody>
			</table>
		</div>
	</div>





	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>