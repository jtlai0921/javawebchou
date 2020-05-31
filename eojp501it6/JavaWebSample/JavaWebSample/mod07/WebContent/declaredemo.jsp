<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>宣告式語法應用</title>
<%!
	//定義Attribute
	private String helloMessage;
	//Overriding jspInit()
	public void jspInit(){
		this.helloMessage="您好!!巨匠電腦!!";
	}
	//定義method
	public String getGreeting()
	{
		return this.helloMessage;
	}
%>
</head>
<body>
<div>呼喚宣告式的自訂方法:<%=this.getGreeting()%></div>
</body>
</html>