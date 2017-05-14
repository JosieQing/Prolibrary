<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../inc/theme.jsp" %>

<script type="text/javascript" src="../../../hui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../../../hui/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="../../../hui/lib/jquery.SuperSlide/2.1.1/jquery.SuperSlide.min.js"></script>
<script type="text/javascript" src="../../../hui/lib/jquery.validation/1.14.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="../../../hui/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="../../../hui/lib/jquery.validation/1.14.0/messages_zh.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<input id="classname"type="text" value="请输入要查询的班级"/>
<input id="classcheck"type="submit" value="查询" class="btn btn-secondary radius"/>
<form id="f1" action="chart.jsp">

<%for(int i=0;i<100;i++)
{
	String s="s"+i;
	
%>
<input type="hidden" name="<%=s%>" id="<%=s%>">
<%
	}
%>
<input type="hidden" id="id11" name="id11">

</form>

<div></div>
</form>
</body>

</html>
<script src="../jss/jquery-1.11.1.min.js"></script>
<script src="classcx.js"></script>
