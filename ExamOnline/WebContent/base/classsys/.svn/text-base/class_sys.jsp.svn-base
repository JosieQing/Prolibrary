<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>  
<%@ page import="com.neuedu.examonline.base.classsys.*"%>
<%@ include file="../../inc/theme.jsp" %>

<!DOCTYPE html>
<html>
<head>
<title>考试管理系统————班级管理</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<!-- <link rel="stylesheet" href="../../bootstrap/bootstrap.min.css"> -->
<style>
body
{
background:#5bc0de;
}

</style>
</head>
<body>
    
<script src="../../js/jquery-3.2.0.min.js" type="text/javascript"></script>
<script src="../../bootstrap/bootstrap.min.js"></script>

<%
List<Class_control> list = (List<Class_control>)session.getAttribute("clist");
%>
<form  action="../../AllSelect?name=" method="post"  class="form form-horizontal"><!-- 需要更改 -->
  <div class="row cl" style="width:1000">
  <label for="inputPassword" class="col-sm-2 control-label">
班级名称</label>
<div class="col-sm-3"><input type="text" class="form-control" id="query_cname" placeholder="class name">
</div>
</div>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button"  class="btn btn-default" value="查询" id="sel_cc"/>
<input type="button"  class="btn btn-primary" value="添加" id="add_cc" onclick="location='add.jsp'"/>
<input type="submit" class="btn btn-success" value="显示全部" id="show_all"/>
</form>
<table border="1" class="table table-striped">
		<tr>
			<td>序号</td>
			<td>班级名称</td>
			<td>专业方向</td>
			<td>教室</td>
			<td>人数</td>
			<td>指导老师</td>
			<td>教学老师</td>
			<td>开班时间</td>
			<td>操作选项</td>
		</tr>
<%

int count = 1;


int rowCount = list.size();//一共几条数据
int pageRow = 10;//每页显示数
int pageSize = rowCount / pageRow + 1;//总页数
if(rowCount%pageRow==0)
{
	pageSize=rowCount/pageRow;
}


int currentPage = 1;//当前页数
String cp = request.getParameter("currentPage");
if (cp != null) {
	currentPage = Integer.parseInt(cp);
	if (currentPage < 1) {
		currentPage = 1;
	}
}


int startIndex = (currentPage - 1) * 10;
int length = startIndex + 10;
if (list.size() < length) {
	length = list.size();
}

if(list.size()>0)
{	
		
	int i = 0;
	for(Class_control cc:list)
	{	
		
		if(i>=startIndex&&i<length)
		{
	
		%>
	<tr>
			<td><%=count%></td>
			<td><%=cc.getCname()%></td>
			<td><%=cc.getSpeciality()%></td>
			<td><%=cc.getClassnum()%></td>
			<td><%=cc.getPnum()%></td>
			<td><%=cc.getMentor()%></td>
			<td><%=cc.getTeacher() %></td>
			<td><%=cc.getStart_date()%></td>
			<td>
		<input type="button"  class="btn btn-warning" value="修改" onclick="location='update.jsp?cno=<%=cc.getCno()%>'"/>
		<input type="button" class="btn btn-danger"value="删除" id="delete" onclick="del(<%=cc.getCno()%>)"/>
			</td>
		</tr>
<%
			count++;
		}
		i++;
	}
}
%>


</table>
<div>
共<%=pageSize%>页&nbsp;&nbsp; 当前第<%=currentPage%>页&nbsp;&nbsp;
	<%
		if (currentPage == 1) {
	%>
	首页&nbsp;&nbsp;上一页&nbsp;&nbsp;
	<%
		} else {
	%>
	<a href="class_sys.jsp?currentPage=<%=1%>">首页</a>&nbsp;&nbsp;
	<a href="class_sys.jsp?currentPage=<%=currentPage-1%>">上一页</a>&nbsp;&nbsp;
	<%
 	}
 	if (currentPage == pageSize) {
 %>
	下一页&nbsp;&nbsp;最后一页&nbsp;&nbsp;
	<%
	} else {
	%>
	<a href="class_sys.jsp?currentPage=<%=currentPage + 1%>">下一页</a>&nbsp;&nbsp;
	<a href="class_sys.jsp?currentPage=<%=pageSize%>">最后一页</a>&nbsp;&nbsp;
	<%
		}
	%>
</div>

</body>
</html>
<script>
function del(id)
{
	if(confirm("确定删除该教师吗？"))
	{
			$.ajax
			(
				{
					url:"../../DelClass",
					type:"post",
					async:true,
					data:{
						cno:id	
					},
					
					timeout:5000,
					dataType:"text",	
					success:function(data,textStatus,jqXHR){						
							location="class_sys.jsp";
					
					},
					error:function(xhr,textStatus){
						alert("请求错误");
					}			
				}				
			)		
	}
}

$(document).ready(function()
		{
		   
			$("#sel_cc").click(function(){
				
				$.ajax
				(
					{
						url:"../../AllSelect",
						type:"post",
						async:true,
						data:{
							name:$("#query_cname").val()	
						},
						timeout:5000,
						dataType:"text",	
						success:function(data,textStatus,jqXHR){
							
								location="class_sys.jsp";
						
						},
						error:function(xhr,textStatus){
							alert("错误");
						}			
					}				
				)	
			})		
		})



</script>
