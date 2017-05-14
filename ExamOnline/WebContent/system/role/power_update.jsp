<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.neuedu.examonline.db.*"%>
<%@ page import="java.sql.*"%>
<%@ include file="../../inc/theme.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>权限修改</title>
</head>
<%
	String id = null;
	id = request.getParameter("id");
	if (id == null) {
		id = "0";
	}

	Statement statm = null;
	ResultSet rsm = null;
	String menuid = null;
	List aa = null;
	try {
		String sqla = "select menu_str,id from character where id="
				+ id;
		statm = conn.createStatement();
		rsm = statm.executeQuery(sqla);
		if (rsm.next()) {
			menuid = rsm.getString("menu_str");
			String[] ss = menuid.split(",");
			aa = Arrays.asList(ss);
		}

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (rsm != null) {
			rsm.close();
		}
		if (statm != null) {
			statm.close();
		}

	}

	Statement statp = null;
	ResultSet rsp = null;
	String role = null;

	try {
		String sqlp = "select role from character where id=" + id;
		statp = conn.createStatement();
		rsp = statp.executeQuery(sqlp);
		if (rsp.next()) {
			role = rsp.getString("role");
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (rsp != null) {
			rsp.close();
		}
		if (statp != null) {
			statp.close();
		}

	}
%>

<body>
<form name="f2" method="post" action="power_update_action.jsp?id=<%=id%>">
	<table class="table table-bordered" style="width: 400px;">
		<tr class="bg-success">
			<td>角色名</td>
			<td><%=role%></td>
		</tr>
		<tr class="bg-info">
			<td>权限</td><td>
			<%
				Statement stat = null;
				ResultSet rs = null;
				String name = null;
				int pid = 0;
				int i = 1;
				try {
					String sql = "select name,id from menu";
					stat = conn.createStatement();
					rs = stat.executeQuery(sql);
					while (rs.next()) {
						name = rs.getString("name");
						pid = rs.getInt("id");
			%>
			<div><label><input name="check1" value="<%=pid%>" type="checkbox"
				<%if (aa.contains(String.valueOf(pid))){out.print("checked");}%> /><%=name%></label></div>
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
	<button type="button" class="btn btn-success" onclick="document.f2.submit();">确定</button>
	<button type="button" class="btn btn-primary" onclick="location='role_manager.jsp'">返回</button>
	</form>
</body>
</html>