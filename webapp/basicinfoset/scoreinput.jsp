<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../layui/css/layui.css">
<script type="text/javascript" src="../layui/layui.js"></script>
<title>教师管理页面</title>
</head>
<body>
	<div class="content" style="padding:10px;">
		<fieldset class="layui-elem-field layui-field-title" style="text-align:center;">
			<legend style="font-size: 30px;">成绩录入</legend>
		</fieldset>
		<form class="layui-form layui-form-pane" action="<%=request.getContextPath()%>/basicinfoset/scoreinput.do" method="POST">
			<div class="layui-form-item">
				<label class="layui-form-label">学生ID</label>
				<div class="layui-input-block">
					<input type="text" name="sid" value=""  autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">课程ID</label>
				<div class="layui-input-block">
					<input type="password" name="cid" value=""  autocomplete="off" class="layui-input">
				</div>
			</div>
		
			<div class="layui-form-item">
				<label class="layui-form-label">课程名</label>
				<div class="layui-input-block">
					<input type="text" name="cname" value="" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">成绩</label>
				<div class="layui-input-block">
					<input type="text" name="score" value=""  autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="go">确认录入</button>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		layui.use(['form', 'laydate'], function(){
		  var $ = layui.jquery
		  ,form = layui.form;
		  form.on('submit(go)', function(data){
			  $("form").submit();
		  });
		});
	</script>
</body>
</html>