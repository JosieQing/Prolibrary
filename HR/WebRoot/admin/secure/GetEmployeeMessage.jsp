<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>员工入职信息查询</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css" href="styles.css">
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="docs-assets/css/docs.css" rel="stylesheet">
		<link href="docs-assets/highlight/css/github.css" rel="stylesheet">
		<link rel="apple-touch-icon-precomposed" sizes="144x144"
			href="../../docs-assets/ico/apple-touch-icon-144-precomposed.png">
		<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">
		<style type="text/css"></style>
		<script type="text/javascript" src="jquery-1.8.0.min.js">
		</script>
	</head>

	<body>
	<div style="text-align:center">
	<label class="control-label" style="font-size:25px;margin:0,auto;position:relative;">员工入职信息查询</label>
	</div>
	<br/>
	<div class="container" style="width:50%;margin:0,auto;position:relative;" >
	<form class="form-horizontal" role="form" method="post" action="">
	<div class="container" style="width:100%;margin:0,auto;position:relative;" >
				<div class="row">
					<div class=" col-md-5 col-md-offset-1 ">
						<div class="form-group">
							请输入员工编号：
							<input type="text" name="textfield" class="form-control" />
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1 ">
						<div class="form-group">
							请输入员工姓名：
							<input type="text" name="textfield2" class="form-control" />
						</div>
					</div>
				</div>
					<div class="row">
					<div class=" col-md-5 col-md-offset-1">
						<div class="form-group">
							请输入部门编号：
							<input type="text" name="textfield" class="form-control" />
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="form-group">
							请输入部门名称：
							<input type="text" name="textfield2" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class=" col-md-5 col-md-offset-1">
						<div class="form-group">
							请输入岗位编号：
							<input type="text" name="textfield" class="form-control" />
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="form-group">
							请输入岗位名称：
							<input type="text" name="textfield2" class="form-control" />
						</div>
					</div>
				</div>
					<div class="row">
						<div class="col-md-4 col-md-offset-2" >
							<div class="form-group">
								<button type="button" class="btn btn-info btn-block">查询</button>
							</div>
						</div>
						<div class="col-md-2 col-md-offset-2">
							<div class="form-group">
								<button type="button" class="btn btn-default  btn-block">重置</button>
							</div>
						</div>
					</div>
				</div>	
								<div class="row">
							<table class="table table-hover">
					<tr>
						<td >条目</td>
						<td >内容</td>
					</tr>
					<tr >
						<td >编号</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td >姓名</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td >性别</td>
						<td >&nbsp;</td>
					</tr>
					<tr>
						<td >入职部门</td>
						<td >&nbsp;</td>

					</tr>
					<tr>
						<td >入职时间</td>
						<td >&nbsp;</td>
					</tr>
					<tr>
						<td >是否在试用期</td>
						<td >&nbsp;</td>
					</tr>
					<tr>
						<td >联系电话</td>
						<td >&nbsp;</td>
					</tr>
						<tr>
						<td >电子邮件</td>
						<td >&nbsp;</td>
					</tr>
					<tr>
						<td >操作</td>
						<td><a href="" role="button">修改</a></td>
					</tr>
					 	<tr>
					 	<td >&nbsp;</td>
						<td><a href="" role="button">删除</a></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	</body>
</html>
