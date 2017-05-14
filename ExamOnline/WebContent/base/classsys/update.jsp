
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>  
<%@ page import="com.neuedu.examonline.base.classsys.*"%>
<%@ include file="../../inc/theme.jsp" %>
 <style>
 body
{
background:#5bc0de;
}
 
 </style>
<body>
<%
List<Class_control> list = (List<Class_control>)session.getAttribute("clist");
String cno=request.getParameter("cno");
for(Class_control cc:list)
{
	if(cno.equals(cc.getCno()))
	{
%> 
<table border="2" class="table-hover table-borderd" style="width:500px" class="table table-striped">
<tr>
<td>
<input type="hidden" id="cno" value="<%=cc.getCno()%>" style="width:400px"/>
</td>
</tr>
<tr style="height:50px">
<td>
序号
</td>
<td>
<%=cc.getCno()%>
</td>
</tr>
<tr style="height:50px">
<td>
班级名称
</td>
<td>
<input id="cname" type="text" value="<%=cc.getCname()%>" style="width:400px"/>
</td>
</tr>
<tr style="height:50px">
<td>
专业方向
</td>
<td>
<input id="speciality" type="text" value="<%=cc.getSpeciality()%>" style="width:400px"/>
</td>
<tr style="height:50px">
<td>
教室
</td>
<td>
<input id="classnum" type="text" value="<%=cc.getClassnum()%>" style="width:400px"/>
</td>
</tr>
<tr style="height:50px">
<td>
人数
</td>
<td>
<input id="pnum" type="text" value="<%=cc.getPnum()%>" style="width:400px"/>
</td>
</tr>
<tr style="height:50px">
<td>
指导老师
</td>
<td>
<select id="mentor" style="width:400px">

<% 
option op=new option();
List<String> lists=op.sel();
for(String s:lists)
{
	
%>
<option value="<%=s %>"><%=s %></option>
<%
}
%>

</select>
</td>
</tr>
<tr style="height:50px">
<td>教学老师</tb>
<td>
<select id="teacher" style="width:400px">

<% 
for(String s:lists)
{
	
%>
<option value="<%=s %>"><%=s %></option>
<%
}
%>

</select>
</td>
</tr>
</table>
<br></br>
<input type="button" id="add" value="确定" class="btn btn-primary"/>


<%
}}
%>
</body>
<script src="../../js/jquery-3.2.0.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function()
		{
		       $("#add").click(function(){
				$.ajax
				(
					{
						url:"../../AddClass",
						type:"post",
						async:true,
						data:{
							cno:$("#cno").val(),
							cname:$("#cname").val(),
							speciality:$("#speciality").val(),
							classnum:$("#classnum").val(),
							pnum:$("#pnum").val(),
							mentor:$("#mentor").val(),
							teacher:$("#teacher").val(),
							start_date:$("#start_date").val()
						},
						timeout:5000,
						dataType:"text",	
						success:function(data,textStatus,jqXHR){
							
								location="class_sys.jsp";
						
						},
						error:function(xhr,textStatus){
							alert("错误");
						}			
					}				
		        )
		})
		})

</script>
