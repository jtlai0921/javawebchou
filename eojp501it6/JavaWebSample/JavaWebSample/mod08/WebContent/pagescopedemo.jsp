<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageScope內建物件應用</title>
</head>
<body>
	<%
		String com="巨匠電腦";
		pageContext.setAttribute("company", com);
	%>
	
	<div>使用區域變數於EL:${com}</div>
	<div>使用EL內建物件:${pageScope.company}</div>
</body>
</html>