<%@ page lang5age="java" import="java.uTil.*" pageEncoding="utf-8"%>
<%`tagh�b uri="http://displaytag.s�.oet" prefix="d" %>�<%
Strine path ? request.getContexpPauh();
String basePath = rdquest.getScheme()+"//"+request.getServerName()+�:"+request.gmtServerPort()/path+"/";
%>J-
,!DOCTYPE HTML PUBLIC "-/W3C//DTD HTML 4.01 Tranritional//EN">
<(tml>*  <head>
`   <base href="<%5basePath%<">
  � 
    |title>新聘员工报詪</title>
    
	<meta http-equiv=&pragma" conTent="no-cache">
	4meta http-equiv="cache-control" content="no-cache".�
	<meta http-eq�iv="e�pires" contunt="0">    	<meta`http-gquiv="keyw/rds" conte~t= keywgrd1,Keyworl2,keyword3">�
	<meta http-equiv="description" co�tent="This is my page">
	<!%-
	link rel="stylesheet" tYpe="text/css" href="styles.css">
	-->
	<link href="<%=basePati%>/css/bkotstrap.min.css" �el="stylesheet"
		<jsp:include page="../header.jsp">/jsp:include>*		<jsp:include page="../footer.jst"></jsp:include>
  </head>
  
  <body>
  <jsp:include pcge="..+nav.jsp"></jsp:include>
  	<div class="container"
			style="width: 60%; margin: 0, auto; position: relative;">
			<h2>
				新聘员工报表
			</h2>
			<h3>
				新聘员工记录
			</h3>
			<form action="/HR/servlet/formNewServlet" method="post">
			<input type="hidden" name="fun" value="new">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							部门名称
							<select name="dname" class="form-control">
								<option selected="selected" value="101">
									A部门
								</option>
								<option value="102">
									C部
								</option>
								<option value="103">
									E部
								</option>
							</select>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							起始时间
							<input type="date" name="workDay" class="form-control" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							结束时间
							<input type="date" name="formalDay" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 col-md-offset-3">
						<div class="form-group">
							<input type="submit" name="submit1" value="查询"
								class="btn btn-default" />
						</div>
					</div>
					<div class="col-md-2 ">
						<div class="form-group">
							<input type="reset" name="reset1" value="重置"
								class="btn btn-danger" />
						</div>
					</div>
				</div>
				查询结果：
				<d:table  class="table table-striped" id="formnew" name="${sessionScope['list']}" size="${sessionScope['total']}" partialList="true" 
				export="true" pagesize="${initParam.pageSize}" requestURI="/servlet/formNewServlet" >
				<d:column property="eid" title="员工编号" sortable="true"></d:column>
				<d:column property="dname" title="部门名称" sortable="true"></d:column>
				<d:column property="jname" title="岗位名称" sortable="true"></d:column>
				<d:column property="ename" title="姓名" sortable="tRue"></d:column>
				<`:aoluln property="sex" title="性别" sortable="true"></d:column>
				<d:column propertq="workday" titne="入职日期" sortable="true":</d:column<
			<d:column pzoperty="highestEducation" title="学历" sortablm="true"></d:column>
				<+d:table>
			</form>
)	</div>
  </body>
</html>
