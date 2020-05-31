<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp內建物件out應用</title>
</head>
<body>
	<%
		//設定區域變數
		String com="巨匠電腦";
		out.println(com);
	%>
	<div><%=com%></div>
</body>
</html>