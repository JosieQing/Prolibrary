<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<title>Ա����ְ����</title>

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
			<h1>
				Ա����ְ����
			</h1>
			<h2>
				��ְ��¼��ѯ
			</h2>
			<form action="/HR/servlet/employeeLeaveMassageServlet" method="post">
			<input type="hidden" name="fun" value="ResignMessage">
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							Ա�����
							<input type="text" name="eid" placehoder="Ա�����"
								class="form-control" />
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							Ա������
							<input type="text" name="ename" placehoder="Ա������"
								class="form-control" />
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							��ְ����
							<select name="totype" class="form-control">
								<option selected="selected" value="0">
									������ְ
								</option>
								<option value="1">
									����
								</option>
								<option value="2">
									����
								</option>
								<option value="3">
									�����ڽ���
								</option>
							</select>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							ʱ��
							<input type="date" name="todate" class="form-control" />
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<input type="submit" name="submit1" value="��ѯ"
								class="btn btn-default" class="form-control" />
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<input type="reset" name="reset1" value="����"
								class="btn btn-danger" class="form-control" />
						</div>
					</div>
				</div>
				<br />
				<c:if test="${list ne null}">
				��ѯ�����
				
				<d:table class="table table-striped"  id="leavemessage" name="${sessionScope['list']}" size="${sessionScope['total']}" partialList="true"  
				export="true" pagesize="${initParam.pageSize}" requestURI="/servlet/employeeLeaveMassageServlet">
				<d:column property="lid" title="��ְ���" sortable="true"></d:column>
				<d:column property="eid" title="Ա�����" sortable="true"></d:column>
				<d:column property="todate" title="��ְ����"></d:column>
				<d:column property="totype" title="��ְ����"></d:column>
				<d:column property="reason" title="��ְ����"></d:column>				
				</d:table>
				</c:if>	
			</form>
		</div>
	</body>
</html>
