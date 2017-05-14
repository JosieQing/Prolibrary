<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
int rowTotal=0;
int pageTotal=0;
int currentPage=1;
String str_currentPage="";

str_currentPage=request.getParameter("curp");
if(str_currentPage==null){
	str_currentPage="1";
}

currentPage = Integer.parseInt(str_currentPage);

%>