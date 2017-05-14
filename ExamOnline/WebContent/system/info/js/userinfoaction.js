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