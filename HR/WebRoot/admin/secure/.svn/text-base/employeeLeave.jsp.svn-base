<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>员工离职处理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
  xmlHttp = new XMLHttpRequest(); <%-- 创建内置对象实现异步--%>
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
                if (xmlHttp.status == 200)          //处理完，返回成功
                  {       
                        var ename = document.getElementById("ename"); 
                       
                       		ename.value = xmlHttp.responseText;
                     
                }  
        }  
}
   </script>             
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../footer.jsp"></jsp:include>
		
		
	</head>

	<body>
	<jsp:include page="../nav.jsp"></jsp:include>
		<div class="container"
			style="width: 60%; margin: 0, auto; position: relative;">
			<h2>
				员工离职管理
			</h2>
			<h3>
				员工离职处理
			</h3>
			<form action="<%=basePath%>servlet/employeeLeaveServlet?fun=resign" method="post">
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							员工编号                 <%--     .innerHTML--%>             <%--   onblur失去焦点时触发--%>
							<input id="eid" type="text" name="eid" placehoder="员工编号" class="form-control" onblur="getEname(this)"/>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							员工姓名
							<input id="ename" type="text" name="ename" placehoder="员工姓名"
								disabled="disabled" class="form-control"/>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							离职时间
							<input id="todate" type="date" name="todate" class="form-control"/>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							离职类型
							<select id="totype" name="totype" class="form-control" >
								<option selected="selected" value="0">
									主动辞职
								</option>
								<option value="1">
									辞退
								</option>
								<option value="2">
									退休
								</option>
								<option value="3">
									开除
								</option>
								<option value="4">
									试用期未通过
								</option>
							</select>
						</div>
					</div>
				</div>
				<br>
				离职事由：
				<br />
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<textarea id="reason" name="reason" rows="12" cols="110" ></textarea>
						</div>
					</div>
						</div>
					<br />
					<div class="col-md-3  col-md-offset-6">
						<div class="form-group">
							<input type="submit" name="submit1" value="提交"
								class="btn btn-danger" onclick="return submit()"/>
						</div>
					</div>
			</form>
		</div>
	</body>
</html>
