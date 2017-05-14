<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.neuedu.examonline.util.*"%>
<%@ include file="../../inc/theme.jsp"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.neuedu.examonline.db.*"%>
<%
	String role = null;
	role = request.getParameter("role");
	if (role == null) {
		role = "";
	} else {
		role = StringUtil.iSOToUtf8(role);
		session.setAttribute("role", role);
	}

	String[] rList = null;
	rList = request.getParameterValues("che");

	String menu_str = "";
	for (int i = 0; i < rList.length; i++) {
		menu_str = menu_str + rList[i] + ",";
	}

	Statement statr = null;
	try {
		String sql = "insert into character(ID,role,menu_str) values(character_id.nextval,'"
				+ role + "','" + menu_str + "')";
		statr = conn.createStatement();
		statr.executeUpdate(sql);

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (statr != null) {
			statr.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	response.sendRedirect("role_manager.jsp");
%>
