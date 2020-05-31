<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PageContext Attribute應用</title>
</head>
<body>
<%
	String com="巨匠電腦";
	//使用pageContext內建物件進行Attribute參考
	pageContext.setAttribute("company", com);
%>
<!-- 使用EL運算輸出 無法運算區域變數 -->
<div>公司行號:${com}</div>
<div>公司行號:${company}</div>

</body>
</html>