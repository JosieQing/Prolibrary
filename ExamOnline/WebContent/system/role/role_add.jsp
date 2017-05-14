<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.neuedu.examonline.db.*"%>
<%@ page import="java.sql.*"%>
<%@ include file="../../inc/theme.jsp"%>
<html>
<head>
<title>添加新角色</title>
</head>
<body>
	<form name="f1" method="post" action="role_add_action.jsp">
		<table class="table table-bordered" style="width:400px;">
			<tr class="bg-success">
			<td>角色名</td>
				<td>
					<div class="form-group">
					<input type="text" class="form-control" id="exampleInputName1" name="role" style="width:200px;">
					</div>
				</td>
			</tr>
			<tr class="bg-info">
				<td>权限</td>
				<td>
				<%
					Statement stat = null;
					ResultSet rs = null;
					String name = null;
					String id = null;
					int i = 1;

					try {
						String sql = "select name,id from menu";
						stat = conn.createStatement();
						rs = stat.executeQuery(sql);
						while (rs.next()) {
							name = rs.getString("name");
							id = rs.getString("id");
				%>
				<div><label><input name="che" value="<%=id%>" type="checkbox"/><%=name%></label></div>
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
			</td>
			</tr>
		</table>
		<button type="button" class="btn btn-success" onclick="document.f1.submit();">提交</button>
		<button type="button" class="btn btn-primary" onclick="location='role_manager.jsp'">返回</button>
	</form>
</body>
</html>