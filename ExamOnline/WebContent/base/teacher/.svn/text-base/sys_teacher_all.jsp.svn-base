<!DOCTYPE html>   
<html>
<head>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>  
<%@ page import="com.neuedu.examonline.base.teacher.*"%>
<%@ page import="com.neuedu.examonline.util.*"%>
<%@ page import="java.util.Date"%> 
<%@ include file="../../inc/theme.jsp" %>
<script src="js/teacher.js" type="text/javascript"></script>


<%
List<Teacher> list = (List<Teacher>)session.getAttribute("tlist");
%>
</head>
<body>
<form action="../../TeacherServlet?name=" method="post">
<div class="container">
	<div class="row">
		<div class="col-md-8">
			输入姓名<input type="text" id="query_tname"/>
			<input type="button" value="查询" id="sel_ter" class="btn btn-primary"/>
		</div>
		<div class="col-md-4">
			<input type="button" value="添加" id="add_ter" class="btn btn-success" onclick="location='add_ter.jsp'"/>
			<input type="submit" value="显示全部" class="btn btn-primary" id="show_all"/>
		</div>
	</div>
</div>
</form>
<div class="container">
		<div class="row">
			<!--  <div class="col-md-1">序号</div> -->
			<div class="col-md-1">教工编号</div>
			<div class="col-md-1">姓名</div>
			<div class="col-md-1">性别</div>
			<div class="col-md-1">年龄</div>
			<div class="col-md-2">TEL</div>
			<div class="col-md-3">入职日期</div>
			<div class="col-md-1">备注信息</div>
			<div class="col-md-2">操作项</div>
		</div>
<%

int count = 1;


int rowCount = list.size();//一共几条数据
int pageRow = 10;//每页显示数
int pageSize = rowCount / pageRow + 1;//总页数
if(rowCount % pageRow == 0)
{
	pageSize = rowCount / pageRow;	
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
	for(Teacher ter:list)
	{	
		
		if(i>=startIndex&&i<length)
		{
			
		%>
	<div class="row" border="10">
		
			<div class="col-md-1"><%=ter.getTno()%></div>
			<div class="col-md-1"><%=ter.getTname()%></div>
			<div class="col-md-1"><%=ter.getTsex()%></div>
			<div class="col-md-1"><%=ter.getTage()%></div>
			<div class="col-md-2"><%=ter.getTtel()%></div>
			<div class="col-md-3"><%=ter.getHiredate()%></div>
			<div class="col-md-1"><%=ter.getTremark()%></div>
			<div class="col-md-2">
		<input type="button" class="btn btn-warning" value="修改" onclick="location='update_ter.jsp?tno=<%=ter.getTno()%>'"/>
		<input type="button" class="btn btn-danger" value="删除" id="del_btn" onclick="del(<%=ter.getTno()%>)"/>
			</div>
		</div>
<%
			count++;
		}
		i++;
	}
}
%>
</div>
<div class="container">
	<div class="row">
		<div class="col-md-2">共<%=pageSize%>页</div>
		<div class="col-md-2"> 当前第<%=currentPage%>页</div>
	<%
		if (currentPage == 1) {
	%>
	<div class="col-md-1">首页</div>
	<div class="col-md-1">上一页</div>
	<%
		} else {
	%>
	<div class="col-md-1"><a href="sys_teacher_all.jsp?currentPage=<%=1%>">首页</a></div>
	<div class="col-md-1"><a href="sys_teacher_all.jsp?currentPage=<%=currentPage-1%>">上一页</a></div>
	<%
 	}
 	if (currentPage == pageSize) {
 %>
	<div class="col-md-1">下一页</div>
	<div class="col-md-2">最后一页</div>
	<%
	} else {
	%>
	<div class="col-md-1"><a href="sys_teacher_all.jsp?currentPage=<%=currentPage + 1%>">下一页</a></div>
	<div class="col-md-2"><a href="sys_teacher_all.jsp?currentPage=<%=pageSize%>">最后一页</a></div>
	<%
		}
	%>
	</div>
</div>
</body>
</html>



