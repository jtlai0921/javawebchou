<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %> 
<html> 
<head> 
<title>XML Tag範例</title> 
</head> 
<body> 
<h2>XML Tag範例</h2> 
<c:set var="mysite"> 
	<mysite> 
      <name>XML Tag範例</name> 
      <example>這是一個JSP網頁</example>
    </mysite> 
</c:set> 
<x:parse xml="${mysite}" var="output"/> 
<b>我的站台 :: </b>
<x:out select="$output/mysite[1]/name" /><br> 
<b>範例 ::</b>
<x:out select="$output/mysite[1]/example" /> 
</body> 
</html>