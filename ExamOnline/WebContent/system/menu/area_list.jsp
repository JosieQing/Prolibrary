<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../inc/theme.jsp" %>
<%@ page import="java.sql.*" %>
<%@ page import="com.neuedu.examonline.db.*"  %>
<html>
<html>
<head>
	<meta charset="utf-8"> 
    <title>菜单名称</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
   <!--  <link rel="stylesheet" href="../../bootstrap/bootstrap.min.css">-->
  </head>

<body>
<table  border="1" class="table table-striped" class="table table-bordered" style="width:800px">
<thead>
<tr>
<td colspan="4">
当前>>菜单名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</td>
</tr>
<body>


<!-- 列表开始 -->

<tr>
<td>序号</td>
<td>id</td>
<td>菜单名称</td>
<td>操作</td>
</tr>

<%
int pageSize=10;
int rowTotal=0;
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
try{
	String countSql="select count(*) as rowTotal  from WANG order by id asc";
	System.out.println("countSql--:"+countSql);
	countStat = conn.createStatement();
	countRs = countStat.executeQuery(countSql);
	while(countRs.next()){
		rowTotal=countRs.getInt("rowTotal");
	}
	
	if(rowTotal%pageSize==0){
		pageTotal=rowTotal/pageSize;
	}else{
		pageTotal=rowTotal/pageSize+1;
	}
	
	int rowIndex = (currentPage-1)*pageSize;
	
	String sql="select * from WANG order by id asc";
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
		String id = rs.getString("id");
		String menu_name = rs.getString("menu_name");
%>
<tr>
<td><%=(i+1)%></td>
<td><%=id %></td>
<td><%=menu_name%></td>
<td>
<a href="area_update.jsp?id=<%=id%>"><button class="btn btn-success">修改</button></a>
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
<tr>
<td colspan="4">
共<%=pageTotal%>页&nbsp;&nbsp;当前是第<%=currentPage %>页&nbsp;&nbsp;
<%
if(currentPage==1){
%>
首页&nbsp;&nbsp;上一页&nbsp;&nbsp;

<%
}else{
%>
 <a href="area_list.jsp?curp=1">首页
 </a>&nbsp;&nbsp;<a href="area_list.jsp?curp=<%=currentPage-1%>">上一页</a>&nbsp;&nbsp;
<%} %>
<% 
if(currentPage==pageTotal){
%>
下一页&nbsp;&nbsp;尾页&nbsp;&nbsp;

<%
	}else{
%>
<a href="area_list.jsp?curp=<%=currentPage+1%>">下一页</a>&nbsp;&nbsp;
	<a href="area_list.jsp?curp=<%=pageTotal%>">最后一页</a>

<%	
} 
%>
</td>
</tr>
</table>
</body>
</html>
<!--  <script src="../../bootstrap/jquery.min.js"></script>-->
    <!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
 <!--   <script src="../../bootstrap/bootstrap.min.js"></script>-->
