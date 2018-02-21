<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'attdance.jsp' starting page</title>
    
	<meta charset="UTF-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

 	<!-- JQuery -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/jquery-3.2.1.min.js"></script>
	<!-- Bootstrap -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/bootstrap.js"></script>
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/bootstrap/css/bootstrap.css">
	<!-- Semantic -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/semantic/components/table.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/semantic/components/icon.min.css">
  	<link rel="stylesheet" href="${pageContext.request.contextPath }/semantic/components/breadcrumb.css">
	<!-- nvabar js -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/customize/js/comm.js"></script>
  	<!-- load transition -->
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/customize/css/load.css">
 	<!-- menu  -->
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/customize/css/menu.css">
  </head>
  
  <body>
  	<jsp:include page="../commons/headerNavbar.jsp" />
	<!-- 网页中部 -->
	<div class="container-fluid mybody">
  		<%-- <jsp:include page="../commons/bodyMenu.jsp" /> --%>
  		<div class="main">
	    <div class="container-fluid well mycontext">
		    
	        <!-- breadcrumb -->
	        <div class="ui large breadcrumb" style="margin:5px 0px 15px 25px;">
	          <c:forEach items="${currNavbar!=null?currNavbar:commonNavbar}" var="currNB">
	          	<c:if test="${currNB.selected}">
	          		<a class="section" href="${currNB.link}">${currNB.name}</a>
	          	</c:if>
	          </c:forEach>
	          <i class="right chevron icon divider"></i>
	          <c:forEach items="${currMenu.listGroups}" var="lg">
	            <c:forEach items="${lg.items}" var="item">
	          		<c:if test="${item.selected}">
	          			<a class="section" href="${lg.items[0].link}">${lg.name}</a>
	          			<i class="right chevron icon divider"></i>
	          			<a class="section" href="${item.link}">${item.name}</a>
	          		</c:if>
		        </c:forEach>
	          </c:forEach>
	          <i class="right chevron icon divider"></i>
	          <div class="active section">员工考勤信息</div>
	        </div>
	        <!-- end breadcrumb -->
	        
	        
	      <!-- search header -->
	      <div class="container-fluid" style="border-top:1px dashed #87CEEB;border-bottom:1px dashed #87CEEB;border-radius:20px;padding:20px 0px 10px 0px;max-width:90%;">
	      <form method="post" action="${pageContext.request.contextPath }/pers/findAttendanceInAaOf.html">
	      	<!-- 页标 -->
	      	<input type="hidden" name="page.pageIndex" value="${page.pageIndex}">
	        <div class="form-group form-inline text-center col-md-offset-1 col-md-10">
	          <div class="form-group col-md-4">
	              <label class="control-label">姓 名：</label>
	              <input type="text" class="form-control" placeholder="Like Staff Name" name="attendance.staff.name" default="${attendance.staff.name}">
	          </div>
	          <div class="form-group col-md-4">
	              <label class="control-label">工 号：</label>
	              <input type="text" class="form-control" placeholder="Like Staff No" name="attendance.staff.no" default="${attendance.staff.no }">
	          </div>
	          <div class="form-group col-md-4">
	              <label class="control-label">类 型：</label>
	              <select class="form-control" style="width:196px;" id="ATTENDANCE_TYPE" name="attendance.dataDictionary.id" sele="${attendance.dataDictionary.id}" >
	                <option value="-1">全部</option>
	              </select>
	          </div>
	          <!-- 异步加载字典数据 -->
	          <script type="text/javascript">
	          		//异步加载字典数据方法
	          		dataDictionary("ATTENDANCE_TYPE",function(data){
        				for(var dd in data){
        					var val = data[dd];
        					$("#ATTENDANCE_TYPE").append("<option value='"+val.id+"'>"+val.value+"</option>");
        				}
        				var sele = $("#ATTENDANCE_TYPE").attr("sele");
        				if(sele!= null && sele.length > 0)
        					$("#ATTENDANCE_TYPE").val(sele).change();
          			});
	          </script>
	        </div>
	        <div class="form-group form-inline text-center col-md-offset-1 col-md-10">
	          <div class="form-group ">
	              <label class="control-label">查询时间：</label>
	              <input type="datetime-local" class="form-control" name="start" default="<fmt:formatDate value="${start }" pattern="yyyy-MM-dd"  />T<fmt:formatDate value="${start }" pattern="HH:mm:ss" />">
	              <!-- <input type="time" class="form-control"> -->
	              <label class="control-label" style="margin:0px 10px;">至</label>
	              <input type="datetime-local" class="form-control" name="stop" default="<fmt:formatDate value="${stop }" pattern="yyyy-MM-dd" />T<fmt:formatDate value="${stop }" pattern="HH:mm:ss" />">
	              <!-- <input type="time" class="form-control"> -->
	          </div>
	        </div>
	        <div class="form-group form-inline text-center col-md-offset-1 col-md-10">
	          <div class="form-group col-md-offset-3 col-md-3">
	            <button type="submit" class="btn btn-info btn-block"><span style="letter-spacing:40px;">查</span>询</button>
	          </div>
	          <div class="form-group col-md-3">
	            <button type="reset" class="btn btn-warning btn-block"><span style="letter-spacing:40px;">重</span>置</button>
	          </div>
	        </div>
	      </form>
	      </div>
	
	
	      <!-- attendance info -->
	      <div class="container-fluid" style="margin-top:20px;border-left:1px dashed #008080;border-right:1px dashed #008080;border-radius:20px;padding:30px 40px 0px;max-width:95%;">
	      <table class="ui blue selectable celled table">
	        <thead>
	          <tr>
	            <th colspan="5" class="h4 center aligned">员工考勤信息</th>
	          </tr>
	          <tr>
	            <th>工号 / No</th>
	            <th>姓名 / Name</th>
	            <th>日期 / Date</th>
	            <th>类型 / Type</th>
	            <th class="center aligned">操作 / Operating</th>
	          </tr>
	        </thead>
	        <tbody>
	        <c:forEach items="${atteList}" var="atte">
	        	<tr>
		            <td>${atte.staff.no}</td>
		            <td>${atte.staff.name}</td>
		            <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${atte.time}" /></td>
		            <c:choose>
		            	<c:when test="${atte.dataDictionary.id == 27}">
			            	<td class="info">${atte.dataDictionary.value}</td>
		            	</c:when>
		            	<c:when test="${atte.dataDictionary.id == 28 || atte.dataDictionary.id == 29}">
			            	<td class="warning">${atte.dataDictionary.value}</td>
		            	</c:when>
		            	<c:when test="${atte.dataDictionary.id == 30}">
			            	<td class="danger">${atte.dataDictionary.value}</td>
		            	</c:when>
		            	<c:when test="${atte.dataDictionary.id == 31}">
			            	<td class="success">${atte.dataDictionary.value}</td>
		            	</c:when>
		            </c:choose>
		            <td class="center aligned">
		              <a href="#" title="编辑"><i class="edit icon text-success"></i></a>
		              <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
		            </td>
		        </tr>
	        </c:forEach>
	         <!--  <tr>
	            <td>1</td>
	            <td>No Action</td>
	            <td>None</td>
	            <td class="info">正常</td>
	            <td class="center aligned">
	              <a href="#" title="编辑"><i class="edit icon text-success"></i></a>
	              <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	            </td>
	          </tr>
	           -->
	        </tbody>
	      </table>
	      <!-- 分页 -->
	      <!-- 设置页标前后显示的页数 -->
	      <c:set var="count" value="2" />
	      <div class="text-center">
	        <ul class="pagination">
	        	<c:if test="${page.pageIndex > 1}">
	            	<li><a index="${page.pageIndex-1}">上一页</a></li>
	            </c:if>
	            <!-- 页前页标 -->
	            <c:choose>
	            	<c:when test="${page.pageIndex - count > 0}">
	            		<c:if test="${page.pageIndex - count > 1}">
				            <li><a index="1">1</a></li>
				            <li><a >···</a></li>
	            		</c:if>
		            	<c:forEach var="index" begin="${page.pageIndex - count}" end="${page.pageIndex - 1}" >
		           			<li><a index="${index}">${index}</a></li>
		            	</c:forEach>
	            	</c:when>
	            	<c:when test="${page.pageIndex - count == 0}">
		            	<c:forEach var="index" begin="${page.pageIndex - count + 1}" end="${page.pageIndex - 1}" >
		           			<li><a index="${index}">${index}</a></li>
		            	</c:forEach>
	            	</c:when>
	            	<c:when test="${page.pageIndex - count < 0 && page.pageIndex - 1 > 1}">
		            	<c:forEach var="index" begin="1" end="${page.pageIndex - 1}" >
		           			<li><a index="${index}">${index}</a></li>
		            	</c:forEach>
	            	</c:when>
	            </c:choose>
	            <!-- 当前页 -->
	            <li class="active"><a>${page.pageIndex}</a></li>
	            <!-- 页后页标 -->
	            <c:choose>
	            	<c:when test="${page.pageIndex + count < page.pageCount}">
	            		<c:forEach var="index" begin="${page.pageIndex +  1}" end="${page.pageIndex + count}" >
		           			<li><a index="${index}">${index}</a></li>
		            	</c:forEach>
			            <li><a >···</a></li>
			            <li><a index="${page.pageCount}">${page.pageCount}</a></li>
	            	</c:when>
	            	<c:when test="${page.pageIndex + count == page.pageCount}">
	            		<c:forEach var="index" begin="${page.pageIndex +  1}" end="${page.pageCount}" >
		           			<li><a index="${index}">${index}</a></li>
		            	</c:forEach>
	            	</c:when>
	            	<c:when test="${page.pageIndex + count > page.pageCount && page.pageIndex + 1 <= page.pageCount}">
	            		<c:forEach var="index" begin="${page.pageIndex +  1}" end="${page.pageCount}" >
		           			<li><a index="${index}">${index}</a></li>
		            	</c:forEach>
	            	</c:when>
	            </c:choose>
	            <!-- 下一页 -->
	            <c:if test="${page.pageIndex < page.pageCount}">
	           		<li><a index="${page.pageIndex+1}">下一页</a></li>
	            </c:if>
	          </ul>
	      </div>
	      <!-- end 分页  -->
	      </div>
	
	    </div>
	  </div>
	</div>
  </body>
</html>
