<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@taglib uri="http://displaytag.sf.net" prefix="d" %>

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

		<title>��ƸԱ������-</title>

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
		
	</head>
	<body>
	<jsp:include page="../nav.jsp"></jsp:include>
		<div class="container"
			style="width: 60%; margin: 0, auto; position: relative;">		
			<h2>
				��ƸԱ������
			</h2>
			<h3>
				��ƸԱ����¼
			</h3>
			<form action="<%=basePath%>/servlet/formNewServlet" method="post">
			<input type="hidden" name="fun" value="new">
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							��������
							<select name="dname" class="form-control">
								<option selected="selected" value="101">
									A����
								</option>
								<option value="102">
									C��
								</option>
								<option value="103">
									E��
								</option>
							</select>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							��ʼʱ��
							<input type="date" name="workDay" class="form-control" />
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							����ʱ��
							<input type="date" name="formalDay" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 col-md-offset-3">
						<div class="form-group">
							<input type="submit" name="submit1" value="��ѯ"
								class="btn btn-default" />
						</div>
					</div>
					<div class="col-md-3 ">
						<div class="form-group">
							<input type="reset" name="reset1" value="����"
								class="btn btn-danger" />
						</div>
					</div>
				</div><%--
				��ѯ�����
				<d:table id="formnew" name="${sessionScope['list']}" size="${sessionScope['total']}" partialList="true" 
				export="true" pagesize="${initParam.pageSize}" requestURI="/servlet/formNewServlet" >
				<d:column property="eid" title="Ա�����" sortable="true"></d:column>
				<d:column property="dname" title="��������" sortable="true"></d:column>
				<d:column property="jname" title="��λ����" sortable="true"></d:column>
				<d:column property="ename" title="����" sortable="true"></d:column>
				<d:column property="sex" title="�Ա�" sortable="true"></d:column>
				<d:column property="workday" title="��ְ����" sortable="true"></d:column>
				<d:column property="highestEducation" title="ѧ��" sortable="true"></d:column>
				</d:table>
			--%></form>
		</div>
	</body>
</html>
