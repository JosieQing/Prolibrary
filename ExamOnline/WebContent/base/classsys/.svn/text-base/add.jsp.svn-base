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
<table border="2" class="table-hover table-borderd" style="width:500px" class="table table-striped">
<tr style="height:50px">
<td>
班级名称
</td>
<td>
<input type="text" id="cname" style="width:400px"/>
</td>
</tr>
<tr style="height:50px">
<td>
专业方向
</td>
<td>
<input type="text" id="speciality" style="width:400px"/>
</td>
</tr>
<tr style="height:50px">
<td>
教室
</td>
<td>
<input type="text" id="classnum" style="width:400px"/>
</td>
</tr>
<tr style="height:50px">
<td>
人数
</td>
<td>
<input type="text" id="pnum" style="width:400px" style="width:450px"/>
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
<td>
教学老师
</td>
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
<input type="button" value="提交" id="add" class="btn btn-success"/>		
</body>		
<!--  <script src="../../js/jquery-3.2.0.min.js" type="text/javascript"></script>-->
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
			