<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../inc/theme.jsp" %>
<%
String id = "1";
//String id = (String)session.getAttribute("user_id");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>测试</title>
</head>
<body>
<input type="hidden" id="user_id" value=<%=id %>>
<script>
$(document).ready(function(){
		 $.ajax({
			    url:'../../UserInfoActionServlet',
			    type:'POST', 
			    async:true,    
			    data:{
			    	user_id:$("#user_id").val(),
			    },
			    timeout:5000,
			    dataType:'json',  
			    success:function(data,textStatus,jqXHR){
				    if(data.result=="1"){
				    	
				    	location="studentinfo.jsp"
				    }
				    if(data.result=="2"){
				   
				    	location="teacherinfo.jsp";
				    }
			        
			    },
			    error:function(xhr,textStatus){
			    alert('错误');
			   
			    }
			})
});
</script>
</body>
</html>