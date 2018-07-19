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
			<legend style="font-size: 30px;">教师信息修改</legend>
		</fieldset>
		<form class="layui-form layui-form-pane" action="${pageContext.request.contextPath }/basicinfoset/teachermodify.do" method="POST">
			<input type="hidden" name="tid" value="${teacher.tid }">
			<div class="layui-form-item">
				<label class="layui-form-label">教师姓名</label>
				<div class="layui-input-block">
					<input type="text" name="tname" value="${teacher.tname }"  autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">登录密码</label>
				<div class="layui-input-block">
					<input type="password" name="password" value=""  autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">性别</label>
				<div class="layui-input-block">
					<input type="radio" name="sex" value="0" title="男" <c:if test="${teacher.sex eq '0' }">checked=""</c:if> >
					<input type="radio" name="sex" value="1" title="女" <c:if test="${teacher.sex eq '1' }">checked=""</c:if> >
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">专业号</label>
				<div class="layui-input-block">
					<input type="text" name="professionalno" value="${teacher.professionalno }" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">教师职称</label>
				<div class="layui-input-block">
					<input type="text" name="ProfessionalTitle" value="${teacher.professionalTitle}"  autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">籍贯</label>
				<div class="layui-input-block">
					<input type="text" name="nativeplace" value="${teacher.nativeplace }"  autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">证件号码</label>
				<div class="layui-input-block">
					<input type="text" name="identifyno" value="${teacher.identifyno }"  autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">政治面貌</label>
				<div class="layui-input-block">
					<input type="text" name="political" value="${teacher.political }" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">联系电话</label>
				<div class="layui-input-block">
					<input type="text" name="mobilephone" value="${teacher.mobilephone }"  autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">民族</label>
				<div class="layui-input-block">
					<input type="text" name="nation" value="${teacher.nation }"  autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">住址</label>
				<div class="layui-input-block">
					<input type="text" name="address" value="${teacher.address }"  autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<button class="layui-btn layui-btn-fluid" lay-submit="" lay-filter="go">确认修改</button>
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