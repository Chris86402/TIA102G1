<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<title>���u�n�J</title>
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
						��J�b���K�X
				</td>
			</tr>
			
			<tr>
				<td>
					<p align = left>
						<b>���u�s��:</b>
				</td>
				<td>
					<p>
						<input type = text name = "staffId" value = "" size = 15>
				</td>
			</tr>
			
			<tr>
				<td>
					<p align = left>
						<b>�K�X:</b>
				</td>
				<td>
					<p>
						<input type = password name = "password" value = "" size = 15>
				</td>
			<tr>
				<td colspan = 2 align = center>
					<input type = "hidden" name = "action" value = "login">
					<input type = "hidden" name = "staffId" value = "${staff.staffId}">
					<input type = submit value = "ok">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>