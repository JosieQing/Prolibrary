<!DOCTYPE html>
<%@ include file="../../inc/head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.neuedu.examonline.exam.impersonality.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.neuedu.examonline.system.user.tools.*"%>
<%@ page import="com.neuedu.examonline.util.*"%>
<html>
<head>
<link rel="stylesheet" href="css/ys.css">
</head>
<body id="b1">
	<%
		int i = 1;
		//String ksbh1 = null;
		//ksbh1 = (String) session.getAttribute("ksbh1");

		CjBean cb = new CjBean();
		//cb.pj(ksbh1);
	%>
	<p id="p1">各班<span class="s1">客观</span>成<span class="s1">绩</span>表</p>
	<form action="cj.jsp">

		<%
			String q_bj = null;
			q_bj = request.getParameter("q_bj");
			if (q_bj == null) {
				q_bj = "";
			} else {
				q_bj = StringUtil.iSOToUtf8(q_bj);
			}

			String q_ksbh = null;
			q_ksbh = request.getParameter("q_ksbh");
			if (q_ksbh == null) {
				q_ksbh = "";
			} else {
				q_ksbh = StringUtil.iSOToUtf8(q_ksbh);
			}
		%>
		<div>
			班&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级:<input class="i1" type="text" name="q_bj" value="<%=q_bj%>">
		</div>
		<div>
			考试编号:<input class="i1" type="text" name="q_ksbh" value="<%=q_ksbh%>">
			<input class="btn" type="submit" value="查询">
		</div>
		
		
		

	</form>
	<table class="table table-condensed">

		<tr>
			<td>序号</td>
			<td>学号</td>
			<td>姓名</td>
			<td>班级</td>
			<td>考试编号</td>
			<td>客观分数</td>
		</tr>
		<%@ include file="fy1_top.jsp"%>
		<%
			fyUtil pu = new fyUtil();
			try {
				rowTotal = cb.hangshu(q_bj, q_ksbh);

				pageTotal = pu.getPageTotal(rowTotal);//得到总页数

				int rowIndex = pu.getRowIndex(currentPage);//得到游标
				List l4 = cb.cjb(q_bj, q_ksbh, rowIndex, pu.getPageSize());
				for (int k = 0; k < l4.size(); k++) {
					CjbObj co = (CjbObj) l4.get(k);

					String xh = co.getXh();
					String xm = co.getXm();
					String bj = co.getBj();
					String stmc = co.getStmc();
					int fs = co.getFs();
		%>
		<tr>
			<td class="active"><%=i++%></td>
			<td class="success"><%=xh%></td>
			<td class="warning"><%=xm%></td>
			<td class="danger"><%=bj%></td>
			<td class="info"><%=stmc%></td>
			<td class="danger"><%=fs%></td>
		</tr>

		<%
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
		<tr>
			<td colspan="6" class="success">
				<%
					String page_location = "cj.jsp";
				%> <%@ include file="fy1_bottom.jsp"%>
			</td>

		</tr>
	</table>
</body>
</html>
<script type="text/javascript">
	function jy() {
		var zy = <%=pageTotal%>
	var ty = 0;
		ty = document.f1.n1.value;
		if (ty == "") {
			alert("跳转页不能为空!");
		} else {
			if (ty == 0) {
				alert("跳转页不能为!");
			} else {
				if (yanzheng(ty) == true) {
					alert("非法字符!");
				} else {
					if (ty > zy) {
						alert("跳转页大于总页数!");
					} else {
						document.f1.submit();
					}
				}
			}
		}

	}
	function yanzheng(para) {
		var flag = false;
		var stand = "0123456789";
		var para_length = 0;
		para_length = para.length;
		for (var i = 0; i < para_length; i++) {
			var para_char = para.substring(i, i + 1);
			if (stand.indexOf(para_char) == -1) {
				flag = true;
				break;
			}
		}
		return flag;
	}
</script>