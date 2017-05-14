<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/head.jsp"%>
<%@ include file="../../inc/db.jsp"%>
<link type="text/css" rel="stylesheet" href="css/login_css.css"/>
<%
String id = null;
id = request.getParameter("id");
if (id == null) {
	id = "0";
}
System.out.print(id);
Statement statp = null;
ResultSet rsp = null;
String role = null;
String link = null;

try {
	String sqlp = "select role from character where id=" + id;
	statp = conn.createStatement();
	rsp = statp.executeQuery(sqlp);
	if (rsp.next()) {
		role = rsp.getString("role");
	}
} catch (Exception e) {
	e.printStackTrace();
} finally {
	if (rsp != null) {
		rsp.close();
	}
	if (statp != null) {
		statp.close();
	}
	if (conn != null) {
		conn.close();
	}
}
%>
<body>
<ol class="breadcrumb">
  <li><a href="main.jsp" target="main">首页</a></li>
  <li class="active">当前登录角色是<%=role%></li>
  <li><a href="../index.jsp" target="_top">退出</a></li>
</ol>
</body>
