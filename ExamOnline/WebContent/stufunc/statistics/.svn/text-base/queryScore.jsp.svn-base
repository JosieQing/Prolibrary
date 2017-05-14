<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.neuedu.examonline.db.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.neuedu.examonline.stufunc.statistics.*"%>

<html>
<head>
<meta charset="utf-8">
<title>Bootstrap 实例</title>
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 包含 bootstrap 样式表 -->
<link rel="stylesheet" href="../../bootstrap/bootstrap.min.css">
</head>

<body>
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
List<StudentQuery> list=sqb.studentScoreQuery(student_id);
int length = list.size();
//System.out.println("length :"+length );
%>
<h3 style="color:blue">当前页面>>>>学生个人成绩查询</h3>
<table class="table table-striped">
<tr>
<td>学生id</td>
<td>学生姓名</td>
<td>班级</td>
<td>考试名称</td>
<td>考试id</td>
<td>考试时间</td>
<td>分数</td>
<td>班级成绩详情</td>
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

<td><input type="button" value="点击查看" id="btn<%=count%>"  class="btn btn-primary"/>

<input type="hidden" value="<%=sq.getExam_id()%>" id="hid<%=count%>">

</td>
<%
		}
count++;
i++;
	}

}
%>

</tr>
<tr>
<td colspan="8">
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