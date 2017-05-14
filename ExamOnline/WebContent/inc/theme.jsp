<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="head.jsp"%>
<%@ include file="db.jsp"%>
<%@ include file="session.jsp"%>
<!-- 用于每个页面的背景颜色设定,放于include中  -->
<%
String userid=null;

userid=(String)session.getAttribute("iid");  /* 假设点击入此页面时用的是session传值所传递的ID值(暂时不用) */
if(userid==null){
	userid="";//目前无session值传入，自定义一个值；
}
//out.println(userid);



//链接数据库，根据用户名取得数据


Statement stat1 = null;
ResultSet rs1 = null;
String theme=null;
String name1=null;
String id1=null;
try{
	String sql="select * from theme where userid ='"+ userid +"'";/* 此处的id为session传过来的值 */
	stat1 = conn.createStatement();
	rs1 = stat1.executeQuery(sql);
	if(rs1.next()){
		if(rs1.getString("theme")==null||"".equals(rs1.getString("theme")))
		{
			theme="gray"; //标记以后更改（默认的页面颜色）
			name1=rs1.getString("realname");
			id1=rs1.getString("userid");
		}
		else{
			theme=rs1.getString("theme");
			name1=rs1.getString("realname");
			id1=rs1.getString("userid");
		}
	}
	else
	{
		theme="protect_eye";//（ 数据库中无记录时）默认的颜色
	}

	
}catch(Exception e){
	e.printStackTrace();
}finally{
	try{
		if(rs1!=null){
			rs1.close();
		}
		if(stat1!=null){
			stat1.close();
		}
		
		//conn你们记得关。 
	}catch(SQLException sqle){
		sqle.printStackTrace();
	}
	
}
	//从数据库得到"主题颜色"信息~
	if("blue".equals(theme)||"green".equals(theme)||"purple".equals(theme)||
			"white".equals(theme)||"yellow".equals(theme)||"pink".equals(theme)||"green2".equals(theme)||"protect_eye".equals(theme)||"gray".equals(theme))
	{
		%>
<LINK rel="stylesheet" href="<%=basePath %>css/theme/<%=theme%>/<%=theme%>.css" type="text/css"/>
<%
}
%>

