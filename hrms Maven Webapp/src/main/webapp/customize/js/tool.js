/*
    显示和影藏内容
    target  触发事件的目标
    hidden 要影藏的控件
    show  要显示的控件
*/
function mySwitch(hidden,show){
  $(hidden).animate({width:'70px',height:'70px',marginTop:'200px',borderRadius:'50%'},800,function(){
    $(show).css('display','block').animate({width:'70px',height:'70px',marginTop:'-500px',borderRadius:'50%'},100)
      .animate({width:'70px',height:'70px',marginTop:'200px',borderRadius:'50%'},1000)
      .animate({width:'100%',height:'100%',marginTop:'0px',borderRadius:'4px'},1000);
  })
  .animate({width:'50px',height:'50px',marginTop:'-100px',borderRadius:'50%'},600,function(){$(this).hide();});
}
//原型
// $(function(){
//   $(".edit.icon").click(function(){
//     // 动画
//     $("#container-Info").animate({width:'70px',height:'70px',marginTop:'200px',borderRadius:'50%'},800,function(){
//       $("#container-Edit").css('display','block').animate({width:'70px',height:'70px',marginTop:'-500px',borderRadius:'50%'},100)
//         .animate({width:'70px',height:'70px',marginTop:'200px',borderRadius:'50%'},1000)
//         .animate({width:'100%',height:'100%',marginTop:'0px',borderRadius:'4px'},1000);
//     })
//     .animate({width:'50px',height:'50px',marginTop:'-100px',borderRadius:'50%'},600,function(){$(this).hide();});
//   });
// });
