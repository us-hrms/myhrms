<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-md-2 sidebar">
   <!-- 左侧菜单栏 -->
   <div class="well" >
       <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
         <c:forEach items="${currMenu.listGroups}" var="lg">
         	<div class="panel panel-default">
	           <div class="panel-heading" role="tab" id="heading${lg.id}">
	             <h4 class="panel-title">
	               <span class="glyphicon ${lg.icon}" aria-hidden="true"></span>
	               <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse${lg.id}" aria-expanded="" aria-controls="collapse${lg.id}">
	 				${lg.name}
	               </a>
	             </h4>
	           </div>
	           <div id="collapse${lg.id}" class="panel-collapse collapse ${lg.selected?'in':''}" role="tabpanel" aria-labelledby="heading${lg.id}">
	             <ul class="list-group">
	               <c:forEach items="${lg.items}" var="item">
		               <c:choose>
		               	<c:when test="${item.disabled}">
		        	       <li class="list-group-item disabled">${item.name}</li>
		               	</c:when>
		               	<c:otherwise>
		        	       <li class="list-group-item ${item.selected?'choose':''}"><a href="${item.link}">${item.name}</a></li>
		               	</c:otherwise>
		               </c:choose>
	               </c:forEach>
	             </ul>
	           </div>
	         </div>
         </c:forEach>
       </div>
   </div>
 </div>