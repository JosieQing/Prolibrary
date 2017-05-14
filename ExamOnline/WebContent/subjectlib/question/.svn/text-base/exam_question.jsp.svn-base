<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="com.neuedu.examonline.util.*" %>
<%@ page import="com.neuedu.examonline.subjectlib.question.*" %>
<%@ include file="../../inc/theme.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<%String types_id = null;
  String course_id = null; 
  types_id =StringUtil.iSOToUtf8(request.getParameter("s2"));
  if(!types_id.equals("")){
  session.setAttribute("types_id", types_id);
  }
  course_id = StringUtil.iSOToUtf8(request.getParameter("s1"));
  if(!course_id.equals("")){

  session.setAttribute("course_id", course_id);
  }
  System.out.println("types_id"+types_id+";");
  System.out.println("course_id"+course_id+";");
  if(types_id.equals("")){
	  types_id=(String)session.getAttribute("types_id");
	  if(types_id==null){
		  types_id="";
	  }
	  }
  if(course_id.equals("")){
	  course_id=(String)session.getAttribute("course_id");
	  if(course_id==null){
		  course_id="";
	  }
	  }
%>
<form action="exam_question.jsp" method="post">
<table border="1" class="table table-striped table-bordered table-condensed">
<tr><td colspan="4" >当前>>试题管理&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
请选择要查询的科目:
<select name="s1">
<option value="不选">显示全部</option>
<%
QuestionBean qb = new QuestionBean();
List <CourseObj>li1 = new ArrayList<CourseObj>();
li1 = qb.getAllCourse();
Iterator<CourseObj> it1 = li1.iterator();
while(it1.hasNext()){
	CourseObj co = it1.next();
	String couse = co.getCouse();
	int c_id = co.getId();
	
%>
<option value="<%=c_id%>"><%=couse%></option>
<%       
}
%>
 </select>

 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请选择要查询的题型:
 <select name="s2">
 <option value="不选">显示全部</option>
<%
List <TypesObj>li2 = new ArrayList<TypesObj>();
li2 = qb.getAllType();
Iterator<TypesObj> it2 = li2.iterator();
while(it2.hasNext()){
	TypesObj to = it2.next();
	String types_name = to.getTypes_name();
	int t_id = to.getTypes_id();
%>
<option value="<%=t_id%>"><%=types_name%></option>
<%       
}
%>
 </select>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <button type="submit" class="btn btn-success" id="btn1" >查询</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <button type="button" class="btn btn-warning"  id="btn2" onclick="location='quesion_add.jsp'">添加</button>
 </td>
 </tr>
<tr><td width="100" >序号</td><td width="650" >题干</td><td width="351">选项</td><td align="center">操作</td></tr>
<%@ include file="page_top.jsp" %>
<%
PageUtil pu = new PageUtil();

	rowTotal=qb.getCount(types_id, course_id);
	pageTotal= pu.getPageTotal(rowTotal);
	int rowIndex = pu.getRowIndex(currentPage);
	
int i = 0;
List<QuestionObj>li3 = new ArrayList<QuestionObj>();
li3 = qb.getList(course_id, types_id,rowIndex,pu.getPageSize());
Iterator<QuestionObj>it3 = li3.iterator();
while(it3.hasNext()){
	QuestionObj qo = it3.next();
	int q_id = qo.getId();
	String questiontext = qo.getQuestiontext();
	String xuanxiang  = "A:"+qo.getA()+" "+"B:"+qo.getB()+" "+"C:"+qo.getC()+" "+"D:"+qo.getD()+" "+"E:"+qo.getE();
	if(qo.getA()==null){
		xuanxiang="无";
	}
	i++;
	%>
	<tr>
	<td ><%=i %></td><td ><%=questiontext %></td><td ><%=xuanxiang %></td><td align="center"><a href="question_update.jsp?id=<%=q_id%>">修改</a> &nbsp;&nbsp;&nbsp;<a href="question_delete_action.jsp?q_id=<%=q_id%>">删除</a></td>
	</tr>
	
	<%
}

%>
<tr><td colspan="4" align="center">
共<%=pageTotal%>页&nbsp;&nbsp;当前是第<%=currentPage%>页&nbsp;&nbsp;

<%
if(currentPage==1){
%>
首页&nbsp;&nbsp;上一页&nbsp;&nbsp;
<%
}else{
%>
<a href="exam_question.jsp?curp=1">首页</a>&nbsp;&nbsp;
<a href="exam_question.jsp?curp=<%=currentPage-1%>">上一页</a>&nbsp;&nbsp;
<%
}
%>

<%
if(currentPage==pageTotal){
%>
下一页&nbsp;&nbsp;最后一页
<%
}else{
%>
<a href="exam_question.jsp?curp=<%=currentPage+1%>">下一页</a>&nbsp;&nbsp;
<a href="exam_question.jsp?curp=<%=pageTotal%>">最后一页</a>
<%
}


%>
 </td> </tr>
</table> 
 </form> 
</body>
</html>
 
 