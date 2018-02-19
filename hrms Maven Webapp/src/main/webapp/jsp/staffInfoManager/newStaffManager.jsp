<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<!-- tool js -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/customize/js/tool.js"></script>
  	<!-- load transition -->
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/customize/css/load.css">
 	<!-- menu  -->
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/customize/css/menu.css">
 	
 	<script type="text/javascript">
 	$(function(){
      //tool.js里面的功能
      $(".edit.icon").click(function(){
        mySwitch("#container-Info","#container-Edit");
        //tomcat 里需要 否则会回到根目录的#页面
        return false;
      });
    });
 	</script>
  </head>
  
  <body>
  	<jsp:include page="../commons/headerNavbar.jsp" />
	<!-- 网页中部 -->
	<div class="container-fluid mybody">
  		<div class="main">
		    <div class="container-fluid well mycontext" id="container-Info">
			    
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
		          <div class="active section">实习员工信息</div>
		        </div>
		        <!-- end breadcrumb -->
		        
		        
		      <!-- search header -->
		      <div class="container-fluid" style="border-top:1px dashed #87CEEB;border-bottom:1px dashed #87CEEB;border-radius:20px;padding:20px 0px 10px 0px;max-width:90%;">
		      <form >
		        <div class="form-group form-inline text-center col-md-offset-1 col-md-10">
		          <div class="form-group col-md-6">
		              <label class="control-label">员 工 工 号：</label>
		              <input type="text" class="form-control" placeholder="Like Staff No">
		          </div>
		          <div class="form-group col-md-6">
		              <label class="control-label">员 工 名 称：</label>
		              <input type="text" class="form-control" placeholder="Like Staff Name">
		          </div>
		        </div>
		        <div class="form-group form-inline text-center col-md-offset-1 col-md-10">
		          <div class="form-group col-md-6">
		              <label class="control-label">实 习 部 门：</label>
		              <select class="form-control" style="width:196px;">
		                <option value="-1">全部</option>
		                <option>部门1</option>
		                <option>部门2</option>
		                <option>部门3</option>
		                <option>部门4</option>
		              </select>
		          </div>
		          <div class="form-group col-md-6">
		              <label class="control-label">实 习 职 位：</label>
		              <select class="form-control" style="width:196px;">
		                <option value="-1">全部</option>
		                <option>职位1</option>
		                <option>职位2</option>
		                <option>职位3</option>
		                <option>职位4</option>
		              </select>
		          </div>
		        </div>
		        <div class="form-group form-inline text-center col-md-offset-1 col-md-10">
		          <div class="form-group col-md-offset-3 col-md-3">
		            <button type="submit" class="btn btn-info btn-block"><span style="letter-spacing:30px;">查</span>询</button>
		          </div>
		          <div class="form-group col-md-3">
		            <button type="reset" class="btn btn-info btn-block"><span style="letter-spacing:30px;">重</span>置</button>
		          </div>
		        </div>
		      </form>
		      </div>
		      <!-- attendance info -->
		      <div class="container-fluid" style="margin-top:20px;border-left:1px dashed #008080;border-right:1px dashed #008080;border-radius:20px;padding:30px 40px 0px;max-width:95%;">
		        <table class="ui blue selectable celled table">
		          <thead>
		            <tr>
		              <th colspan="7" class="h4 center aligned"><span style="letter-spacing:20px;">实习员工信</span>息</th>
		            </tr>
		            <tr>
		              <th>工号 / No</th>
		              <th>姓名 / Name</th>
		              <th>年龄 / Age</th>
		              <th>实习部门 / Dept</th>
		              <th>实习职位 / Position</th>
		              <th>入职日期 / Date</th>
		              <th class="center aligned">操作 / Operating</th>
		            </tr>
		          </thead>
		          <tbody>
		            <tr>
		              <td>1</td>
		              <td>No Action</td>
		              <td>None</td>
		              <td>None</td>
		              <td>None</td>
		              <td>None</td>
		              <td class="center aligned">
		                <a href="#" title="查看详情"><i class="unhide icon text-info"></i></a>
		                <a href="#" title="修改"><i class="edit icon text-success"></i></a>
		                <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
		              </td>
		            </tr>
		            <tr>
		              <td>2</td>
		              <td>Approved</td>
		              <td >Requires call</td>
		              <td>None</td>
		              <td>None</td>
		              <td>None</td>
		              <td class="center aligned disabled">
		                <a href="#" title="查看详情"><i class="unhide icon text-info"></i></a>
		                <a href="#" title="修改"><i class="edit icon text-success"></i></a>
		                <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
		              </td>
		            </tr>
		            <tr>
		              <td>3</td>
		              <td>Denied</td>
		              <td >None</td>
		              <td>None</td>
		              <td>None</td>
		              <td>None</td>
		              <td class="center aligned">
		                <a href="#" title="查看详情"><i class="unhide icon text-info"></i></a>
		                <a href="#" title="修改"><i class="edit icon text-success"></i></a>
		                <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
		              </td>
		            </tr>
		            <tr>
		              <td>4</td>
		              <td>No Action</td>
		              <td >None</td>
		              <td>None</td>
		              <td>None</td>
		              <td>None</td>
		              <td class="center aligned">
		                <a href="#" title="查看详情"><i class="unhide icon text-info"></i></a>
		                <a href="#" title="修改"><i class="edit icon text-success"></i></a>
		                <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
		              </td>
		            </tr>
		            <tr>
		              <td>5</td>
		              <td>Approved</td>
		              <td >Requires call</td>
		              <td>None</td>
		              <td>None</td>
		              <td>None</td>
		              <td class="center aligned">
		                <a href="#" title="查看详情"><i class="unhide icon text-info"></i></a>
		                <a href="#" title="修改"><i class="edit icon text-success"></i></a>
		                <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
		              </td>
		            </tr>
		            <tr>
		              <td>6</td>
		              <td>Denied</td>
		              <td >None</td>
		              <td>None</td>
		              <td>None</td>
		              <td>None</td>
		              <td class="center aligned">
		                <a href="#" title="查看详情"><i class="unhide icon text-info"></i></a>
		                <a href="#" title="修改"><i class="edit icon text-success"></i></a>
		                <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
		              </td>
		            </tr>
		            <tr>
		              <td>7</td>
		              <td>Denied</td>
		              <td >None</td>
		              <td>None</td>
		              <td>None</td>
		              <td>None</td>
		              <td class="center aligned">
		                <a href="#" title="查看详情"><i class="unhide icon text-info"></i></a>
		                <a href="#" title="修改"><i class="edit icon text-success"></i></a>
		                <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
		              </td>
		            </tr>
		            <tr>
		              <td>8</td>
		              <td>Denied</td>
		              <td >None</td>
		              <td>None</td>
		              <td>None</td>
		              <td>None</td>
		              <td class="center aligned">
		                <a href="#" title="查看详情"><i class="unhide icon text-info"></i></a>
		                <a href="#" title="修改"><i class="edit icon text-success"></i></a>
		                <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
		              </td>
		            </tr>
		            <tr>
		              <td>9</td>
		              <td>Denied</td>
		              <td >None</td>
		              <td>None</td>
		              <td>None</td>
		              <td>None</td>
		              <td class="center aligned">
		                <a href="#" title="查看详情"><i class="unhide icon text-info"></i></a>
		                <a href="#" title="修改"><i class="edit icon text-success"></i></a>
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
		
		    <!-- background -->
		    <div class="container-fluid well mycontext" id="container-Edit">
			    
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
		          <div class="active section">实习员工信息</div>
		        </div>
		        <!-- end breadcrumb -->
		        
		      <!-- search header -->
		      <div class="container-fluid" style="border-top:1px dashed #87CEEB;border-bottom:1px dashed #87CEEB;border-radius:20px;padding:20px 0px 10px 0px;max-width:90%;">
		      <form >
		        表单
		      </form>
		      </div>
		      <!-- attendance info -->
		      <div class="container-fluid" style="margin-top:20px;border-left:1px dashed #008080;border-right:1px dashed #008080;border-radius:20px;padding:30px 40px 0px;max-width:95%;">
		        编辑内容区域
		      </div>
		    </div><!-- back -->
		
		  </div>
	</div><!-- 网页中部结尾 -->
  </body>
</html>
