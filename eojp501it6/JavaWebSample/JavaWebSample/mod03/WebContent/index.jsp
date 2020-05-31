<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我是首頁</title>
</head>
<body>
<!-- 重要的話說三遍 -->
<%
	for(int start=0;start<3;start++){
		out.println("<li>Hello World!!!");
	}
%>
</body>
</html>