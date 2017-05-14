<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script src="<%=basePath %>js/jquery-3.2.0.min.js"></script>
<script src="<%=basePath%>bootstrap/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=basePath %>bootstrap/bootstrap.min.css">


<!-- [if lt IE 9] -->
<script type="text/javascript" src="<%=basePath %>hui/lib/html5shiv.js"></script>
<script type="text/javascript" src="<%=basePath %>hui/lib/respond.min.js"></script>
<!-- [if IE 6] -->
<script type="text/javascript" src="<%=basePath %>hui/lib/DD_belatedPNG_0.0.8a-min.js" ></script> 
<script type="text/javascript" src="<%=basePath %>hui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="<%=basePath %>hui/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="<%=basePath %>hui/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="<%=basePath %>hui/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="<%=basePath %>hui/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="<%=basePath %>hui/static/h-ui.admin/js/H-ui.admin.js"></script>
<script type="text/javascript" src="<%=basePath %>hui/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<link rel="Bookmark" href="<%=basePath %>favicon.ico" >
<link rel="Shortcut Icon" href="<%=basePath %>favicon.ico" />
<link href="<%=basePath %>hui/static/h-ui/css/H-ui.min.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>hui/static/h-ui.admin/css/H-ui.admin.css" rel="stylesheet" type="text/css" />
<link href="<%=basePath %>hui/lib/Hui-iconfont/1.0.8/iconfont.css" rel="stylesheet" type="text/css" />