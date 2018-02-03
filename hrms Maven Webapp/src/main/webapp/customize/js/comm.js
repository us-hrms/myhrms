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
  
});