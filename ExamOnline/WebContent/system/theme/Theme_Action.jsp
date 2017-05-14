<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../inc/theme.jsp"%>
<!-- 此页面为过渡改变主题颜色 -->
<%
String color=null;
color=request.getParameter("cl"/* name */);
if(color==null)
{
	color="";}
String userid1=null;
userid1=request.getParameter("id"/* name */);
if(userid1==null)
{
	userid1="";}
System.out.println("color:"+color+",userid1:"+userid1);



Statement stat = null;
ResultSet rs = null;

try{
	String sql="update theme set theme='"+  color  +"' where userid ='"+ userid1 +"'";/* 此处的id为session传过来的值 */
	stat = conn.createStatement();
	stat.executeUpdate(sql);
	
		
		
	
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		if(rs!=null){
			rs.close();
		}
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
response.sendRedirect("Theme.jsp");
%>