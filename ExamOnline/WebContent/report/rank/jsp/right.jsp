<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.neuedu.examonline.util.*"%>
<%@ include file="../../../inc/db.jsp" %>
<%@ include file="../../../inc/head.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>成绩排名</title>
    <link rel="stylesheet" href="../CSS/right.css"/>
</head>
<body>
<%
//姓名
	String inquire_name = null;
	inquire_name = request.getParameter("inquire_name");
	if(inquire_name == null){
		inquire_name ="";
	}else{
		inquire_name=StringUtil.iSOToUtf8(inquire_name);
	}
//班级
	String inquire_classes = null;
	inquire_classes = request.getParameter("inquire_classes");
	if(inquire_classes == null){
		inquire_classes ="";
	}else{
		inquire_classes=StringUtil.iSOToUtf8(inquire_classes);
	}
//卷名
	String inquire_volume = null;
	inquire_volume = request.getParameter("inquire_volume");
	if(inquire_volume == null){
		inquire_volume ="";
	}else{
		inquire_volume=StringUtil.iSOToUtf8(inquire_volume);
	}
%>
<!-- 查询开始  -->
<div class="right-top">
    <form action="right.jsp" id="from1" class="form-content">
        <span>姓名：</span><input type="text" id="name" name="inquire_name" class="form-content-input1" value="<%=inquire_name%>"/>
        <span>班级：</span><input type="text" id="classes" name="inquire_classes" class="form-content-input1" value="<%=inquire_classes%>"/>
        <span>卷名：</span><input type="text" id="volume" name="inquire_volume" class="form-content-input1" value="<%=inquire_volume%>"/>
 <br>
       <input type="submit" value="查询" class="btn btn-success form-content-input2"/>
    </form>
</div>
<!-- 查询结束 -->
<!-- 列表开始 -->
<div class="right-content">
    <table border="1" class="table-hover right-content-table">
        <tr class="right-content-table-tr">
            <td class="right-content-table-tdv-xh">序号</td>
            <td class="right-content-table-td">姓名</td>
            <td class="right-content-table-td">班级</td>
            <td class="right-content-table-td">卷名</td>
            <td class="right-content-table-td">排名</td>
            <td class="right-content-table-td">成绩</td>
        </tr>
<!-- 列表结束 -->
<%

int i = 0;
ResultSet rs = null;
Statement stat = null;
String sql = null;
String sqlpm = null;
String sql1 = null;
String sqlzg = null;


try{
	//sql = "select * from performance where 1 = 1"   ;
	sql=  "SELECT DISTINCT S.NUM ,S.NAME,S.cname,E.EXAM_NAME,FS + (SELECT SUM(SCORE)FROM ZGCJ Z WHERE S.NUM = Z.STUID AND Z.EXAM_ID = E.ID) FS FROM EXAM_MANAGEMENT E, KGCJ K, ZGCJ Z, STUDENT S WHERE S.NUM = Z.STUID AND S.cname = E.EXAM_CLASS AND S.NAME = K.XM";
	//sqlpm = "SELECT p.*, dense_rank() OVER(ORDER BY fs ) class_ranking FROM ("+sql+")p ";

	if(!"".equals(inquire_name)){//姓名查询
		sql = sql + " and s.name like '%"+inquire_name+"%'";
	}
	if(!"".equals(inquire_classes)){//班级查询
		sql = sql + " and s.cname like '%"+inquire_classes+"%'";
	}
	if(!"".equals(inquire_volume)){//卷名
		sql = sql + " and e.exam_name like  '%"+inquire_volume+"%'";
	}
	sqlpm = "SELECT p.*, dense_rank() OVER(ORDER BY fs desc ) class_ranking FROM ("+sql+")p ";
	
	System.out.println("sql--:"+sql);
	System.out.println("sqlpm--:"+sqlpm);
	stat = conn.createStatement();
	//rs = stat.executeQuery(sqlzg);
	//rs = stat.executeQuery(sql);
	rs = stat.executeQuery(sqlpm);
	
//------------------------------------------------------------------------------
	while(rs.next()){
		
		String NUM = rs.getString("NUM");
		String name = rs.getString("name");
		String fs = rs.getString("fs");
		String cname = rs.getString("cname");
		String exam_name = rs.getString("exam_name");
		String class_ranking = rs.getString("class_ranking");//排名
%>

        <tr class="right-content-table-tr1">
            <td><%= (i+1) %></td><!-- 编号 -->
            <td><%= name%></td><!-- 姓名 -->
            <td><%= cname%></td><!-- 班级 -->
            <td><%=exam_name%></td><!-- 卷名 -->
            <td><%= class_ranking%></td> 
            <td><%= fs%></td><!-- 成绩 -->
        </tr>
<%
i++;
	}
}
catch(Exception e){
	e.printStackTrace();
}
finally{
	try{
		if(rs!=null){
			rs.close();
		}
		if(stat!=null){
			stat.close();
		}
		if(conn!=null){
			stat.close();
		}
		
	}catch(SQLException sqle){
		sqle.printStackTrace();
	}
}
%>
    </table>
</div>

</body>
</html>