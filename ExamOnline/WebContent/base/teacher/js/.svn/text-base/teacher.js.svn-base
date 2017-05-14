$(document).ready(function(){
	
	
	
	//增加和修改
	$("#newinfo_btn").click(function(){
		
		var sex=$("input:radio[name='tsex']:checked").val();
		//alert("性别是"+sex);
		$.ajax
		(
			{
				url:"../../AddTeacherServlet",
				type:"post",
				async:true,
				data:{
					tno:$("#tno").val(),
					tname:$("#tname").val(),
					tsex:sex,
					tage:$("#tage").val(),  
					ttel:$("#ttel").val(),
					hiredate:$("#hiredate").val(),
					tremark:$("#tremark").val()
				},
				timeout:5000,
				dataType:"text",	
				success:function(data,textStatus,jqXHR){
					
						location="sys_teacher_all.jsp";
				
				},
				error:function(xhr,textStatus){
					alert("错误");
				}			
			}				
		)	
	})	

	//查询
	$("#sel_ter").click(function(){
		
		$.ajax
		(
			{
				url:"../../TeacherServlet",
				type:"post",
				async:true,
				data:{
					name:$("#query_tname").val()	
				},
				timeout:5000,
				dataType:"text",	
				success:function(data,textStatus,jqXHR){
					
						location="sys_teacher_all.jsp";
				
				},
				error:function(xhr,textStatus){
					alert("错误");
				}			
			}				
		)	
	})		
})



//删除
function del(id)
{
	if(confirm("确定删除该教师吗？"))
	{
			$.ajax
			(
				{
					url:"../../DelTeacherServlet",
					type:"post",
					async:true,
					data:{
						tno:id	
					},
					timeout:5000,
					dataType:"text",	
					success:function(data,textStatus,jqXHR){
						
							location="sys_teacher_all.jsp";
					
					},
					error:function(xhr,textStatus){
						alert("请求错误");
					}			
				}				
			)		
	}
}
			
		