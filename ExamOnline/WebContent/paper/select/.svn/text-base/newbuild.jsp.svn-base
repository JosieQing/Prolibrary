<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../inc/theme.jsp"%>    
<%@ page import="com.neuedu.examonline.paper.select.*" %>
<%@ page import="com.neuedu.examonline.paper.select.Question" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>组卷界面</title>
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<table border="1" align="center" class="table table-striped table-bordered">
<thead>
<tr class="alert alert-info">
<td colspan="8" align="center">
<b>选题组卷操作栏</b>--组卷界面
</td>
</tr>
</thead>
<tbody>
<!--功能： 建表和标题分 -->
<%
String question=(String)session.getAttribute("Iwant");
question=question.trim();//去空
String []ques=question.split(",");
Tool to=new Tool();
int[]xuhao=to.paixu(ques);
int xnum=0;//选择题数
for(int x=0;x<xuhao.length;x++)
{
	String obj=to.getstr_st(""+xuhao[x]);
	obj=obj.trim();//去空	
	if("简答".equals(obj))//没起作用
	{
		xnum=x;
		break;
	}
}
String newquestion="";
for(int x:xuhao)
{
	newquestion=newquestion+x+",";
}
newquestion=newquestion.substring(0, newquestion.length()-1);

//接受当前操作的卷纸号和卷纸名
String paperselect=(String)session.getAttribute("paperselect");
String papername=(String)session.getAttribute("papername");
String i=(String)session.getAttribute("i");
System.out.print(i+"刚出session");
if(i==null)
{
	i="1";
}
System.out.print(i+"出session");
%>
<tr>
<td>
当前操作卷号：<%= paperselect%>&nbsp;&nbsp;&nbsp;试卷名：<%= papername%>
</td>
</tr>
<tr>
<td>
共有<%=ques.length %>题&nbsp;&nbsp;分别是：<%=newquestion %>&nbsp;&nbsp;
前<%=xnum %>是选择题&nbsp;
</td>
</tr>
<tr>
<td class="well form-inline">
<form action="buildServlet" method="post" >
此题是第<%=i %>题&nbsp;
试题号是：<input type="text" id="stid" name="stid" class="form-control"/>&nbsp;
设置分数：<input type="text" id="fen" name="fen" class="form-control"/>&nbsp;
<input type="hidden" id="i" name="i" value="<%=i%>"/>
<input type="hidden" id="count" name="count" value="<%=ques.length%>"/>
<input type="submit" value="确定" class="btn btn-danger"/>&nbsp;&nbsp;
<input type="button" value="返回" class="btn btn-primary" onclick="location='list.jsp'"/>
</form>
</td>
</tr>
</tbody>
</table>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
</body>
</html>