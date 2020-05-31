<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scriptlet Demo</title>
</head>
<body>
<%
	//定義區域變數
	String hello="您好";
%>
<br/>
<%
	//使用區域變數
	out.println(hello);
%>
</body>
</html>