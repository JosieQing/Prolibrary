<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
共<%=pageTotal%>页&nbsp;&nbsp;当前是第<%=currentPage%>页&nbsp;
<form name="f1" id="f1" action="<%=page_location%>">
跳转到第<input id="j1" type="text" name="n1" >页&nbsp;&nbsp;
<input type="button" value="跳转" onclick="jy()"></form>
<%
if(currentPage==1){
%>
首页&nbsp;&nbsp;上一页&nbsp;&nbsp;
<%	
}else{
%>
	<a href="<%=page_location%>?curp=1">首页</a>&nbsp;&nbsp;
	<a href="<%=page_location%>?curp=<%=currentPage-1%>">上一页</a>&nbsp;&nbsp;
<% 
}
%>
<%
if(currentPage==pageTotal){
%>
	下一页&nbsp;&nbsp;最后一页
<%	
}else{
%>
	<a href="<%=page_location%>?curp=<%=currentPage+1%>">
	下一页</a>&nbsp;&nbsp;<a href="<%=page_location%>?curp=<%=pageTotal%>">最后一页</a>
<%	
}
%>