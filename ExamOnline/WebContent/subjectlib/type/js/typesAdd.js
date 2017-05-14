$(document).ready(function(){
	$("#addTypes").click(function(){
		$.ajax({
			url:'../../ProblemTypesServlet',
			type:'POST',
			async:true,
			data:{
				func:$("#func").val(),
				types_addName:$("#types_addName").val()
			},
			timeout:10000,
			dataType:'json',
			success:function(data){
				if(data.result=="1"){
					alert("添加成功");
					location="problemTypes_list.jsp";
				}
				if(data.result=="0"){
					$("#addTypesMessage").html("<font color='red'><b>添加题型失败</b></font>")
				}
			},
			error:function(data){
				alert("异常");
			}
		})
	});
	
	
	
	
	
	
	
});
