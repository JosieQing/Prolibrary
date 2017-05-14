<%@page import="java.util.List"%>
<%@ include file="../../../inc/theme.jsp"%> 
<%@ page import="com.neuedu.examonline.paper.select.*" %>
<%@ page import="com.neuedu.examonline.paper.select.Question" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>建卷界面</title>
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<table border="1" align="center" class="table table-bordered">
<tr class="alert alert-info">
<td colspan="8" align="center">
<b>选题组卷操作栏</b>--建卷界面
</td>
</tr>
<!--功能： 建表和标题分 -->
<%
String question=(String)session.getAttribute("Iwant");
if(question==null)
{
	response.sendRedirect("list.jsp?err=0");
}else
{
question=question.trim();//去空
String []ques=question.split(",");
Tool to=new Tool();
//查找当前已有卷号最大值
String paper=to.getpapernum();
//接受操作卷纸号
if(paper==null)
{
	paper="1";//设置的初始值
}
if(paper=="")
{
	paper="1";//设置的初始值
}
//显示的当前操作页面
int papershow =1;
papershow=Integer.parseInt(paper)+1;
%>
<%

%>
<tr>
<td>
共选中<%=ques.length %>题&nbsp;&nbsp;当前操作卷号：<%= papershow%>&nbsp;
</td>
</tr>
<tr>
<td class="well form-inline">
<form action="makeServlet" method="post">
试卷名：<input name="papername" type="text" class="form-control"/>
要操作的卷号：<input type="text" id="paperselect" name="paperselect" class="form-control"/>&nbsp;
<input type="hidden" id="papershow" name="papershow" value="<%=papershow %>">
<input type="submit" value="确定" class="btn btn-danger"/>&nbsp;&nbsp;
<input type="button" value="返回" class="btn btn-primary" onclick="location='list.jsp'"/>
</form>
<%
}
%>
</td>
</tr>
</table>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
</body>
</html>