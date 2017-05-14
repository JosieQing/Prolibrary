<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%@ page import="com.neuedu.examonline.util.*" %>
<%@ include file="../../inc/theme.jsp" %>

<%
//----------获取from表单里的值----------------
String exam_name=null;//考试名
exam_name=request.getParameter("kaoshiming");//
if(exam_name==null){
	exam_name="";
}else{
	exam_name=StringUtil.iSOToUtf8(exam_name);
}

String remark=null;//备注
remark=request.getParameter("beizhu");//
if(remark==null){
	remark="";
}else{
	remark=StringUtil.iSOToUtf8(remark);
}

String paper_name=null;//卷子名
paper_name=request.getParameter("juanziming");//
if(paper_name==null){
	paper_name="";
//	out.print("test_paper_name");
}else{
	paper_name=StringUtil.iSOToUtf8(paper_name);
}

String exam_class=null;//班级
exam_class=request.getParameter("banji");//
if(exam_class==null){
	exam_class="";
}
String total_points=null;//总分
total_points=request.getParameter("zongfen");//
if(total_points==null){
	total_points="";
}


String total_time=null;//总时间
total_time=request.getParameter("zongshijian");//
if(total_time==null){
	total_time="";
}
String start_time=null;//开始时间
start_time=request.getParameter("kaishishijian");//
if(start_time==null){
	start_time="";
}

String paper_id=null;//id
paper_id=request.getParameter("paper_id");//
if(paper_id==null){
	paper_id="";
}

String current_user_id=null;
current_user_id=(String)session.getAttribute("uId");

//----------链接数据库----------------
Statement stat = null;
try{
	//拼写入库的sql语句
	String sql="insert into exam_management(ID,exam_name,remark,paper_name,paper_id,"+
				"exam_class,total_points,total_time,status,start_time)"+
				" values(EXAM_SEQ.nextval,'"+exam_name+"','"+remark+"','"+paper_name+"','"+paper_id+"','"+
						exam_class+"',"+total_points+","+total_time+",1,to_date('"+start_time+"','yyyy-MM-dd hh:mi:ss'))";
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
