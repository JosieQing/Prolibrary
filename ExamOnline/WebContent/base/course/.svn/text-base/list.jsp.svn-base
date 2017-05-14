<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.neuedu.examonline.db.*"%>
<%@ include file="../../inc/theme.jsp" %>
<html>
<head>
	<meta charset="utf-8"> 
    <title>科目管理</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
   <!--  <link rel="stylesheet" href="../../bootstrap/bootstrap.min.css">-->
  </head>

<body>
<table  border="1" class="table table-striped" class="table table-bordered" style="width:800px">
<thead>
<tr>
<td colspan="4">
当前>>科目管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button"  onclick="location='add1.jsp'" value="添加" class="btn btn-primary">

</td>
</tr>

<tr align="center">
<td>序号</td>
<td>id</td>
<td colspan="3">couse</td>
</tr>
</thead>


<%
int pageSize=5;
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
	String countSql="select count(*) as rowTotal  from COURSE order by id asc";
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
	
	String sql="select * from COURSE order by id asc";
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
		if(i>4)
		{
			break;
		}
		String id=rs.getString("id");
		String couse=rs.getString("couse");

%>
		<tr>
		<td><%=(i+1) %></td>
		<td><%=id %></td>
		<td><%=couse%></td>


		<td>
		
		<a href="update1.jsp?id=<%=id%>&couse=<%=couse%>"><button class="btn btn-success">修改</button></a>
		<a href="javascript:delete1('<%=id%>')"><button class="btn btn-danger">删除</button></a>
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
 <a href="list.jsp?curp=1">首页</a>&nbsp;&nbsp;<a href="list.jsp?curp=<%=currentPage-1%>">上一页</a>&nbsp;&nbsp;
<%} %>
<% 
if(currentPage==pageTotal){
%>
下一页&nbsp;&nbsp;尾页&nbsp;&nbsp;

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
<!--  <script src="../../bootstrap/jquery.min.js"></script>-->
    <!-- 可选: 合并了 Bootstrap JavaScript 插件 -->
 <!--   <script src="../../bootstrap/bootstrap.min.js"></script>-->


<script language="javascript">
function delete1(id){
	if(confirm("您确认要删除吗？")){
	alert("删除逐渐为"+id+"的记录");
		location="delete_action.jsp?id="+id;
	}
}
</script>
