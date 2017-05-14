<%@ page language="java" contentType="text/html; charset=UTF-8"%>
&nbsp;&nbsp;
共<%=pageTotal%>页&nbsp;&nbsp;&nbsp;&nbsp;当前是第<%=currentPage%>页&nbsp;&nbsp;&nbsp;&nbsp;

<%
if(currentPage==1){
%>
首页&nbsp;&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;
<%
}else{
%>
<a href="<%=page_location%>?curp=1&double=<%=name%>">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<%=page_location%>?curp=<%=currentPage-1%>&double=<%=name%>">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<%
}
%>

<%
if(currentPage==pageTotal){
%>
下一页&nbsp;&nbsp;&nbsp;&nbsp;最后一页
<%
}else{
%>
<a href="<%=page_location%>?curp=<%=currentPage+1%>&double=<%=name%>">下一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<%=page_location%>?curp=<%=pageTotal%>&double=<%=name%>">最后一页</a>
<%
}
%>