<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="../../../inc/theme.jsp"%>

<%
String id= (String)session.getAttribute("MId");
if(id==null){
	id="0";
}

Statement stat = null;
try{
	String sql="delete user_table where idea="+id;
	stat = conn.createStatement();
	stat.executeUpdate(sql);
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		if(stat!=null){
			stat.close();
		}
		if(conn!=null){
			conn.close();
		}
	}catch(SQLException sqle){
		sqle.printStackTrace();
	}
}

response.sendRedirect("../double_table/double.jsp");
%>