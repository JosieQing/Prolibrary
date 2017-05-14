<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../inc/theme.jsp"%>
<!-- 此页面用于点击修改主题 -->
<html>
<head>

<script type="text/javascript">
var color="";
function border_blue(){
	
	$("#blue").css("border","2px solid black");
	
	$("#purple").css("border","0");
	$("#green").css("border","0");
	$("#white").css("border","0");
	$("#yellow").css("border","0"); 
	$("#pink").css("border","0");
	$("#green2").css("border","0");
	$("#protect_eye").css("border","0");
	$("#gray").css("border","0");
	color="blue";
}
function border_purple(){
	
	$("#purple").css("border","2px solid black");
	
	$("#blue").css("border","0");
	$("#green").css("border","0");
	$("#white").css("border","0");
	$("#yellow").css("border","0");
	$("#pink").css("border","0");
	$("#green2").css("border","0");
	$("#protect_eye").css("border","0");
	$("#gray").css("border","0");
	color="purple";
}
function border_green(){
	
	$("#green").css("border","2px solid black");
	
	$("#purple").css("border","0");
	$("#blue").css("border","0");
	$("#white").css("border","0");
	$("#yellow").css("border","0");
	$("#pink").css("border","0");
	$("#green2").css("border","0");
	$("#protect_eye").css("border","0");
	$("#gray").css("border","0");
	color="green";
}
function border_white(){
	
	$("#white").css("border","2px solid black");
	
	$("#purple").css("border","0");
	$("#green").css("border","0");
	$("#blue").css("border","0");
	$("#yellow").css("border","0");
	$("#pink").css("border","0");
	$("#green2").css("border","0");
	$("#protect_eye").css("border","0");
	$("#gray").css("border","0");
	color="white";
}
function border_yellow(){
	
	$("#yellow").css("border","2px solid black");
	
	$("#purple").css("border","0");
	$("#green").css("border","0");
	$("#white").css("border","0");
	$("#blue").css("border","0");
	$("#pink").css("border","0");
	$("#green2").css("border","0");
	$("#protect_eye").css("border","0");
	$("#gray").css("border","0");
	color="yellow";
}
function border_pink(){
	
	$("#pink").css("border","2px solid black");
	
	$("#purple").css("border","0");
	$("#green").css("border","0");
	$("#white").css("border","0");
	$("#blue").css("border","0");
	$("#yellow").css("border","0");
	$("#green2").css("border","0");
	$("#protect_eye").css("border","0");
	$("#gray").css("border","0");
	color="pink";
}
function border_green2(){
	
	$("#green2").css("border","2px solid black");
	
	$("#purple").css("border","0");
	$("#green").css("border","0");
	$("#white").css("border","0");
	$("#blue").css("border","0");
	$("#yellow").css("border","0");
	$("#pink").css("border","0");
	$("#protect_eye").css("border","0");
	$("#gray").css("border","0");
	color="green2";
}
function border_protect_eye(){
	
	$("#protect_eye").css("border","2px solid black");
	
	$("#purple").css("border","0");
	$("#green").css("border","0");
	$("#white").css("border","0");
	$("#blue").css("border","0");
	$("#yellow").css("border","0");
	$("#pink").css("border","0");
	$("#green2").css("border","0");
	$("#gray").css("border","0");
	color="protect_eye";
}
function border_gray(){
	
	$("#gray").css("border","2px solid black");
	
	$("#purple").css("border","0");
	$("#green").css("border","0");
	$("#white").css("border","0");
	$("#blue").css("border","0");
	$("#yellow").css("border","0");
	$("#pink").css("border","0");
	$("#green2").css("border","0");
	$("#protect_eye").css("border","0");
	color="gray";
}

function submit1(){
	document.yes.cl.value=color;
	document.yes.submit();
}
</script>


<%
String userid1=null;

userid1=(String)session.getAttribute("iid"); /* 假设点击入此页面时用的是session传值(暂时不用) */
if(userid1==null){
	userid1="9527";//目前无session值传入，自定义一个值；
}
//out.println(userid);



//链接数据库，根据用户名取得数据
//boolean flag=false;没用

Statement stat = null;
ResultSet rs = null;
String theme1=null;
String name=null;
String cl1=null;
String id=null;
try{
	String sql="select * from theme where userid ='"+ userid1 +"'";/* 此处的id为session传过来的值 */
	stat = conn.createStatement();
	rs = stat.executeQuery(sql);
	if(rs.next()){
		if(rs.getString("theme")==null||"".equals(rs.getString("theme")))
		{
			theme1="white";
		
			name=rs.getString("realname");
			id=rs.getString("userid");
		}
		else{
		theme1=rs.getString("theme");
		
	
		name=rs.getString("realname");
		id=rs.getString("userid");
		//flag=true;}
	}}
	else{
		
		response.sendRedirect("Theme_add.jsp");
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
//从数据库得到"主题颜色"信息~
	if("blue".equals(theme1)||"green".equals(theme1)||"purple".equals(theme1)||
			"white".equals(theme1)||"yellow".equals(theme1)||"pink".equals(theme1)||"green2".equals(theme1)||"protect_eye".equals(theme1)||"gray".equals(theme1))
	{
		%>
<LINK rel="stylesheet" href="../../css/theme/<%=theme1%>/<%=theme1%>.css" type="text/css"/>
<%
}
%>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 

<body >
<div >
<font size="5" >当前>><strong>主題管理</strong> &nbsp;&nbsp;&nbsp;&nbsp;当前用戶>><strong><%= name %></strong>&nbsp;&nbsp;&nbsp;&nbsp;当前主題>><strong><%= theme1 %></strong>
</font></div>
<hr width="100%" style="margin-top:3px;border:1px solid black;"/>


<img class="img-thumbnail" id="blue" src="pic/blue.gif" style="width:100px;height:100px"  onclick="border_blue()" >



<img class="img-thumbnail" id="purple"  src="pic/purple.gif" style="width:100px;height:100px" onclick="border_purple()">
<img class="img-thumbnail" id="green"  src="pic/green.jpg" style="width:100px;height:100px" onclick="border_green()">
<br>

<img class="img-thumbnail"  id="white"  src="pic/white.bmp" style="width:100px;height:100px" onclick="border_white()">
<img class="img-thumbnail"  id="yellow"  src="pic/yellow.bmp" style="width:100px;height:100px" onclick="border_yellow()">
<img class="img-thumbnail"  id="pink"  src="pic/pink.png" style="width:100px;height:100px"  onclick="border_pink()">

<br>
<img class="img-thumbnail"  id="green2"  src="pic/green2.gif" style="width:100px;height:100px" onclick="border_green2()">
<img class="img-thumbnail"  id="protect_eye"  src="pic/protect_eye.bmp" style="width:100px;height:100px" onclick="border_protect_eye()">
<img class="img-thumbnail"  id="gray"  src="pic/gray.gif" style="width:100px;height:100px" onclick="border_gray()">

<br>

<button type="button" class="btn btn-warning" id="ok" name="ok" onclick="submit1()">应用</button>


<form name="yes" action="Theme_Action.jsp">
<input type="hidden" name="cl">
<input type="hidden" name="id" value="<%=id %>">
</form>


</body>


</html>
