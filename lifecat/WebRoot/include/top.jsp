<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<%-- 页眉 导航条 --%>	
	
<script>

    <c:if test="${not empty message}">
    alert("${message}");
    console.log("msg弹出");
    </c:if>
    
</script>


<div class="navbar navbar-default">
	<div class="container">
	
		<!--导航条头部-->
		<div class="navbar-header">
			<a href="http://www.lifecat.club/" target="_blank" class="navbar-brand"> 
				<img src="img/xiaohui.png" height="44"  width="152" style="margin-top: -13px;" />
			</a>
			
			<!--logo-->
			<!--折叠菜单的触发按钮-->
			<button data-toggle="collapse" data-target="#my-collapse"
				type="button" class="navbar-toggle collapsed">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<!--导航条尾部信息栏-->
		<div id="my-collapse" class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-right">
				<!-- 用户名信息 -->
				<li><a href="#" data-toggle="modal" data-target="#updatemsg"><span 
						class="glyphicon glyphicon-user"></span>
						欢迎你 ${user.name}</a>
				</li>
				<!-- 修改密码:target跳转到myModal模块 -->
				<li><a href="#" data-toggle="modal" data-target="#updatepsw"><span
						class="glyphicon glyphicon-pencil"></span>
						修改密码</a>
				</li>
				
				<li><a href="http://localhost:8080/student/index.jsp"><span
						class="glyphicon glyphicon-log-out"></span>退出</a>
				</li>
			</ul>
		</div>
	</div>

	<!-- 模态框（Modal）updatepsw --修改密码 -->
	<div class="modal fade" id="updatepsw" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">登录密码修改</h4>
				</div>
				<div class="modal-body">
				
					<!-- form表单 修改密码信息 action=forechange -->
					<form action="UpdatePSWServlet" class="form col-md-12 center-block"
						method="post">
						<div class="form-group">
							<h4>
								<label for="fpassword">原密码</label>
							</h4>
							
							<input type="password" id="fpassword" name="fpassword"
								class="form-control input-md" placeholder="请输入原密码" title="默认账号">
								
						</div>
						<div class="form-group">
							<h4>
								<label for="password1">请输入要修改的密码</label>
							</h4>
							
							<input name="password1" id="password1" type="password"
								class="form-control input-md" placeholder="请输入你要修改的密码">
								
						</div>
						<div class="form-group">
							<h4>
								<label for="password2">请再次输入</label>
							</h4>
							
							<input name="password2" id="password2" type="password"
								class="form-control " placeholder="请再次输入密码">
								
						</div>
						<div class="form-group">
							<button class="btn btn-primary btn-lg btn-block">修改</button>
						</div>
					</form>
					
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>

			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	
	
	<!-- /.modal -->
	<!-- 模态框（Modal）updatemsg --添加图片 -->
	<div class="modal fade" id="updatemsg" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">修改信息</h4>
				</div>
				
				<!-- 修改个人信息 -->
				<div class="modal-body">
					<form action="UpdateMSGServlet" class="form col-md-12 center-block"
						method="post">
						<div class="form-group">
							<h5>新昵称</h5>
							<input type="text" name="nickname" class="form-control input-lg"
								placeholder="" title="输入昵称">
						</div>
						<div class="form-group">
							<h5>性别</h5>
							<input type="text" name="sex" class="form-control input-lg"
								placeholder="" title="输入性别">
						</div>

						<div class="form-group">
							<h5>年龄</h5>
							<input type="textarea" name="age"
								class="form-control input-lg" placeholder="" title="输入年龄">
						</div>

						<div class="form-group">
							<h5>生日</h5>
							<input type="text" name="birthday" class="form-control input-lg"
								placeholder="" title="输入生日">
						</div>

						<div class="form-group">
							<h5>邮箱</h5>
							<input type="text" name="email" class="form-control input-lg"
								placeholder="" title="你的邮箱">
						</div>
						
						
						<div class="form-group">
							<button class="btn btn-primary btn-lg btn-block">修改</button>
						</div>
					</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>

			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->

</div>



