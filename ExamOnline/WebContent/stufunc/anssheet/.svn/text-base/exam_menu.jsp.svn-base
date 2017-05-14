<%@page import="com.neuedu.examonline.stufunc.anssheet.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>选择考试</title>
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 包含 bootstrap 样式表 -->
<link rel="stylesheet" href="../../bootstrap/bootstrap.min.css">
</head> 
<body>
<table class="table table-striped">
<!-- 表开始 -->
<tr>
<td colspan="8">当前>>选择考试界面</td>
</tr>
<tr>
<td>序号</td>
<td>考试名称</td> <!-- exam_name -->
<td>考试开始时间</td><!-- start_time -->
<td>考试状态</td><!-- status1未开始 2已开始 3已结束-->
<td>操作</td>
</tr>
<%
ExamBean eb = new ExamBean();
List<ExamView> list=eb.getList();
for(ExamView e1:list)
{%>
<tr>
<td><%=e1.getId()%></td>
<td><%=e1.getExam_namc()%></td>
<td><%=e1.getStart_time()%></td>
<td><%
if(e1.getStatus()==1){
	 out.print("未开始");
	}else if(e1.getStatus()==2){
		out.print("已开始");
	}else{
		out.print("已结束");
	}
	%></td>
<td><a href="Quiz.jsp?id=<%=e1.getId()%>"><%
if(e1.getStatus()==2){
	 out.print("点击进入考试界面");
	}else{
		out.print("");
	}
	%></a><td>
</tr> 
<%
}
%>
</table>
</body>
</html>
<script src="../../bootstrap/jquery.min.js"></script>
<script src="../../bootstrap/bootstrap.min.js"></script>
