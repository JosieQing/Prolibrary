<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.neuedu.examonline.exam.manager.*" %>
<%@ page import="com.neuedu.examonline.util.*" %>
<%@ include file="../../inc/theme.jsp" %>
<%@ page import="java.util.*" %>

<html >
<style>
        td{
            font-family: "华文隶书";
            font-style: normal;

        }
        td：link{
            color: #ffe025;
        }
        td:visited{
            color: darkviolet;
        }
        td:hover{
            color:red;
        }
        td:active{
            color: teal;
            
        }
          p:active{
            color: blue;
        }
</style>
<head>
<title >考试管理</title>

<script src="js/jquery-3.2.0.min.js"></script>

</head>
<body>
<table border="1" style="background:#E0FFFF"  align="center">
<!-- 导航开始 -->
<tr>
<td colspan="7" bgcolor="#00aaaa" >当前>>菜单一</td>
</tr>
<!-- 导航结束 -->
<%
String exam_name=null;
exam_name=request.getParameter("exam_name");
if(exam_name==null){
	exam_name=(String)session.getAttribute("qn");
	if(exam_name==null){
		exam_name="";//输入查询的那个（变量）
	}
}else{
	exam_name = StringUtil.iSOToUtf8(exam_name);
	session.setAttribute("qn", exam_name);
}
%>
<!-- 查询开始 -->
<form action="exam_main.jsp">
<tr>
<td colspan="7">
考试名称:<input type="text" name="exam_name" value="<%=exam_name%>">
  <input class="btn btn-success radius" type="submit" value="查询">
<input class="btn btn-success radius" type="button" value="添加" onclick="location='exam.jsp'">
</td>
</tr>
</form>
<!-- 查询结束 -->

<!-- 列表开始 -->
<tr>
<td>序号</td>
<td>考试名</td>
<td>备注</td>
<td>卷子名</td>
<td>班级</td>
<td>开始时间</td>
<td>管理</td>

</tr>


<% 
//分页相关
int pageSize=10;//页面规定有多少行
int rowTotal=121;//定义有多少行
int pageTotal=0;  //统计共多少页的
int currentPage=1; //记录当前是第几页的
String str_currentPage="";//定义变量 

str_currentPage=request.getParameter("curp");
if(str_currentPage==null){
	str_currentPage="1";
}
currentPage=Integer.parseInt(str_currentPage);


int i=0;
ResultSet rs = null;
Statement stat = null;

ResultSet countRs=null;//sql语句的结果放在resultset类中
Statement countStat=null;//statement 对象负责讲sql语句发送给DB来执行，通过 connecton来创建



try{
	String countSql="select count(*) as rowTotal from exam_management where exam_name like'%"+exam_name+"%'order by id asc";
	//取当前表的总记录数
    System.out.println("countSql--"+countSql);
    countStat=conn.createStatement();
    countRs=countStat.executeQuery(countSql);//查询数据     执行select语句返回一个Resultset 结果集
    if(countRs.next()){
    	rowTotal=countRs.getInt("rowTotal");
    }
    if(rowTotal%pageSize==0){  //一共有多少页
    	pageTotal=rowTotal/pageSize;//如果没有余数那么页数就等于 列数除多少行
    }else{
    	pageTotal=rowTotal/pageSize+1;  //如果有余数那么就加一页 以便于存多数据
    }
   int rowIndex=(currentPage-1)*pageSize;




	
	//String sql="select * from exam_management where exam_name like '%"+exam_name+"%' order by id asc";
	String sql="select e.id,exam_name,remark,j.name ,exam_class ,e.status,e.start_time from paper j,EXAM_MANAGEMENT e where e.paper_id=j.id and e.exam_name like '%"+exam_name+"%' order by e.id asc";
	System.out.println("sql--:"+sql);
	//stat = conn.createStatement();
	stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rs = stat.executeQuery(sql);
	//rs.last();
	//rowTotal=rs.getRow();
	//rs.beforeFirst();
	if(rowIndex==0){
		rs.beforeFirst();
	}else{
		rs.absolute(rowIndex);
	}
	

	while(rs.next()){
		if(i>9)
		{
			break;
		}
		
		String id = rs.getString("id");
		String exam_name1 = rs.getString("exam_name");
		String remark = rs.getString("remark");
		String jtest_parer_name = rs.getString("name");
		String exam_class=rs.getString("exam_class");
		String status=rs.getString("status");
		String start_time=rs.getString("start_time");
		%>
<tr>
<td><%=(i+1)%></td>
<td><%=exam_name1%></td>
<td><%=remark%></td>
<td><%=jtest_parer_name%></td>
<td><%=exam_class %></td>
<td><%=start_time %></td>
<td>
<%
if("1".equals(status)){
%>

<a class="q<%=id%>" href="exam_user_update.jsp?id=<%=id%>">修改</a>
<a class="q<%=id%>" href="javascript:delete1('<%=id%>')">删除</a>
<%
}
%>
  <p  id="<%=id%>">分发</p>   
<!--  <a class="f<%=id%>" href="javascript:fenfa1('<%=id%>')">分发</a> -->
</td>
</tr>
<% 
i++;
	}
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		if(countRs!=null){
			countRs.close();
		}
		if(countStat!=null){
			countStat.close();
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

<!-- 列表结束 -->


<!-- 分页开始 -->
<tr>
<td colspan=7">

共<%=pageTotal %>页&nbsp;&nbsp;当前是第<%=currentPage %>页&nbsp;&nbsp;
<%
if(currentPage==1){
%>
首页&nbsp;&nbsp;上一页&nbsp;&nbsp;
<%
}else{
	%>
	<a href="exam_main.jsp?curp=1">首页</a>&nbsp;&nbsp;
	<a href="exam_main.jsp?curp=<%=currentPage-1 %>"> 上一页</a>
	<%
}                                 
%>
<%if(currentPage==pageTotal){ %>
下一页&nbsp;&nbsp;最后一页
<%}else{
	%>
<a href="exam_main.jsp?curp=<%=currentPage+1 %>">下一页</a>&nbsp;&nbsp;
<a href="exam_main.jsp?curp=<%=pageTotal%>">最后一页</a>
<%
}

%>
</td>
</tr>
<!-- 分页结束 -->

</table>
</body>
</html>
<script luanuage="javascript">
function delete1(id){
	if(confirm("您确认要删除吗？")){
		//alert("删除主键为"+id+"的记录");
		location="exam_user_delete_action.jsp?id="+id;
	}
}
</script>
<script luanuage="javascript">
$(document).ready(function(){
	
  $("p").click(function(){
	//alert($(this).attr("id"));
	if(confirm("确定发卷？")){
	alert(new Date());
	
	$(".q"+$(this).attr("id")).each(function(){
		$(this).hide();
	
	});
	
	
		location="exam_user_fenfa.jsp?id="+$(this).attr("id");
	
	}
  });
});
</script>