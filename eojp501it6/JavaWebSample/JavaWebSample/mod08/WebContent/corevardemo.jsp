<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 設定attribute內容 -->
<c:set var="com" value="巨匠電腦"></c:set>
<!-- EL輸出 -->
${com}
<br/>
<!-- JSTL輸出 -->
<c:out value="${com}"></c:out>

</body>
</html>