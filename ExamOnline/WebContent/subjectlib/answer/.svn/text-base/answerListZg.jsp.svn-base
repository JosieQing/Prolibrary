<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="com.neuedu.examonline.subjectlib.answer.answerBean"%>
<%@page import="com.neuedu.examonline.subjectlib.answer.answerObj"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.neuedu.examonline.util.*" %>
<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../../bootstrap/bootstrap.min.css" rel="stylesheet"> 
<body>
<div class="container">
<div class="table-responsive">          
<table class="table table-striped table-bordered table-hover" border="1">
<tbody>
<!--导航部分 -->
<tr >
<td colspan="4"><a style="align:left;"href="main.jsp">主页</a><div  style="text-align:center;"><font style="color:deepskyblue;font-size:30px"><b>主观题答案</b></font></div></td>
</tr>
<%
String query_subject=null;
query_subject=request.getParameter("query_subject");
if(query_subject==null){
	query_subject=(String)session.getAttribute("qs");
	if(query_subject==null){
		query_subject="";
	}
}else{
	query_subject = StringUtil.iSOToUtf8(query_subject);
	session.setAttribute("qs", query_subject);
}

%>

<tr>
<td colspan="4">
<form  class=" form-inline" action="answerListZg.jsp">
<div class="form-croup">
请输入题目内容:<input class=" form-control" type="text" name="query_subject" value="<%=query_subject%>">&nbsp;
<input type="submit" class="btn btn-info"  value="查询" >
<input type="button"  class="btn btn-info" value="返回" onclick="location='answerListZg.jsp?query_subject=<%=""%>'">
</td>
</tr>
</div>
</form>
<!--导航结束 -->

<tr>
<td><font color="pink" ><b>序号</b></font></td>
<td><font color="pink" ><b>题目</b></font></td>
<td><font color="pink" ><b>答案</b></font></td>
<td><font color="pink" ><b>操作</b></font></td>
</tr>
<%
int rowTotal=0;
int pageTotal=0;
int currentPage=1;
String str_currentPage="";
str_currentPage=request.getParameter("curp");
if(str_currentPage==null){
	str_currentPage="1";
}
currentPage = Integer.parseInt(str_currentPage);
PageUtil pu = new PageUtil();
answerBean ab=new answerBean();

	rowTotal=ab.getCount(query_subject);
	pageTotal= pu.getPageTotal(rowTotal);
	int rowIndex = pu.getRowIndex(currentPage); 
	List rList = ab.getZgAnswerList(query_subject,rowIndex,pu.getPageSize());
	for(int i=0;i<rList.size();i++){
		answerObj ao = (answerObj)rList.get(i);//
		String zg_id = ao.getZg_id();
		//out.print(kg_id);
		String subject = ao.getSubject();
		String zg_answer= ao.getZg_answer();
%>
<tr>
<td ><%=(i+1) %></td>
<td ><%=subject%></td>
<td ><%=zg_answer%></td>
<td>
<a href="answer_updateZg.jsp?zg_id=<%=zg_id%>&curp=<%=currentPage%>">修改</a>

</td>
</tr>
<%
	}
%>
<!-- 分页开始 -->
<tr>
<td colspan="4">
<%
String page_location="answerListZg.jsp";
%>
共<%=pageTotal%>页&nbsp;&nbsp;当前是第<%=currentPage%>页&nbsp;&nbsp;
<%
if(currentPage==1){
%>
首页&nbsp;&nbsp;上一页&nbsp;&nbsp;
<%
}else{
%>
<a href="<%=page_location%>?curp=1">首页</a>&nbsp;&nbsp;
<a href="<%=page_location%>?curp=<%=currentPage-1%>">上一页</a>&nbsp;&nbsp;
<%
}
%>

<%
if(currentPage==pageTotal){
%>
下一页&nbsp;&nbsp;最后一页
<%
}else{
%>
<a href="<%=page_location%>?curp=<%=currentPage+1%>">下一页</a>&nbsp;&nbsp;
<a href="<%=page_location%>?curp=<%=pageTotal%>">最后一页</a>
<%
}
%>

</td>

</tr>
</tbody>
<!-- 分页结束 -->
</table>
<script src="../../bootstrap/jquery.min.js"></script>
<script src="../../bootstrap/bootstrap.min.js"></script>
</div>
</div>
</body>
</html>