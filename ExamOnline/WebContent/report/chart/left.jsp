<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@page import="java.util.*"%>
<%@ page import="com.neuedu.examonline.report.chart.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String wqmh=null;
wqmh=request.getParameter("wqmh");
if(wqmh==null)
{wqmh=(String)session.getAttribute("wqmh");
if(wqmh==null)
	{wqmh="";}
	}else{
		wqmh=new String(wqmh.getBytes("iso-8859-1"),"utf-8");
		session.setAttribute("wqmh",wqmh);
	}
String num=null;
num=request.getParameter("num");
if(num==null)
{num=(String)session.getAttribute("num");
if(num==null)
	{num="";}
	}else{
		num=new String(num.getBytes("iso-8859-1"),"utf-8");
		session.setAttribute("num",num);
	}
String name=null;
name=request.getParameter("name");
if(name==null)
{name=(String)session.getAttribute("name");
if(name==null)
	{name="";}
	}else{
		name=new String(name.getBytes("iso-8859-1"),"utf-8");
		session.setAttribute("name",name);
	}
String sex=null;
sex=request.getParameter("sex");
if(sex==null)
{sex=(String)session.getAttribute("sex");
if(sex==null)
	{sex="";}
	}else{
		sex=new String(sex.getBytes("iso-8859-1"),"utf-8");
		session.setAttribute("sex",sex);
	}
String cname=null;
cname=request.getParameter("cname");
if(cname==null)
{cname=(String)session.getAttribute("cname");
if(cname==null)
	{cname="";}
	}else{
		cname=new String(cname.getBytes("iso-8859-1"),"utf-8");
		session.setAttribute("cname",cname);
	}
String age=null;
age=request.getParameter("age");
if(age==null)
{age=(String)session.getAttribute("age");
if(age==null)
	{age="";}
	}else{
		age=new String(age.getBytes("iso-8859-1"),"utf-8");
		session.setAttribute("age",age);
	}
String kname=null;
kname=request.getParameter("kname");
if(kname==null)
{kname=(String)session.getAttribute("kname");
if(kname==null)
	{kname="";}
	}else{
		kname=new String(kname.getBytes("iso-8859-1"),"utf-8");
		session.setAttribute("kname",kname);
	}
String kszname=null;
kszname=request.getParameter("kszname");
if(kszname==null)
{kszname=(String)session.getAttribute("kszname");
if(kszname==null)
	{kszname="";}
	}else{
		kszname=new String(kszname.getBytes("iso-8859-1"),"utf-8");
		session.setAttribute("kszname",kszname);
	}


%>
<table border="1"><tr><td>
<table border="1">
<tr align="center"><td>学号</td><td>姓名</td><td>性别</td><td>班级</td><td>年龄</td><td>操作</td></tr>
<% List abb=(List)session.getAttribute("Li");
List bbc=new ArrayList();
List bbc1=new ArrayList();

PageUtil pu = new PageUtil();
UserBean ub = new UserBean();
StudentBean stt=new StudentBean();
int currentPage=1;
String str_currentPage="";

str_currentPage=request.getParameter("dqy");
if(str_currentPage==null){
	str_currentPage="1";
}
int rowTotal=0;
int pageTotal=0;

