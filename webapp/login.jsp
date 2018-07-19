<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="layui/css/layui.css">
	<script type="text/javascript" src="layui/layui.js"></script>
	<style type="text/css">
		body {
			background-image: url("image/bg.jpg");
		}
		.content {
			width: 350px;
			height: 400px;
			margin-top: 150px;
			margin-left: 100px;
			background-color: white;
			padding: 20px;
		}
		.layui-form-pane .layui-form-label {
			width: 40px;
			padding: 8px 0px;
		}
		.layui-form-pane .layui-input-block {
			margin-left: 40px;
		}
		i {
			color: #e6e6e6;
		}
		i:hover {
			color: #009688;
		}
	</style>
	</head>
	<body onload="init()">
		<div class="content">
			<fieldset class="layui-elem-field layui-field-title" style="text-align:center;">
				<legend style="font-size: 30px;">账号登录</legend>
			</fieldset>
			<form class="layui-form layui-form-pane" action="${pageContext.request.contextPath }/login.do" method="POST">
				<div class="layui-form-item">
					<label class="layui-form-label"><i class="layui-icon layui-icon-username" style="font-size: 28px;"></i></label>
					<div class="layui-input-block">
						<input type="text" name="username" lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label"><i class="layui-icon layui-icon-password" style="font-size: 28px;"></i></label>
					<div class="layui-input-block">
						<input type="password" name="password" lay-verify="required|correct" placeholder="请输入密码" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item" pane="">
					<label class="layui-form-label"><i class="layui-icon layui-icon-friends" style="font-size: 28px;"></i></label>
					<div class="layui-input-block">
						<input type="radio" name="usertype" value="1" title="管理员" checked="">
						<input type="radio" name="usertype" value="2" title="教师">
						<input type="radio" name="usertype" value="3" title="学生">
					</div>
				</div>
				<div class="layui-form-item">
					<button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="go">登&nbsp;&nbsp;&nbsp;&nbsp;录</button>
					<!-- <input type="button" class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="go" value="登&nbsp;&nbsp;&nbsp;&nbsp;录"> -->
				</div>
				<div class="layui-form-item" style="text-align: right;">
					<a href="#">立即注册</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#">忘记密码</a>
				</div>
				<fieldset class="layui-elem-field layui-field-title" style="text-align:center;">
					<legend style="font-size: 14px; color: #e6e6e6;">其他方式登录</legend>
				</fieldset>
				<div class="layui-form-item" style="text-align: center;">
					<i class="layui-icon layui-icon-login-wechat" style="font-size: 38px;"></i>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<i class="layui-icon layui-icon-login-qq" style="font-size: 38px;"></i>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<i class="layui-icon layui-icon-login-weibo" style="font-size: 38px;"></i>
				</div>
			</form>
		</div>
		<script>
			layui.use(['form'], function(){
			  var $ = layui.jquery
			  ,form = layui.form
			  ,layer = layui.layer;
			  //校验用户名是否存在
			  form.verify({
				  exists:function(value, item){
					  var rs = "用户名已存在";
					  $.ajax({
						  type: "GET",
						  url: "${pageContext.request.contextPath }/check.do",
						  async: false,
						  data: {checkType:"username", username:value},
						  success: function(result){
							  if(result=='failed'){
								  rs = "";
							  }
						  }
					  });
					  return rs;
				  },
				  correct:function(value, item){
					  var rs = "正在校验用户信息";
					  var username = $("input[name='username']").val();
					  var usertype = $("input[name='usertype']:checked").val();
					  $.ajax({
						  type: "GET",
						  url: "${pageContext.request.contextPath }/check.do",
						  async: false, //很重要
						  data: {checkType:"userinfo", username:username, password:value, usertype:usertype},
						  success: function(result){
							  if(result=='00'){//校验通过
								  rs = "";
							  }else if(result=='01'){//
								  rs = "用户名或密码错误";
							  } else if(result=='02'){
								  rs = "用户无系统登录权限";
							  }
						  }
					  });
					  return rs;
				  }
			  });
			  form.on('submit(go)', function(data){
				  $("form").submit();
			  });
			});
			function init(){
				if(window.top !== window.self){
					window.top.location.href = "${pageContext.request.contextPath }";
				}
			}
		</script>
	</body>
</html>