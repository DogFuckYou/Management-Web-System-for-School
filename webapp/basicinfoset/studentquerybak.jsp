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
<title>学生管理页面</title>
</head>
<body>
	<div class="header">
		<fieldset class="layui-elem-field layui-field-title" style="text-align:center;">
			<legend style="font-size: 30px;">学生信息查询</legend>
		</fieldset>
		<form class="layui-form layui-form-pane" action="${pageContext.request.contextPath }/basicinfoset/studentquery.do" method="POST">
			<div class="layui-form-item layui-form-item-left">
				<label class="layui-form-label">学生ID：</label>
				<div class="layui-input-inline">
					<input type="text" name="sid" value="${param.sid }" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item layui-form-item-right">
				<label class="layui-form-label">学生姓名：</label>
				<div class="layui-input-inline">
					<input type="text" name="sname" value="${param.sname }" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<button class="layui-btn" lay-submit="" lay-filter="go">查&nbsp;&nbsp;&nbsp;&nbsp;询</button>
				<button class="layui-btn" lay-submit="" lay-filter="add">新&nbsp;&nbsp;&nbsp;&nbsp;增</button>
			</div>
		</form>
	</div>
	<div class="content">
		<c:if test="${not empty studentList }">
		<table lay-filter="content">
		  <thead>
		    <tr>
		      <th lay-data="{field:'sid', width:80}">学生ID</th>
		      <th lay-data="{field:'sname', width:100}">学生姓名</th>
		      <th lay-data="{field:'classesname', width:150}">所属班级</th>
		      <th lay-data="{field:'admissiondate', width:110}">入学日期</th>
		      <th lay-data="{field:'birth', width:110, sort:true}">出生日期</th>
		      <th lay-data="{field:'nativeplace', width:100}">籍贯</th>
		      <th lay-data="{field:'identifyno', width:180}">证件号码</th>
		      <th lay-data="{field:'political', width:100}">政治面貌</th>
		      <th lay-data="{field:'mobilephone', width:120}">联系电话</th>
		      <th lay-data="{field:'nation', width:60}">民族</th>
		      <th lay-data="{field:'address'}">住址</th>
		      <th lay-data="{fixed: 'right', width:130, align:'center', toolbar: '#barDemo'}">操作</th>
		    </tr> 
		  </thead>
		  <tbody>
		  	<c:forEach items="${studentList }" var="stu">
		  		<tr>
			      <td>${stu.sid }</td>
			      <td>${stu.sname }</td>
			      <td>${stu.classesname }</td>
			      <td><fmt:formatDate value="${stu.admissiondate }" pattern="yyyy-MM-dd" /></td>
			      <td><fmt:formatDate value="${stu.birth }" pattern="yyyy-MM-dd" /></td>
			      <td>${stu.nativeplace }</td>
			      <td>${stu.identifyno }</td>
			      <td>${stu.political }</td>
			      <td>${stu.mobilephone }</td>
			      <td>${stu.nation }</td>
			      <td>${stu.address }</td>
			    </tr>
		  	</c:forEach>
		  </tbody>
		</table>
		<script type="text/html" id="barDemo">
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
			<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
		</script>
		</c:if>
	</div>
	<script type="text/javascript">
		layui.use('table', function(){
		  var $ = layui.jquery
		  ,laypage = layui.laypage
		  ,table = layui.table; //Tab的切换功能，切换事件监听等，需要依赖element模块
		  var divheight = document.documentElement.clientHeight-190;
		  table.init('content', {
			  height: divheight //设置高度
			  ,limit: 10 //注意：请务必确保 limit 参数（默认：10）是与你服务端限定的数据条数一致
			  ,page: {count:19 }
			}); 
		  //监听工具条
		  table.on('tool(content)', function(obj){
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