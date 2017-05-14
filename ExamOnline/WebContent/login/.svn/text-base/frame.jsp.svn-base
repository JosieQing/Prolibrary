<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = null;
id = request.getParameter("select");
if (id == null) {
	id = "0";
}

%>
<frameset cols="10%,*"  border="1"  >
	<frame  noresize="noresize" src="left.jsp?id=<%=id%>"  name="left"> </frame>
	<frameset rows="5%,*,10%">
		<frame noresize="noresize" src="top.jsp?id=<%=id%>" name="top" scrolling="no"> </frame>
		<frame noresize="noresize" src="main.jsp" name="main">	</frame>
		<frame noresize="noresize" src="bottom.jsp" name="bottom">	</frame>
	</frameset>
</frameset>