currentPage = Integer.parseInt(str_currentPage);
try{
	if(abb==null){

	//得到总行数
	rowTotal=ub.getCount();
	
	//得到总页数
	pageTotal= pu.getPageTotal(rowTotal);
	
	//得到当前游标
	int rowIndex = pu.getRowIndex(currentPage);
	

	//得到列表
	List rList = ub.getList(rowIndex, pu.getPageSize());
	for(int i=0;i<rList.size();i++){
		Student uo = (Student)rList.get(i);
		String sno = uo.getSno();
		String name1=uo.getSname();
		String sex1=uo.getSex();
		String cname1=uo.getBname();
		String age1=uo.getSage();
		bbc.add(sno);
		System.out.println(name1);
		bbc1.add(name1);
%>
<tr>
<td id="td<%=i%>"><%=sno%></td>
<td><%=name1%></td>
<td><%=sex1%></td>
<td><%=cname1%></td>
<td><%=age1%></td>
<td align="center">
<input  id="in<%=i %>" type="button" value="个人折线图">&nbsp;&nbsp;<input  id="hn<%=i %>" type="button" value="个人能力图">
</td>
</tr>
<%
	}}else{
		int pagesize=8;
		rowTotal=abb.size();
		
		//得到总页数
		pageTotal= pu.getPageTotal(rowTotal);
	List acc=	stt.Select(abb, currentPage, pagesize);
	for(int i=0;i<acc.size();i++){
		Student uo = (Student)acc.get(i);
		String sno = uo.getSno();
		String name1=uo.getSname();
		String sex1=uo.getSex();
		String cname1=uo.getBname();
		String age1=uo.getSage();
		bbc.add(sno);
		bbc1.add(StringUtil.iSOToUtf8(name1));
%>
<tr>
<td id="td<%=i%>"><%=sno%></td>
<td><%=name1%></td>
<td><%=sex1%></td>
<td><%=cname1%></td>
<td><%=age1%></td>
<td align="center">
<input  id="in<%=i %>" type="button" value="个人折线图">&nbsp;&nbsp;<input  id="hn<%=i %>"  type="button" value="个人能力图">
</td>
</tr>
<%
	}
	}
	session.setAttribute("LL", bbc);
	session.setAttribute("LL1", bbc1);
}catch(Exception e){
	e.printStackTrace();
}
%>
<tr><td colspan="6">共<%=pageTotal %>页
&nbsp;&nbsp;当前是第<select id="sbb1"><%for(int i=1;i<=pageTotal;i++){if(i==currentPage){%><option selected="selected"><%=currentPage %></option><%}else{%><option><%=i %></option><%}} %></select>
页<input id="ab1" type="button" value="跳转">&nbsp;&nbsp;<% if(currentPage!=1){ %>
<a href="left.jsp?dqy=<%=1 %>">
<%} %>首页<% if(currentPage!=1){ %></a>
<%} %>&nbsp;&nbsp;<% if(currentPage!=1){ %>
<a href="left.jsp?dqy=<%=currentPage-1 %>"><%} %>
上一页<% if(currentPage!=1){ %></a><%} %>&nbsp;&nbsp;
<% if(currentPage!=pageTotal){ %>
<a href="left.jsp?dqy=<%=currentPage+1 %>">
<%} %>下一页<% if(currentPage!=pageTotal){ %>
</a><%} %>&nbsp;&nbsp;<% if(currentPage!=pageTotal){ %>
<a href="left.jsp?dqy=<%=pageTotal%>">
<%} %>尾页<% if(currentPage!=pageTotal){ %>
</a><%} %>&nbsp;&nbsp;
<input id="ab2" type="button" value="显示全部">
</td></tr>
<tr><td colspan="6" align="center"><input  id="ssd1" type="button" value="显示当前列表柱形图"></td></tr>
</table></td>
<td>
<form id="lForm" name="lForm" action="left.jsp" method="post">
<table border="1">
<tr><td><input id="ss1" type="button" value="确定">&nbsp;&nbsp;完全模糊查询:&nbsp;&nbsp;</td><td><input id="tt1" type="text" value="<%=wqmh%>"></td></tr>
<tr align="center"><td colspan="2">按各项模糊查询:</td></tr>
<tr><td align="center">学号:</td><td><input id="tt2" type="text" value="<%=num%>"></td></tr>
<tr><td align="center">姓名:</td><td><input id="tt3" type="text" value="<%=name%>"></td></tr>
<tr><td align="center">性别:</td><td><select id="tt4"><option <% if(sex.equals("男")){%> selected="selected"<% } %>>男</option><option <% if(sex.equals("女")){%> selected="selected"<% } %>>女</option></select></td></tr>
<tr><td align="center">班级:</td><td><select id="tt5"><option><%=cname%></option><div id="d1"></div></select></td></tr>
<tr><td align="center">年龄:</td><td><input id="tt6" type="text" value="<%=age%>"></td></tr>
<tr><td colspan="2" align="center"><input id="ss2" type="button" value="确定"></td></tr>
<tr><td><input id="ss3" type="button" value="确定">&nbsp;&nbsp;按考试名查询:&nbsp;&nbsp;</td><td><select id="tt7"><option value="1"><%=kname%></option><div id="d2"></div></select></td></tr>
<tr><td><input id="ss4" type="button" value="确定">&nbsp;&nbsp;按考试组查询:&nbsp;&nbsp;</td><td><select id="tt8"><option value="1"><%=kszname%></option></select></td></tr>
</table>
</form>
</td>
</tr>
</table>
<script src="js/jquery-3.2.0.min.js"></script>
<script src="js/left.js"></script>
</body>
</html>