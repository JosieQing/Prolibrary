 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>岗位信息管理</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<%
			String q = (String) request.getAttribute("q");
		%>
	<script type="text/javascript">
   	function onDeleteJob(JOBNO) {
   		if( confirm("确认删除？")) {
	   		url = "<%=basePath %>servlet/job?s=delete";
	   		$.get(url, {jobno:JOBNO},
	   			function(data) {
	   				alert(data);
	   				location.reload();
	   			});
	   	}
   	}
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
function getJname(t)  
{  
  var jobno = t.value;
   if ((jobno == null) || (jobno == "")) return;
  var url = "<%=basePath%>servlet/ajaxServlet?s=getjname&jobno="+jobno;

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
                        var jname = document.getElementById("jname"); 
                       
                       		jname.value = xmlHttp.responseText;
                       
                }  
        }  
} 
   </script>
 	<jsp:include page="../header.jsp"></jsp:include>
	</head>
	<body>
	 <jsp:include page="../nav.jsp"></jsp:include>
	<br/>
	<div style="text-align:center" >
	<label class="control-label" style="font-size:25px;margin:0,auto;position:relative;">岗位信息管理</label>
	</div>
	<br/>
	<div class="container" style="width:50%;margin:0,auto;position:relative;" >
	<form class="form-horizontal" role="form" method="post" action="/HR/servlet/job?s=message">
	<div class="container" style="width:50%;margin:0,auto;position:relative;" >
				<div class="row">
					<div class=" col-sm-10">
						<div class="form-group">
							岗位编号：
							<input type="text" name="jobno" class="form-control" id="jobno" onblur="getJname(this)"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class=" col-sm-10">
						<div class="form-group">
							岗位名称：
							<input type="text" name="jname" class="form-control" id="jname" disabled/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class=" col-sm-10">
						<div class="form-group">
							部门编号：
							<input type="text" name="deptno" class="form-control"  />
						</div>
					</div>
				</div>
					<div class="row">
						<div class="col-md-3 col-md-offset-1" >
							<div class="form-group">
								<button type="submit" class="btn btn-info btn-block">查询</button>
							</div>
						</div>
						<div class="col-md-3 col-md-offset-1">
							<div class="form-group">
							<button type="submit" class="btn btn-default btn-block">取消</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
				<table class="table table-hover">
					<tr>
						<td align="center">编号</td>
						<td align="center">名称</td>
						<td align="center">类型</td>
						<td align="center">编制</td>
						<td align="center">部门编号</td>
						<td align="center">修改</td>
						<td align="center">删除</td>
					</tr>
					<c:forEach items="${sessionScope.list}" var="job">					
						<tr>
							<td align="center"><c:out value="${job.jobno}"></c:out></td>
							<td align="center"><c:out value="${job.jname}"></c:out></td>
							<td align="center"><c:out value="${job.jobStyle}"></c:out></td>
							<td align="center"><c:out value="${job.jobCompile}"></c:out></td>
							<td align="center"><c:out value="${job.deptno}"></c:out></td>
							<td>
							 <a  class="btn btn-success btn-sm" href="/HR/admin/secure/ModifyJobMessage.jsp?jobno=${job.jobno}" >修改</a>
							</td>
							<td>		 
							 <a
								href="/HR/servlet/job?s=delete&jobno=${job.jobno}"
								class="btn btn btn-danger  btn-block " role="submit">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
				</div>
		</form>
	</div>
	   <jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
