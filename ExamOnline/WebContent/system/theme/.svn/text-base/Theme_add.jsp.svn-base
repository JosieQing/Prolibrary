<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../inc/theme.jsp"%>
<html>
<head>

<title>库中无该ID需向库中添加新数据！！</title>
</head>
<body>
<%String uid=(String)session.getAttribute("iid");

String rname=(String)session.getAttribute("irname");

if(uid==null)
{
	uid="";}
if(rname==null)
{
	rname="";}
Statement stat = null;
ResultSet rs = null;

try{
	String sql="insert into theme (userid,theme,realname) values('"+ uid  + "','','"+ rname+"')";                         
/* 此处的id为session传过来的值 */
	
	
	stat = conn.createStatement();
	stat.executeUpdate(sql);
	
		
		
	
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
response.sendRedirect("Theme.jsp");

%>

</body>
</html>