<%@ page language="java" contentType="text/html; charset=UTF-8"
    isELIgnored="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	pageContext.setAttribute("name","Eric Chen");
%>
<div>您的姓名:${pageScope.name}</div>
</body>
</html>