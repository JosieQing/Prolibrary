<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../../inc/theme.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>problemTypes_add</title>
</head>

<body>

	<input type="hidden" name="func" id="func" value="add" />
	<div id="addTypesMessage"></div>
	<table align="center">
		<input type="hidden" id="func" name="func" value="findTypes" />
		<tr>
			<td><input class="form-control" type="text" id="types_addName"
				name="types_addName" placeholder="题型名称" autofocus></td>
		</tr>
		<tr>
			<td><input class="btn btn-primary" id="addTypes" name="addTypes"
				type="button" value="提交" /></td>
			<td><input class="btn btn-warning" type="button" value="返回"
				onclick="location='problemTypes_list.jsp'" /></td>
		</tr>
	</table>

</body>
</html>

<script src="<%=basePath%>subjectlib/type/js/typesAdd.js"></script>
<!-- 利用ajax回调函数跳转到problemTypes_list.jsp查询 -->