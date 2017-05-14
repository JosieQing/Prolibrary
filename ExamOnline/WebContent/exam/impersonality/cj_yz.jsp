<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.neuedu.examonline.exam.impersonality.*"%>
<%@ page import="com.neuedu.examonline.system.user.tools.*"%>
<%@ page import="com.neuedu.examonline.util.*"%>

<% 
CjBean cb1 = new CjBean();
String ksbh1 = null;
ksbh1 = request.getParameter("k1");
if(ksbh1==null){
	ksbh1="";
}
String kszt = null;
kszt = request.getParameter("k2");
if(kszt==null){
	kszt="";
}else {
	kszt = StringUtil.iSOToUtf8(kszt);
}
cj_yzBean cb = new cj_yzBean();

int ksbh2 = Integer.parseInt(ksbh1);
String a1=cb.yz2(ksbh2);
if(a1.equals("已结束")){
	System.out.println("判断没有问题");
	

int a=cb.yz(ksbh2);
if(a==1){
	response.sendRedirect("err.jsp");
}else{
	//session.setAttribute("ksbh1", ksbh1);
		cb1.pj(ksbh1);
	response.sendRedirect("cj.jsp");
}
}else{
	response.sendRedirect("err1.jsp");
}
%>

