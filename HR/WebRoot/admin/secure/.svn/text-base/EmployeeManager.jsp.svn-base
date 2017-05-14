<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.neusoft.bean.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://blog.csdn.net/qjyong/tags/pager" prefix="p" %>
<%@taglib uri="http://displaytag.sf.net"  prefix="display"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>员工入职信息查询</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<%
			String q = (String) request.getAttribute("q");
		%>
			  	 <script>
	function ifcuowu(q){	
		if(q!=null && q.trim!="" && q!="null"){
			alert(q);
		}
	}
	
		window.onload= ifcuowu('<%=q%>');
		
			 var xmlHttp = false;
    //获得Microsoft  IE
    try {
      xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
    } catch (e) {
    try {
        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    } catch (e2) {
       xmlHttp = false;
   }
}
//获得非Microsoft  IE
if (!xmlHttp && typeof XMLHttpRequest != 'undefined') {
  xmlHttp = new XMLHttpRequest();
}
/*通过异步传输XMLHTTP发送参数到AjaxServlet，返回符合条件的XML文档*/  
function getEname(t)  
{  
  var eid = t.value;
   if ((eid == null) || (eid == "")) return;
  var url = "<%=basePath%>servlet/ajaxServlet?s=geteid&eid="+eid;

  xmlHttp.open("POST", url, true);
  
  xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
  
 xmlHttp.onreadystatechange = complete;
  xmlHttp.send(null);
  
}   
function complete()  
{  
        if (xmlHttp.readyState == 4)  
        {    
                if (xmlHttp.status == 200)  //处理完，返回成功
                {       
                        var ename = document.getElementById("ename"); 
                       
                       		ename.value = xmlHttp.responseText;
                       
                }  
        }  
} 
   </script>
		<script>
   		window.onload = function() {
   		$("#ee").addClass("table");
   		
  	 }
  	  	function onDeleteEntry(EID) {
   		if(confirm("确认删除？")) {
	   		url = "<%=basePath %>servlet/empEntry?s=delete";
	   		$.get(url, {eid:EID },
	   			function(data) {
	   				alert(data);
	   				location.reload();
	   			});
	   	}
   	}
  	 </script>
		<link rel="stylesheet" type="text/css" href="styles.css">
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="docs-assets/css/docs.css" rel="stylesheet">
		<link href="docs-assets/highlight/css/github.css" rel="stylesheet">
		<link rel="apple-touch-icon-precomposed" sizes="144x144"
			href="../../docs-assets/ico/apple-touch-icon-144-precomposed.png">
		<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">
		<style type="text/css"></style>
		<script type="text/javascript" src="jquery-1.8.0.min.js">
		</script>
		<script src="<%=basePath %>js/jquery.min.js"></script>
		<script src="<%=basePath %>js/bootstrap.min.js"></script>
	</head>
	<body>
	<jsp:include page="../nav.jsp"></jsp:include>
	<div style="text-align:center">
	<label class="control-label" style="font-size:25px;margin:0,auto;position:relative;">员工入职信息查询</label>
	</div>
	<br/>
	<div class="container" style="width:100%;margin:0,auto;position:relative;" >
	<form class="form-horizontal" role="form" method="post" action="/HR/servlet/empEntry?s=message">
	<div class="container" style="width:40%;margin:0,auto;position:relative;" >
				<div class="row">
					<div class=" col-md-5 col-md-offset-1 ">
						<div class="form-group">
							员工编号：
							<input type="text" name="eid" id="eid" class="form-control" onblur="getEname(this)"/>
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1 ">
						<div class="form-group">
							员工姓名：
							<input type="text" name="ename" id="ename" class="form-control" disabled/>
						</div>
					</div>
				</div>
					<div class="row">
					<div class=" col-md-5 col-md-offset-1">
						<div class="form-group">
							部门编号：
							<input type="text" name="deptno" class="form-control" />
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="form-group">
							岗位编号：
							<input type="text" name="jobno" class="form-control" />
						</div>
					</div>
				</div>
					<div class="row">
						<div class="col-md-4 col-md-offset-2" >
							<div class="form-group">
								<button type="submit" class="btn btn-info btn-block">查询</button>
							</div>
						</div>
						<div class="col-md-2 col-md-offset-2">
							<div class="form-group">
								<button type="reset" class="btn btn-default  btn-block">重置</button>
							</div>
						</div>
					</div>
				</div>
				<br/>
				<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-11 col-md-offset-1">
				<c:if test="${list ne null}">	
				 <display:table id="ee" name="${requestScope['list']}"
		 size="${requestScope['total']}" partialList="true" export="true"
		 pagesize="${initParam.pageSize}" requestURI="/servlet/empEntry">
		 <display:column property="eid" title="编号" sortable="true"></display:column>
		 <display:column property="ename" title="姓名" sortable="true"></display:column>
		 <display:column property="sex" title="性别" sortable="true"></display:column>
		 <display:column property="phone" title="电话" sortable="true"></display:column>
		 <display:column property="email" title="邮件" sortable="true"></display:column>
		 <display:column property="workDay" title="工作日期" sortable="true"></display:column>
		 <display:column property="formalDay" title="转正日期" sortable="true"></display:column>
		 <display:column property="probationDay" title="试用日期" sortable="true"></display:column>
		 <display:column  title="操作" >
		  <a  class="btn btn-success btn-sm" href="/HR/admin/secure/ModifyEmpMessage.jsp?eid=${ee.eid}" >修改</a>
		 <a class="btn btn-danger btn-sm" onclick="onDeleteEntry(${ee.eid});">删除</a>
		  </display:column>
		  </display:table>	
		  </c:if>
				</div>						
			</div>
		</form>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
	</body>
	
</html>
