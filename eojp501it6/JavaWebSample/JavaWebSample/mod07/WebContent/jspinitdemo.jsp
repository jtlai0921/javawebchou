<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP init範例</title>
</head>
<body>
<%!
	//單行註解說明
	private String companyName;
	//Overriding 初始化
	public  void jspInit(){
		this.companyName="巨匠電腦";
}
%>
<!-- 直接嵌入在標籤中的運算式 -->
<div style="font-size:48px;color:red">公司名稱:<%=this.companyName%></div>
<%
	/*區域變數定義
	*區域變數只活在_jspService Method中
	*/
	String address="台北市公園路";
	out.println(address);
%>

</body>
</html>