<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<title>使用 JSTL 函数</title>
</head>
<body>

<c:set var="string1" value="巨匠電腦 資訊教育專業."/>
<c:set var="string2" value="${fn:substring(string1, 0, 4)}" />

<p>擷取的字元 : ${string2}</p>

</body>
</html>