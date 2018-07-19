<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 文件上传form表单必须添加 enctype="multipart/form-data" 并且提交方式必须是post  -->
	<form action="${pageContext.request.contextPath }/demo/fileupload/upload.do" method="post" enctype="multipart/form-data">
		<input type="file" name="fileName">
		<input type="text" name="username" value="小江">
		<input type="text" name="sex" value="1">
		<br>
		<input type="submit" value="提交">
	</form>
</body>
</html>