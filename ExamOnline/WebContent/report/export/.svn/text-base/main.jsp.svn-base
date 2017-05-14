<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="" %>

<%@ page import="java.sql.*" %>



<html>

<head>

  <title>成绩查询及导出</title>

</head>

<style>

#font_style{
font-family:"Microsoft YaHei";
}
hr{
border:1px #cccccc dashed;
}
table{
border:1px #cccccc solid;
}
tr{
border:1px #cccccc solid;
}
td{
border:1px #cccccc solid;
} 

</style>

<body height="100%">

<br/>
<h2 align="center"><font color="#444444" id="font_style">成绩查询及列表导出</font></h2>
<div align="center">


<input type="button">
<input id="excel1" type="button" value="查询">
<input id="excel" type="button" value="导出">

</div>
<hr size="1" width="80%"/>

<%


Class.forName("oracle.jdbc.driver.OracleDriver");

Connection conn1=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");

Statement stat=conn1.createStatement();

ResultSet rs=stat.executeQuery
("select * from emp e, dept d where e.deptno=d.deptno order by e.sal desc");

%>

<table width="50%" border="1" align="center" cellspacing="0">

	<tr align="center">
	<td>序号</td>
	<td>姓名</td>
	<td>成绩</td>
	<td>排名</td>
	</tr>
	
	<% 
	int i=0;
	while(rs.next()){ 
	i++;
	%>

    <tr align="center">

		<td><%=i %></td>

		<td><%=rs.getString("ename")%></td>

		<td><%=rs.getString("sal")%></td>
		
		<td><%=rs.getString("empno")%></td>

    </tr>

    <% } %>

<table>

</body>

</html>



