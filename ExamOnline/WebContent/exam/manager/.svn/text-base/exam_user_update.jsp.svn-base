<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../inc/theme.jsp" %>
<html>
<body>
<%
String id=null;
id = request.getParameter("id");
if(id==null){
	id="0";
}

String u_exam_name=null;
String u_remark=null;
String u_paper_name=null;
String u_exam_class=null;

ResultSet rs = null;
Statement stat = null;
try{
	String sql="select * from exam_management where id="+id;
	System.out.println("sql2--:"+sql);
	stat = conn.createStatement();
	rs = stat.executeQuery(sql);
	if(rs.next()){
		u_exam_name=rs.getString("exam_name");
		u_remark=rs.getString("remark");
		u_paper_name=rs.getString("paper_name");
		u_exam_class=rs.getString("exam_class");	
	}
}catch(Exception e){
e.printStackTrace();
}finally{
	try{
		if(rs!=null){
			rs.close();
		}
		if(stat!=null){
			stat.close();
		}
		if(conn!=null){
			conn.close();
		}
	}catch(SQLException sqle){
		sqle.printStackTrace();
	}
}
%>
<form name="f1" action="exam_user_update_action.jsp">
<input type="hidden" name="id" value="<%=id%>">
<table border="1">
<tr>
<td>考试名</td>
<td><input type="text" name=exam_name value="<%=u_exam_name%>"></td>
</tr>
<tr>
<td>备注</td>
<td><input type="text" name="remark" value="<%=u_remark%>"></td>
</tr>
<tr>
<td>卷子名</td>
<td><input type="text" name="paper_name" value="<%=u_paper_name%>"></td>
</tr>
<tr>
<td>班级</td>
<td><input type="text" name="exam_class" value="<%=u_exam_class%>"></td>
</tr>
<tr>
<td><input type="button" class="btn btn-block btn-default" value="提交" onclick="document.f1.submit();"/></td>
<td><input type="button" value="返回" onclick="location='exam_main.jsp'"/></td>
</tr>
</table>
</form>

</body>
</html>