<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=utf-8"  
    pageEncoding="utf-8"%>  


<script>
$(function(){
     
	/* <c:if test="${!empty id}">
    $("#name").val($("#name").val()+"${id}");
    console.log("账号自动填充");
    </c:if> */
     
   /*  <c:if test="${!empty msg}">
    
    $("span.errorMessage").html("${msg}");
    $("div.loginErrorMessageDiv").show();     
    console.log("账号密码错误提醒");
    </c:if> */
    
    $("form.loginForm").submit(function(){
        if(0==$("#name").val().length||0==$("#password").val().length){
            $("span.errorMessage").html("请输入账号密码");
            $("div.loginErrorMessageDiv").show();           
            console.log("账号密码为空");
            return false;
        }
        console.log("账号密码不为空");
        return true;
    });
     
    $("form.loginForm input").keyup(function(){
        $("div.loginErrorMessageDiv").hide();   
        console.log("隐藏警告信息");
    });
    
})
</script>
<style>
</style>




<div class="loginDiv">
	<div class="header">
		<div class="nav">
			<div class="logo"></div>
			<div class="entry">

				<span class="state">记录每一刻</span> <a href="http://www.wten.cn/"
					target="_blank">访问博客</a>


			</div>

		</div>
	</div>

	<!--登陆框-->
	<form class="loginForm" action="forelogin" method="post">
		<div class="loginSmallDiv" id="loginSmallDiv">
			<!--错误提示-->
			<div class="loginErrorMessageDiv">
				<div class="alert alert-danger alert-dismissible">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close"></button>
					<span class="errorMessage"></span>
				</div>
			</div>

			<div class="login_account_text">账户登录</div>
			<!--账号-->
			<div class="loginInput">
				<span class="loginInputIcon"> <span
					class="glyphicon glyphicon-user"></span> </span> <input type="text"
					placeholder="请输入用户名" name="name" id="name">
			</div>
			<!--密码-->
			<div class="loginInput">
				<span class="loginInputIcon"> <span
					class="glyphicon glyphicon-lock"></span> </span> <input type="password"
					placeholder="密码" name="password" id="password">
			</div>
			<!--身份验证-->
			<div>
				<a href="#nowhere" class="notImplementLink">忘记登录密码</a> <a
					class="pull-right" href="#nowhere">也没办法找回</a>
			</div>
			<div style="margin-top:20px;">
				<button type="submit" class="btn btn-block blueButton ">登陆</button>
			</div>
		</div>
	</form>
</div>