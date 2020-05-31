<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pageContext應用</title>
</head>
<body>
	<%
		//區域變數設定
		String com="巨匠電腦";
		pageContext.setAttribute("company", com);
	%>
	<!-- 使用EL輸出 -->
	<div>公司行號:${company}</div>
</body>
</html>