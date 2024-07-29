<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.staff.service.StaffServiceImpl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>�ܧ�K�X</title>
</head>
<body>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���D:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	<form action="${pageContext.request.contextPath}/staff/staff.do" method="post">
	<table border = 1>
			<tr>
				<td colspan = 2>
					<p align = center>
						�ܧ�K�X
				</td>
			</tr>
			
			<tr>
				<td>
					<p align = left>
						<b>���u�s��:</b>
				</td>
				<td>${staffId}</td>
			</tr>
			
			<tr>
				<td>
					<p align = left>
						<b>��J�±K�X:</b>
				</td>
				<td>
					<p>
						<input type = password name = "pastPassword" value = "" size = 15>
				</td>
			</tr>
			
			<tr>
				<td>
					<p align = left>
						<b>��J�s�K�X:</b>
				</td>
				<td>
					<p>
						<input type = password name = "newPassword">
				</td>
			</tr>
		
			<tr>
				<td colspan = 2 align = center>
					<input type = "hidden" name = "action" value = "changePW">
					<input type = submit value = "�T�{�ק�">
				</td>
			</tr>
		</table>
	
	</form>
</body>
</html>