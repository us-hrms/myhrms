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
      //部门下拉框改变事件
      $("[name='staffCertificate.staff.department.id']").change(function(){
      	/* 异步获得职位 */
       	var did = $(this).val();
       	position(did,function(data){
       		var target = $("[name='staffCertificate.staff.position.id']");
       		$(target).empty().append("<option value='-1'>全部</option>");
	 		for(var idx in data){
	 			var posi = data[idx];
	  			target.append("<option value='"+posi.id+"'>"+posi.name+"</option>");
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
	          <div class="active section">员工证书信息</div>
	        </div>
	        <!-- end breadcrumb -->
	        
		      <!-- search header -->
		      <div class="container-fluid" style="border-top:1px dashed #87CEEB;border-bottom:1px dashed #87CEEB;border-radius:20px;padding:20px 0px 10px 0px;max-width:90%;">
		      <form  action="${pageContext.request.contextPath }/staff/findStaffCertificateManagerInSceaOf.html" method="post">
	      	<!-- 页标 -->
	      	<input type="hidden" name="page.pageIndex" value="${page.pageIndex}">
		        <div class="form-group form-inline text-center col-md-offset-1 col-md-10">
		          <div class="form-group col-md-4">
		              <label class="control-label">证 书 编 号：</label>
		              <input type="text" class="form-control" placeholder="Like Certificate No" name="staffCertificate.no" default="${staffCertificate.no }">
		          </div>
		          <div class="form-group col-md-4">
		              <label class="control-label">员 工 工 号：</label>
		              <input type="text" class="form-control" placeholder="Like Staff No" name="staffCertificate.staff.no" default="${staffCertificate.staff.no }">
		          </div>
		          <div class="form-group col-md-4">
		              <label class="control-label">员 工 名 称：</label>
		              <input type="text" class="form-control" placeholder="Like Staff Name" name="staffCertificate.staff.name" default="${staffCertificate.staff.name }">
		          </div>
		        </div>
		        <div class="form-group form-inline text-center col-md-offset-1 col-md-10">
		          <div class="form-group col-md-4">
		              <label class="control-label">所 属 部 门：</label>
		              <select class="form-control" style="width:196px;" name="staffCertificate.staff.department.id" sele="${staffCertificate.staff.department.id }">
		                <option value="-1">全部</option>
		              </select>
		          </div>
	            <script type="text/javascript">
	            	department(function(data){
	            		var target = $("[name='staffCertificate.staff.department.id']");
				   		for(var idx in data){
				   			var dept = data[idx];
				    		target.append("<option value='"+dept.id+"'>"+dept.name+"</option>");
				    	}
				    	var sele = $(target).attr("sele");
				      	if(sele!= null && sele.length > 0)
				       		$(target).val(sele).change();
	            	});
	            </script>
		          <div class="form-group col-md-4">
		              <label class="control-label">所 属 职 位：</label>
		              <select class="form-control" style="width:196px;" name="staffCertificate.staff.position.id" sele="${staffCertificate.staff.position.id }">
		                <option value="-1">全部</option>
		              </select>
		          </div>
	            <script type="text/javascript">
	            	/* 异步获得职位 */
	            	var did = $("[name='staffCertificate.staff.department.id']").attr("sele");
	            	position(did,function(data){
	            		var target = $("[name='staffCertificate.staff.position.id']");
				   		for(var idx in data){
				   			var posi = data[idx];
				    		target.append("<option value='"+posi.id+"'>"+posi.name+"</option>");
				    	}
				    	var sele = $(target).attr("sele");
				      	if(sele!= null && sele.length > 0)
				       		$(target).val(sele).change();
	            	});
	            </script>
		          <div class="form-group col-md-4">
		              <label class="control-label">所 持 证 书：</label>
		              <select class="form-control" style="width:196px;" name="staffCertificate.certificate.id" sele="${staffCertificate.certificate.id }">
		                <option value="-1">所有</option>
		              </select>
		          </div>
	            <script type="text/javascript">
	            	/* 异步获得职证书*/
	            	certificate(function(data){
	            		var target = $("[name='staffCertificate.certificate.id']");
				   		for(var idx in data){
				   			var cert = data[idx];
				    		target.append("<option value='"+cert.id+"'>"+cert.name+"</option>");
				    	}
				    	var sele = $(target).attr("sele");
				      	if(sele!= null && sele.length > 0)
				       		$(target).val(sele).change();
	            	});
	            </script>
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
		              <th colspan="6" class="h4 center aligned"><span style="letter-spacing:20px;">员工证书信</span>息</th>
		            </tr>
		            <tr>
		              <th>员工 / No-Name</th>
		              <th>岗位 / Dept-Posi </th>
		              <th>证书号 / No</th>
		              <th>证书名称 / CName</th>
		              <th>获得日期 / Date</th>
		              <th class="center aligned">操作 / Operating</th>
		            </tr>
		          </thead>
		          <tbody>
			          <c:forEach items="${staffCertificates }" var="tsc">
			            <tr>
			              <td>${tsc.staff.no } - ${tsc.staff.name }</td>
			              <td>${tsc.staff.department.name } - ${tsc.staff.position.name }</td>
			              <td>${tsc.no }</td>
			              <td>${tsc.certificate.name }</td>
			              <td><fmt:formatDate pattern="yyyy年MM月dd日" value="${tsc.date }" /></td>
			              <td class="center aligned">
			                <a href="#" title="查看详情"><i class="unhide icon text-info"></i></a>
			                <a href="#" title="查看证书"><i class="newspaper icon text-info"></i></a>
			                <a href="#" title="修改"><i class="edit icon text-success"></i></a>
			                <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
			              </td>
			            </tr>
			          </c:forEach>
		           <!--  <tr>
		              <td>1</td>
		              <td>No Action</td>
		              <td>None</td>
		              <td>None</td>
		              <td>None</td>
		              <td class="center aligned">
		                <a href="#" title="查看详情"><i class="unhide icon text-info"></i></a>
		                <a href="#" title="查看证书"><i class="newspaper icon text-info"></i></a>
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
		              <td class="center aligned disabled">
		                <a href="#" title="查看详情"><i class="unhide icon text-info"></i></a>
		                <a href="#" title="查看证书"><i class="newspaper icon text-info"></i></a>
		                <a href="#" title="修改"><i class="edit icon text-success"></i></a>
		                <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
		              </td>
		            </tr> -->
		            
		          </tbody>
		          <tfoot class="full-width">
		            <tr>
		              <th colspan="6">
		                <div class="col-md-2 col-md-offset-5">
		                  <button class="btn btn-info btn-block" data-toggle="modal" data-target="#newCertificate"><span style="letter-spacing:10px;">新增证</span>书</button>
		                </div>
		              </th>
		            </tr>
		          </tfoot>
		        </table>
		
		        <!-- 新增证书 Model -->
		        <div class="modal fade" id="newCertificate" tabindex="-1" role="dialog" aria-labelledby="certificateModel" style="margin-top:230px;">
		          <div class="modal-dialog" role="document">
		            <div class="modal-content">
		              <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		                <h4 class="modal-title" id="certificateModel">添加新证书</h4>
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
	          <div class="active section">编辑员工证书信息</div>
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
