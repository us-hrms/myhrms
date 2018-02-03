<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<div class="container-fluid" style="max-width:96%;">
  		<jsp:include page="../commons/bodyMenu.jsp" />
  		<div class="col-md-10 main">
	    <div class="container-fluid well">
	      <!-- search header -->
	      <div class="container-fluid" style="border-top:1px dashed #87CEEB;border-bottom:1px dashed #87CEEB;border-radius:20px;padding:20px 0px 10px 0px;max-width:90%;">
	      <form >
	        <div class="form-group form-inline text-center col-md-offset-1 col-md-10">
	          <div class="form-group col-md-4">
	              <label class="control-label">姓 名：</label>
	              <input type="text" class="form-control" placeholder="Like Staff Name">
	          </div>
	          <div class="form-group col-md-4">
	              <label class="control-label">工 号：</label>
	              <input type="text" class="form-control" placeholder="Like Staff No">
	          </div>
	          <div class="form-group col-md-4">
	              <label class="control-label">类 型：</label>
	              <select class="form-control" style="width:196px;">
	                <option value="-1">全部</option>
	                <option>2</option>
	                <option>3</option>
	                <option>4</option>
	                <option>5</option>
	              </select>
	          </div>
	        </div>
	        <div class="form-group form-inline text-center col-md-offset-1 col-md-10">
	          <div class="form-group ">
	              <label class="control-label">查询时间：</label>
	              <input type="datetime-local" class="form-control">
	              <!-- <input type="time" class="form-control"> -->
	              <label class="control-label" style="margin:0px 10px;">至</label>
	              <input type="datetime-local" class="form-control">
	              <!-- <input type="time" class="form-control"> -->
	          </div>
	        </div>
	        <div class="form-group form-inline text-center col-md-offset-1 col-md-10">
	          <div class="form-group col-md-offset-3 col-md-6">
	            <button class="btn btn-info btn-block"><span style="letter-spacing:40px;">查</span>询</button>
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
	          <tr>
	            <td>1</td>
	            <td>No Action</td>
	            <td>None</td>
	            <td class="info">正常</td>
	            <td class="center aligned">
	              <!-- <a href="#" title="编辑"><span class="glyphicon glyphicon-edit text-success" aria-hidden="true"></span></a> -->
	              <a href="#" title="编辑"><i class="edit icon text-success"></i></a>
	              <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	            </td>
	          </tr>
	          <tr>
	            <td>2</td>
	            <td>Approved</td>
	            <td>Requires call</td>
	            <td class="warning">迟到</td>
	            <td class="center aligned disabled">
	              <a href="#" title="编辑"><i class="edit icon text-success"></i></a>
	              <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	            </td>
	          </tr>
	          <tr>
	            <td>3</td>
	            <td>Denied</td>
	            <td>None</td>
	            <td class="warning">早退</td>
	            <td class="center aligned">
	              <a href="#" title="编辑"><i class="edit icon text-success"></i></a>
	              <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	            </td>
	          </tr>
	          <tr>
	            <td>4</td>
	            <td>No Action</td>
	            <td>None</td>
	            <td class="danger">旷工</td>
	            <td class="center aligned">
	              <a href="#" title="编辑"><i class="edit icon text-success"></i></a>
	              <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	            </td>
	          </tr>
	          <tr>
	            <td>5</td>
	            <td>Approved</td>
	            <td>Requires call</td>
	            <td class="success">请假</td>
	            <td class="center aligned">
	              <a href="#" title="编辑"><i class="edit icon text-success"></i></a>
	              <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	            </td>
	          </tr>
	          <tr>
	            <td>6</td>
	            <td>Denied</td>
	            <td>None</td>
	            <td class="info">正常</td>
	            <td class="center aligned">
	              <a href="#" title="编辑"><i class="edit icon text-success"></i></a>
	              <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	            </td>
	          </tr>
	          <tr>
	            <td>7</td>
	            <td>Denied</td>
	            <td>None</td>
	            <td class="info">正常</td>
	            <td class="center aligned">
	              <a href="#" title="编辑"><i class="edit icon text-success"></i></a>
	              <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	            </td>
	          </tr>
	          <tr>
	            <td>8</td>
	            <td>Denied</td>
	            <td>None</td>
	            <td class="info">正常</td>
	            <td class="center aligned">
	              <a href="#" title="编辑"><i class="edit icon text-success"></i></a>
	              <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	            </td>
	          </tr>
	          <tr>
	            <td>9</td>
	            <td>Denied</td>
	            <td>None</td>
	            <td class="info">正常</td>
	            <td class="center aligned">
	              <a href="#" title="编辑"><i class="edit icon text-success"></i></a>
	              <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	            </td>
	          </tr>
	        </tbody>
	      </table>
	      <!-- 分页 -->
	      <div class="text-center">
	        <ul class="pagination">
	          <li><a href="#">上一页</a></li>
	          <li class="active"><a>1</a></li>
	          <li><a href="#">2</a></li>
	          <li><a href="#">3</a></li>
	          <li><a href="#">4</a></li>
	          <li><a href="#">5</a></li>
	          <li><a href="#">下一页</a></li>
	        </ul>
	      </div>
	      </div>
	
	    </div>
	  </div>
	</div>
  </body>
</html>
