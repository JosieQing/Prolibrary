<!DOCTYPE html>   
<html>
<head>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>  
<%@ page import="com.neuedu.examonline.base.teacher.*"%>   

<%@ include file="../../inc/theme.jsp" %>
<script src="js/teacher.js" type="text/javascript"></script>


</head>
<body>
<%
List<Teacher> list = (List<Teacher>)session.getAttribute("tlist");
String tno=request.getParameter("tno");
for(Teacher ter:list)
{
	if(tno.equals(ter.getTno()))
	{
		String sex=ter.getTsex();
%> 
<div class="page-container">
<form class="form form-horizontal">

 	<div class="row cl">
			<input type="hidden" id="tno" value="<%=ter.getTno()%>"/><br/>
		<label class="col-sm-2 control-label">教工编号:</label>
		<label class="col-sm-2 control-label"><%=ter.getTno()%></label>
	</div>
	
	<div class="row cl">
		<label class="col-sm-2 control-label">姓名:</label>
		<div class="col-sm-6">
			<input id="tname" type="text" class="input-text" value="<%=ter.getTname()%>" />
		</div>
	</div>
	
	<div class="row cl">
		<label class="col-sm-2 control-label">性别:</label>
		<div class="col-sm-1">
		<input type="radio" value="男" class="tsex"  name="tsex" <%if("男".equals(sex)){ %>checked="checked"<%}%>/>男
		</div>
		<div class="col-sm-1">
		<input type="radio" value="女"  class="tsex" name="tsex" <%if("女".equals(sex)){ %>checked="checked"<%}%>/>女
		</div>
	</div>
	
	<div class="row cl">
		<label class="col-sm-2 control-label">年龄:</label>
		<div class="col-sm-6">
			<input id="tage" type="text"  class="input-text"  value="<%=ter.getTage()%>" />
		</div>
	</div>
	
	<div class="row cl">
		<label class="col-sm-2 control-label">TEL:</label>
		<div class="col-sm-6">
			<input id="ttel" type="text" class="input-text"  value="<%=ter.getTtel()%>" />
		</div>
	</div>
	
	<div class="row cl">
		<label class="col-sm-2 control-label">入职日期:</label>
		<div class="col-sm-6">
			<input id="hiredate"  type="text"  class="input-text Wdate" readonly="readonly"  onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd'})"  value="<%=ter.getHiredate()%>" />
		</div>
	</div>
	
	<div class="row cl">
		<label class="col-sm-2 control-label">备注信息:</label>
		<div class="col-sm-6">
			<input id="tremark" type="text"  class="input-text"  value="<%=ter.getTremark()%>" />
		</div>
	</div>
	
	<div class="row cl">
		<div class="col-sm-offset-2 col-sm-6">
			<input type="button" class="btn btn-default"  id="newinfo_btn" value="确定"/>
		</div>
	</div>
</form>

<%
}}
%>
</div>
</body>
</html>
