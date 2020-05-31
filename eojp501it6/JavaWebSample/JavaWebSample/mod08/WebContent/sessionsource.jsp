<%@ page language="java" contentType="text/html; charset=UTF-8"
   import="com.gjun.domain.Customers" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session狀態管理</title>
</head>
<body>
	<%
		//建構一個客戶物件
	Customers customers=new Customers();
	customers.setCustomerid("0001");
	customers.setCompanyName("巨匠電腦");
	customers.setPhone("02-12345678");
	session.setAttribute("customers",customers);
	%>
	
	<div>建構一個客戶物件!!</div>
</body>
</html>