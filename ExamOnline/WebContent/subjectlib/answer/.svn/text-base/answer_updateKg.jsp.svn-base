<%@page import="com.neuedu.examonline.subjectlib.answer.answerBean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改答案</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../../bootstrap/bootstrap.min.css" rel="stylesheet"> 
</head>
<body>
<div class="container">
<div class="table-responsive">          
<table class="table table-striped table-bordered table-hover" border="1">
<tbody>
<% 
String kg_id=null;
kg_id=request.getParameter("kg_id");

if(kg_id==null){
	kg_id="0";
}
out.print(kg_id);


String kg_answer=null;
answerBean ab=new answerBean();

kg_answer=ab.getKgAnswerById(kg_id);
out.print(kg_answer);

String curp=null;
curp=request.getParameter("curp");

if(curp==null){
	curp="0";
}


%>

<form method="post" action="updateServlet">
<input type="hidden" id="kg_id" name="kg_id" value="<%=kg_id%>">
<input type="hidden" id="curp" name="curp" value="<%=curp%>">


<table border="1">


<tr>
	<td>答案：</td>
	<td><input type="text" id="kg_answer" name="kg_answer" value="<%=kg_answer%>"></td>
</tr>


<tr>
	<td><input id="updateButton" type="submit" value="提交"/></td>
	<td><input type="button" value="返回" onclick="location='answerListKg.jsp'"/></td>
</tr>
</table>
<script src="../../bootstrap/jquery.min.js"></script>
<script src="../../bootstrap/bootstrap.min.js"></script>
</div>
</div>
</form>
</body>
</html>