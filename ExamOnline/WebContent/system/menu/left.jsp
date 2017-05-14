<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.neuedu.examonline.system.menu.MenuList" %>
<%@ page import="com.neuedu.examonline.system.menu.Menu" %>
<%@ page import="java.util.*" %>
<%@ include file="../../inc/theme.jsp" %> 
<html>
<head>
    <meta charset="UTF-8">
    <title>left</title>
</head>
<body>
<%
MenuList mList = new MenuList();
List tempList = mList.getMenuList();
if(tempList!=null && tempList.size()>0){
for(int i=0;i<tempList.size();i++){
	Menu m =(Menu)tempList.get(i);
%>
<a href="<%=m.getLink()%>" target="mFrame"><%=m.getName()%></a><br>
<%
}
}
%>
</body>
</html>
