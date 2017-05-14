<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.neuedu.examonline.util.*"%>
<%@ include file="../../inc/theme.jsp"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.neuedu.examonline.db.*"%>

<%

String id = null;
id = request.getParameter("id");
if (id == null) {
	id = "0";
}

String[] roleList = null;
roleList = request.getParameterValues("check1");


String menu_str = "";
for (int i = 0; i < roleList.length; i++) {
	menu_str = menu_str + roleList[i] + ",";
}




Statement statadd = null;
try {
	String sql = "update character set menu_str='"+menu_str+"' where id="+id;
	statadd = conn.createStatement();
	statadd.executeUpdate(sql);
	
} catch (Exception e) {
	e.printStackTrace();
} finally {
	if (statadd != null) {
		statadd.close();
	}
	if (conn != null) {
		conn.close();
	}
}



response.sendRedirect("role_manager.jsp");
%>

