<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../inc/theme.jsp" %>
<%
//----------获取from表单里的值----------------
String id=null;
id = request.getParameter("id");
if(id==null){
	id="0";
}

String menu_name=null;
menu_name=request.getParameter("menu_name");//
if(menu_name==null){
	menu_name="";
}else{
	menu_name =new String(menu_name.getBytes("iso-8859-1"),"utf-8");
}

String current_user_id=null;
current_user_id=(String)session.getAttribute("uId");

//----------链接数据库----------------
Statement stat = null;
try{
	//拼写update的sql语句
	String sql="update wang set menu_name='"
	+menu_name+"',UPDATE_TIME=sysdate,UPDATER="+current_user_id+" where id="+id;
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

response.sendRedirect("area_list.jsp");
%>
