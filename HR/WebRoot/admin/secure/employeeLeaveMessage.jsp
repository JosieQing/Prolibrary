<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<title>员工离职管理</title>

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
			<h1>
				员工离职管理
			</h1>
			<h2>
				离职记录查询
			</h2>
			<form action="/HR/servlet/employeeLeaveMassageServlet" method="post">
			<input type="hidden" name="fun" value="ResignMessage">
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							员工编号
							<input type="text" name="eid" placehoder="员工编号"
								class="form-control" />
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							员工姓名
							<input type="text" name="ename" placehoder="员工姓名"
								class="form-control" />
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							离职类型
							<select name="totype" class="form-control">
								<option selected="selected" value="0">
									主动辞职
								</option>
								<option value="1">
									辞退
								</option>
								<option value="2">
									退休
								</option>
								<option value="3">
									试用期结束
								</option>
							</select>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							时间
							<input type="date" name="todate" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<input type="submit" name="submit1" value="查询"
								class="btn btn-default" class="form-control" />
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<input type="reset" name="reset1" value="重置"
								class="btn btn-danger" class="form-control" />
						</div>
					</div>
				</div>
				<br />
				<c:if test="${list ne null}">
				查询结果：
				
				<d:table class="table table-striped"  id="leavemessage" name="${sessionScope['list']}" size="${sessionScope['total']}" partialList="true"  
				export="true" pagesize="${initParam.pageSize}" requestURI="/servlet/employeeLeaveMassageServlet">
				<d:column property="lid" title="离职编号" sortable="true"></d:column>
				<d:column property="eid" title="员工编号" sortable="true"></d:column>
				<d:column property="todate" title="离职日期"></d:column>
				<d:column property="totype" title="离职类型"></d:column>
				<d:column property="reason" title="离职事由"></d:column>				
				</d:table>
				</c:if>	
			</form>
		</div>
	</body>
</html>
