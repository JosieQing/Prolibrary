<%@page import="java.util.List"%>
<%@ include file="../../../inc/theme.jsp"%>    
<%@ page import="com.neuedu.examonline.paper.select.Tool" %>
<%@ page import="com.neuedu.examonline.paper.select.Question" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选题界面</title>
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<table border="1" align="center" class="table table-striped table-bordered">
<thead>
<tr class="alert alert-info">
<td colspan="8" align="center">
<b>选题组卷操作栏</b>--选题界面
</td>
</tr>
<%
String err=request.getParameter("err");
if("0".equals(err))
{
	out.print("没有选取题目！");
}
java.text.SimpleDateFormat formater=new java.text.SimpleDateFormat("yyyy年MM月dd日  h:mm a");
String strCurrentTime =formater.format(new java.util.Date());
int nowpage=0;
int rowtotal=0;
int pagetotal=0;
Tool to=new Tool();
rowtotal=to.getrowtotal();
//接收操作人
String bibox=null;
bibox=request.getParameter("bibox");
if(bibox==null)
{
	bibox="尼古拉斯赵四";//设置的初始值，因为表只有五条信息
}
if(bibox=="")
{
	bibox="尼古拉斯赵四";//设置的初始值，因为表只有五条信息
}
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
//接收设置的列表显示容量
String str_pagesize=null;
str_pagesize=request.getParameter("pagesize");
if(str_pagesize==null)
{
	str_pagesize="3";//设置的初始值，因为表只有五条信息
}
if(str_pagesize=="")
{
	str_pagesize="3";//设置的初始值，因为表只有五条信息
}
int pagesize=Integer.parseInt(str_pagesize);
//接收搜索内容
String select="";
select=request.getParameter("text");
if(select==""||select==null)
{
	select="请输入题号/题型/学科";
}else
{
	select=new String(select.getBytes("iso8859-1"),"utf-8");
}
//接收当前页
String str_nowpage=request.getParameter("nowpage");
if(str_nowpage==null)
{
	str_nowpage="1";
}
nowpage=Integer.parseInt(str_nowpage);
//接受textvalue-搜索信息
String textvalue=request.getParameter("text");

pagetotal=to.getpagetotal(rowtotal,pagesize);
int rowIndex=to.getnowIndex(str_nowpage,pagesize);
String radiovalue=request.getParameter("radio");
%>
<tr align="center"><form  name="formSelect" action="list.jsp">
<td colspan="6" class="well form-inline">
总题数：<input id="quessize" name="quessize" type="text" class="form-control" value="<%=rowtotal %>"/>
列表容量：<input id="pagesize" name="pagesize" class="form-control" type="text"/>
搜索：<input id="text" name="text" type="text" class="form-control" value="<%=select%>"/>
<input id="submit" name="submit" type="submit" class="btn btn-success" value="确定">
</td>
<td rowspan="2">
<b>搜索类型：</b><br><br>
<input type="radio" id="questiontext" name="radio" value="1"/>题号<br>
<input type="radio" id="boss" name="radio" value="2"/>题型<br>
<input type="radio" id="tixingid" name="radio" value="3"/>学科</td></form>
<td rowspan="<%=pagesize+2%>"><div>
操作人：<br><%=bibox %></div><br/><div>
登入时间：<br><%=strCurrentTime %></div>
<br/><div>操作试卷号：<br><%=papershow %></div></td>
</tr>
<tr>
<td align="center">序号</td>
<td align="center">题号</td>
<td align="center">题干</td>
<td align="center">出题人</td>
<td align="center">题型</td>
<td align="center">所属学科</td>
</tr>
</thead>
<tbody>
<%
int nowIndex=to.getnowIndex(str_nowpage,pagesize);
if(textvalue!=null)
{
	textvalue=new String(textvalue.getBytes("iso8859-1"),"utf-8");
}
List<Question>list=to.getlist(pagesize,rowIndex,radiovalue,textvalue);
for(int i=0;i<list.size();i++)
{
	Question ques=list.get(i);
	String id = ques.getId();
	String questiontext=ques.getQuestiontext() ; 
	String boss=ques.getBoss() ;           
	String types_name= ques.getTypes_name();
	String COUSE = ques.getCOUSE();	
%>
<tr>
<td><%=i+1 %></td>
<td><%=id %></td>
<td><%=questiontext %></td>
<td><%=boss %></td>
<td><%=types_name %></td>
<td><%=COUSE %></td>
<td>
<input type="checkbox" class="want" name="want" id="want" value="<%=id %>"/><!-- 此处多选的value值时此题的题号ID -->
</td>
<%
}
%>
</tr>

<tr>
<td colspan="8" align="center" class="well form-inline">
<input type="button" class="btn btn-warning" onclick="getOne()" value="选取">&nbsp;
当页所选题题号:<input id="questext" name="questext" type="text" class="form-control"/>&nbsp;
<input type="button" value="生成试卷" class="btn btn-danger" onclick="over()"/>&nbsp;
<input type="button" value="预览" class="btn btn-primary" onclick="looknow()"/></td>
</tr>
</tbody>
<tr>
<td  colspan="8" align="center">共<%=pagetotal %>页&nbsp;当前页：<%=nowpage %>&nbsp;
<%
if(nowpage<=1)
{
%>
首页&nbsp;&nbsp;上一页
<%	
}else
{
%>
<a href="list.jsp?nowpage=1&select=<%=select %>">首页</a>&nbsp;
<a href="list.jsp?nowpage=<%=nowpage-1 %>&select=<%=select %>">上一页</a>&nbsp;
<%	
}
%>
<%
if(nowpage>=pagetotal)
{
%>
下一页&nbsp;&nbsp;尾页
<%	
}else
{
%>
<a href="list.jsp?nowpage=<%=nowpage+1 %>&select=<%=select %>">下一页</a>&nbsp;
<a href="list.jsp?nowpage=<%=pagetotal %>&select=<%=select %>">尾页</a></td> 
<%	
}
%>
</tr>
</table>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              
</body>
</html>
<script src="js/list.js"></script>