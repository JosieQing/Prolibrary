<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../inc/db.jsp" %>
<%
//----------获取?传值里的值----------------
String id=null;
id = request.getParameter("id");
if(id==null){
	id="0";
}
//----------链接数据库----------------
Statement stat = null;
try{
	//拼写update的sql语句
	String sql="delete course where id="+id;
	
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
