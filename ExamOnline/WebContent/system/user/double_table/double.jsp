<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.neuedu.examonline.system.user.tools.*"%>
<%@ page import="com.neuedu.examonline.system.user.user.*"%>
<%@ include file="../../../inc/theme.jsp"%>
<html>
<head>
<script src="../../../js/jquery-3.2.0.min.js"></script>
<link rel="stylesheet" href="../../../css/double.css" type="text/css">
</head>
<body>

	<div style="display: block;" id="cover"></div>
	<div id="loginMessage"></div>
	<form action="double.jsp" method="post">
		<table class="tablev1" border="1">
			<tr>
				<td align="center">搜索：<input name="double" type="text" />
					&nbsp;&nbsp;&nbsp;&nbsp; <input id="select" type="submit" class="btn btn-success"
					value="查询" />
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
					id="add_action" class="btn btn-success" type="button" onclick="sendmsg()" value="添加" />
				</td>
			</tr>

			<tr>
				<td>
					<table class="tablev2" border="1">
						<tr>
							<td class="tdn0" align="center">序号</td>
							<td class="tdn1" align="center">登录名</td>
							<td class="tdn2" align="center">人员/角色</td>
							<td class="tdn3" align="center">操作</td>
						</tr>
						<%@ include file="../Page/page_top.jsp"%>
						<%
							String name = request.getParameter("double");
						
							PageUtil pu = new PageUtil();
							UserBean ub = new UserBean();
							rowTotal = ub.getCount(name);
							pageTotal = pu.getPageTotal(rowTotal);
							int rowIndex = pu.getRowIndex(currentPage);

							Statement stat = null;
							ResultSet rs = null;
							
							if (name == null) {
								name = "";
							}
							String login_name = "";
							String role = "";
							int i = 1;
							try {
								//链接数据库
								String sql = "select * from user_table where login_name like '%"
										+ name + "%' order by idea asc";
								stat = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
								rs = stat.executeQuery(sql);
								if(rowIndex == 0){
									rs.beforeFirst();
								}else{
								rs.absolute(rowIndex);
								}
								while (rs.next()) {
									if(i>5){
										break;
									}
									int id = rs.getInt("idea");
									login_name = rs.getString("login_name");
									role = rs.getString("role");
						%>
						<tr class="bg-warning">
							<td align="center"><%=i%></td>
							<td align="center"><%=login_name%></td>
							<td align="center"><%=role%></td>
							<td align="center"><a class="tda1"
								href="../Update/update.jsp?id=<%=id%>">修改</a> <a class="tda2"
								href="../Update/delete.jsp?id=<%=id%>">删除</a></td>
						</tr>
						<%
							i++;
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						%>
					</table>
					</form>
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<%
						String page_location = "double.jsp";
					%> 
					<%@ include file="../Page/page_bottom.jsp"%>
				</td>
			</tr>
		</table>

		<div id="send_msg" class="send_msg">
			<table width=100% border="0">
				<tr>
					<td colspan="2" align="center" class="add_user">添加用户</td>
				</tr>
				<tr>
					<td align="center">登录名：</td>
					<td align="center"><input type="text" id="add_login"
						name="add_login"></td>
				</tr>
				<tr>
					<td align="center">密码：</td>
					<td align="center"><input type="password" id="add_pass"
						name="add_pass"></td>
				</tr>
				<tr>
					<td align="center">个人信息：</td>
					<td align="center"><select id="change" name="change">
							<option value="null">请选择</option>
							<option value="teacher">教师</option>
							<option value="student">学生</option>
					</select> <select id="add_select" name="add_select">
							<!-- 读取值与返回信息遍历信息 -->
					</select>
				</tr>
				<tr>
					<td align="center">角色：</td>
					<td align="center"><select id="add_role" name="add_role">
							<%
								Statement hide = null;
								ResultSet show = null;

								String actress = null;
								try {
									//链接数据库
									String sql = "SELECT * from character";
									hide = conn.createStatement();
									show = hide.executeQuery(sql);
									while (show.next()) {
										actress = show.getString("role");
							%>
							<option value="<%=actress%>"><%=actress%></option>
							<%
								}
								} catch (Exception e) {
									e.printStackTrace();
								} finally {
									try {
										if (hide != null) {
											hide.close();
										}
										if (show != null) {
											show.close();
										}
										if (rs != null) {
											rs.close();
										}
										if (stat != null) {
											stat.close();
										}
										if (conn != null) {
											conn.close();
										}
									} catch (SQLException sqle) {
										sqle.printStackTrace();
									}
								}
							%>
					</select></td>
				</tr>
				<tr>
					<td align="center">备注：</td>
					<td align="center"><input type="text" id="add_remark"
						name="add_remark"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input id="action" class="btn btn-success"
						type="button" value="确定" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
						class="btn btn-success" type="button" value="关闭" onclick="closs()" /></td>
				</tr>
			</table>
		</div>
</body>
</html>

<script>
	$(".send_msg").hide();
	$("#cover").hide();
	function sendmsg() {
		$("#send_msg").show();
		$("#cover").show();
	}
	function closs() {
		$(".send_msg").hide();
		$("#cover").hide();
	}
</script>
<script>
	$("#change").change(function() {
		$("#add_select").empty();
		if ($("#change option:selected").val() == "teacher") {
			$.ajax({
				url : '../../../teacherServlet',
				type : 'POST',
				async : true,
				data : {
					teacher : $("#change").val()
				},
				timeout : 5000,
				dataType : 'json',
				success : function(data, textStatus,jqXHR) {
					var item = data;
					var selectModle = $("#add_select");
					selectModle.empty();
					if (item != null) {
						for ( var i in item) {
							var items = item[i];
							selectModle.append("<option value = '" + items.teacher_name+"'>"
											+ items.teacher_name
											+ "</option>")
						};
					} else {
						selectModle.empty();
					}
				},
				error : function(xhr, textStatus) {
					alert('错误');
				}
		})
	} else if ($("#change option:selected").val() == "student") {
		$.ajax({
			url : '../../../studentServlet',
			type : 'POST',
			async : true,
			data : {
				student : $("#change").val()
			},
			timeout : 5000,
			dataType : 'json',
			success : function(data, textStatus,jqXHR) {
				var item = data;
				var selectModle = $("#add_select");
				selectModle.empty();
				if (item != null) {
					for ( var i in item) {
					var items = item[i];
					selectModle.append("<option value = '" + items.student_name+"'>"
								+ items.student_name + "</option>")};
				} else {
				selectModle.empty();
				}
			},
			error : function(xhr, textStatus) {
				alert('错误');
			}
		})
	}
})
</script>
<script src="../../../js/textJq.js"></script>