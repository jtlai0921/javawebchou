<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>狀態參考可視範圍應用</title>
</head>
<body>
	<%
		String com="巨匠電腦";
		pageContext.setAttribute("com",com);
		String branch="台北認證中心";
		session.setAttribute("com",branch);
	%>
	<!-- page level -->
	<div>Page範圍:${com}</div>
</body>
</html>