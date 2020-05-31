<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scriptlet說明</title>
</head>
<body>
	<%
		String hello="您好";
		pageContext.setAttribute("hello", hello);
	%>
	<div>
		EL應用範例:${hello}
	</div>
</body>
</html>