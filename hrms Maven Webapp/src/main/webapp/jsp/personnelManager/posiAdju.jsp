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
	<!-- tool js -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/customize/js/tool.js"></script>
  	<!-- load transition -->
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/customize/css/load.css">
 	<!-- menu  -->
 	<link rel="stylesheet" href="${pageContext.request.contextPath }/customize/css/menu.css">
 	
 	<script type="text/javascript">
 	$(function(){
      // 职位所属部门提示框初始化
      $('[data-toggle="popover"]').popover({trigger:'hover',placement:'bottom',title:'所属部门',
        content:function(){
          return $(this).text();
        }
      });
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
	<div class="container-fluid" style="max-width:96%;">
  		<jsp:include page="../commons/bodyMenu.jsp" />
		<div class="col-md-10 main">
	      <div class="container-fluid well" id="container-Info">
	        <!-- search header -->
	        <div class="container-fluid" style="border-top:1px dashed #87CEEB;border-bottom:1px dashed #87CEEB;border-radius:20px;padding:20px 0px 10px 0px;max-width:90%;">
	        <form >
	          <div class="form-group form-inline text-center col-md-offset-1 col-md-10">
	            <div class="form-group col-md-4">
	                <label class="control-label">员 工 编 号：</label>
	                <input type="text" class="form-control" placeholder="Like Staff No">
	            </div>
	            <div class="form-group col-md-4">
	                <label class="control-label">员 工 姓 名：</label>
	                <input type="text" class="form-control" placeholder="Like Staff Name">
	            </div>
	            <div class="form-group col-md-4">
	                <label class="control-label">所 属 部 门：</label>
	                <select class="form-control" style="width:196px;">
	                  <option value="-1">全部</option>
	                  <option>部门1</option>
	                  <option>部门2</option>
	                  <option>部门3</option>
	                  <option>部门4</option>
	                </select>
	            </div>
	          </div>
	          <!-- <div class="form-group form-inline text-center col-md-offset-1 col-md-10">
	            <div class="form-group ">
	                <label class="control-label">查询时间：</label>
	                <input type="datetime-local" class="form-control">
	                <label class="control-label" style="margin:0px 10px;">至</label>
	                <input type="datetime-local" class="form-control">
	            </div>
	          </div> -->
	          <div class="form-group form-inline text-center col-md-offset-1 col-md-10">
	            <div class="form-group col-md-offset-4 col-md-4">
	              <button class="btn btn-info btn-block" data-toggle="modal" data-target="#findResult"><span style="letter-spacing:30px;">查</span>询</button>
	            </div>
	          </div>
	        </form>
	        </div>
	        <!-- attendance info -->
	        <div class="container-fluid" style="margin-top:20px;border-left:1px dashed #008080;border-right:1px dashed #008080;border-radius:20px;padding:30px 40px 0px;max-width:95%;">
	          <table class="ui blue selectable celled table">
	            <thead>
	              <tr>
	                <th colspan="5" class="h4 center aligned"><span style="letter-spacing:20px;">职位调整信</span>息</th>
	              </tr>
	              <tr>
	                <th>原职位 / Position</th>
	                <th>现职位 / Position</th>
	                <th>调整类型 / Type</th>
	                <th>调整日期 / Staff</th>
	                <th class="center aligned">操作 / Operating</th>
	              </tr>
	            </thead>
	            <tbody>
	              <tr>
	                <td data-container="body" data-toggle="popover" data-placement="top">1</td>
	                <td data-container="body" data-toggle="popover" data-placement="top">No Action</td>
	                <td  >None</td>
	                <!-- data-content="Vivamus sagittis lacus vel augue  laoreet rutrum faucibus." -->
	                <td>None</td>
	                <td class="center aligned">
	                  <a href="#" title="查看"><i class="unhide icon text-info"></i></a>
	                  <a href="#" title="修改"><i class="edit icon text-success"></i></a>
	                  <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	                </td>
	              </tr>
	              <tr>
	                <td data-container="body" data-toggle="popover" data-placement="top">2</td>
	                <td data-container="body" data-toggle="popover" data-placement="top">Approved</td>
	                <td>Requires call</td>
	                <td>None</td>
	                <td class="center aligned disabled">
	                  <a href="#" title="查看"><i class="unhide icon text-info"></i></a>
	                  <a href="#" title="修改"><i class="edit icon text-success"></i></a>
	                  <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	                </td>
	              </tr>
	              <tr>
	                <td data-container="body" data-toggle="popover" data-placement="top">3</td>
	                <td data-container="body" data-toggle="popover" data-placement="top">Denied</td>
	                <td >None</td>
	                <td>None</td>
	                <td class="center aligned">
	                  <a href="#" title="查看"><i class="unhide icon text-info"></i></a>
	                  <a href="#" title="修改"><i class="edit icon text-success"></i></a>
	                  <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	                </td>
	              </tr>
	              <tr>
	                <td data-container="body" data-toggle="popover" data-placement="top">4</td>
	                <td data-container="body" data-toggle="popover" data-placement="top">No Action</td>
	                <td >None</td>
	                <td>None</td>
	                <td class="center aligned">
	                  <a href="#" title="查看"><i class="unhide icon text-info"></i></a>
	                  <a href="#" title="修改"><i class="edit icon text-success"></i></a>
	                  <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	                </td>
	              </tr>
	              <tr>
	                <td data-container="body" data-toggle="popover" data-placement="top">5</td>
	                <td data-container="body" data-toggle="popover" data-placement="top">Approved</td>
	                <td >Requires call</td>
	                <td>None</td>
	                <td class="center aligned">
	                  <a href="#" title="查看"><i class="unhide icon text-info"></i></a>
	                  <a href="#" title="修改"><i class="edit icon text-success"></i></a>
	                  <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	                </td>
	              </tr>
	              <tr>
	                <td data-container="body" data-toggle="popover" data-placement="top">6</td>
	                <td data-container="body" data-toggle="popover" data-placement="top">Denied</td>
	                <td >None</td>
	                <td>None</td>
	                <td class="center aligned">
	                  <a href="#" title="查看"><i class="unhide icon text-info"></i></a>
	                  <a href="#" title="修改"><i class="edit icon text-success"></i></a>
	                  <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	                </td>
	              </tr>
	              <tr>
	                <td data-container="body" data-toggle="popover" data-placement="top">7</td>
	                <td data-container="body" data-toggle="popover" data-placement="top">Denied</td>
	                <td >None</td>
	                <td>None</td>
	                <td class="center aligned">
	                  <a href="#" title="查看"><i class="unhide icon text-info"></i></a>
	                  <a href="#" title="修改"><i class="edit icon text-success"></i></a>
	                  <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	                </td>
	              </tr>
	              <tr>
	                <td data-container="body" data-toggle="popover" data-placement="top">8</td>
	                <td data-container="body" data-toggle="popover" data-placement="top">Denied</td>
	                <td >None</td>
	                <td>None</td>
	                <td class="center aligned">
	                  <a href="#" title="查看"><i class="unhide icon text-info"></i></a>
	                  <a href="#" title="修改"><i class="edit icon text-success"></i></a>
	                  <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	                </td>
	              </tr>
	              <tr>
	                <td data-container="body" data-toggle="popover" data-placement="top">9</td>
	                <td data-container="body" data-toggle="popover" data-placement="top">Denied</td>
	                <td >None</td>
	                <td>None</td>
	                <td class="center aligned">
	                  <a href="#" title="查看"><i class="unhide icon text-info"></i></a>
	                  <a href="#" title="修改"><i class="edit icon text-success"></i></a>
	                  <a href="#" title="删除"><i class="trash outline icon text-danger"></i></a>
	                </td>
	              </tr>
	            </tbody>
	            <tfoot class="full-width">
	              <tr>
	                <th colspan="5">
	                  <!-- <div class="ui right floated small primary labeled icon button"><i class="user icon"></i> 新增部门 </div> -->
	                  <div class="col-md-2 col-md-offset-5">
	                    <button class="btn btn-info btn-block" data-toggle="modal" data-target="#newDept"><span style="letter-spacing:10px;">新增调整信</span>息</button>
	                  </div>
	                </th>
	              </tr>
	            </tfoot>
	          </table>
	
	          <!-- 查询 Model -->
	          <div class="modal fade" id="findResult" tabindex="-1" role="dialog" aria-labelledby="findResultModel" style="margin-top:230px;">
	            <div class="modal-dialog" role="document">
	              <div class="modal-content">
	                <div class="modal-header">
	                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                  <h4 class="modal-title" id="findResultModel">查询结果</h4>
	                </div>
	                <div class="modal-body"  style="padding:30px 0px;">
	                  <!-- loading -->
	                  <div class="transition-loader">
	                    <div class="transition-loader-inner">
	                      <label></label>
	                      <label></label>
	                      <label></label>
	                      <label></label>
	                      <label></label>
	                      <label></label>
	                    </div>
	                  </div>
	                </div>
	                <div class="modal-footer">
	                  <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	                  <button type="button" class="btn btn-primary">确认</button>
	                </div>
	              </div>
	            </div>
	          </div>
	
	          <!-- 新增调整信息 Model -->
	          <div class="modal fade" id="newDept" tabindex="-1" role="dialog" aria-labelledby="deptModel" style="margin-top:230px;">
	            <div class="modal-dialog" role="document">
	              <div class="modal-content">
	                <div class="modal-header">
	                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	                  <h4 class="modal-title" id="deptModel">职位调整</h4>
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
	      <div class="container-fluid well" id="container-Edit">
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
