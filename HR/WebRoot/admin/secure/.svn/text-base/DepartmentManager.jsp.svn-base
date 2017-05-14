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
		<title>部门信息管理</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
   			<%
			String q = (String) request.getAttribute("q");
		%>
		<script type="text/javascript">
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
function getName(t)  
{  
  var deptno = t.value;
   if ((deptno == null) || (deptno == "")) return;
  var url = "<%=basePath%>servlet/ajaxServlet?s=getName&deptno="+deptno;
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
                {       var s=new Array();
                		var m=xmlHttp.responseText; 
                		s=m.split(",") ;              		 
                        var dname = document.getElementById("dname");                      
                       		dname.value = s[0];
                       	var superDept = document.getElementById("superDept");                      
                       		superDept.value = s[1];
                       
                }  
        }  
} 
   </script>
   <jsp:include page="../header.jsp"></jsp:include>
	</head>
	<body>
	<jsp:include page="../nav.jsp"></jsp:include>
	<div style="text-align:center">
	<label class="control-label" style="font-size:25px;margin:0,auto;position:relative;">部门信息查询</label>
	</div>
	<br/>
	<div class="container" style="width:80%;margin:0,auto;position:relative;" >
	<form class="form-horizontal" role="form" method="post" action="/HR/servlet/department?s=message">
	<div class="container" style="width:30%;margin:0,auto;position:relative;" >
				<div class="row">
					<div class=" col-sm-10">
						<div class="form-group">
							请输入部门编号：
							<input type="text" name="deptno"  id="deptno" class="form-control" onblur="getName(this)" />
						</div>
					</div>
					<div class="col-sm-10 ">
						<div class="form-group">
							部门名称：
							<input type="text" name="dname" class="form-control" id="dname" disabled />
						</div>
					</div>
					<div class="col-sm-10 ">
						<div class="form-group">
							上级部门：
							<input type="text" name="superDept"  id="superDept" class="form-control" disabled/>
						</div>
					</div>
				</div>
					<div class="row">
						<div class="col-md-3 col-md-offset-1 " >
							<div class="form-group">
								<button type="submit" class="btn btn-info btn-block">查询</button>
							</div>
						</div>
						<div class="col-md-3 col-md-offset-1">
							<div class="form-group">
							<button type="reset" class="btn btn-default btn-block">取消</button>
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
						<td align="center">电话</td>
						<td align="center">传真</td>
						<td align="center">描述</td>
						<td align="center">上级部门</td>
						<td align="center">成立日期</td>
						<td align="center">修改</td>
						<td align="center">删除</td>
					</tr>
					<c:forEach items="${sessionScope.list}" var="dept">
					
						<tr>
							<td align="center"><c:out value="${dept.deptno}"></c:out></td>
							<td align="center"><c:out value="${dept.dname}"></c:out></td>
							<td align="center"><c:out value="${dept.dtype}"></c:out></td>
							<td align="center"><c:out value="${dept.phone}"></c:out></td>
							<td align="center"><c:out value="${dept.fax}"></c:out></td>
							<td align="center"><c:out value="${dept.describe}"></c:out></td>
							<td align="center"><c:out value="${dept.superDept}"></c:out></td>
							<td align="center"><c:out value="${dept.startDay}"></c:out></td>
							<td><a
								href="/HR/admin/secure/ModifyDepartmentMessage.jsp?deptno=${dept.deptno}"
								class="btn btn btn-success  btn-block " role="submit">修改</a>
							</td>
							<td><a
								href="/HR/servlet/department?s=delete&deptno=${dept.deptno}"
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
