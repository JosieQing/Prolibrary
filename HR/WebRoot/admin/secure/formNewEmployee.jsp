<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib uri="http://displaytag.sf.net" prefix="d" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>新聘员工报表-</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../footer.jsp"></jsp:include>
		
	</head>
	<body>
	<jsp:include page="../nav.jsp"></jsp:include>
		<div class="container"
			style="width: 60%; margin: 0, auto; position: relative;">		
			<h2>
				新聘员工报表
			</h2>
			<h3>
				新聘员工记录
			</h3>
			<form action="<%=basePath%>/servlet/formNewServlet" method="post">
			<input type="hidden" name="fun" value="new">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							部门名称
							<select name="dname" class="form-control">
								<option selected="selected" value="101">
									A部门
								</option>
								<option value="102">
									C部
								</option>
								<option value="103">
									E部
								</option>
							</select>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							起始时间
							<input type="date" name="workDay" class="form-control" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							结束时间
							<input type="date" name="formalDay" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 col-md-offset-3">
						<div class="form-group">
							<input type="submit" name="submit1" value="查询"
								class="btn btn-default" />
						</div>
					</div>
					<div class="col-md-3 ">
						<div class="form-group">
							<input type="reset" name="reset1" value="重置"
								class="btn btn-danger" />
						</div>
					</div>
				</div><%--
				查询结果：
				<d:table id="formnew" name="${sessionScope['list']}" size="${sessionScope['total']}" partialList="true" 
				export="true" pagesize="${initParam.pageSize}" requestURI="/servlet/formNewServlet" >
				<d:column property="eid" title="员工编号" sortable="true"></d:column>
				<d:column property="dname" title="部门名称" sortable="true"></d:column>
				<d:column property="jname" title="岗位名称" sortable="true"></d:column>
				<d:column property="ename" title="姓名" sortable="true"></d:column>
				<d:column property="sex" title="性别" sortable="true"></d:column>
				<d:column property="workday" title="入职日期" sortable="true"></d:column>
				<d:column property="highestEducation" title="学历" sortable="true"></d:column>
				</d:table>
			--%></form>
		</div>
	</body>
</html>
