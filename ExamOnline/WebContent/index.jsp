<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="inc/head.jsp"%>
<%@ page import="com.neuedu.examonline.db.*"%>
<%@ page import="com.neuedu.examonline.util.*"%>
<%@ page import="java.sql.*"%>
<%@ include file="inc/db.jsp"%>
<html>
<body>
<form class="form-horizontal" action="login/frame.jsp" name="form">
  <select class="form-control" name="select">
  <%
  Statement stat = null;
	ResultSet rs = null;
	String role = null;
	String id = null;
	int i = 1;
	try {
		String sql = "select id,role from character";
		stat = conn.createStatement();
		rs = stat.executeQuery(sql);
		while (rs.next()) {
			role = rs.getString("role");
			id = rs.getString("id");
			%>
			  <option value="<%=id%>"><%=i+"."+role%></option>
			  
			<%
			session.setAttribute("id"+i, id);
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

</select>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">进入系统</button>
    </div>
  </div>
</form>
</body>
</html>