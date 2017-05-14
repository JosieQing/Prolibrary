<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../inc/theme.jsp" %>

<html>
<style>
td{
            font-family: "华文隶书";
            font-style: normal;
            
        }
</style>

<body>
<form name="f1" action="exam_user_add_action.jsp">
<div>
<table border="1" style="background:#E0FFFF" align="center">
<tr>
<td>考试名</td>
<td><input type="text" name="kaoshiming"></td>
</tr>
<tr>
<td>备注</td>
<td><input type="text" name="beizhu"></td>
</tr>
<tr>
<td>卷子名</td>
<td>
<select name="paper_id">
<!-- 这块应该是动态添加  获取试卷的id 多个id多个选项 -->
<%

ResultSet rs = null;
Statement stat = null;

ResultSet rss = null;
Statement statt = null;
//for(int i=0;i<9;i++){
	try{
		String sql="select e.paper_id,j.name from paper j,exam_management e where e.paper_id=j.id order by e.id asc";
		System.out.println("sql--:"+sql);
		stat = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rs = stat.executeQuery(sql);
	
while(rs.next()){
	//out.print("jexam_id");
	//out.print("test_parer_name");
	int i=0;
	int id=rs.getInt("paper_id");
	String name=rs.getString("name");
	i++;
%>
  <option value="<%=id%>" ><%=name%></option>
 
<%

}

%>
 
</select>
</td>
</tr>
<tr>
<td>班级</td>
<td>
<select  name="banji">
<!-- 这块应该是动态添加  获取试卷的id 多个id多个选项 -->
<%
      String sqll="select s.cname ,s.cno from class_sys s ,exam_management e where e.exam_class=s.cno order by e.id asc";
//String sqll="select class1 from student s ,exam_management e where e.exam_class=s.num";
		System.out.println("sql--:"+sqll);
		statt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rss = stat.executeQuery(sqll);
	
while(rss.next()){
//	out.print("jexam_id");
//	out.print("test_parer_name");
int i=0;
	int id=rss.getInt("cno");
	String name=rss.getString("cname");
	i++;
%>
  <option value="<%=id%>"><%=name%></option>
<%

}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			
			if(stat!=null){
				stat.close();
			}
			
			if(rs!=null){
				rs.close();
			}
			
			if(rss!=null){
				rss.close();
			}
		
			if(statt!=null){
				statt.close();
			}
			if(conn!=null){
				conn.close();
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		
	}
%>

   
</select>
 <!--
<input type="text" name="banji">
-->
</td>
</tr>
<tr>
<td>总分</td>
<td><input type="text" name="zongfen"></td>
</tr>
<tr>
<td>总时间</td>
<td><input type="text" name="zongshijian"></td>
</tr>
<tr>
<td>开始时间</td>
<td>
<input type="text" name="kaishishijian" readonly class="form-control"  onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd'})" ></td>
</tr>

<tr>
<td><input class="btn btn-success radius"  type="button" value="提交" onclick="document.f1.submit();"/></td>
<td><input class="btn btn-success radius" type="button" value="返回" onclick="location='exam_main.jsp'"/></td>
<td> <a href="../paper/select/list.jsp" >重新组卷！</a></td>
</tr>
</table>

 <!--  <input name="fa" id="fa" type="submit" value="确认分发试卷">--> 
</div>
</form>

</body>
</html>