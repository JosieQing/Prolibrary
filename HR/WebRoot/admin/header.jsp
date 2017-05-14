<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


    
    <title>人力资源管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">

	<link href="<%=basePath%>css/docs.css" rel="stylesheet">
	
	<link href="<%=basePath%>css/github.css" rel="stylesheet">

	<link rel="apple-touch-icon-precomposed" sizes="144x144"
			href="<%=basePath%>ico/apple-touch-icon-144-precomposed.png">
			
	<link rel="shortcut icon" href="<%=basePath%>ico/favicon.png">
