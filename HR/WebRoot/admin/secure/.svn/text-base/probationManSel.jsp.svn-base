<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
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

		<title>试用信息查询</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
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
		
		
		</script>

	</head>

	<body>

		<jsp:include page="../nav.jsp"></jsp:include>

		<div class="container"
			style="width: 70%; margin: 0, auto; position: relative;"
			align="center">
			<button type="button" class="btn btn-info" data-toggle="collapse"
				data-target="#demo3">
				<h4>
					试用信息查询
				</h4>
			</button>
			<br />
			<br />
			<div id="demo3" class="collapse in">
				<div class="container" align="center">
					<form action="<%=basePath%>servlet/probationManServlet"
						method="post">
						<input type="hidden" name="s" value="eidandstate" />
						<div id="demo3" class="panel-collapse ">
							<div class="row">
								<div class="col-md-2 col-md-offset-2">
									<div class="form-group" align="center">
										员工编号
										<input type="number" class="form-control" placeholder="员工编号"
											name="eid3" id="eid3" onblur="getEname(this)" />
									</div>
								</div>
								<div class="col-md-2">
									<div class="form-group">
										试用状态
										<select class="form-control" name="state" id="state">
										<option selected  value="1" >
												不限
											</option>
											<option value="2">
												已转正
											</option>
											<option value="3">
												延期中
											</option>
											<option value="4">
												未录用
											</option>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								
								<div class="col-md-2 col-md-offset-2">
									<div class="form-group" align="center">
										<br>
										<button type="submit" class="btn btn-success " >
											查询
										</button>
									</div>
								</div>
								<div class="col-md-2">
								<div class="form-group" align="center" >
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
		</div>
		

<div class="container"
			style="width: 90%; margin: 0, auto; position: relative;"
			align="center">

			<c:if test="${list ne null}">
				<display:table class="table table-hover" id="probationInfo"
					name="${requestScope['list']}" size="${requestScope['total']}"
					partialList="true" export="true" pagesize="${initParam.pageSize}"
					requestURI="/servlet/probationManServlet">
					<display:column property="pmid" title="试用编号" sortable="true"></display:column>
					<display:column property="eid" title="员工编号" sortable="true"></display:column>
					<display:column property="probationDay" title="试用开始日期"
						sortable="true"></display:column>
					<display:column property="probationTime" title="试用时间"
						sortable="true"></display:column>
					<display:column property="state" title="试用状态" sortable="true"></display:column>
					<display:column property="formalDay" title="转正日期" sortable="true"></display:column>
					<display:column property="delayDay" title="延迟日期" sortable="true"></display:column>
					<display:column property="leaveDay" title="离职日期" sortable="true"></display:column>
					<display:column property="endDay" title="试用结束日期" sortable="true"></display:column>
				</display:table>
			</c:if>
		</div>
		</div>
	</body>
</html>
