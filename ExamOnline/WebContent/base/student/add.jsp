<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import=" com.neuedu.examonline.base.student.*" %>
<%@ include file="../../inc/theme.jsp" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8"> 
    <title>样式</title>
 
    <meta name="viewport" content="width=device-width, initial-scale=1">
 
   <!--  <link rel="stylesheet" href="../bootstrap/bootstrap.min.css"> -->
  </head>
<body>

<!-- <form name="fl" method="post" action="add_action.jsp"> -->
<table border="1" class="table table-hover table-bordered " align="center" style="width:500px">
<tr class="info">
<td>姓名</td>
<td><input type="text" id="name" name="name"></td>
</tr>
<tr class="info">
<td>学号</td>
<td><input type="text" id="num" name="num"></td>
</tr>
<tr class="info">
<td>性别</td>
<td><input type="text"  id="sex" name="sex"></td>
</tr>
<tr class="info">
<td>年龄</td>
<td><input type="text"  id="age" name="age"></td>
</tr>

<tr class="info">
<td>班级</td>
<td >
<select id="cname"  name="cname">
<%
option op=new option();
List<String> lists=op.sel();
for(String s:lists)
{
%>
<option value="<%=s %>" ><%=s %></option>
<%
}%>

</select>
</td>
</tr>
<tr class="info">
<td><input type="button" value="提交" id="addButton" class="btn btn-success" /></td>
<td><input type="button" value="返回" onclick="location='list.jsp'" class="btn btn-warning"/></td>
</tr>
</table>
<!--  </form>-->

</body>
</html>
<script src="add.js"></script>
<!--  <script src="../js/jquery-3.2.0.min.js"></script>
<script src="../bootstrap/jquery.min.js"></script>   
<script src="../bootstrap/bootstrap.min.js"></script>-->

