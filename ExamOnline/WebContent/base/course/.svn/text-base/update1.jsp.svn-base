<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.neuedu.examonline.util.*" %>
<%@ include file="../../inc/theme.jsp" %>
<html>
<head>
<title>添加界面</title>
    <!--  <link rel="stylesheet" href="../../bootstrap/bootstrap.min.css">-->
</head>
<body>
<%
String id=null;
id=request.getParameter("id");
String couse=request.getParameter("couse");
if(id==null){
	id="0";
}
%>



<input type="hidden" id="id" value="<%=id%>"><!-- 隐藏域 -->
<table border="1" class="table table-hover" style="width:500px">
<tr class="warning" align="center">
<td>id</td>
<td><%=id%></td>
</tr >
<tr class="warning" align="center">
<td>couse</td>
<td><input type="text" id="couse" name="couse" value="<%=couse%>"></td>
</tr> 
<tr class="warning" align="center">
<td><input type="button" value="提交" id="updateButton" class="btn btn-primary"/></td>
<td><input type="button" value="返回" onclick="location='list.jsp'"  class="btn btn-primary"/></td>
</tr>
</table>


</body>
</html>
<!--<script src="../../js/jquery-3.2.0.min.js"></script>-->
<script src="update.js"></script>