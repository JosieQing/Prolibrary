$(document).ready(function(){
	$("#action").click(function(){
		 $.ajax({
			    url:'../../../addServlet',
			    type:'POST',
			    async:true,
			    data:{
			    	add_login:$("#add_login").val(),
			    	add_pass:$("#add_pass").val(),
			    	add_select:$("#add_select").val(),
			    	add_role:$("#add_role").val(),
			    	add_remark:$("#add_remark").val()
			    },
			    timeout:5000,
			    dataType:'json',
			    success:function(data,textStatus,jqXHR){
				    if(data.result=="0")
				    	{
				    	$("#loginMessage").html("<span><font color='red'><b>错误！</b></font></span>");
				    	}
				    if(data.result=="1")
			    		{
			    		location = "double.jsp";
			    		}
				    if(data.result=="2")
			    	{
			    	$("#loginMessage").html("<span><font color='red'><b>用户已存在！</b></font></span>");
			    	}
			    },
			    error:function(xhr,textStatus){
			    alert('错误');
			  	}
	 	 })
	});
});