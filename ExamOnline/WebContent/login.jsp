<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<style>
.css{
margin-top:20%;
margin-left:40%;
}
#font_style{
font-family:"Microsoft YaHei";
}

</style>
<div class="css">
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎登陆</title>
</head>

<body style="background:url('images/1.jpg') no-repeat;">

<h2 align="justify">&nbsp;<font id="font_style" color="#555555">在线考试管理系统</font></h2>

 <div id="loginMessage"></div>
		<table border="1">
			<tr>
				<td>用户名：</td>
				<td><input id="uName" name="uName" type="text" value=""></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input id="pWord" name="pWord" type="password" value=""></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input id="uLogin" name="uLogin" type="button" value="登录">
				</td>
			</tr>
		</table>

</body>

</html>
<script src="<%=basePath%>js/jquery-3.2.0.min.js"></script>
<script src="<%=basePath%>js/login.js"></script>
</div>
