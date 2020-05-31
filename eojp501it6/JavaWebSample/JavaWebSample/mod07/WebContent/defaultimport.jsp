<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<String> names=new ArrayList<String>();
	names.add("allen");
	names.add("barry");
	names.add("cathy");
%>
<div>姓名1:<%=names.get(0)%></div>
<div>姓名2:<%=names.get(1)%></div>
<div>姓名3:<%=names.get(2)%></div>
</body>
</html>