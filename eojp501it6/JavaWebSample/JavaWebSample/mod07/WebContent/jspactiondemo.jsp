<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Action應用</title>
</head>
<body>
<jsp:useBean id="customers" class="com.gjun.domain.Customers"></jsp:useBean>
<jsp:setProperty property="customerid" name="customers" value="0001"/>
<jsp:setProperty property="companyName" name="customers" value="巨匠"/>
<jsp:setProperty property="address" name="customers" value="高雄市"/>

<!-- 呈現資料 -->
<jsp:getProperty property="companyName" name="customers"/>
</body>
</html>