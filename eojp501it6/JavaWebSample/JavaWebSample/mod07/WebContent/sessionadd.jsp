<%@ page language="java" contentType="text/html; charset=UTF-8"
    session="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String companyName="巨匠電腦";
		//進入Session狀態管理
		session.setAttribute("com",companyName);
	%>
	<div>透過Session參照一個字串物件完成</div>
</body>
</html>