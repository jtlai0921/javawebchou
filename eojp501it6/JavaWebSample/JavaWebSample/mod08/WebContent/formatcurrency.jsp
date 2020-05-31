<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>數值貨幣格式化</title>
</head>
<body>
<fmt:setLocale value="en_US"/>
 <p>美元en_US: <fmt:formatNumber value="123.456" type="currency"/></p>
 <fmt:setLocale value="ja_JP"/>
 <p>日幣ja_JP: <fmt:formatNumber value="123.456" type="currency"/></p>
 <fmt:setLocale value="de_DE"/>
 <p>德國de_DE: <fmt:formatNumber value="123.456" type="currency"/></p>

</body>
</html>