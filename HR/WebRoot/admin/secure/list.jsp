<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.neusoft.bean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://blog.csdn.net/qjyong/tags/pager" prefix="pager"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<style>
@import url("/Java09WebDemo/css/screen.css");

* {
	font-family: "宋体";
	font-size: 14px
}
</style>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<base href="<%=basePath%>">

		<title>My JSP 'Admins.jsp' starting page</title>

		<!--<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
		<link href="<%=basePath%>docs-assets/css/docs.css" rel="stylesheet">
		<link href="<%=basePath%>docs-assets/highlight/css/github.css"
			rel="stylesheet">

		<link rel="apple-touch-icon-precomposed" sizes="144x144"
			href="<%=basePath%>docs-assets/ico/apple-touch-icon-144-precomposed.png">
		<link rel="shortcut icon"
			href="<%=basePath%>docs-assets/ico/favicon.png">
			
		<link rel="stylesheet" type="text/css" href="styles.css">


	-->
	</head>

	<body>

		登录用户名称：${sessionScope.username }

		<!--
		name:从request或session中去获取list
		size：从request或session中去获取总的记录数
		partialList：partialList=true  后台（数据库）分页，如果不写，默认为前台分页
		export：export=true可以有到处的功能
		pagesize:每页要显示的记录数
		sortable:排序
		requestURI:请求路径------AdminManagerServlet  servlet/adminManagerServlet
		-->
		
		<display:table id="admin" name="${requestScope['list']}"
			size="${requestScope['total']}" partialList="true" export="true"
			pagesize="${initParam.pageSize}"
			requestURI="/servlet/adminManagerServlet">
			<display:column property="id" title="编号" sortable="true"></display:column>
			<display:column property="username" title="用户名" sortable="true"></display:column>
			<display:column property="password" title="密码" sortable="true"></display:column>
			<display:column title="操作">
				<a
					href="/Java09WebDemo/admin/secure/modify.jsp?id=${admin.id}&username=${admin.username}&password=${admin.password}"
					class="btn btn-primary btn-lg active" role="button">修改</a>
				<a
					href="/Java09WebDemo/servlet/adminManagerServlet?q=delete${admin.id}"
					class="btn btn-default btn-lg active" role="button">删除</a>
			</display:column>
		</display:table>


	</body>
</html>


