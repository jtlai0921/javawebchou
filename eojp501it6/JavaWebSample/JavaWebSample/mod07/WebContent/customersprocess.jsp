<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.io.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客戶資料處理</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
	//擷取表單欄位內容
	String customerid=request.getParameter("customerid");
	String companyName=request.getParameter("companyName");
	String address=request.getParameter("address");
	String phone=request.getParameter("phone");
	%>
	<br/>
	<div>客戶編號:<%=customerid%></div>
	<div>公司行號:<%=companyName%></div>
	<div>聯絡地址:<%=address%></div>
	<div>連絡電話:<%=phone%></div>
	<div></div>
	<%
		PrintWriter writer=response.getWriter();
		writer.println("Hello World!!");
	
	%>
</body>
</html>