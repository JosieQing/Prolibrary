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
		<jsp:include page="../header.jsp"></jsp:include>
	</head>
<body>
	<jsp:include page="../nav.jsp"></jsp:include>
	<div style="text-align:center">
	<label class="control-label" style="font-size:25px;margin:0,auto;position:relative;">添加岗位</label>
	</div>
	<br/>
	<div class="container" style="width:50%;margin:0,auto;position:relative;" >
	<form class="form-horizontal"  method="post" action="servlet/job">
	<input type="hidden" name="s" value="addJob"  />
				<div class="row">
					<div class="col-md-5 ">
						<div class="form-group">
							岗位编号
							<input type="text" name="jobno" class="form-control" placeholder="岗位编号" />
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="form-group">
							岗位名称
							<input type="text" name="jname" class="form-control" placeholder="岗位名称"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<div class="form-group">
							岗位类型
							<select name="jobStyle" class="form-control" >
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
							<input type="text" name="jobCompile" class="form-control" placeholder="编制" />
						</div>
					</div>
				</div>
					<div class="row">
					<div class="col-md-5 ">
						<div class="form-group">
							部门编号
							<input type="text" name="deptno" class="form-control" placeholder="部门编号" />
						</div>
					</div>
				</div>
				<div class="row">
						<div class="col-md-2 col-md-offset-3" >
							<div class="form-group">
								<button type="submit" class="btn btn-info btn-lg btn-block">保存</button>
							</div>
						</div>
						<div class="col-md-2 col-md-offset-1">
							<div class="form-group">
								<button type="submit" class="btn btn-default btn-lg btn-block">重置</button>
							</div>
						</div>
					</div>
		</form>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
