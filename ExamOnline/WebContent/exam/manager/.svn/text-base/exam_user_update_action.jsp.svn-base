<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="com.neuedu.examonline.util.*" %>
<%@ include file="../../inc/theme.jsp" %>
<%
//----------获取from表单里的值----------------
String id=null;
id = request.getParameter("id");
if(id==null){
	id="0";
}

String exam_name=null;//考试名
exam_name=request.getParameter("exam_name");//
if(exam_name==null){
	exam_name="";
}else{
	exam_name=StringUtil.iSOToUtf8(exam_name);
}

String remark=null;//备注
remark=request.getParameter("remark");//
if(remark==null){
	remark="";
}else{
	remark=StringUtil.iSOToUtf8(remark);
}

String paper_name=null;//卷子名
paper_name=request.getParameter("paper_name");//
if(paper_name==null){
	paper_name="";
	
}else{
	paper_name=StringUtil.iSOToUtf8(paper_name);
}

String exam_class=null;//班级
exam_class=request.getParameter("exam_class");
if(exam_class==null){
	exam_class="";
}

String current_user_id=null;
current_user_id=(String)session.getAttribute("uId");

//----------链接数据库----------------
Statement stat = null;
try{
	//拼写update的sql语句
	String sql="update exam_management set exam_name='"
	+exam_name+"',remark='"+remark+"',paper_name='"+paper_name
	+"',exam_class='"+exam_class+"'"+" where id="+id;
	
	System.out.println("sql--:"+sql);
	stat = conn.createStatement();
	stat.executeUpdate(sql);
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
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

response.sendRedirect("exam_main.jsp");
%>
