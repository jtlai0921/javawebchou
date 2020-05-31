<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>原始網頁</title>
</head>
<body>
	<%
		int rad=(int)(Math.random()*10000);
		//透過HttpServletRequest進行隨機值參考
		request.setAttribute("number",rad);
	%>
	<jsp:forward page="showvalue.jsp"></jsp:forward>
</body>
</html>