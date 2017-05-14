<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../../inc/theme.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>problemTypes_update</title>
</head>
<%
	String types_updateId = null;
	types_updateId = request.getParameter("types_id");
	if (types_updateId == null) {
		types_updateId = "";
	}
%>
<body>

	<table align="center">
		<input type="hidden" id="func" name="func" value="findTypes" />
		<div id="updateMessage"></div>
		<tr>
			<td colspan="2"><b>题型ID:</b><input class="form-control"
				type="text" id="types_updateId" name="types_updateId"
				value="<%=types_updateId%>" readonly /></td>
		</tr>
		<tr>
			<th>题型名称:</th>
			<td><input class="form-control" type="text"
				id="types_updateName" name="types_updateName" placeholder="题型名称"
				autofocus></td>
		</tr>
		<tr>
			<td><input class="btn btn-primary" id="updateType"
				name="updateType" type="button" value="提交" /></td>
			<td align="center"><input class="btn btn-warning" type="button"
				value="返回" onclick="location='problemTypes_list.jsp'" /></td>
		</tr>
</body>
</html>
<script src="<%=basePath%>subjectlib/type/js/typesUpdate.js"></script>

<!-- 利用ajax回调函数跳转到problemTypes_list.jsp查询 -->
