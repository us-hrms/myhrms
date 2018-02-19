
//异步加载字典数据
function dataDictionary(tableCloumn,fun){
	$.ajax({
		url:"${pageContext.request.contextPath }/getDateDictsByAjaxInDda.do",
		data:"dataDictionary.tableColumn="+tableCloumn,
		type:"post",
		dataType:"json",
		success:function(data){
			fun(data);
		}
	});
};
$(function(){
  
  //搜索结果模型初始化
  $("form [data-toggle=modal]").click(function(){
	var tg = $(this).attr("data-target");
	$(tg).modal();
    return false;
  });
  $("a[data-toggle=modal]").click(function(){
	 //如果需要登录 将a标签的href属性值放到登录表单上 以便登录后跳转
	var tg = $(this).attr("data-target");
	$(tg).children("form").attr("url",$(this).attr("href"));
	$(this).attr("href", "#");
  });
	//分页 页标单击事件
	$(".pagination li").click(function(){
		var index = $(this).children().attr("index");
		if(index == null)
			return true;
		console.log(index);
		$("input[name='page.pageIndex']").val(index).parents("form").submit();
	});
	//表单上次数据显示
	$("input").each(function(index,element){
		var ipt = $(element).attr("default");
		if(ipt!=null && ipt.length>0)
			$(element).val(ipt);
	});
});