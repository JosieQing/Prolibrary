function getOne()
{
	$(document).ready(function(){
		$.ajax({
			url:'listServlet',
		    type:'POST', //GET
		    async:true, //或false,是否异步
		    data:{
		    	questext:$("#questext").val(),
		    },
		    timeout:5000,    //超时时间
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){		   		    		    
		    	alert('添加成功！');
		    	location="list.jsp"
		    },
		    error:function(xhr,textStatus){
		    	alert('数据传送失败！');
		    }		
		});
	})		
}

function looknow()
{
			   		    		    
	location="show.jsp"
	
}

function over()
{
	   		    		    
	location="make.jsp"
		
}
window.onload=function()
{
		var temp="";
		$(".want").click(function(){
			if(this.checked)
			{
				temp=temp+($(this).val())+",";
				document.getElementById("questext").value=temp;	
				//此处需要有","末尾和后续要连接所以需要有否则会出现拼接错误，相反后续方法有正则表达式截取","所以无妨
				//所以不能单单最求美观，temp.substr(0,temp.length-1);
			}
			
		})
}





