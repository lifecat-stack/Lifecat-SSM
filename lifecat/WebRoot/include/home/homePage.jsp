<%@page import="srsjava.bean.UserMsg"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@page import="srsjava.bean.*"%>

<script>
	$(function() {

		$("div[status]").hide();
		$("div[status=diary-show]").show();
		console.log("运行隐藏和显示表格");

		$("a[status]").click(function() {
			var status = $(this).attr("status");
			console.log(status);
			$("div[status]").hide();
			$("div[status=" + status + "]").show();
			//由于双引号没加，造成编译错误
			$("div.dataType li").removeClass("active");
			$(this).parent("li").addClass("active");
		});

	});
</script>

<style>
.msg {
	position: relative;
	left: 100px;
	top: 20px;
	width: 100%;
	height: 20px;
	z-index: 99;
}

.modal {
	position: relative;
	left: 100px;
	top: 50px; 
	width: 400px;
	display: block;
}
</style>

<!-- top-页面状态栏 -->
<div class="container">
	<div class="jumbotron " status="information">
		<h1>个人信息</h1>
		<p>独一无二的我。</p>
	</div>
	<div class="jumbotron " status="diary-show">
		<h1>成长历程</h1>
		<p>每一分，都在成长。</p>
	</div>
	<div class="jumbotron " status="image-show">
		<h1>成长相册</h1>
		<p>记录美好时刻。</p>
	</div>
</div>

<!-- left-页面切换栏 -->
<div class="container">
	<div class="row">
		<div class="col-md-2  dataType">
			<ul class="nav nav-pills nav-stacked">
				<li class="" role="presentation"><a href="#"
					status="information">用户信息</a>
				</li>

				<li role="presentation" class="active"><a href="#"
					status="diary-show">成长日记</a>
				</li>

				<li role="presentation" class=""><a href="#"
					status="image-show">相册集</a>
				</li>

			</ul>
		</div>
	</div>
	<!-- 获取UserMsg对象 -->
	<%
		UserMsg usermsg = new UserMsg();
		usermsg.setId(100);
		usermsg.setNickname("汪十号");
		usermsg.setSex("男");
		usermsg.setAge("21");
		usermsg.setBirthday("1997.1.15");
		usermsg.setEmail("59682");
	%>

	<!-- right-主页面栏 -->
	<div class="col-md-9 col-md-offset-1 ">

		<!-- 个人信息栏 -->
		<div class="modal" status="information">
			<h2>个人信息:</h2>
			<table>
				<tr class="msg">
					<span>昵称: <%=usermsg.getNickname()%> </span>
				</tr>
				<br>
				<tr class="msg">
					<span>性别: <%=usermsg.getSex()%> </span>
				</tr>
				<br>
				<tr class="msg">
					<span>年龄: <%=usermsg.getAge()%> </span>
				</tr>
				<br>
				<tr class="msg">
					<span>生日: <%=usermsg.getBirthday()%> </span>
				</tr>
				<br>
				<tr class="msg">
					<span>邮箱: <%=usermsg.getEmail()%> </span>
				</tr>
				<br>
				<br>

				<tr class="msg">
					<p>路漫漫其修远兮，吾将上下而求索。</p>
				</tr>
			</table>
		</div>
	</div>


	<!-- 日记栏 -->
	<div class="modal" status="diary-show">

		<!-- 搜索框 -->
		<div class="row">
			<div class="col-lg-4 col-lg-offset-8">
				<form action="SearchServlet" method="post">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="请输入要查询的内容 "
							name="keyword" value="${param.keyword}"> <span
							class="input-group-btn">
							<button class="btn btn-default" type="submit">搜索</button> </span>
					</div>
					<!-- /input-group -->
				</form>
			</div>
			<!-- /.col-lg-6 -->
		</div>

		<!-- /.row -->
		<br>
		<div class="modal">
			<table>
				<tr class="msg">
					<span><a href=<%="www.baidu.com"%>>第1篇日记</a> </span>
				</tr>
				<br>
				<br>
				<tr class="msg">
					<span><a href=<%="www.baidu.com"%>>第2篇日记</a> </span>
				</tr>
				<br>
				<br>
				<tr class="msg">
					<span><a href=<%="www.baidu.com"%>>第3篇日记</a> </span>
				</tr>
				<br>
				<br>
				<tr class="msg">
					<span><a href=<%="www.baidu.com"%>>第4篇日记</a> </span>
				</tr>
				<br>
				<br>
				<tr class="msg">
					<span><a href="www.baidu.com">1</a>&nbsp;&nbsp;<a
						href="www.baidu.com">2</a>&nbsp;&nbsp; <a href="www.baidu.com">3</a>&nbsp;&nbsp;
						<a href="www.baidu.com">...</a> </span>
				</tr>
			</table>
		</div>
	</div>


	<!-- 相册栏 -->
	<div class="modal" status="image-show">
		<div>
			<table>
				<tr class="msg">
					<span><img src="img/xiaohui.png" height="44" width="152"
						style="margin-top: 40px;" /> </span>
				</tr>
				<br>
				<br>
				<tr class="msg">
					<sp an> <img src="img/xiaohui.png" height="44" width="152"
						style="margin-top: 40px;" /> </span>
				</tr>
				<br>
				<br>
				<tr class="msg">

					<span><img src="img/xiaohui.png" height="44" width="152"
						style="margin-top: 40px;" /> </span>
				</tr>
				<br>
				<br>
			</table>
		</div>
		<div></div>
	</div>
</div>