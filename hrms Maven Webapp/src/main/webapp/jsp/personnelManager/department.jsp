<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
      // 部门负责人提示框初始化
      $("[data-toggle=popover]").popover({
      	trigger:'hover',
      	placement:'bottom',
      	title:'负责人信息'
      });
      //tool.js里面的功能
      $(".edit.icon").click(function(){
        mySwitch("#container-Info","#container-Edit");
        //tomcat 里需要 否则会回到根目录的#页面
        return false;
      });
      //异步加载部门负责人信息
      $("td[did]").each(function(index,element){
      	var id = $(element).attr("did");
      	$.ajax({
      		url:"${pageContext.request.contextPath }/staff/getDeptStaffByAjaxInSaOf.do",
      		data:"staff.department.id="+id,
      		type:"post",
      		dataType:"json",
      		success:function(data){
      			if(data=='暂无')
      				$(element).text(data);
      			else{
      				var arrContent = [data.length],arrName = [data.length];
      				for(var idx in data){
	      				arrContent[idx] = data[idx].name+"："+data[idx].position.name;
	      				arrName[idx] = data[idx].name;
      				}
	      			$(element).attr("data-content",arrContent.join(" || "));
	      			$(element).text(arrName.join("、"));
      			}
      		}
      	});
      });
    });
 	</script>
  </head>
  
  <body>
  	<jsp:include page="../commons/headerNavbar.jsp" />
	<!-- 网页中部 -->
	<div class="container-fluid mybody">
  		<%-- <jsp:include page="../commons/bodyMenu.jsp" /> --%>
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
         <%--  ${currMenu.listGroups} --%>
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
          <div class="active section">部门信息</div>
        </div>
        <!-- end breadcrumb -->
        
	      <!-- search header -->
	      <div class="container-fluid" style="border-top:1px dashed #87CEEB;border-bottom:1px dashed #87CEEB;border-radius:20px;padding:20px 0px 10px 0px;max-width:90%;">
	      <form method="post" action="${pageContext.request.contextPath }/pers/getDeptInDaOf.html" >
	      	<!-- 页标 -->
	      	<input type="hidden" name="page.pageIndex" value="${page.pageIndex}">
	        <div class="form-group form-inline text-center col-md-offset-1 col-md-10">
	          <div class="form-group col-md-4">
	              <label class="control-label">部 门 名 称：</label>
	              <input type="text" class="form-control" placeholder="Like Dept Name" name="department.name" default="${department.name }">
	          </div>
	          <div class="form-group col-md-4">
	              <label class="control-label">部 门 编 号：</label>
	              <input type="text" class="form-control" placeholder="Dept ID" name="department.id" default="${department.id }">
	          </div>
	          <div class="form-group col-md-4">
	              <label class="control-label">部 门 规 模：</label>
	              <select class="form-control" style="width:196px;" name="count">
	                <option ${count!=null&&count==-1?'selected="selected"':''} value="-1">全部</option>
	                <option ${count!=null&&count==1?'selected="selected"':''} value="1">1~50</option>
	                <option ${count!=null&&count==2?'selected="selected"':''} value="2">51~100</option>
	                <option ${count!=null&&count==3?'selected="selected"':''} value="3">101~150</option>
	                <option ${count!=null&&count==4?'selected="selected"':''} value="4">151+</option>
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
	            <th colspan="5" class="h4 center aligned"><span style="letter-spacing:20px;">部门信</span>息</th>
	          </tr>
	          <tr>
	            <th>编号 / ID</th>
	            <th>部门名称 / Name</th>
	            <th>负责人 / Principal</th>
	            <th>在职人数 / Sum</th>
	            <th class="center aligned">操作 / Operating</th>
	          </tr>
	        </thead>
	        <tbody>
	        	<c:forEach items="${deptList }" var="dept">
	        	  <tr>
		            <td>${dept.id}</td>
		            <td>${dept.name}</td>
		            <td  data-container="body" data-toggle="popover" did="${dept.id}" data-content="nihao" >加载中...</td>
		            <td>${fn:length(dept.staffs) }</td>
		            <td class="center aligned">
		              <a href="#" title="查看"><i class="unhide icon text-info"></i></a>
		              <a href="#" title="修改"><i class="edit icon text-success"></i></a>
		              <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
		            </td>
		          </tr>
	        	</c:forEach>
	          <!-- <tr>
	            <td>1</td>
	            <td>No Action</td>
	            <td  data-container="body" data-toggle="popover">None</td>
	            data-content="Vivamus sagittis lacus vel augue  laoreet rutrum faucibus."
	            <td>25</td>
	            <td class="center aligned">
	              <a href="#" title="查看"><i class="unhide icon text-info"></i></a>
	              <a href="#" title="修改"><i class="edit icon text-success"></i></a>
	              <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	            </td>
	          </tr> -->
	        </tbody>
	        <tfoot class="full-width">
	          <tr>
	            <th colspan="5">
	              <!-- <div class="ui right floated small primary labeled icon button"><i class="user icon"></i> 新增部门 </div> -->
	              <div class="col-md-2 col-md-offset-5">
	                <button class="btn btn-info btn-block" data-toggle="modal" data-target="#newDept"><span style="letter-spacing:10px;">新增部</span>门</button>
	              </div>
	            </th>
	          </tr>
	        </tfoot>
	      </table>
	      <!-- 新增部门 Model -->
	      <div class="modal fade" id="newDept" tabindex="-1" role="dialog" aria-labelledby="deptModel" style="margin-top:230px;">
	        <div class="modal-dialog" role="document">
	          <div class="modal-content">
	            <div class="modal-header">
	              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	              <h4 class="modal-title" id="deptModel">添加新部门</h4>
	            </div>
	            <div class="modal-body">
	              ...
	            </div>
	            <div class="modal-footer">
	              <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	              <button type="button" class="btn btn-primary">添加</button>
	            </div>
	          </div>
	        </div>
	      </div>
	      
	      
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
	
	
	    <!-- background -->
	    <div class="container-fluid well" id="container-Edit">
	    
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
          <div class="active section">编辑部门信息</div>
        </div>
        <!-- end breadcrumb -->
        
	      <!-- search header -->
	      <div class="container-fluid" style="border-top:1px dashed #87CEEB;border-bottom:1px dashed #87CEEB;border-radius:20px;padding:20px 0px 10px 0px;max-width:90%;">
	      <form >
	        内容头部
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
