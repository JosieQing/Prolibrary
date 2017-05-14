<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.neuedu.examonline.subjectlib.type.*"%>
<%@ page import="java.util.*"%>
<%@ include file="../../inc/theme.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>problemTypes_list</title>

</head>
<body>

	<table border="1" class="table table-hover" align="center">
		<input type="hidden" value="delete" id="func" name="func">

		<thead>
			<tr align="center">
				<th>题型序号</th>
				<th>题型名称</th>
				<th>操作<input class="btn btn-primary" type="button" value="添加题型"
					id="types_add" name="types_add"
					onclick="location='problemTypes_add.jsp'"></th>
			</tr>
		</thead>

		<%
			ProblemTypesDAO dao = new ProblemTypesDAO();
			List list = dao.getTypesAll();
			for (int i = 0; i < list.size(); i++) {
				ProblemTypesBean bean = (ProblemTypesBean) list.get(i);
				String types_id = bean.getTypes_id();
				String types_name = bean.getTypes_name();
		%>

		<tr>
			<td class="info"><%=(i + 1)%></td>
			<td class="active"><%=types_name%></td>
			<td class="warning"><a
				href="problemTypes_update.jsp?types_id=<%=types_id%>">修改题型</a> <a
				id="deleteTypes" href="javascript:delete1('<%=types_id%>')">删除题型</a>
				<input type="hidden" value=<%=types_id%> id="delete_id" name="delete_id"></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>

<script type="text/javascript">
	function delete1(id) {
		if (confirm("是否删除id为" + id + "的题型信息？")) {

			$.ajax({
				url : '../../ProblemTypesServlet',
				type : 'POST',
				data : {
					func : $("#func").val(),
					delete_id : $("#delete_id").val()
				},
				dataType : "text",
				success : function(data) {
					if (data == "1") {
						alert("删除成功");
						location = "problemTypes_list.jsp";
					}
				},
				error : function() {
					alert("异常");
				}
			});

		}
	}
</script>

<%-- <script src="<%=basePath %>js/typesDelete.js"></script> --%>