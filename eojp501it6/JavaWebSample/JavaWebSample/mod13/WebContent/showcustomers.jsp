<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢結果</title>
</head>
<body>
	<c:if test="${result!=null}">
		<fieldset>
			<legend>查詢結果</legend>
			<table border="1" width="100%">
				<tr>
					<td>客戶編號</td>
					<td>${result.customerId}</td>
				</tr>
				<tr>
					<td>公司行號</td>
					<td>${result.companyName}</td>
				</tr>
				<tr>
					<td>聯絡地址</td>
					<td>${result.address}</td>
				</tr>
				<tr>
					<td>連絡電話</td>
					<td>${result.phone}</td>
				</tr>
				<tr>
					<td>國家別</td>
					<td>${result.country}</td>
				</tr>
			</table>
		</fieldset>
	</c:if>
</body>
</html>