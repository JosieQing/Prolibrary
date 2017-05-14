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

		<title>修改员工信息</title>

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
	<label class="control-label" style="font-size:25px;margin:0,auto;position:relative;">修改员工信息</label>
	</div>
	<br/>
	<br/>
	<div class="container" style="width:50%;margin:0,auto;position:relative;" >
	<% 
	Integer eid = Integer.valueOf(request.getParameter("eid"));
	EmpEntryService es=new EmpEntryServiceImpl();
	EmpEntry ee=es.getEmpMessageById(eid); 
	%>
	<form class="form-horizontal" role="form" method="post" action="<%=request.getContextPath()%>/servlet/empEntry">
			<input type="hidden" name="s" value="modify"  />
	  	<input type="hidden" name="eid" value="<%=ee.getEid()%>"  />	
				<div class="row">
					<div class="col-md-3 ">
						<div class="form-group">
					员工号：<label class="control-label" name="eid"><%=ee.getEid()%></label>
						</div>
					</div>
					<div class="col-md-3 col-md-offset-1">
						<div class="form-group">
					部门编号：<input type="text" name="deptno" class="form-control" value="<%=ee.getDeptno()%>" />
						</div>
					</div>
					<div class="col-md-3 col-md-offset-1">
						<div class="form-group">
					岗位编号：<input type="text" name="jobno" class="form-control" value="<%=ee.getJobno()%>" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5 ">
						<div class="form-group">					
								姓名
							<input type="text" name="ename" class="form-control" value="<%=ee.getEname()%>"/>
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="form-group">				
								性别
							<select name="sex" class="form-control" selected="selected" >
								<option value="1">
									男
								</option>
								<option  value="0">
									女
								</option>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5 ">
						<div class="form-group">
							联系电话
							<input type="text" name="phone" class="form-control" value="<%=ee.getPhone()%>"/>
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="form-group">
							电子邮件
							<input type="text" name="email" class="form-control" value="<%=ee.getEmail()%>" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 ">
						<div class="form-group">
							转正日期
							<input type="date" name="formalDay" class="form-control" value="<%=ee.getFormalDay()%>"  />
						</div>
					</div>
					<div class="col-md-3 col-md-offset-1">
						<div class="form-group">
							试用期
							<input type="date" name="probationDay" class="form-control" value="<%=ee.getProbationDay()%>" />
						</div>
					</div>
					<div class="col-md-3 col-md-offset-1">
						<div class="form-group">
							工作日期
							<input type="date" name="workDay" class="form-control" value="<%=ee.getWorkDay()%>" />
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
