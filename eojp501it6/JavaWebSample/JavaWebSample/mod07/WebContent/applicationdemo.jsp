<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 獲取應用系統資訊 -->
	<%
		String app=application.getInitParameter("appname");
		out.println(app);
	%>
</body>
</html>