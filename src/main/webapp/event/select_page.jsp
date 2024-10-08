<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Dessert | Dashboard</title>

		<!-- header-css etc. -->
		<%@ include file="../comPage1.file"%>
		
		<style>
		  table#table-1 {
			width: 450px;
			background-color: #CCCCFF;
			margin-top: 5px;
			margin-bottom: 10px;
		    border: 3px ridge Gray;
		    height: 80px;
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
                <li class="breadcrumb-item active">促銷活動</li>
              </ol>
            </div><!-- /.col -->
          </div><!-- /.row -->
        </div><!-- /.container-fluid -->
      </div>
      <!-- /.content-header -->

	<!-- 功能內容開始 -->
	<section class="content">
		<table id="table-1">
	   <tr><td><h3>IBM Event: Home</h3><h4>( MVC )</h4></td></tr>
	</table>
	
	<p>This is the Home page for IBM Event: Home</p>
	
	<h3>資料查詢:</h3>
		
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color:red">請修正以下錯誤:</font>
		<ul>
		    <c:forEach var="message" items="${errorMsgs}">
				<li style="color:red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	
	<ul>
	  <li><a href='listAllEvent.jsp'>List</a> all Events.  <br><br></li>
	  
	  
	  <li>
	    <FORM METHOD="post" ACTION="event.do" >
	        <b>輸入活動流水號 (如60001):</b>
	        <input type="text" name="eventId">
	        <input type="hidden" name="action" value="getOne_For_Display">
	        <input type="submit" value="送出">
	    </FORM>
	  </li>
	
	  <jsp:useBean id="eventSvc" scope="page" class="com.tia102g1.event.model.EventService" />
	   
	  <li>
	     <FORM METHOD="post" ACTION="event.do" >
	       <b>選擇活動流水號:</b>
	       <select size="1" name="eventId">
	         <c:forEach var="eventVO" items="${eventSvc.all}" > 
	          <option value="${eventVO.eventId}">${eventVO.eventId}
	         </c:forEach>   
	       </select>
	       <input type="hidden" name="action" value="getOne_For_Display">
	       <input type="submit" value="送出">
	    </FORM>
	  </li>
	  
	  <li>
	     <FORM METHOD="post" ACTION="event.do" >
	       <b>選擇活動名稱:</b>
	       <select size="1" name="eventId">
	         <c:forEach var="eventVO" items="${eventSvc.all}" > 
	          <option value="${eventVO.eventId}">${eventVO.eventName}
	         </c:forEach>   
	       </select>
	       <input type="hidden" name="action" value="getOne_For_Display">
	       <input type="submit" value="送出">
	     </FORM>
	  </li>
	</ul>
	
	
	<h3>活動管理</h3>
	
	<ul>
	  <li><a href='addEvent.jsp'>Add</a> a new Event.</li>
	</ul>
	
	</section>
	<!-- 功能內容結束 -->
	
	<!-- footer and script link -->
	<%@ include file="../comPage3.file"%>

	</body>
</html>