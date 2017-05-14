<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ include file="../../inc/theme.jsp" %>
<html>
<body>
<%
String id = null;
id = request.getParameter("id");

String menu_name = null;
Statement stat = null;
ResultSet rs = null;
try{
	String sql="select * from wang where id="+id;
	System.out.println("sql--:"+sql);
	stat = conn.createStatement();
	rs = stat.executeQuery(sql);
	while(rs.next()){
		menu_name = rs.getString("menu_name");
	}
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
%>



<form  name="f1" action="area_update_action.jsp">
<input type="hidden" name="id" value="<%=id%>">
<table border="1" class="table table-hover" style="width:500px"><tr>
<td>id</td>
<td><%=id%></td>
</tr>
<tr class="warning" align="center">
<td>菜单名称</td>
<td><input type="text" name = "menu_name" value="<%=menu_name%>"></td>
</tr>
<tr>
<td><input type="button" value="提交" onclick="document.f1.submit();"class="btn btn-primary"/></td>
<td><input type="button" value="返回" onclick="location='area_list.jsp'"class="btn btn-primary"/></td>
</tr>
</table>
</form>
</body>
</html>