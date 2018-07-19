<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../layui/css/layui.css">
<link rel="stylesheet" href="../css/style.css">
<script type="text/javascript" src="../layui/layui.js"></script>
<title>学生成绩管理页面</title>
</head>
<body>
	<div class="header">
		<fieldset class="layui-elem-field layui-field-title" style="text-align:center;">
			<legend style="font-size: 30px;">学生成绩录入</legend>
		</fieldset>
		<%-- <form class="layui-form layui-form-pane" action="${pageContext.request.contextPath }/basicinfoset/studentquery.do" method="POST"> --%>
			<div class="layui-form-item layui-form-item-left">
				<label class="layui-form-label" style="width: 290px">学生ID：</label>
				<div class="layui-input-inline">
					<input type="text" name="sid" value="${param.sid }" autocomplete="off" class="layui-input">
				</div>
			</div>
			<%--  <div class="layui-form-item layui-form-item-right">
				<label class="layui-form-label">学生姓名：</label>
				<div class="layui-input-inline">
					<input type="text" name="sname" value="${param.sname }" autocomplete="off" class="layui-input">
				</div>
			</div> --%> 
			<div class="layui-form-item">
				<!-- <button class="layui-btn" name="querybtn">查&nbsp;&nbsp;&nbsp;&nbsp;询</button> -->
				<button class="layui-btn" lay-submit="insertbtn" lay-filter="add">录&nbsp;&nbsp;&nbsp;&nbsp;入</button>
			</div>
		<!-- </form> -->
	</div>
	<div class="content">
		<table class="layui-hide" id="lay_table_student" lay-filter="student">
		</table>
		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>
	</div>
	<script type="text/javascript">
		layui.use('table', function(){
		  var $ = layui.jquery
		  ,table = layui.table; 
		  $("button[name='querybtn']").on('click', function(){
			  var sid = $("input[name='sid']").val();
			  var sname = $("input[name='sname']").val();
			  var divheight = document.documentElement.clientHeight-170;
			  table.render({
			    elem: '#lay_table_student'
			    ,url: '${pageContext.request.contextPath }/basicinfoset/studentquery.do'
			    ,where: {sid: sid, sname: sname}
			    ,method: 'post'
			    ,cols: [[
			    	{field:'sid', title: '学生ID', width:80}
			    	,{field:'sname', title: '学生姓名', width:100}
			    	,{field:'classesname', title: '所属班级', width:150}
			    	,{field:'admissiondate', title: '入学日期', width:110}
			    	,{field:'birth', title: '出生日期', width:110, sort:true}
			    	,{field:'nativeplace', title: '籍贯', width:100}
			    	,{field:'identifyno', title: '证件号码', width:180}
			    	,{field:'political', title: '政治面貌', width:100}
			    	,{field:'mobilephone', title: '联系电话', width:120}
			    	,{field:'nation', title: '民族', width:60}
			    	,{field:'address', title: '住址'}
			    	/* ,{fixed: 'right', title: '操作', width:130, align:'center', toolbar: '#barDemo'} */
			    ]]
			    ,page: true
			    ,height: divheight
			  });
			  
		  }); 
		  $("button[name='insertbtn']").on('click', function(){
			  layer.open({
				  type: 2,
				  title: '成绩录入信息页',
				  shadeClose: true,
				  shade: 0.8,
				  area: ['380px', '90%'],
				  content: '${pageContext.request.contextPath }/basicinfoset/scoreinput.jsp' //iframe的url
				}); 
		  });
		  //监听工具条
		  table.on('tool(student)', function(obj){
		    var data = obj.data;
		    if(obj.event === 'del'){
		      layer.confirm('真的删除行么', function(index){
		    	  var delRS = true;
		    	  $.ajax({
					  type: "GET",
					  url: "${pageContext.request.contextPath }/basicinfoset/studentdel.do",
					  async: false,
					  data: {sid:data.sid},
					  success: function(result){
						  if(result!='00'){
							  delRS = false;
						  }
					  }
				  });
		    	  if(delRS){//删除成功
		    		  obj.del();
			          layer.close(index);
		    	  }
		      });
		    } else if(obj.event === 'edit'){
		    	layer.open({
	    		  type: 2,
	    		  title: '学生信息修改',
	    		  shadeClose: false,
	    		  shade: 0.8,
	    		  area: ['480px', '90%'],
	    		  content: '${pageContext.request.contextPath }/basicinfoset/studentpremodify.do?sid='+data.sid //iframe的url
	    		}); 
		    }
		  });
		});
	</script>
</body>
</html>