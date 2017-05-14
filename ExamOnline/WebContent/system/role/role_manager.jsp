<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.neuedu.examonline.db.*"%>
<%@ page import="com.neuedu.examonline.util.*"%>
<%@ page import="java.sql.*"%>
<%@ include file="../../inc/theme.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>角色管理</title>
<style type="text/css">
#d1{
position: absolute;
left: 50px;
top: 50px;
font-size: 30px;
}
</style>
</head>
<body>
<ol class="breadcrumb">
  <li>系统管理</li>
  <li class="active">角色管理</li>
</ol>
<div id="d1">
	<%
	String roles = null;
	roles = request.getParameter("roles");
	if (roles == null) {
		roles = (String) session.getAttribute("roles");
		if (roles == null) {
			roles = "";
		}
	} else {
		roles = StringUtil.iSOToUtf8(roles);
		session.setAttribute("roles", roles);
	}
%>

	<form class="form-inline" action="role_manager.jsp">
		<div class="form-group">
			<label for="exampleInputName2">角色</label> <input type="text"
				class="form-control" id="exampleInputName2" name="roles"
				value="<%=roles%>"  style="width: 250px;">
		</div>
		<button type="submit" class="btn btn-primary btn-sm">查询</button>
		<button type="button" class="btn btn-success btn-sm"
			onclick="location='role_add.jsp'">添加</button>
	</form>

	<table class="table table-bordered table-hover"  style="width: 500px;">
		<tr>
			<td>序号</td>
			<td>角色名</td>
			<td>操作</td>
		</tr>
		<%
			Statement stat = null;
			ResultSet rs = null;
			String role = null;
			String id = null;
			int i = 1;
			try {
				String sql = "select role,id from character where role like '%"
						+ roles + "%' order by id asc";
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);
				while (rs.next()) {
					role = rs.getString("role");
					id = rs.getString("id");
		%>
		<tr>
			<td><%=i%></td>
			<td><%=role%></td>
			<td><a href="power_update.jsp?id=<%=id%>">修改</a>&nbsp;&nbsp;&nbsp;
				<a href="javascript:delete1('<%=id%>')">删除</a></td>
		</tr>
		<%
			i++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs != null) {
					rs.close();
				}
				if (stat != null) {
					stat.close();
				}
				if (conn != null) {
					conn.close();
				}
			}
		%>

	</table>
	</div>
</body>
</html>
<script luanuage="javascript">
	function delete1(id) {
		if (confirm("您确认要删除吗？")) {
			location = "role_delete_action.jsp?id=" + id;
		}
	}
</script>