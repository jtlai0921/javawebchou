<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>呈現畫面</title>
</head>
<body>

<fieldset>
	<legend>您輸入的資料</legend>
	<div>客戶編號:<%=request.getParameter("customerId") %></div>
	<div>First Name:<%=request.getParameter("firstName") %></div>
	<div>Last Name:<%=request.getParameter("lastName") %></div>
	<div>EMAIL:<%=request.getParameter("email") %></div>
</fieldset>
</body>
</html>