<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客戶新增結果</title>
</head>
<%
request.setCharacterEncoding("UTF-8");
%>
<body>
	<jsp:useBean id="customer" class="com.gjun.entity.Customer"></jsp:useBean>
	<jsp:setProperty property="*" name="customer"/>

<%
	//處理資料維護...
%>	
<fieldset>
	<legend>您輸入的資料</legend>
	<div>客戶編號:${customer.customerId}</div>
	<div>First Name:${customer.firstName}</div>
	<div>Last Name:${customer.lastName}</div>
	<div>EMAIL:${customer.email}</div>
</fieldset></body>
</html>