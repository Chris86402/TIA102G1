<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.tia102g1.event.model.*"%>

<%
    EventService eventSvc = new EventService();
    List<EventVO> list = eventSvc.getAll();
    pageContext.setAttribute("list", list);
%>


<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>所有活動資料 - listAllEvent.jsp</title>

		<!-- header-css etc. -->
		<%@ include file="../comPage1.file"%>
		
		<style>
		  table#table-1 {
			background-color: #CCCCFF;
		    border: 2px solid black;
		    text-align: center;
		  }
		  table#table-1 h4 {
		    color: red;
		    display: block;
		    margin-bottom: 1px;
		  }
		  h4 {
		    color: blue;
		    display: inline;
		  }
		</style>
		
		<style>
		  table {
			width: 800px;
			background-color: white;
			margin-top: 5px;
			margin-bottom: 5px;
		  }
		  table, th, td {
		    border: 1px solid #CCCCFF;
		  }
		  th, td {
		    padding: 5px;
		    text-align: center;
		  }
		</style>

	</head>
	
	<body class="hold-transition sidebar-mini layout-fixed">

	<!-- side bar -->
	<%@ include file="../comPage2.file"%>
	
	<!-- Content Wrapper. Contains page content -->
    <!-- 儀錶板上面那排 -->
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <div class="content-header">
        <div class="container-fluid">
          <div class="row mb-2">
            <div class="col-sm-6">
              <h1 class="m-0">促銷活動</h1>
            </div><!-- /.col -->
            <div class="col-sm-6">
              <ol class="breadcrumb float-sm-right">
                <li class="breadcrumb-item"><a href="<%=URIPath%>index.jsp">首頁</a></li>
                <li class="breadcrumb-item "><a href="<%=URIPath%>event/select_page.jsp">促銷活動</a></li>
                <li class="breadcrumb-item active">查詢所有活動資料</li>
              </ol>
            </div><!-- /.col -->
          </div><!-- /.row -->
        </div><!-- /.container-fluid -->
      </div>
      <!-- /.content-header -->

	<!-- 功能內容開始 -->
	<section class="content">
	<h4>此頁練習採用 EL 的寫法取值:</h4>
	<table id="table-1">
		<tr><td>
			 <h3>所有活動資料 - listAllEvent.jsp</h3>
			 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
		</td></tr>
	</table>
	
	<table>
		<tr>
			<th>活動流水號</th>
			<th>活動名稱</th>
			<th>活動開始日期</th>
			<th>活動結束日期</th>
			<th>活動折數</th>
			<th>活動圖片</th>
			<th>活動狀態</th>
			<th>活動文案內容</th>
			<th>建檔者</th>
			<th>建檔時間</th>
			<th>最後更新者</th>
			<th>最後更新時間</th>
			<th>修改</th>
			<th>刪除</th>
		</tr>
		<%@ include file="page1.file" %> 
		<c:forEach var="eventVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
			
			<tr>
				<td>${eventVO.eventId}</td>
				<td>${eventVO.eventName}</td>
				<td>${eventVO.startDt}</td>
				<td>${eventVO.endDt}</td>
				<td>${eventVO.eventDiscount}</td>
				<td><img src="<%=request.getContextPath()%>/event/EventDBGifReader?eventId=${eventVO.eventId}" width="100px"></td>
				<td>${eventVO.status}</td> 
				<td>${eventVO.eventContent}</td>
				<td>${eventVO.createdBy}</td>
				<td><fmt:formatDate value="${eventVO.dateCreated}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>${eventVO.lastUpdatedBy}</td>
				<td><fmt:formatDate value="${eventVO.lastUpdated}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
				  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/tia102g1/event/event.do" style="margin-bottom: 0px;">
				     <input type="submit" value="修改">
				     <input type="hidden" name="eventId"  value="${eventVO.eventId}">
				     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
				</td>
				<td>
				  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/tia102g1/event/event.do" style="margin-bottom: 0px;">
				     <input type="submit" value="刪除">
				     <input type="hidden" name="eventId"  value="${eventVO.eventId}">
				     <input type="hidden" name="action" value="delete"></FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file" %>
	
	</section>
	<!-- 功能內容結束 -->
	
	<!-- footer and script link -->
	<%@ include file="../comPage3.file"%>

	</body>
</html>