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


<!-- 處理資料維護...-->
<!-- 派與參數傳遞-->
<jsp:forward page="showcustomers.jsp">
	<jsp:param value="${customer.customerId}" name="customerId"/>
	<jsp:param value="${customer.firstName}" name="firstName"/>
	<jsp:param value="${customer.lastName}" name="lastName"/>
	<jsp:param value="${customer.email}" name="email"/>
</jsp:forward>
	
	
</body>
</html>