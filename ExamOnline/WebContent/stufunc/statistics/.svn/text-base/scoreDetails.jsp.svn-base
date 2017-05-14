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
	String student_id=null;
	student_id=request.getParameter("studentid");
	
	if(student_id==null)
	{
		student_id=(String)session.getAttribute("sid");
	}else
	{
		session.setAttribute("sid", student_id);
	}
	
	String exam_id=null;
	exam_id=request.getParameter("exam_id");
	
	if(exam_id==null)
	{
		exam_id=(String)session.getAttribute("eid");
	}else
	{
		session.setAttribute("eid", exam_id);
	}
	
	ScoreDetailsBean sdb= new ScoreDetailsBean();
	List<ScoreDetails> list =sdb.studentScoreDetail(student_id);
	List<String> listid = new ArrayList<String>();
	Map<String,StudentQuery> map=new TreeMap<String,StudentQuery>();
	
	for(ScoreDetails sd:list)
	{

		StudentQueryBean sqb = new StudentQueryBean();
		List<StudentQuery> list2=sqb.studentScoreQuery(sd.getStudent_id());
	
		for(StudentQuery sq:list2)
		{
				if((exam_id).equals(sq.getExam_id()))
				{
					listid.add(sd.getStudent_id());
					map.put(sd.getStudent_id(),sq);
				}
				
		}
	}
	


	
%>
<h3 style="color:blue">当前页面>>>>班级该科成绩查询</h3>
<table class="table table-striped">
<tr>
<td>学生id</td>
<td>学生姓名</td>
<td>班级</td>
<td>考试id</td>
<td>考试名称</td>
<td>考试时间</td>
<td>分数</td>
</tr>
<%

int rowCount=map.size();//集合里一共有多少条数据
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

if(map.size()<pageLength)
{
	pageLength=map.size();
}

if(map.size()>0){
	int i=0;

	for(String id:listid)
	{
		if(i>=startIndex&&i<pageLength)
		{
			StudentQuery sq = map.get(id);
%>
						<tr>
						<td><%=id%></td>
						<td><%=sq.getName()%></td>
						<td><%=sq.getClass_name()%></td>
						<td><%=sq.getExam_id()%></td>
						<td><%=sq.getExam_name()%></td>
						<td><%=sq.getStart_time()%></td>
						<td><%=sq.getStudent_score()%></td>
						</tr>
<%
		}
					
		i++;	
		
	}
			
}

%>


<tr>
<td colspan="7">
共<%=pageSize%>页&nbsp;&nbsp;&nbsp;&nbsp;当前第<%=currentPage%>页&nbsp;&nbsp;&nbsp;&nbsp;

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
	<a href="scoreDetails.jsp?currentPage=<%=1%>">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="scoreDetails.jsp?currentPage=<%=currentPage-1%>">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<%		
	}
	if(currentPage==pageSize){
%>
下一页&nbsp;&nbsp;&nbsp;&nbsp;最后一页
<%
	}
	else{
%>
	<a href="scoreDetails.jsp?currentPage=<%=currentPage+1%>">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="scoreDetails.jsp?currentPage=<%=pageSize%>">最后一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<%	
	}
%>
</td>
</tr>


</table>
</body>
</html>
<script src="../../js/jquery-3.2.0.min.js"></script>
<script src="../../bootstrap/bootstrap.min.js"></script>