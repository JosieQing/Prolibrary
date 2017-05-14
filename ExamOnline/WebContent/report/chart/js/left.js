$(document).ready(function(){
$.ajax({
    url:'../../XiaLaServlet',
    type:'Post', //GET
    async:true, //或false,是否异步
    data:{
    	w:1
    },
    timeout:5000,    //超时时间
    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
  
    success:function(data,textStatus,jqXHR){
    //alert(data.result);
    	//var abb="";
    	var l="";
    	for(var i in data){
        l=l+"<option>"+data[i]+"</option>";
    	}
    	
    	$("#tt5").html(l);
        //alert(textStatus);
        //alert(jqXHR);
    },
    error:function(xhr,textStatus){
    alert('错误');
    },
});


$.ajax({
    url:'../../XiaLaServlet',
    type:'Post', //GET
    async:true, //或false,是否异步
    data:{
    	w:2
    },
    timeout:5000,    //超时时间
    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
  
    success:function(data,textStatus,jqXHR){
    //alert(data.result);
    	var l="";
    	for(var i in data){
        l=l+"<option>"+data[i]+"</option>";
    	}
    	
    	$("#tt7").html(l);
        //alert(textStatus);
        //alert(jqXHR);
    },
    error:function(xhr,textStatus){
    alert('错误');
    },
});

$.ajax({
    url:'../../XiaLaServlet',
    type:'Post', //GET
    async:true, //或false,是否异步
    data:{
    	w:3
    },
    timeout:5000,    //超时时间
    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
  
    success:function(data,textStatus,jqXHR){
    //alert(data.result);
    	//alert(data.s1)
    	var l="";
    	for(var i in data){
        l=l+"<option>"+data[i]+"</option>";
    	}
    	
    	$("#tt8").html(l);
        //alert(textStatus);
        //alert(jqXHR);
    },
    error:function(xhr,textStatus){
    alert('错误');
    },
});

$("#ss1").click(function(){
	
	 $.ajax({
		    url:'../../FindServlet',
		    type:'POST', //GET
		    async:true,    //或false,是否异步
		    data:{
		    	xa:1,
		    	a:$("#tt1").val()
		   
		    },
		    timeout:5000,    //超时时间
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){
			    //alert("123");
		    	document.getElementById("lForm").submit();
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

$("#ss2").click(function(){
	
	 $.ajax({
		    url:'../../FindServlet',
		    type:'POST', //GET
		    async:true,    //或false,是否异步
		    data:{
		    	xa:2,
		    	a:$("#tt2").val(),
		    	b:$("#tt3").val(),
		    	c:$("#tt4").val(),
		    	d:$("#tt5").val(),
		    	e:$("#tt6").val()
		   
		    },
		    timeout:5000,    //超时时间
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){
			    //alert(data.result);
//		    	document.getElementById("lForm").submit();
		    	location="left.jsp";
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

$("#ss3").click(function(){
	
	 $.ajax({
		    url:'../../FindServlet',
		    type:'POST', //GET
		    async:true,    //或false,是否异步
		    data:{
		    	xa:3,
		    	a:$("#tt7").val()
		 
		    },
		    timeout:5000,    //超时时间
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){
			    //alert(data.result);
		    	//document.getElementById("lForm").submit();
		    	location="left.jsp";
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

$("#ss4").click(function(){
	
	 $.ajax({
		    url:'../../FindServlet',
		    type:'POST', //GET
		    async:true,    //或false,是否异步
		    data:{
		    	xa:4,
		    	a:$("#tt8").val()
	
		    },
		    timeout:5000,    //超时时间
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){
		    	//document.getElementById("lForm").submit();
		    	location="left.jsp";
		        //alert(textStatus);
		        //alert(jqXHR);
		    },
		    error:function(xhr,textStatus){
		    alert("错误");
		    //alert(xhr);
		    //alert(textStatus);
		    }
		})
	});

$("#ab1").click(function(){
	location="left.jsp?dqy="+$("#sbb1").val();
	});

$("#ab2").click(function(){
	
	 $.ajax({
		    url:'../../XiQbServlet',
		    type:'POST', //GET
		    async:true,    //或false,是否异步
		    data:{
		    },
		    timeout:5000,    //超时时间
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){
		    	if(data.result==1){
		    	location="left.jsp";
		    	}
		    },
		    error:function(xhr,textStatus){
		    alert('错误');
		    //alert(xhr);
		    //alert(textStatus);
		    }
		})


	});
$("#ssd1").click(function(){
	if(confirm("按此考试组查询吗？")){
	 $.ajax({
		    url:'../../GztServlet',
		    type:'POST', //GET
		    async:true,    //或false,是否异步
		    data:{
		    	xx:1,
		        ksz:$("#tt8").val()
		    },
		    timeout:5000,    //超时时间
		    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){
			    //alert(data.result);
//		    	document.getElementById("lForm").submit();
		    	//document.getElementById("bFrame").src="charts-4";
		    	parent.frames["bFrame"].location='charts-4.jsp';
		        //alert(textStatus);
		        //alert(jqXHR);
		    },
		    error:function(xhr,textStatus){
		    alert('错误');
		    //alert(xhr);
		    //alert(textStatus);
		    }
		})
		}
	});

	$("#in0").click(function(){
		 $.ajax({
			    url:'../../GztServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	xx:2,
			        id:$("#td0").html()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
//			    	document.getElementById("lForm").submit();
			    	parent.frames["bFrame"].location='charts-1.jsp';
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
	$("#hn0").click(function(){
		if(confirm("按此考试组查询吗？")){
		 $.ajax({
			    url:'../../GztServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	xx:3,
			        id:$("#td0").html(),
			        ksz:$("#tt8").val()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
//			    	document.getElementById("lForm").submit();
			    	parent.frames["rFrame"].location='leida.jsp';
			        //alert(textStatus);
			        //alert(jqXHR);
			    },
			    error:function(xhr,textStatus){
			    alert('错误');
			    //alert(xhr);
			    //alert(textStatus);
			    }
			})
		}
		});
	
	$("#in1").click(function(){
		 $.ajax({
			    url:'../../GztServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	xx:2,
			        id:$("#td1").html()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
//			    	document.getElementById("lForm").submit();
			    	parent.frames["bFrame"].location='charts-1.jsp';
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
	$("#hn1").click(function(){
		if(confirm("按此考试组查询吗？")){
		 $.ajax({
			    url:'../../GztServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	xx:3,
			        id:$("#td1").html(),
			        ksz:$("#tt8").val()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
//			    	document.getElementById("lForm").submit();
			    	parent.frames["rFrame"].location='leida.jsp';
			        //alert(textStatus);
			        //alert(jqXHR);
			    },
			    error:function(xhr,textStatus){
			    alert('错误');
			    //alert(xhr);
			    //alert(textStatus);
			    }
			})	
		}
		});
	$("#in2").click(function(){
		 $.ajax({
			    url:'../../GztServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	xx:2,
			        id:$("#td2").html()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
//			    	document.getElementById("lForm").submit();
			    	parent.frames["bFrame"].location='charts-1.jsp';
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
	$("#hn2").click(function(){
		if(confirm("按此考试组查询吗？")){
		 $.ajax({
			    url:'../../GztServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	xx:3,
			        id:$("#td2").html(),
			        ksz:$("#tt8").val()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
//			    	document.getElementById("lForm").submit();
			    	parent.frames["rFrame"].location='leida.jsp';
			        //alert(textStatus);
			        //alert(jqXHR);
			    },
			    error:function(xhr,textStatus){
			    alert('错误');
			    //alert(xhr);
			    //alert(textStatus);
			    }
			})		
		}
		});
	$("#in3").click(function(){
		 $.ajax({
			    url:'../../GztServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	xx:2,
			        id:$("#td3").html()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
//			    	document.getElementById("lForm").submit();
			    	parent.frames["bFrame"].location='charts-1.jsp';
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
	$("#hn3").click(function(){
		if(confirm("按此考试组查询吗？")){
		 $.ajax({
			    url:'../../GztServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	xx:3,
			        id:$("#td3").html(),
			        ksz:$("#tt8").val()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
//			    	document.getElementById("lForm").submit();
			    	parent.frames["rFrame"].location='leida.jsp';
			        //alert(textStatus);
			        //alert(jqXHR);
			    },
			    error:function(xhr,textStatus){
			    alert('错误');
			    //alert(xhr);
			    //alert(textStatus);
			    }
			})	
		}
		});

	$("#in4").click(function(){
		
		 $.ajax({
			    url:'../../GztServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	xx:2,
			        id:$("#td4").html()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
//			    	document.getElementById("lForm").submit();
			    	parent.frames["bFrame"].location='charts-1.jsp';
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
	$("#hn4").click(function(){
		if(confirm("按此考试组查询吗？")){
		 $.ajax({
			    url:'../../GztServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	xx:3,
			        id:$("#td4").html(),
			        ksz:$("#tt8").val()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
//			    	document.getElementById("lForm").submit();
			    	parent.frames["rFrame"].location='leida.jsp';
			        //alert(textStatus);
			        //alert(jqXHR);
			    },
			    error:function(xhr,textStatus){
			    alert('错误');
			    //alert(xhr);
			    //alert(textStatus);
			    }
			})	
		}
		});
	$("#in5").click(function(){
		 $.ajax({
			    url:'../../GztServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	xx:2,
			        id:$("#td5").html()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
//			    	document.getElementById("lForm").submit();
			    	parent.frames["bFrame"].location='charts-1.jsp';
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
	$("#hn5").click(function(){
		if(confirm("按此考试组查询吗？")){
		 $.ajax({
			    url:'../../GztServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	xx:3,
			        id:$("#td5").html(),
			        ksz:$("#tt8").val()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
//			    	document.getElementById("lForm").submit();
			    	parent.frames["rFrame"].location='leida.jsp';
			        //alert(textStatus);
			        //alert(jqXHR);
			    },
			    error:function(xhr,textStatus){
			    alert('错误');
			    //alert(xhr);
			    //alert(textStatus);
			    }
			})	
		}
		});
	
	$("#in6").click(function(){
		 $.ajax({
			    url:'../../GztServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	xx:2,
			        id:$("#td6").html()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
//			    	document.getElementById("lForm").submit();
			    	parent.frames["bFrame"].location='charts-1.jsp';
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
	$("#hn6").click(function(){
		if(confirm("按此考试组查询吗？")){
		 $.ajax({
			    url:'../../GztServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	xx:3,
			        id:$("#td6").html(),
			        ksz:$("#tt8").val()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
//			    	document.getElementById("lForm").submit();
			    	parent.frames["rFrame"].location='leida.jsp';
			        //alert(textStatus);
			        //alert(jqXHR);
			    },
			    error:function(xhr,textStatus){
			    alert('错误');
			    //alert(xhr);
			    //alert(textStatus);
			    }
			})	
		}
		});
	$("#in7").click(function(){
		 $.ajax({
			    url:'../../GztServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	xx:2,
			        id:$("#td7").html()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
//			    	document.getElementById("lForm").submit();
			    	parent.frames["bFrame"].location='charts-1.jsp';
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
	$("#hn7").click(function(){
		if(confirm("按此考试组查询吗？")){
		 $.ajax({
			    url:'../../GztServlet',
			    type:'POST', //GET
			    async:true,    //或false,是否异步
			    data:{
			    	xx:3,
			        id:$("#td7").html(),
			        ksz:$("#tt8").val()
			    },
			    timeout:5000,    //超时时间
			    dataType:'json',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
//			    	document.getElementById("lForm").submit();
			    	parent.frames["rFrame"].location='leida.jsp';
			        //alert(textStatus);
			        //alert(jqXHR);
			    },
			    error:function(xhr,textStatus){
			    alert('错误');
			    //alert(xhr);
			    //alert(textStatus);
			    }
			})	
		}
		});
})