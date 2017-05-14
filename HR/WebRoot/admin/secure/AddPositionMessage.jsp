<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>岗位创建及添加</title>

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
	<label class="control-label" style="font-size:25px;margin:0,auto;position:relative;">添加岗位</label>
	</div>
	<br/>
	<br/>
	<div class="container" style="width:50%;margin:0,auto;position:relative;" >
	<form class="form-horizontal" role="form" method="post" action="">
				<div class="row">
					<div class="col-md-5 ">
						<div class="form-group">
							岗位编号
							<input type="text" name="textfield1" class="form-control" />
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="form-group">
							岗位名称
							<input type="text" name="textfield2" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<div class="form-group">
							岗位类型
							<select name="select1" class="form-control">
								<option selected="selected">
									管理
								</option>
								<option>
									技术
								</option>
								<option>
									营销
								</option>
								<option>
									市场
								</option>
							</select>
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="form-group">
							编制
							<input type="text" name="textfield3" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-2 col-md-offset-3" >
							<div class="form-group">
								<button type="button" class="btn btn-info btn-lg btn-block">保存</button>
							</div>
						</div>
						<div class="col-md-2 col-md-offset-1">
							<div class="form-group">
								<button type="button" class="btn btn-default btn-lg btn-block">重置</button>
							</div>
						</div>
					</div>
		</form>
	</div>
	</body>
</html>
