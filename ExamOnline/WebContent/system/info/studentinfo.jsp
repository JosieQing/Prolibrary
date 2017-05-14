<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../inc/theme.jsp" %>
<%
String id="2";
//String id = (String)session.getAttribute("user_id");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生信息查询页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<input type="hidden" value="<%=id %>" id="user_id" >
<table border="1" class="table table-hover" style="width:700px">
<tr><td colspan="4" >当前>>学生信息查询
<tr class="info">
<td align="center">学号</td>
<td align="center"><input type="text" name="num" id="num" disabled="disabled" ></td>
</tr>
<tr class="info">
<td align="center">姓名</td>
<td align="center"><input type="text" name="name" id="name" disabled="disabled" ></td>
</tr>
<tr class="info">
<td align="center">性别</td>
<td align="center"><input type="text" name="sex" id="sex" disabled="disabled" ></td>
</tr>
<tr class="info">
<td align="center">年龄</td>
<td align="center"><input type="text" name="age" id="age" disabled="disabled" ></td>
</tr>
<tr class="info">
<td align="center">班级</td>
<td align="center"><input type="text" name="banji" id="banji" disabled="disabled" ></td>
</tr>
<tr class="info">
<td align="center">学生编号</td>
<td align="center"><input type="text" name="cno" id="cno" disabled="disabled" ></td>
</tr>
</table>
<button type="button" class="btn btn-warning " id="btn1" onclick="location='studentInfoUpdate.jsp?id=<%=id%>'">编辑
</button>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type="button" class="btn btn-success " id="btn2" onclick="location='../../login/left.jsp'">返回
</button>
<script src="js/studentinfo.js"></script>
</body>
</html>
