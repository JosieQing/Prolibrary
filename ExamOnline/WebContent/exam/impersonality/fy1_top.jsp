<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int rowTotal=123;//总行数
int pageTotal=0;//总页数
int currentPage=1;//当前页
String str_currentPage="";

str_currentPage=request.getParameter("curp");
if(str_currentPage==null){
	str_currentPage="1";
}
currentPage = Integer.parseInt(str_currentPage);

String s_currentPage="";

s_currentPage=request.getParameter("n1");
if(s_currentPage==null){
	s_currentPage=str_currentPage;
}
currentPage = Integer.parseInt(s_currentPage);
System.out.println(pageTotal);
System.out.println(s_currentPage);
%>
