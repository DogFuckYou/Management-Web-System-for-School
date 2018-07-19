<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./layui/css/layui.css">
<link rel="stylesheet" href="./css/style.css">
<script type="text/javascript" src="../layui/layui.js"></script>
<title>教师管理页面</title>
</head>
<body>
	<div class="header">
		<fieldset class="layui-elem-field layui-field-title" style="text-align:center;">
			<legend style="font-size: 30px;">教师信息查询</legend>
		</fieldset>
		<form class="layui-form layui-form-pane" action="${pageContext.request.contextPath }/basicinfoset/teacherquery.do" method="POST">
			<div class="layui-form-item layui-form-item-left">
				<label class="layui-form-label">教师ID：</label>
				<div class="layui-input-inline">
					<input type="text" name="tid" value="${param.tid }" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item layui-form-item-right">
				<label class="layui-form-label">教师姓名：</label>
				<div class="layui-input-inline">
					<input type="text" name="tname" value="${param.tname }" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<button class="layui-btn" lay-submit="" lay-filter="go">查&nbsp;&nbsp;&nbsp;&nbsp;询</button>
				<button class="layui-btn" lay-submit="" lay-filter="add">新&nbsp;&nbsp;&nbsp;&nbsp;增</button>
			</div>
		</form>
	</div>
	<div class="content">
		<c:if test="${not empty teacherList }">
		<table lay-filter="content">
		  <thead>
		    <tr>
		      <th lay-data="{field:'tid', width:80}">教师ID</th>
		      <th lay-data="{field:'tname', width:100}">教师姓名</th>
		      <th lay-data="{field:'sex', width:60}">性别</th>
		      <th lay-data="{field:'professionalno', width:80}">专业号</th>
		      <th lay-data="{field:'ProfessionalTitle', width:110}">职称</th>
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
		  	<c:forEach items="${teachertList }" var="tea">
		  		<tr>
			      <td>${tea.tid }</td>
			      <td>${tea.tname }</td>
			      <td>${tea.sex }</td>
					<td>${tea.professionalno }</td>
					<td>${tea.ProfessionalTitle }</td>
			      <td>${tea.nativeplace }</td>
			      <td>${tea.identifyno }</td>
			      <td>${tea.political }</td>
			      <td>${tea.mobilephone }</td>
			      <td>${tea.nation }</td>
			      <td>${tea.address }</td>
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
					  url: "${pageContext.request.contextPath }/basicinfoset/teacherdel.do",
					  async: false,
					  data: {tid:data.tid},
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
	    		  title: '教师信息修改',
	    		  shadeClose: false,
	    		  shade: 0.8,
	    		  area: ['480px', '90%'],
	    		  content: '${pageContext.request.contextPath }/basicinfoset/teacherpremodify.do?tid='+data.tid //iframe的url
	    		}); 
		    }
		  });
		});
	</script>
</body>
</html>