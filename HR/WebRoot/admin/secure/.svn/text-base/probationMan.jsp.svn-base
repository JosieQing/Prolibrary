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
		<title>试用管理</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">-->
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
		
function getEname(t)  
{  

  var eid = t.value;
  var ename1 = $("#ename1");
   if ((eid == null) || (eid == "")) return;
  var url = "<%=basePath%>servlet/ajaxServlet?s=ename";
 
	$.get(url,{eid: eid},function(data) {
 			
	   			if(data == "0"){
	   			
	   				alert("员工不存在！")
	   			}else{
	   				ename1.val(data);
	   			}
	 });
}   

function getEname2(t)  
{  
  var eid = t.value;
   if ((eid == null) || (eid == "")) {return;}else{
   		
   		var pmid = $("#pmid"); 
   		
   		var ename2 = $("#ename2"); 
   				
   		var pmid_url = "<%=basePath%>servlet/ajaxServlet?s=pmid";
		var ename2_url = "<%=basePath%>servlet/ajaxServlet?s=ename";
		
   			// 请求员工试用编号
	   		$.get(pmid_url, {eid: eid},function(data) {
	   				// 试用编号为空，说明员工编号输入有误
	   				if(data == "0") {
						alert("非试用员工！");	   					
	   					pmid.val();
	   					ename2.val();
	   				}
	   				else {
	   				pmid.val(data);
	   					// 请求员工姓名并填充表单
	   					$.get(ename2_url, {eid: eid},
	   						function(data) {
	   					
	   							ename2.val(data);
	   						}
	   					)};
	   			});
  }
}   

	function checkForm1(t){


		var eid = $("#eid1").val();
  		
 		
 		if ((eid == null) || (eid == "")) {alert("请输入员工编号"); return  false; }
 		
  		
	 	//日期的验证
	 	var startday =$("#startday").val();
  		
  		if ((startday == null) || (startday == "")) {alert("请正确选择日期");
  		return false;
  		}
  		
	}
	
	
	function checkForm2(t){

	
		var eid = $("#eid2").val();
  		
  		if ((eid == null) || (eid == "")) {alert("请输入员工编号"); return false; }
	}
	
</script>
		<jsp:include page="../header.jsp"></jsp:include>
		<jsp:include page="../footer.jsp"></jsp:include>

	</head>
	<body>

		<jsp:include page="../nav.jsp"></jsp:include>

		<div class="container"
			style="width: 70%; margin: 0, auto; position: relative;"
			align="center">
			<button type="button" class="btn btn-info" data-toggle="collapse"
				data-target="#demo1">
				<h4>
					试用信息录入
				</h4>
			</button>
			<br />
			<br />
			<div class="container" align="center">
				<form action="<%=basePath%>servlet/probationManServlet"
					method="post">
					<input type="hidden" name="s" value="add" />
					<div id="demo1" class="collapse in" align="center">
						<div class="row">
							<div class="col-md-2 col-md-offset-2">
								<div class="form-group" align="center">
									员工编号
									<input type="number" class="form-control" placeholder="员工编号"
										name="eid1" autofocus id="eid1"  onblur="getEname(this)"  />
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									员工姓名
									<input type="text" class="form-control" placeholder="员工姓名"
										id="ename1" disabled />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-2 col-md-offset-2">
								<div class="form-group">
									试用开始日期
									<input type="date" class="form-control" name="probationDay" id="startday"
									name="startday"/>
								</div>
							</div>
							<div class="col-md-2">
								<div class="form-group">
									试用持续时间
									<select class="form-control" name="probationTime"
										id="probationTime">
										<option selected value="3">
											三个月
										</option>
										<option value="6">
											六个月
										</option>
										<option value="12">
											一年
										</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row" align="right">
							<div class="col-md-2 col-md-offset-2">
								<div class="form-group">
									<br>
									<button type="submit" class="btn btn-success" onclick="return checkForm1(this)">
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
			<button type="button" class="btn btn-info" data-toggle="collapse"
				data-target="#demo2">
				<h4>
					试用信息管理
				</h4>
			</button>
			<br />
			<br />
			<div id="demo2" class="collapse in">
				<div class="container" align="center">
					<form action="<%=basePath%>servlet/probationManServlet"
						method="post">
						<input type="hidden" name="s" value="man" />
						<div id="demo2" class="panel-collapse ">
							<div class="row">
								<div class="col-md-2 col-md-offset-1">
									<div class="form-group">
										试用编号
										<input type="text" class="form-control" placeholder="试用编号"
											id="pmid" disabled name="pmid" />
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										员工编号
										<input type="number" class="form-control" placeholder="员工编号"
											id="eid2" name="eid2"  onblur="getEname2(this)"   />
									</div> 
								</div>
								<div class="col-md-2">
									<div class="form-group">
										员工姓名
										<input type="text" class="form-control" placeholder="员工姓名"
											id="ename2" disabled name="ename2" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-2 col-md-offset-1">
									<div class="form-group">

										考核结果
										<select class="form-control" name="result" id="result">

											<option selected value="1">
												转正
											</option>

											<option value="2">
												延期一个月
											</option>

											<option value="3">
												不予录用
											</option>

										</select>
									</div>
								</div>
							</div>
							<div class="row" align="right">
								<div class="col-md-3 col-md-offset-1">
									<div class="form-group">
										考核评语
										<textarea rows="5px" cols="40px" name="remarks" id="remarks"></textarea>
									</div>
								</div>
								<div class="col-md-1 col-md-offset-1">
									<div class="form-group">
										<br>
										<br>
										<br>
										<button type="submit" class="btn btn-success"  onclick="return checkForm2(this)" >
											保存
										</button>
									</div>
								</div>
								<div class="col-md-1">
									<div class="form-group">
										<br>
										<br>
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
			</div>
	</body>

</html>
