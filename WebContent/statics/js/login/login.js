/**
 * Created by bdqn on 2016/5/3.
 */
//登录的方法
function login(){
    var loginName=$("#loginName").val();
    var password=$("#password").val();
    $.ajax({
        url:contextPath+"/easybuy_user_Servlet",
        method:"post",
        data:{loginName:loginName,password:password,action:"Login"},
        success:function(jsonStr){
            var result=eval("("+jsonStr+")");
            if(result==1){
            	  showMessage("登录成功")
                window.location.href=contextPath+"/LOP?action=tiao";
            }else{
                showMessage(result.message)
            }
        }
    })
}