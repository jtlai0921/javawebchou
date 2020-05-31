<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//取出初始化參數
		String com=config.getInitParameter("com");
	%>
	<div>公司行號:<%=com%></div>
</body>
</html>