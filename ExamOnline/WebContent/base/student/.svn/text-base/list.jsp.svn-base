<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.neuedu.examonline.db.*"%>
<%@ page import="com.neuedu.examonline.util.*"%>
<%@ include file="../../inc/theme.jsp" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8"> 
    <title>样式</title>
 
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
    <!-- <link rel="stylesheet" href="../bootstrap/bootstrap.min.css"> -->
  </head>
<body>
<table border="1" class="table table-hover table-bordered " align="center" style="width:700px">
<tr class="danger ">
<td colspan="7">
当前>>学生管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td></tr>
<%
String query_name=null;
query_name=request.getParameter("query_name");
if(query_name==null){
	query_name="";
}else{
	query_name= StringUtil.iSOToUtf8(query_name);
	session.setAttribute("query_name",query_name);
}

%>

<form action="list.jsp">
<tr class="danger ">
<td colspan="7">
姓名：<input type="text" name="query_name" value="<%=query_name%>">
<input type="submit" value="查询" class="btn btn-primary"/>
<input type="button" value="添加" class="btn btn-warning" onclick="location='add.jsp'"/>
</td>
</tr>
</form>

<tr class="danger ">
<td>序号</td>
<td>姓名</td>
<td>学号</td>
<td>性别</td>
<td>年龄</td>
<td>班级</td>
<td>操作</td>
</tr>



<%

int pageSize=10;
int rowTotal=28;
int pageTotal=0;
int currentPage=1;

String str_currentPage="";
str_currentPage=request.getParameter("curp");
if(str_currentPage==null){
	str_currentPage="1";
}


currentPage=Integer.parseInt(str_currentPage);

int i=0;
Statement stat = null;
ResultSet rs = null;
Statement countStat = null;
ResultSet countRs = null;
//String id=null;
//Connection conn=null;


try{
	String countSql="select count(*) as rowTotal  from student where name like '%"+query_name+"%' order by num asc";
	System.out.println("countSql--:"+countSql);
	countStat = conn.createStatement();
	countRs = countStat.executeQuery(countSql);
	while(countRs.next()){
		rowTotal=countRs.getInt("rowTotal");
	}
	
	
	
	if(rowTotal%pageSize==0){
		pageTotal=rowTotal/pageSize;
		}
		else{
		pageTotal=rowTotal/pageSize+1;
		}
	
	int rowIndex=(currentPage-1)*pageSize;
	//rs.last();
	//rowTotal=rs.getRow();
	//rs.beforeFirst();
	String sql="select * from student where name like '%"+query_name+"%' order by num asc";
	System.out.println("sql--:"+sql);
	stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs = stat.executeQuery(sql);
	if(rowIndex==0)
	{
		rs.beforeFirst();
	}
	else{
		rs.absolute(rowIndex);
	}

	
	while(rs.next()){
		if(i>9)
		{
			break;
		}
		String name=rs.getString("name");
		String num=rs.getString("num");
		String sex=rs.getString("sex");
		String age=rs.getString("age");
		String cname=rs.getString("cname");
%>
		<tr class="danger ">
		<td><%=(i+1) %></td>
		<td><%=name %></td>
		<td><%=num %></td>
		<td><%=sex %></td>
		<td><%=age%></td>
		<td><%=cname%></td>

		<td>
		<a href="update.jsp?num=<%=num%>" class="btn btn-warning">修改</a>
		<a href="javascript:delete1('<%=num%>')" class="btn btn-danger">删除</a>
		</td>
		</tr>
<%
i++;
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
		if(countRs!=null){
			countRs.close();
		}
		if(countStat!=null){
			countStat.close();
		}
		
	}catch(SQLException sqle){
		sqle.printStackTrace();
	}
	
}


%>

<tr class="danger ">
<td colspan="7">
共<%=pageTotal%>页&nbsp;&nbsp;当前是第<%=currentPage%>页&nbsp;&nbsp;
<%
if(currentPage==1){

%>

	首页&nbsp;&nbsp;上一页&nbsp;&nbsp;
<%
}else{
%>
<a href="list.jsp?curp=1">首页</a>&nbsp;&nbsp;
<a href="list.jsp?curp=<%=currentPage-1 %>">上一页</a>&nbsp;&nbsp;
<%
}
%>
<% 
if(currentPage==pageTotal){
	%>	
	下一页&nbsp;&nbsp;最后一页&nbsp;&nbsp;
<%
}else{
	%>	
<a href="list.jsp?curp=<%=currentPage+1%>">下一页</a>&nbsp;&nbsp;
<a href="list.jsp?curp=<%=pageTotal%>">最后一页</a>
<% 
}
%>
</td>
</tr>
</table>
</body>
</html>
<!--<script src="../js/jquery-3.2.0.min.js"></script>-->
<script language="javascript">
function delete1(num){
	if(confirm("您确认要删除吗？")){
	//alert("删除逐渐为"+num+"的记录");
		location="delete_action.jsp?num="+num;
	}
}
</script>
<!-- <script src="../bootstrap/jquery.min.js"></script>
    
<script src="../bootstrap/bootstrap.min.js"></script> -->







