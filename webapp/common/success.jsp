<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: white;">
	<table align="center" border="1" cellspacing="0" cellpadding="0" height="50%">
			<tr>
				<td colspan="4" style="text-align:center">
					<strong>成功信息提示</strong>
				</td>
			</tr>
			<tr>
				<td>
					<img alt="错误" src="${pageContext.request.contextPath }/image/success.jpg" style="width:102px;height:128px;">
				</td>
				<td>
					${message }
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center">
					<a href="#" onclick="history.go(-1)">返回上一级</a> 
				</td>
			</tr> 
		</table>
</body>
</html>