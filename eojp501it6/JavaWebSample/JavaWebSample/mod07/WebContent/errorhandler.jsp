<%@ page language="java" contentType="text/html; charset=UTF-8"
    isErrorPage="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>錯誤處理網頁</title>
</head>
<body>
<div>您發生的錯誤訊息:<%=exception.getMessage()%></div>
</body>
</html>