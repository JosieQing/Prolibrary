<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../inc/theme.jsp" %>
<html>
<head>
<title>添加界面</title>
   <!--   <link rel="stylesheet" href="../../bootstrap/bootstrap.min.css">-->
</head>
<body>

<!--  <form name="f1" method="post" action="add_action.jsp">-->

<table border="1" class="table table-hover" style="width:500px">
<tr class="danger">
<td align="center">id</td>
<td align="center"><input type="text" name="id" id="id"></td>
</tr>
<tr class="danger">
<td align="center">couse</td>
<td align="center"><input type="text" name="couse" id="couse" ></td>
</tr>
<tr class="danger" align="center">
<td ><input type="button" value="提交" id="addButton"  class="btn btn-success"/></td>
<td><input type="button" value="返回" onclick="location='list.jsp'" class="btn btn-success"/></td>
</tr>
</table>
<!--  </form>-->

</body>
</html>
<!--<script src="../../js/jquery-3.2.0.min.js"></script>-->
<script src="add.js"></script> 