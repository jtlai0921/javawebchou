<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<title>JSTL sql:query Tag</title>
</head>
<body>
 
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
     url="jdbc:mysql://localhost:3306/sakila?useSSL=false&serverTimezone=UTC"
     user="root"  password="1111"/>

<sql:query dataSource="${db}" var="result">
SELECT * from Customer;
</sql:query>
 
<table border="1" width="100%">
<tr>
<th>客戶編號</th>
<th>First Name</th>
<th>Last Name</th>
<th>Email</th>
</tr>
<c:forEach var="row" items="${result.rows}">
<tr>
<td><c:out value="${row.customer_id}"/></td>
<td><c:out value="${row.first_name}"/></td>
<td><c:out value="${row.last_name}"/></td>
<td><c:out value="${row.email}"/></td>
</tr>
</c:forEach>
</table>

</body>
</html>