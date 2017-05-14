/*
function checkSubmit(){
	if(document.lForm.uName.value==""){
		alert("用户名不能为空！");
		document.lForm.uName.focus();
	}else if(document.lForm.pWord.value==""){
		alert("密码不能为空！");
		document.lForm.pWord.focus();
	}else{
		document.lForm.submit();
	}
	//document.getElementById("lForm").submit();
}
*/

$(document).ready(function(){
	
	$("#uLogin").click(function(){
		
		 $.ajax({
			    url:'LoginServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	uName:$("#uName").val(),
			    	pWord:$("#pWord").val()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
				    if(data.result=="0"){
				    	alert("用户名密码错误！");
				    	
				    }
				    if(data.result=="1"){
				    	location="index.jsp";
				    }
			        //alert(textStatus);
			        //alert(jqXHR);
			    },
			    error:function(xhr,textStatus){
			    alert('错误');
			    //alert(xhr);
			    //alert(textStatus);
			    }
			})


		});

});