<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../inc/db.jsp"%>
<%@ include file="../../inc/head.jsp"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<!DOCTYPE html>   
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../login/css/main.css" />
<script src="js/login_javascript.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="css/login_css.css"/>
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
		String sqla = "select menu_str,id from character where id="+ id;
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


	String role = null;
	String link = null;

%>

			
</head>
<body class="body_left" onload="loadFun()">
<div id="menu">
	<ul class="nav nav-pills nav-stacked" role="navigation">
		<li class="active"><a href="#" onclick="show('base')">基础数据</a>
			<ul  class="nav nav-pills nav-stacked" id="base">
			<%
				Statement stat1 = null;
				ResultSet rs1 = null;
				String name = null;
				int pid = 0;
				int i = 1;
				try {
					String sql = "select name,id,link from menu";
					stat1 = conn.createStatement();
					rs1 = stat1.executeQuery(sql);
					while (rs1.next()) {
						name = rs1.getString("name");
						pid = rs1.getInt("id");
						link = rs1.getString("link");
			if(pid<=4){
					%>
					<%
					if(aa.contains(String.valueOf(pid))){
						out.print("<li><a href='"+link+"' target='main'>"+name+"</a></li>");}%>
					<%
			}
			i++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs1 != null) {
					rs1.close();
				}
				if (stat1 != null) {
					stat1.close();
				}
			}
		%>
			</ul></li>
			<li class="active"><a href="#" onclick="show('system')">系统管理</a>
			<ul  class="nav nav-pills nav-stacked" id="system">
			<%
			Statement stat2 = null;
			ResultSet rs2 = null;
			name = null;
			pid = 0;
			i = 1;
			try {
				String sql = "select name,id,link from menu";
				stat2 = conn.createStatement();
				rs2 = stat2.executeQuery(sql);
				while (rs2.next()) {
					name = rs2.getString("name");
					pid = rs2.getInt("id");
					link = rs2.getString("link");
			if((pid<=9)&(pid>4)){				
				%>
				<%if(aa.contains(String.valueOf(pid))){
					out.print("<li><a href='"+link+"' target='main'>"+name+"</a></li>");}%>
				<%
			}
			i++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs2 != null) {
					rs2.close();
				}
				if (stat2 != null) {
					stat2.close();
				}
			}
			%>
			</ul></li>
			<li class="active"><a href="#" onclick="show('subjectlib')">题库管理</a>
			<ul class="nav nav-pills nav-stacked" id="subjectlib">
			<%
			Statement stat3 = null;
			ResultSet rs3 = null;
			name = null;
			pid = 0;
			i = 1;
			try {
				String sql = "select name,id,link from menu";
				stat3 = conn.createStatement();
				rs3 = stat3.executeQuery(sql);
				while (rs3.next()) {
					name = rs3.getString("name");
					pid = rs3.getInt("id");
					link = rs3.getString("link");
			if((pid<=12)&(pid>9)){				
				%>
				<%
				if(aa.contains(String.valueOf(pid))){
					out.print("<li><a href='"+link+"' target='main'>"+name+"</a></li>");}%>
				<%
			}
			i++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs3 != null) {
					rs3.close();
				}
				if (stat3 != null) {
					stat3.close();
				}
			}
			%>
			</ul></li>
			<li class="active"><a href="#" onclick="show('paper')">试卷管理</a>
			<ul class="nav nav-pills nav-stacked" id="paper">
			<%
			Statement stat4 = null;
			ResultSet rs4 = null;
			name = null;
			pid = 0;
			i = 1;
			try {
				String sql = "select name,id,link from menu";
				stat4 = conn.createStatement();
				rs4 = stat4.executeQuery(sql);
				while (rs4.next()) {
					name = rs4.getString("name");
					pid = rs4.getInt("id");
					link = rs4.getString("link");
			if((pid<=14)&(pid>12)){				
				%>
				<%
				if(aa.contains(String.valueOf(pid))){
					out.print("<li><a href='"+link+"' target='main'>"+name+"</a></li>");}%>
				<%
			}
			i++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs4 != null) {
					rs4.close();
				}
				if (stat4 != null) {
					stat4.close();
				}
			}
			%>
			</ul></li>
			<li class="active"><a href="#" onclick="show('exam')">考试管理</a>
			<ul class="nav nav-pills nav-stacked" id="exam">
			<%
			Statement stat5 = null;
			ResultSet rs5 = null;
			name = null;
			pid = 0;
			i = 1;
			try {
				String sql = "select name,id,link from menu";
				stat5 = conn.createStatement();
				rs5 = stat5.executeQuery(sql);
				while (rs5.next()) {
					name = rs5.getString("name");
					pid = rs5.getInt("id");
					link = rs5.getString("link");
			if((pid<=17)&(pid>14)){				
				%>
				<%
				if(aa.contains(String.valueOf(pid))){
					out.print("<li><a href='"+link+"' target='main'>"+name+"</a></li>");}%>
				<%
			}
			i++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs5 != null) {
					rs5.close();
				}
				if (stat5 != null) {
					stat5.close();
				}
			}
			%>
			</ul></li>
			<li class="active"><a href="#" onclick="show('report')">报表统计</a>
			<ul class="nav nav-pills nav-stacked" id="report">
			<%
			Statement stat6 = null;
			ResultSet rs6 = null;
			name = null;
			pid = 0;
			i = 1;
			try {
				String sql = "select name,id,link from menu";
				stat6 = conn.createStatement();
				rs6 = stat6.executeQuery(sql);
				while (rs6.next()) {
					name = rs6.getString("name");
					pid = rs6.getInt("id");
					link = rs6.getString("link");
			if((pid<=21)&(pid>17)){				
				%>
				<%
				if(aa.contains(String.valueOf(pid))){
					out.print("<li><a href='"+link+"' target='main'>"+name+"</a></li>");}%>
				<%
			}
			i++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs6 != null) {
					rs6.close();
				}
				if (stat6 != null) {
					stat6.close();
				}
			}
			%>
			</ul></li>
			<li class="active"><a href="#" onclick="show('stufunc')">学生功能</a>
			<ul class="nav nav-pills nav-stacked" id="stufunc">
			<%
			Statement stat7 = null;
			ResultSet rs7 = null;
			name = null;
			pid = 0;
			i = 1;
			try {
				String sql = "select name,id,link from menu";
				stat7 = conn.createStatement();
				rs7 = stat7.executeQuery(sql);
				while (rs7.next()) {
					name = rs7.getString("name");
					pid = rs7.getInt("id");
					link = rs7.getString("link");
			if((pid<=24)&(pid>21)){				
				%>
				<%
				if(aa.contains(String.valueOf(pid))){
					out.print("<li><a href='"+link+"' target='main'>"+name+"</a></li>");}%>
				<%
			}
			i++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs7 != null) {
					rs7.close();
				}
				if (stat7 != null) {
					stat7.close();
				}
				if (conn != null) {
					conn.close();
				}
			}
			%>
			</ul></li>
	</ul>
</div>
</body>
</html>



