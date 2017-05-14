<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>部门创建及添加</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<jsp:include page="../header.jsp"></jsp:include>
	</head>
<body>
	<jsp:include page="../nav.jsp"></jsp:include>
	<div style="text-align:center">
	<label class="control-label" style="font-size:25px;">添加部门</label>
	</div>
	<br/>
	<div class="container" style="width:50%;margin:0,auto;position:relative;" >
	<form class="form-horizontal"  method="post" action="servlet/department">
	  	<input type="hidden" name="s" value="addDept"  />
				<div class="row">
					<div class="col-md-5 ">
						<div class="form-group">
							部门编号
							<input type="text" name="deptno" class="form-control" placeholder="部门编号" />
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="form-group">
							部门名称
							<input type="text" name="dname" class="form-control" placeholder="部门名称"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5">
						<div class="form-group">
							部门类型
							<select name="type" class="form-control" placeholder="部门类型">
								<option selected="selected">
									公司
								</option>
								<option>
									部门
								</option>
							</select>
						</div>
					</div>
					<div class="col-md-5 col-md-offset-1">
						<div class="form-group">
							电话
							<input type="text" name="phone" class="form-control" placeholder="电话" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5 ">
						<div class="form-group">
							传真
							<input type="text" name="fax" class="form-control" placeholder="传真"/>
						</div>
					</div>
					<div class="col-md-5  col-md-offset-1">
						<div class="form-group">
							上级部门
							<input type="text" name="superDept" class="form-control" placeholder="上级部门"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5 ">
						<div class="form-group">
							成立日期
							<input type="date" name="startDay" class="form-control" placeholder="成立日期"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12 ">
						<div class="form-group">
							描述
							<textarea name="describe" class="form-control" rows="3" cols="15">
							</textarea>
						</div>
					</div>
				</div>
					<div class="row">
						<div class="col-md-2 col-md-offset-3" >
							<div class="form-group">
								<button type="submit" class="btn btn-info btn-lg btn-block">保存</button>
							</div>
						</div>
						<div class="col-md-2 col-md-offset-1">
							<div class="form-group">
								<button type="submit" class="btn btn-default btn-lg btn-block">重置</button>
							</div>
						</div>
					</div>
		</form>
	</div>
		   <jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
