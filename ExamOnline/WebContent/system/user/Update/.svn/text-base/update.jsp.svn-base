<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="../../../inc/theme.jsp"%>
<link rel="stylesheet" href="<%=basePath %>/css/double.css" type="text/css">

<html>
<head>
<style type="text/css">
#add_role{
width:53%;
}
</style>
</head>
<body>
<%
String id=null;
id = request.getParameter("id");
if(id==null){
	id="0";
}
session.setAttribute("MId",id);

String login_name = "";
String password = "";
String remark = "";

ResultSet rs = null;
Statement stat = null;

try{
	String sql="select * from user_table where idea = "+id;
	stat = conn.createStatement();
	rs = stat.executeQuery(sql);
	if(rs.next()){
		login_name = rs.getString("login_name");
		password = rs.getString("password");
		remark = rs.getString("remark");
	}
}catch(Exception e){
e.printStackTrace();
}
%>

<form name="f1" action="update_action.jsp">
<table border="1" id="uptable">
<tr>
<td align="center">登录名</td>
<td align="center"><input type="text" name="login_name" value="<%=login_name%>"></td>
</tr>
<tr>
<td align="center">密码</td>
<td align="center"><input type="text" name="password" value="<%=password%>"></td>
</tr>
<tr>
<td align="center">角色</td>
<td align="center">
<select id="add_role" name="add_role">
<%
Statement hide = null;
ResultSet show = null;

String actress = null;
try{
	//链接数据库
	String sql = "SELECT * from acter";
	hide = conn.createStatement();
	show = hide.executeQuery(sql);
	while(show.next()){
		actress = show.getString("actress");
%>
<option value="<%=actress%>"><%=actress%></option>
<%
	}
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		if(hide!=null){
			hide.close();
		}
		if(show!=null){
			show.close();
		}
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
%>
</select>
</td>
</tr>
<tr>
<td align="center">备注</td>
<td align="center"><input type="text" name="remark" value="<%=remark%>"/></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="button" class="btn btn-success" value="确定" onclick="document.f1.submit();"/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" class="btn btn-success" value="返回" onclick="location='../double_table/double.jsp'"/></td>
</tr>
</table>
</form>
</body>
</html>
