<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
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
	<!-- nvabar js -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/customize/js/comm.js"></script>
	<!-- login.js -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/customize/js/login.js"></script>
  	<!-- load transition -->
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/customize/css/load.css">
 	<!-- menu  -->
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/customize/css/menu.css">
  </head>
  
  <body>
  	<jsp:include page="commons/headerNavbar.jsp" />
    <div class="container well" style="max-width:30%;margin-top:80px;padding:50px;">
	  <h2 class="text-center">员工登录</h2>
	  <div class="alert alert-info text-center login-alert">
	    请填入工号和密码
	  </div>
	  <form url="home.html">
	    <div class="form-group">
	      <label for="no" class="control-label" style="letter-spacing:20px;cursor:pointer;">工号</label>
	      <div class="input-group">
	        <div class="input-group-addon">
	          <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
	        </div>
	        <input type="text" class="form-control" name="staff.no" id="no" placeholder="No"  data-container="body" data-toggle="popover" data-placement="top" data-content="请填写工号">
	      </div>
	    </div>
	    <div class="form-group">
	      <label for="password" class="control-label" style="letter-spacing:20px;cursor:pointer;">密码</label>
	      <div class="input-group">
	        <div class="input-group-addon">
	          <span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
	        </div>
	        <input type="password" name="staff.password" class="form-control" id="password" placeholder="Password" data-container="body" data-toggle="popover" data-placement="top" data-content="请填写密码" >
	      </div>
	    </div>
	    <!-- <div class="checkbox">
	      <label>
	        <input type="checkbox"> Check me out
	      </label>
	    </div> -->
	    <button type="submit" class="btn btn-primary btn-block staff-login-btn">登录</button>
	  </form>
	</div>
  </body>
</html>
