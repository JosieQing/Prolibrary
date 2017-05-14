<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.neusoft.bean.*"%>
<%@ page import="com.neusoft.service.*"%>
<%@ page import="com.neusoft.service.impl.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>modify</title>
		
		<script type="text/javascript">
function checkForm(){
function checkUsername() {
	var mail = $("username");
	var divID = $("DivUsername");
	divID.value = "";
	if (mail.value == "") {
		divID.value = "用户名不能为空";
		//mail.focus();
		return false;
	}
}
function checkPass() {
	var pwd = $("pwd");
	var divID = $("DivPwd");
	divID.value = "";
	if (pwd.value == "") {
		divID.value = "密码不能为空";
		//pwd.focus();
		return false;
	}
	if(pwd.value.length<6){
		divID.value="密码必须等于或大于6个字符";
		//pwd.focus();
		return false;
		}
	//return true;
}
function checkRePass() {
	var pwd = $("pwd"); //输入密码
	var repwd = $("repwd"); //再次输入密码
	var divID = $("DivRepwd");
	divID.value = "";
	if (pwd.value != repwd.value) {
		divID.value = "两次输入的密码不一致";
		return false;
	}

}
return true;
	}
	
	function checkUsername() {
	
	alert("24");
	var mail = $("username");
	var divID = $("DivUsername");
	divID.value = "";
	if (mail.value == "") {
		divID.value = "用户名不能为空";
		//mail.focus();
		return false;
	}
}
function checkPass() {
	var pwd = $("pwd");
	var divID = $("DivPwd");
	divID.value = "";
	if (pwd.value == "") {
		divID.value = "密码不能为空";
		//pwd.focus();
		return false;
	}
	if(pwd.value.length<6){
		divID.value="密码必须等于或大于6个字符";
		//pwd.focus();
		return false;
		}
	//return true;
}
function checkRePass() {
	var pwd = $("pwd"); //输入密码
	var repwd = $("repwd"); //再次输入密码
	var divID = $("DivRepwd");
	divID.value = "";
	if (pwd.value != repwd.value) {
		divID.value = "两次输入的密码不一致";
		return false;
	}

}
	
</script>
<script src="<%=basePath%>/js/jquery.min.js"></script>
<script src="<%=basePath%>/js/jquery.js"></script>
<script src="<%=basePath%>/js/bootstrap.js"></script>
<script src="<%=basePath%>/js/holder.js"></script>
<script src="<%=basePath%>/js/highlight.js">
</script>
<script >hljs.initHighlightingOnLoad();</script>
<script src="<%=basePath%>/js/application.js"></script>
 <link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet">

<!-- Documentation extras -->
<link href="<%=basePath%>/css/docs.css" rel="stylesheet">
<link href="<%=basePath%>/css/github.css" rel="stylesheet">

<link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=basePath%>/ico/apple-touch-icon-144-precomposed.png">
<link rel="shortcut icon" href="<%=basePath%>/ico/favicon.png">
</head>
	

	<body>
		<jsp:include page="../nav.jsp"></jsp:include>
		
		<div class="container"
			style="width: 70%; margin: 0, auto; position: relative;"
			align="center">
			<table id="center" border="0" cellspacing="0" cellpadding="0">
				<tr>
				<td></td>
				</tr>
				<form action="<%=basePath%>servlet/adminManagerServlet?q=modify"
					method="post">
					<tr>
						<td >
							用户名:
						</td>
						<td>
							<input id="username" type="text" class="inputs"
								onblur="return checkUsername()" name="DivUsername"
								value=${sessionScope.username } />
							<div class="red" id="DivUsername"></div>
						</td>
					</tr>
					<tr>
						<td class="left">
							输入密码：
						</td>
						<td>
							<input id="pwd" type="password" class="inputs"
								onblur="return checkPass()" name="DivPwd"
								value=${sessionScope.password } />
							<div class="red" id="DivPwd"></div>
						</td>
					</tr>
					<tr>
						<td class="left">
							确认密码：
						</td>
						<td>
							<input id="repwd" type="password" class="inputs"
								onblur="return checkRePass()"
								value=${sessionScope.password } />
							<div class="red" id="DivRepwd"></div>
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;
						</td>
						<td>
							<input name="btn" type="submit" value="确定" class="rb1" onclick="return checkForm()" />
							<input name="btn" type="reset" value="重置" class="rb1" />
						</td>
					</tr>
					

				</form>
			</table>

		</div>
		
	</body>
</html>
