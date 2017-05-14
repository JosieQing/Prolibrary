<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.neusoft.bean.*"%>
<%@ page import="com.neusoft.service.*"%>
<%@ page import="com.neusoft.service.impl.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>修改岗位信息</title>

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
	<label class="control-label" style="font-size:25px;margin:0,auto;position:relative;">修改岗位</label>
	</div>
	<br/>
	<br/>
	<div class="container" style="width:50%;margin:0,auto;position:relative;" >
	<% 
	Integer jobno = Integer.valueOf(request.getParameter("jobno"));
	JobService js = new JobServiceImpl();
	Job job=js.getJobMessageById(jobno); 
	%>
	<form class="form-horizontal" role="form" method="post" action="<%=request.getContextPath()%>/servlet/job">
			<input type="hidden" name="s" value="modify"  />
	  	<input type="hidden" name="jobno" value="<%=job.getJobno()%>"  />	
				<div class="row">
					<div class="col-md-6 ">
						<div class="form-group">
					岗位编号：<label class="control-label" name="jobno"><%=job.getJobno()%></label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5 ">
						<div class="form-group">					
								部门编号
							<input type="text" name="deptno" class="form-control" value="<%=job.getDeptno()%>"/>
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="form-group">				
								岗位名称
							<input type="text" name="jname" class="form-control" value="<%=job.getJname()%>"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5 ">
						<div class="form-group">
							岗位编制
							<input type="text" name="jobCompile" class="form-control" value="<%=job.getJobCompile()%>"/>
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="form-group">
							岗位类型
							<input type="text" name="jobStyle" class="form-control" value="<%=job.getJobStyle()%>" />
						</div>
					</div>
				</div>
					<div class="row">
						<div class="col-md-2 col-md-offset-3" >
							<div class="form-group">
								<button type="submit" class="btn btn-info btn-lg btn-block">确认</button>
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
