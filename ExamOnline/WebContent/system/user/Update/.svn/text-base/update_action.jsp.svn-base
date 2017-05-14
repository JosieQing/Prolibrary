<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="../../../inc/theme.jsp"%>

<%
String id= (String)session.getAttribute("MId");
if(id==null){
	id="0";
}

Statement stat = null;
String login_name = request.getParameter("login_name");
String password = request.getParameter("password");
String actress = request.getParameter("add_role");
String add_role = new String(actress.getBytes("iso-8859-1"), "utf-8");
String remark = request.getParameter("remark");
String add_remark = new String(remark.getBytes("iso-8859-1"), "utf-8");

try{
	String sql="update user_table set login_name = '"+login_name+"',password='"+
			password+"',role='"+add_role+"',remark='"+add_remark+"' where idea="+id;
	System.out.print(sql);
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