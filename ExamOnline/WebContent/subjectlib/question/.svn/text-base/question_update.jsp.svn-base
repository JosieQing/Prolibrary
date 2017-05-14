<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.neuedu.examonline.util.*" %>
<%@ page import="com.neuedu.examonline.subjectlib.question.*" %>
<%@ include file="../../inc/theme.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>试题修改页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%
//String id = (String)session.getAttribute("user_id");
String q_id =request.getParameter("id");
String user_id ="2";
%>

<input type="hidden" value="<%=user_id%>" id="user_id">
<input type="hidden" value="<%=q_id%>" id="q_id">
<table border="1" class="table table-hover" style="width:700px">
<tr><td colspan="4" >当前>>试题修改
<tr class="info">
<td align="center">题干</td>
<td align="center"><input type="text" name="questiontext" id="questiontext" placeholder="请输入题干选项内容"></td>
</tr>

<tr class="info">
<td align="center">A</td>
<td align="center"><input type="text" name="A" id="A" placeholder="请输入A选项内容" ></td>
</tr>
<tr class="info">
<td align="center">B</td>
<td align="center"><input type="text" name="B" id="B" placeholder="请输入B选项内容" ></td>
</tr>
<tr class="info">
<td align="center">C</td>
<td align="center"><input type="text" name="C" id="C" placeholder="请输入C选项内容" ></td>
</tr>
<tr class="info">
<td align="center">D</td>
<td align="center"><input type="text" name="D" id="D" placeholder="请输入D选项内容" ></td>
</tr>

<tr class="info">
<td align="center">E</td>
<td align="center"><input type="text" name="E" id="E" placeholder="请输入E选项内容" ></td>
</tr>
<tr class="info">
<td align="center">备注</td>
<td align="center"><input type="text" name="remark" id="remark" placeholder="请输入备注内容" ></td>
</tr>
<tr class="info">
<td align="center">请选择题型:</td>
<td align="center">
<select id="s2" name="s2">
				<%
				List<TypesObj> li2 = new ArrayList<TypesObj>();
				QuestionBean qb = new QuestionBean();
				li2 = qb.getAllType();
				Iterator<TypesObj> it2 = li2.iterator();
				while (it2.hasNext()) {
					TypesObj to = it2.next();
					String types_name = to.getTypes_name();
					int t_id = to.getTypes_id();
				%>
				<option value="<%=t_id%>"><%=types_name%></option>
				<%
					}
				%>
</select></td>
</tr>
</table>
	<button type="button" class="btn btn-success" id="btn1" >提交</button>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	<button type="button" class="btn btn-success" onclick="location='exam_question.jsp'">返回</button> 
<script src="js/question_update.js"></script>
</body>
</html>
