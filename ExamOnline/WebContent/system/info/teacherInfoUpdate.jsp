<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../inc/theme.jsp" %>
<%
String id = request.getParameter("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教师修改信息页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>


<input type="hidden" value="<%=id %>" id="user_id" >
<table border="1" class="table table-hover" style="width:500px">
<tr><td colspan="4" >当前>>教师信息修改
<tr class="info">
<td align="center">工号</td>
<td align="center"><input type="text" name="tno" id="tno" disabled="disabled" ></td>
</tr>
<tr class="info">
<td align="center">姓名</td>
<td align="center"><input type="text" name="tname" id="tname" disabled="disabled" ></td>
</tr>
<tr class="info">
<td align="center">年龄</td>
<td align="center"><input type="text" name="tage" id="tage" disabled="disabled" ></td>
</tr>
<tr class="info">
<td align="center">性别</td>
<td align="center"><input type="text" name="tsex" id="tsex" disabled="disabled" ></td>
</tr>
<tr class="info">
<td align="center">手机号</td>
<td align="center"><input type="text" name="ttel" id="ttel"></td>
</tr>
<tr class="info">
<td align="center">入校时间</td>
<td align="center"><input type="text" name="hiredate" id="hiredate" disabled="disabled" ></td>
</tr>
<tr class="info">
<td align="center">备注</td>
<td align="center"><input type="text" name="tremark" id="tremark" ></td>
</tr>
</table>
<button type="button" class="btn btn-warning " id="tupdatebutton">修改
</button>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type="button" class="btn btn-success " onclick="location='teacherinfo.jsp'" id="btn">返回
</button>

<script src="js/teacherinfo.js"></script>
</body>
</html>
