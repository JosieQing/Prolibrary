<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*" %>
<%@ page import="com.neuedu.examonline.db.*"%>
<%@ page import="com.neuedu.examonline.base.student.*" %>
<%@ include file="../../inc/theme.jsp" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8"> 
    <title>样式</title>
 
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
   <!--   <link rel="stylesheet" href="../bootstrap/bootstrap.min.css">-->
  </head>
<head>
	

<body>
<%
String num=null;
num=request.getParameter("num");
if(num==null){
	num="0";
}
String name=null;
String sex=null;
String age=null;
String cname=null;

Statement stat = null;
ResultSet rs = null;
//String id=null;
//Connection conn=null;


try{
	String sql="select * from student where num='"+num+"'";
	System.out.println("sql--:"+sql);
	stat = conn.createStatement();
	rs = stat.executeQuery(sql);
	if(rs.next()){
		 name=rs.getString("name");
		 num=rs.getString("num");
		 sex=rs.getString("sex");
		 age=rs.getString("age");
		 cname=rs.getString("cname");
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
<!-- <form  name="fl" action="update_action.jsp"> -->
<input type="hidden" name="num" value="<%=num %>">
<table border="1" class="table table-hover table-bordered " align="center" style="width:500px">
<tr class="success">
<td>姓名</td>
<td><input type="text" name="name" id="name"value="<%=name %>"></td>
</tr>
<tr class="success">
<td>学号</td>
<td><input type="text" name="num" id="num" value="<%=num %>"></td>
</tr>
<tr class="success">
<td>性别</td>
<td><input type="text" name="sex" id="sex" value="<%=sex %>"></td>
</tr>
<tr class="success">
<td>年龄</td>
<td><input type="text" name="age" id="age" value="<%=age%>"></td>
</tr>

<tr class="success">
<td>班级</td>
<td>
<select id="cname"  name="cname">
<%
option op=new option();
List<String> lists=op.sel();
for(String s:lists)
{
%>
<option value="<%=s %>" ><%=s %></option>
<%
}%>

</select></td>
</tr>
<tr class="success">
<td><input type="button" value="提交" id="updateButton" class="btn btn-success"/></td>
<td><input type="button" value="返回" onclick="location='list.jsp'" class="btn btn-warning"/></td>
</tr>
</table>
<!-- </form>-->

</body>
</html>
<script src="update.js"></script>
<!--  <script src="../js/jquery-3.2.0.min.js"></script>

<script src="../bootstrap/jquery.min.js"></script>
    
<script src="../bootstrap/bootstrap.min.js"></script>-->
