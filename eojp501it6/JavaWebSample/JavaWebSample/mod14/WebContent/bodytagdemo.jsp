<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="h" uri="/WEB-INF/tld/customtag.tld" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BodyTag自訂標籤</title>
</head>
<%
	String message="Hello World";
	pageContext.setAttribute("message",message);
%>
<body>
<div><h:mybody message="${message}">
	<h2 style="font-size:48px;color:red">巨匠您好</h2>
</h:mybody></div>
</body>
</html>