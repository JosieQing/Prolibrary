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
<title>浏览界面</title>
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<table border="1" align="center" class="table table-striped table-bordered ">
<thead>
<tr class="alert alert-info">
<td colspan="8" align="center" >
<b>选题组卷操作栏</b>--浏览界面
</td></tr></thead>
<!--功能： 生成可阅读型试卷 -->
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

List<Question>paper=to.getpaper(xuhao);
String Quest="";
String A="";
String B="";
String C="";
String D="";
String E="";
for(int i=0;i<(ques.length)*2;i++)
{	
	if(i%2==0)
	{	
		Question Qnumber=paper.get(i/2);//获取单个的题对象
		if(i<=((xnum-1)*2))
		{
			Quest=""+Qnumber.getNum()+"."+Qnumber.getQuestiontext();
			A=Qnumber.getA();
			B=Qnumber.getB();
			C=Qnumber.getC();
			D=Qnumber.getD();
			E=Qnumber.getE();
			%>
			<tr>
			<td>
			<div><%=Quest %></div>
			<div><%=A %></div>
			<div><%=B %></div>
			<div><%=C %></div>
			<div><%=D %></div>
			<div><%=E %></div>
			</td>
			</tr>
			<%				
		}
		else
		{
			Quest=""+Qnumber.getNum()+"."+Qnumber.getQuestiontext();
			%>
			<tr>
			<td>
			<div><%=Quest %></div>
			</td>
			</tr>
			<%			
		}	
	
	}else
	{
		Quest="";
%>
<tr>
<td>
<input type="text" id="text" name="text" value="<%=Quest %>" class="form-control"/> 
</td>
</tr>
<%	
	}
}
}
%> 
</table>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
</body>
</html>