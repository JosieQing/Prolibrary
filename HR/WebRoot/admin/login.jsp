<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<noscript>本页面需要JavaScript 请打开JavaScript脚本</noscript>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <script src="<%=basePath %>js/bootstrap.min.js"></script>
    <script src="<%=basePath %>js/jquery.min.js"></script>
    
 <link href="<%=basePath%>/css/bootstrap.css" rel="stylesheet">

<!-- Documentation extras -->
<link href="<%=basePath%>/css/docs.css" rel="stylesheet">
<link href="<%=basePath%>/css/github.css" rel="stylesheet">

<link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=basePath%>/ico/apple-touch-icon-144-precomposed.png">
<link rel="shortcut icon" href="<%=basePath%>/ico/favicon.png">


<% String err= (String) request.getAttribute("err"); %>
    
  <!--  在当前页显示提示框-->
<script  language="javascript" >
	
	
		function ifcuowu(err){	
			if(err!=null && err.trim!="" && err!="null"){
				alert(err);
			}
		}
	
		window.onlod=ifcuowu('<%= err %>');
	
</script>
<link href="<%=basePath%>css/login.css" rel="stylesheet">
  </head>
  <body>

   <div class="container" style="width:25%;margin:0,auto;position:relative;" >
      <form class="form-signin"  method="post" action="<%=basePath%>servlet/adminServlet">
      <input type="hidden" name="q" value="login">
        <h2 class="form-signin-heading">Please sign in</h2>
          <div id="div-user-pass">
	        	<div id="div-user">
	        		<input id="input-user" type="text" name="username" class="form-control" placeholder="账号  至少3个字符" maxlength="20" onfocus="restoreFormState()" onkeyup="checkLoginForm()" onblur="checkLoginForm()" required autofocus>
	        	</div>
	        	<div id="div-pass">
	        		<input id="input-pass" type="password" name="password" class="form-control" placeholder="密码  至少6个字符" maxlength="20" onfocus="restoreFormState()" onkeyup="checkLoginForm()" onblur="checkLoginForm()" required>
	       		</div>
	        </div>
	        <div id="div-vali">
	        	<img id="image" title="点击更换" name="random-image" src="<%=basePath%>servlet/imgServlet" onclick="refreshImage(this)">
	   				<input id="input-vali" type="text" name="random-code" class="form-control form-validation" onkeyup="checkLoginForm()" onfocus="restoreFormState()" onblur="checkLoginForm()" placeholder="验证码" maxlength="5" required>
	     		<input type="checkbox" class="form-remember" name="mark" value="remember-me"> 记住我
	     	</div>
	     	
	        <button id="login-form-submit" disabled class="btn btn-lg btn-primary btn-block" type="submit" onclick="formWillSubmit()">登陆</button>
		</form>
	</div>	
  </body>
  <script type="text/javascript">
  function refreshImage(image)
{
    image.src = "<%=basePath%>servlet/imgServlet?" + Math.random();
}

function restoreFormState()
{
    var user = $("#input-user");
    var pass = $("#input-pass");
	var vali = $("#input-vali");
    var submitButton = $("#login-form-submit");
    
    user[0].placeholder = "账号  至少3个字符";
    pass[0].placeholder = "密码  至少6个字符";
    vali[0].placeholder = "验证码";
    
    user.parent().removeClass("has-error");
    pass.parent().removeClass("has-error");
    vali.parent().removeClass("has-error");
}

function checkLoginForm()
{
	// Select elements
    var user = $("#input-user");
    var pass = $("#input-pass");
	var vali = $("#input-vali");
    var submitButton = $("#login-form-submit");
    // Check three input fields
    if (checkUsername(user) & checkPass(pass) & checkVali(vali)) {
    	submitButton[0].disabled = false;
    } else {
    	submitButton[0].disabled = true;
    }
}

function checkUsername(user)
{
	var len = user.val().length;
	if (len == 0) {
		$("#div-user").removeClass("has-error");
		return false;
	}
	if (len >= 3) {
		$("#div-user").removeClass("has-error");
		return true;
	}
	$("#div-user").addClass("has-error");
	return false;
}

function checkPass(pass)
{
	var len = pass.val().length;
	if (len == 0) {
		$("#div-pass").removeClass("has-error");
		return false;
	}
	if (len >= 6) {
		$("#div-pass").removeClass("has-error");
		return true;
	}
	$("#div-pass").addClass("has-error");
	return false;
}

function checkVali(vali)
{
	var len = vali.val().length;
	if (len == 0) {
		$("#div-vali").removeClass("has-error");
		return false;
	}
	if (len == 5) {
		$("#div-vali").removeClass("has-error");
		return true;
	}
	$("#div-vali").addClass("has-error");
	return false;
}

// Peform ajax post
function formWillSubmit() 
{
	var user = $("#input-user");
    var pass = $("#input-pass");
    var vali = $("#input-vali");
    
    var upperCase = vali.val();
    vali.val(upperCase.toUpperCase());
   
	var targetURL = getRootPath() + "/admin/login";
	$.post(targetURL, $("#form-signin").serialize(), function(data) {
		var result = String($.trim(data));
		if(result == VALIDATION_FAIL) {
			vali.parent().addClass("has-error");
			vali[0].placeholder = "输入有误";
		} else if (result == AUTHORITY_FAIL) {
			user.parent().addClass("has-error");
			pass.parent().addClass("has-error");
			pass.val("");
			pass[0].placeholder = "用户名密码错误";
		} else if (result == INVALID_INPUT) {
			user.parent().addClass("has-error");
			pass.parent().addClass("has-error");
			user.val("");
			pass.val("");
			pass[0].placeholder = "请不要输入特殊字符";
			user[0].placeholder = "请不要输入特殊字符";
		} else if (result == TIME_OUT) {
		 	vali.parent().addClass("has-error");
			vali[0].placeholder = "超时";
		} else if (result == FORBIDDEN) {
			user.val("");
			pass.val("");
			alert("你的账号被禁用 请联系超级管理员");
			user.focus();
		} else {
			location.reload();
			return;
		}
		refreshImage($("#image")[0]);
		$("#login-form-submit")[0].disabled = true;
		vali.val("");
		return;
	});
}

function getRootPath(){
    var curWwwPath = window.document.location.href;
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    var localhostPath = curWwwPath.substring(0, pos);
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return (localhostPath + projectName);
}

// Response text from sever
VALIDATION_FAIL = "ValidationFail";
AUTHORITY_FAIL = "AuthorityFail";
INVALID_INPUT = "InvalidInput";
TIME_OUT = "TimeOut";
FORBIDDEN = "forbidden"
  
  </script>
  
</html>
