<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.neusoft.bean.*"%>

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

		<title>调动管理</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<jsp:include page="../header.jsp"></jsp:include>

		<jsp:include page="../footer.jsp"></jsp:include>
		
		
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
		
	
	
		window.onload = function(){
		
		$("#dname2").load("<%=basePath %>servlet/ajaxServlet?s=dep");
		}
		
		function onDepartmentChange(t) {
		
   		console.log(t.value);
   	
   		if(t.value==="0"){
   			$("#jname2").empty();
   		}else{
   			var dep_Id = $("#dname2").val();
   			$("#jname2").load("<%=basePath %>servlet/ajaxServlet?s=job", {depId: dep_Id});
   		}
   	}
		
		function getMessage(t){
		
			var eid = t.value;
			
			if ((eid == null) || (eid == "")) {return;}else{
   		
   		var ename = $("#ename1"); 
   		var dname = $("#dname1");
   		var jname = $("#jname1"); 
   				
   		var ename_url = "<%=basePath%>servlet/ajaxServlet?s=ename";
		var dname_url = "<%=basePath%>servlet/ajaxServlet?s=dname";
		var jname_url = "<%=basePath%>servlet/ajaxServlet?s=jname";
		var	eid_url = "<%=basePath%>servlet/probationManServlet?s=emp";
		
		
   			
	   		$.get(eid_url, {eid: eid},function(data) {
	   				// 试用编号为空，说明员工编号输入有误
	   				if(data == "0") {
						alert("员工不存在！"); 					
	   					pmid.val();
	   					ename2.val();
	   					return;
	   				}
	   				else {
	   				
	   					// 请求员工姓名并填充表单
	   					$.get(ename_url, {eid: eid},
	   						function(data) {
	   					
	   							ename.val(data);
	   						}
	   					)
	   					
	   					$.get(dname_url, {eid: eid},
	   						function(data) {
	   					
	   							dname.val(data);
	   						}
	   					)
	   					
	   					$.get(jname_url, {eid: eid},
	   						function(data) {
	   					
	   							jname.val(data);
	   						}
	   					)
	   					
	   			};
	   			});
  }
		
		}
   
  function checkForm(t){


		var eid = $("#eid1").val();
		var dname = $("#dname2").val();
  		var reason = $("#reason").val();
  		
		if ((eid == null) || (eid == "")) {alert("请输入员工编号"); return  false ;  } 		
 		
  		if(dname == "0"){alert("请选择新部门"); return false ; }
  		
	 	if(reason == null  ||  reason == ""){alert("请注明调动原因"); return false;}
	}
 
   </script>
		
	</head>

	<body >
	
	<jsp:include page="../nav.jsp"></jsp:include>
	
		<div class="container"  style="width:70%;margin:0,auto;position:relative;" align="center">
			 <button type="button" class="btn btn-info" data-toggle="collapse"
				data-target="#demo1">
				<h4>
					员工调动管理
				</h4>
			</button>
			<br/>
			<br/>
			<div class="container"  align="center" >
			<form action="<%=basePath%>servlet/transferManServlet"
					method="post" >
					<input type="hidden" name="s"
						value="add" />
				<div id="demo1" class="collapse in" align="center">
					<div class="row">
						<div class="col-md-2 col-md-offset-2">
							<div class="form-group" align="center">
								员工姓名
								<input type="text" class="form-control" placeholder="员工姓名" name="ename1" id="ename1"
									disabled />
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								员工编号
								<input type="text" class="form-control" placeholder="员工编号" name="eid1" id="eid1"
									autofocus onblur="getMessage(this)"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2 col-md-offset-2">
							<div class="form-group">
								  原部门
								<input type="text" class="form-control" placeholder="原部门" name="dname1" id="dname1"
									disabled />
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								新部门
								<select class="form-control" name="dname2" id="dname2" onchange="onDepartmentChange(this)" >
									
								</select>
							</div>
						</div>
						<div class="col-md-2" >
								<div class="form-group">
									调动类型
									<select class="form-control" name="tmtype" id="tmtype">
										<option selected value="1">
											主动调动
										</option>
										<option value="2">
											被动调动
										</option>
										<option value="3 ">
											数据录入错误
										</option>
									</select>
								</div>
							</div>
					</div>
					<div class="row">
						<div class="col-md-2 col-md-offset-2" >
							<div class="form-group">
								原岗位
								<input type="text" class="form-control" placeholder="原岗位" name="jname1" id="jname1"
									disabled />
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								新岗位
								<select class="form-control" name="jname2" id="jname2">
								</select>
							</div>
						</div>
						
						</div>
						
						<div class="row">
						<div class="col-md-4 col-md-offset-2" >
							<div class="form-group">
								调动原因
								<input class="form-control" type="text" name="reason" id="reason"/>
							</div>
						</div>
					</div>
					<div class="row" align="right">
						<div class="col-md-2 col-md-offset-2">
							<div class="form-group">
								<br>
								<button type="submit" class="btn btn-success" onclick="checkForm(this)">
									提交
								</button>
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<br>
								<button type="reset" class="btn btn-warning">
									重置
								</button>
							</div>
						</div>
					</div>
				</div>
			</form>
			</div>
			<br/>
		</div>
		
	</body>
	
	
</html>
