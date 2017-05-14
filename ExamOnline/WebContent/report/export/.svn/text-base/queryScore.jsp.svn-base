<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.neuedu.examonline.report.export.*"%>
<%@ include file="../../../inc/theme.jsp"%>  
<div>
<html>
<head>
<meta charset="utf-8">
<title>导出列表</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../../bootstrap/bootstrap.min.css">
</head>

<body style="background:url('images/1.jpg') no-repeat;">
<h2 align="center">列表查询及导出</h2>

&nbsp;&nbsp;&nbsp;<a href="excel.jsp"><h4>导出列表</h4></a>

<%
String student_id;
student_id=(String)session.getAttribute("student_id");
if(student_id==null)
{
	student_id=(String)session.getAttribute("idd");
}else{
	session.setAttribute("idd",student_id);	
}

StudentQueryBean sqb = new StudentQueryBean();
List<StudentQuery> list=sqb.studentScoreQuery("1");
session.setAttribute("Liii", list);
int length = list.size();
//System.out.println("length :"+length );
%>

<table class="table table-striped">
<tr>
<td>学生id</td>
<td>学生姓名</td>
<td>班级</td>
<td>考试名称</td>
<td>考试id</td>
<td>考试时间</td>
<td>分数</td>

</tr>

<%	

int rowCount=list.size();//集合里一共有多少条数据
int pageRow=10;//每页显示的行数
int pageSize=1;
	if(rowCount%pageRow==0)
		{
			pageSize=rowCount/pageRow;
		}
	else
		{
			pageSize=rowCount/pageRow+1;
		}
int currentPage=1;//当前页数

String cp=request.getParameter("currentPage");
	if(cp!=null)
	{
		currentPage = Integer.parseInt(cp);
		if(currentPage<1)
		{
			currentPage=1;
		}
	}
	
int startIndex=(currentPage-1)*10;
int pageLength=startIndex+10;
	if(list.size()<pageLength)
	{
		pageLength=list.size();
	}
	

if(list.size()>0)
{
	int i=0;
	int count=0;
	
	for(StudentQuery sq:list)
	{
		if(i>=startIndex&&i<pageLength)
		{
%>
<tr>
<td><%=sq.getStudent_id()%></td>
<td><%=sq.getName()%></td>
<td><%=sq.getClass_name()%></td>
<td><%=sq.getExam_name()%></td>
<td><%=sq.getExam_id()%></td>
<td><%=sq.getStart_time()%></td>
<td><%=sq.getStudent_score()%></td> 


<%
		}
count++;
i++;
	}

}
%>

</tr>
<tr>
<td colspan="7">
共<%=pageSize%>页&nbsp;&nbsp;&nbsp;&nbsp;当前是第<%=currentPage%>页&nbsp;&nbsp;&nbsp;&nbsp;

<%
	if(currentPage==1)
	{
%>
首页&nbsp;&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;
<% 	
	}
	else
	{
%>
	<a href="queryScore.jsp?currentPage=<%=1%>">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="queryScore.jsp?currentPage=<%=currentPage-1%>">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<%		
	}
	if(currentPage==pageSize){
%>
下一页&nbsp;&nbsp;&nbsp;&nbsp;最后一页
<%
	}
	else{
%>
	<a href="queryScore.jsp?currentPage=<%=currentPage+1%>">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="queryScore.jsp?currentPage=<%=pageSize%>">最后一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<%	
	}
%>
</td>
</tr>
</table>


</body>
</html>
</div>
<script src="../../js/jquery-3.2.0.min.js"></script>
<script>

$(document).ready(function(){
	
	<%for(int i=0;i<length;i++)
	{
	%>

	$("#btn"+<%=i%>).click(function(){	
	location="scoreDetails.jsp?studentid=<%=student_id%>&exam_id="+$("#hid"+<%=i%>).val();	
	})
<%
}
%>	
})
</script>
<script src="../../bootstrap/bootstrap.min.js"></script>