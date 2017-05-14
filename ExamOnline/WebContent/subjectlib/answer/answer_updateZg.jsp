<%@page import="com.neuedu.examonline.util.StringUtil"%>
<%@page import="com.neuedu.examonline.subjectlib.answer.answerBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../../bootstrap/bootstrap.min.css" rel="stylesheet"> 
</head>
<body>
<div class="container">
<div class="table-responsive">          
<table class="table table-striped table-bordered table-hover" border="1">
<tbody>
<% 
String zg_id=null;
zg_id=request.getParameter("zg_id");

if(zg_id==null){
	zg_id="0";
}
out.print(zg_id);


String zg_answer=null;
answerBean ab=new answerBean();

zg_answer=ab.getZgAnswerById(zg_id);

out.print(zg_answer);

String curp=null;
curp=request.getParameter("curp");

if(curp==null){
	curp="0";
}

%>

<form method="post" action="updateZgServlet">
<input type="hidden" id="zg_id" name="zg_id" value="<%=zg_id%>">
<input type="hidden" id="curp" name="curp" value="<%=curp%>">

<table border="1">

<tr>
	<td>答案：</td>
	<td><input type="text" id="zg_answer" name="zg_answer" value="<%=zg_answer%>"></td>
</tr>


<tr>
	<td><input id="updateButton1" type="submit" value="提交"/></td>
	<td><input type="button" value="返回" onclick="location='answerListZg.jsp'"/></td>
</tr>

</tbody>
</table>
<script src="../../bootstrap/jquery.min.js"></script>
<script src="../../bootstrap/bootstrap.min.js"></script>
</div>
</div>
</form>
</body>
</html>