<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session狀態管理與應用</title>
</head>
<body>
	<%
		//產生隨機碼
		int rad=(int)(Math.random()*10000)+1;
		session.setAttribute("number",rad);
	%>
	<br/>
	<div>您的編號:<%=(Integer)session.getAttribute("number")%></div>
</body>
</html>