<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ include file="../../inc/theme.jsp" %>

<%
String num=null;
num=request.getParameter("num");
if(num==null){
	num="0";
}


Statement stat = null;
try{

	String sql="delete student where num="+num;
	
	System.out.println("sql--:"+sql);
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

response.sendRedirect("list.jsp");
%>
