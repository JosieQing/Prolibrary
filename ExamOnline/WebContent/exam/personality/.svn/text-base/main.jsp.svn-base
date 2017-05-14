<%@page import="com.neuedu.examonline.exam.personality.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="com.neuedu.examonline.exam.personality.*"%>

<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="com.neuedu.examonline.util.*"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"
	name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../../bootstrap/bootstrap.min.css" rel="stylesheet">
<title>主观题判卷</title>
</head>
<body>
	<div class="container">
		<div class="table-responsive">

			<%
			   
				int rowTotal = 0;
				int pageTotal = 0;
				int currentPage = 1;
				String str_currentPage = "";
				str_currentPage = request.getParameter("curp");
				if (str_currentPage == null) {
					str_currentPage = "1";
				}
				currentPage = Integer.parseInt(str_currentPage);
				PageUtil123 pu = new PageUtil123();
				panjuanBean pb = new panjuanBean();
				//得到总行数
				rowTotal = pb.getCount();
				//得到总页数
				pageTotal = pu.getPageTotal(rowTotal);
				//得到当前游标
				int rowIndex = pu.getRowIndex(currentPage);
				//得到列表
				List rList = pb.getList(rowIndex, pu.getPageSize());
				for (int i = 0; i < rList.size(); i++) {
					panjuanObj po = (panjuanObj) rList.get(i);//
					String stu_name = po.getStu_name();
					String stu_id = po.getStu_id();
					String exam_id = po.getExam_id();
					String subject = po.getSubject();
					String zg_answer = po.getZg_answer();
					String stu_zg_answer = po.getStu_zg_answer();
					String score = po.getScore();
			%>
			<form class=" form-inline" method="post" action="submit">
				<input type="hidden" id="stu_id" name="stu_id" value="<%=stu_id%>">
				<input type="hidden" id="exam_id" name="exam_id"
					value="<%=exam_id%>"> <input type="hidden" id="curp"
					name="curp" value="<%=currentPage%>">
				<table class="table table-striped table-bordered table-hover"
					border="1">
					<tr>
						<td colspan="2"><p class="text-center">
								<font style="font-size: 30px;"><b>主观题判卷</b></font>
							</p></td>
					</tr>
					<tr >
						<td colspan="2">学生姓名：<%=stu_name%>&nbsp;&nbsp;&nbsp;&nbsp;学号：<%=stu_id%></td>
					</tr>
					<tr>
						<td class="col-md-2">题号：<%=exam_id%></td>
						<td>题目：<%=subject%></td>
					</tr>
					<tr>
						<td class="col-md-2">参考答案：</td>
						<td><%=zg_answer%></td>
					</tr>
					<tr>
						<td class="col-md-2">学生答案：</td>
						<td><%=stu_zg_answer%></td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="form-croup">
								成绩：<input class=" form-control" type="text" name="score"
									value="<%=score%>">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input
									class="btn btn-info" id="updateButton" type="submit" value="提交"
									onclick="submit()" />
						</td>
						</div>
					</tr>
					<%
						}
					%>
					<tr>
						<td colspan="2">
							<%
								String page_location = "main.jsp";
							%> 共<%=pageTotal%>页&nbsp;&nbsp;当前是第<%=currentPage%>页&nbsp;&nbsp; <%
 	if (currentPage == 1) {
 %> 首页&nbsp;&nbsp;上一页&nbsp;&nbsp; <%
 	} else {
 %> <a href="<%=page_location%>?curp=1">首页</a>&nbsp;&nbsp; <a
							href="<%=page_location%>?curp=<%=currentPage - 1%>">上一页</a>&nbsp;&nbsp;
							<%
								}
							%> <%
 	if (currentPage == pageTotal) {
 %> 下一页&nbsp;&nbsp;最后一页 <%
 	} else {
 %> <a href="<%=page_location%>?curp=<%=currentPage + 1%>">下一页</a>&nbsp;&nbsp;
							<a href="<%=page_location%>?curp=<%=pageTotal%>">最后一页</a> <%
 	}
 %>
						</td>
					</tr>
					<!-- 分页结束 -->
					</tbody>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
<script src="../../bootstrap/jquery.min.js"></script>
<script src="../../bootstrap/bootstrap.min.js"></script>
