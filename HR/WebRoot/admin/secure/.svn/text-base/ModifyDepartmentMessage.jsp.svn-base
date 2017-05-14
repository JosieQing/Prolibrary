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

		<title>修改部门信息</title>

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
	<label class="control-label" style="font-size:25px;margin:0,auto;position:relative;">修改部门</label>
	</div>
	<br/>
	<div class="container" style="width:50%;margin:0,auto;position:relative;" >
	<% 
	Integer deptno = Integer.valueOf(request.getParameter("deptno"));
	/* 根据Id获取信息 */
	DepartmentService deptService = new DepartmentServiceImpl();
	Department dept=deptService.getDeptMessageById(deptno);
	%>
	<form class="form-horizontal" role="form" method="post" action="<%=request.getContextPath()%>/servlet/department">
	  	<input type="hidden" name="s" value="modify"  />
	  	<input type="hidden" name="deptno" value="<%=dept.getDeptno()%>"  />
				<div class="row">
					<div class="col-md-6 ">
						<div class="form-group">
					部门编号：<label class="control-label" name="deptno"><%=dept.getDeptno()%></label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5 ">
						<div class="form-group">
							部门名称
							<input type="text" name="dname" class="form-control" value="<%=dept.getDname()%>" />
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="form-group">
							部门类型
							<select name="type" class="form-control">
								<option selected="selected">
									公司
								</option>
								<option>
									部门
								</option>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5 ">
						<div class="form-group">
							传真
							<input type="text" name="fax" class="form-control" value="<%=dept.getFax()%>"  />
						</div>
					</div>
					<div class="col-md-5  col-md-offset-1">
						<div class="form-group">
							电话
							<input type="text" name="phone" class="form-control" value="<%=dept.getPhone()%>" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5 ">
						<div class="form-group">
							成立日期
							<input type="date" name="startDay" class="form-control" value="<%=dept.getStartDay()%>"  />
						</div>
					</div>
					<div class="col-md-5  col-md-offset-1">
						<div class="form-group">
							上级部门
							<input type="text" name="superDept" class="form-control" value="<%=dept.getSuperDept()%>" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 ">
						<div class="form-group">
							描述
							<textarea name="describe" class="form-control" rows="3" cols="20" >
							 <%=dept.getDescribe()%>
							</textarea>
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
