<!DOCTYPE html>
<%@ include file="../../inc/head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.neuedu.examonline.exam.impersonality.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.neuedu.examonline.util.*"%>
<html>
<head>

<link rel="stylesheet" href="css/ys.css">
</head>
<body id="b2">

<p id="p2">考试汇<span id="s2">总</span></p>
	<form action="ks.jsp">

		<%
			String q_ksm = null;
			q_ksm = request.getParameter("q_ksm");
			if (q_ksm == null) {
				q_ksm = "";
			} else {
				q_ksm = StringUtil.iSOToUtf8(q_ksm);
			}

			String q_ksbh = null;
			q_ksbh = request.getParameter("q_ksbh");
			if (q_ksbh == null) {
				q_ksbh = "";
			} else {
				q_ksbh = StringUtil.iSOToUtf8(q_ksbh);
			}
			String q_jzbh = null;
			q_jzbh = request.getParameter("q_jzbh");
			if (q_jzbh == null) {
				q_jzbh = "";
			} else {
				q_jzbh = StringUtil.iSOToUtf8(q_jzbh);
			}
		%>
		
		<div>
			考试名称:<input class="i2" type="text" name="q_ksm" value="<%=q_ksm%>">
		</div>
		<div>
			考试编号:<input class="i2" type="text" name="q_ksbh" value="<%=q_ksbh%>">
			
			<input id="d2" class="btn" type="submit" value="查询">
		     
		</div>
		<div>
			卷子编号:<input class="i2" type="text" name="q_jzbh" value="<%=q_jzbh%>">
		</div>
		


	</form>
	<table  class="table table-condensed">

		<tr class="active">
			<td>序号</td>
			<td>考试名</td>
			<td>考试编号</td>
			<td>卷子编号</td>
			<td>开始时间</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		<%@ include file="fy1_top.jsp"%>
		<%
			fyUtil pu1 = new fyUtil();
			int i = 1;
			KsBean kb = new KsBean();
			try {
				rowTotal = kb.hangshu(q_ksm, q_ksbh, q_jzbh);

				pageTotal = pu1.getPageTotal(rowTotal);//得到总页数

				int rowIndex = pu1.getRowIndex(currentPage);//得到游标
				List l2 = kb.ksm(q_ksm, q_ksbh, q_jzbh, rowIndex,
						pu1.getPageSize());
				for (int k = 0; k < l2.size(); k++) {
					KsObj ko = (KsObj) l2.get(k);

					String ksbh = ko.getId();
					String a2 = ko.getExam_namc();
					String a3 = ko.getStart_time();
					String a4 = ko.getPaper_id();
					String a5 = ko.getStatus();
		%>
		<tr>
			<td class="danger"><%=i++%></td>
			<td class="success" width="20%"><%=a2%></td>
			<td class="warning"><%=ksbh%></td>
			<td class="danger"><%=a4%></td>
			<td class="info"><%=a3%></td>
			<td class="success"><%=a5%></td>
			<td class="danger"><a id="a1" href="cj_yz.jsp?k1=<%=ksbh%>&k2=<%=a5%>"
				target="bFrame">判卷</a></td>
		</tr>
		<%
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		%>
		<tr class="warning" colspan="6">
			<td colspan="7" class="info">
				<%
					String page_location = "ks.jsp";
				%> 
				<%@ include file="fy1_bottom.jsp"%>
			</td>

		</tr>
	</table>
</body>
</html>
<script type="text/javascript">
	function jy() {
		var zy =
<%=pageTotal%>
	var ty = 0;
		ty = document.f1.n1.value;
		if (ty == "") {
			alert("跳转页不能为空!");
		} else {
			if (ty == 0) {
				alert("跳转页不能为0!");
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
