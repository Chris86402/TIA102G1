<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>新增員工成功</title>
</head>
<body>
<h2>新增員工成功</h2>
<p>員工資料:</p>
<table border="1">
    <tr><td>員工編號</td><td>${staff.staffId}</td></tr>
    <tr><td>預設密碼</td><td>${staff.password}</td></tr>
    <tr><td>姓名</td><td>${staff.name}</td></tr>
    <tr><td>電話</td><td>${staff.phone}</td></tr>
    <tr><td>電子郵件</td><td>${staff.email}</td></tr>
    <tr><td>入職日期</td><td>${staff.employDt}</td></tr>
    <tr><td>建立者</td><td>${staff.createdBy}</td></tr>
	<!--     ======================================================== -->
    <tr><td>建立日期</td>
    <td><fmt:formatDate value="${staff.dateCreated}" pattern="yyyy-MM-dd HH:mm:ss"/></td></tr>
    <!--     ======================================================== -->
    <tr><td>最後更新者</td><td>${staff.lastUpdatedBy}</td></tr>
    <!--     ======================================================== -->
    <tr><td>最後更新日期</td>
    <td><fmt:formatDate value="${staff.lastUpdated}" pattern="yyyy-MM-dd HH:mm:ss"/></td></tr>
    <!--     ======================================================== -->
</table>
<a href="${pageContext.request.contextPath}/staff/staff.do?action=getAll">返回列表</a>
<a href="${pageContext.request.contextPath}/staff/staffMainPage/mainPage.jsp">回首頁</a>
</body>
</html>
