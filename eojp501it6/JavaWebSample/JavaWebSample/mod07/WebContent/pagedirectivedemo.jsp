<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ page  info="我是JSP網頁 由Eric設計"  %>
 <%@ include file="banner.html" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>@page Directivie應用</title>
</head>
<body>
<br/>
<%
	String hello="您好";
	out.println(this.getServletInfo());
%>
</body>
</html>