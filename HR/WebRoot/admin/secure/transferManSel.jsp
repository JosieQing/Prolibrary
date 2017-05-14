<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'transferManSel.jsp' starting page</title>
    
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
				data-target="#demo2">
				<h4>
					调动信息查询
				</h4>
			</button>
			<br/>
            <br/>
			<div id="demo2" class="collapse in">
			<div class="container"  align="center" >
				<form  action="<%=basePath%>servlet/transferManServlet"
					method="post">
					<input type="hidden" name="s"
						value="sele" />
					<div id="demo1" class="panel-collapse ">
						<div class="row">
							<div class="col-md-2 col-md-offset-2">
								<div class="form-group">
									员工编号
									<input type="text" class="form-control" placeholder="员工编号"
										id="eid2" name="eid2" />
								</div>
							</div>
							
							<div class="col-md-2">
								<div class="form-group">
									调动类型
									<select class="form-control" id="tmtype2" name="tmtype2">
										<option selected value="1">
											不限
										</option>
										<option value="2">
											主动调动
										</option>
										<option value="3">
											被动调动
										</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3 col-md-offset-1">
								<div class="form-group">
									开始日期
									<input type="date" class="form-control" placeholder="开始日期" id="startday"  name="startday"/>
								</div>
							</div>
							<div class="col-md-3">
								<div class="form-group">
									结束日期
									<input type="date" class="form-control" placeholder="结束日期" id="endday" name="endday" />
								</div>
							</div>
						</div>
						<div class="row">
						<div class="col-md-2 col-md-offset-3">
								<div class="form-group">
									<br>
									<button type="submit" class="btn btn-info">
										查询
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
			<display:table class="table table-hover" id="transferInfo" name="${requestScope['list']}"
							size="${requestScope['total']}" partialList="true" export="true"
							pagesize="${initParam.pageSize}"
							requestURI="/servlet/transferManServlet">
							<display:column property="tmid" title="调动编号" sortable="true" ></display:column>
							<display:column property="eid" title="员工编号" sortable="true" ></display:column>
							<display:column property="oldDname" title="原部门"
								sortable="true" ></display:column>
							<display:column property="oldJname" title="原岗位"
								sortable="true" ></display:column>
							<display:column property="newDname" title="新部门" sortable="true" ></display:column>
							<display:column property="newJname" title="新岗位" sortable="true" ></display:column>
							<display:column property="tmType" title="调动类型" sortable="true" ></display:column>
							<display:column property="reason" title="调动原因" sortable="true" ></display:column>
							<display:column property="tmDate" title="调动日期" sortable="true" ></display:column>
						</display:table>
						</c:if>
						</div>
	
						
  </body>
</html>
