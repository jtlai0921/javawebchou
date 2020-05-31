<%@ page language="java" contentType="text/html; charset=UTF-8" import="org.apache.commons.dbcp2.BasicDataSource"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客戶資料維護</title>
</head>
<body>
	<%
	//建構DataSource物件
	BasicDataSource dataSource=new BasicDataSource();
	dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
	dataSource.setUrl("jdbc:mysql://localhost:3306/sakila?useSSL=false"
			+ "&serverTimezone=UTC&characterEncoding=utf-8");
	dataSource.setUsername("root");
	dataSource.setPassword("1111");
	pageContext.setAttribute("datasource",dataSource);
	%>
	<jsp:useBean id="dao" class="com.gjun.domain.CustomerDao"></jsp:useBean>
	<jsp:setProperty name="dao" property="dataSource" value="${datasource}"/>
	<jsp:useBean id="customer" class="com.gjun.domain.Customer"></jsp:useBean>
	<jsp:setProperty property="*" name="customer"/>
	
	${dao.insert(customer)}	
	<div>客戶編號:${customer.customerId}</div>
	<div>First Name:${customer.firstName}</div>
	<div>Last Name:${customer.lastName}</div>
	<div>EMAIL:${customer.email}</div>
</body>
</html>