<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../inc/theme.jsp"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.neuedu.examonline.db.*"%>

<%
	String id = null;
	id = request.getParameter("id");
	if (id == null) {
		id = "0";
	}

	Statement stat = null;
	try {
		//拼写update的sql语句
		String sql = "delete character where id=" + id;

		stat = conn.createStatement();
		stat.executeUpdate(sql);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (stat != null) {
				stat.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	response.sendRedirect("role_manager.jsp");
%>