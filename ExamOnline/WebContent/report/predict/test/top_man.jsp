<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../inc/theme.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<input id="id" type="text" value="请输入要查询的id"/>
<input id="check" type="submit" value="查询" class="btn btn-secondary radius"/>
<form id="f2" action="chart1.jsp">

<%for(int i=0;i<100;i++)
{
	String s="ss"+i;
	
%>
<input type="hidden" name="<%=s%>" id="<%=s%>">
<%
	}
%>
<input type="hidden" id="id111" name="id111">

<div></div>
</body>
</html>
<script src="../jss/jquery-1.11.1.min.js"></script>
<script src="mancx.js"></script>