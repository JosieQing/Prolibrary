$(document).ready(function(){
	$("#classcheck").click(function(){
		$.ajax({
		    url:'../../../classcheck',
		    type:'POST',//GET
		    data:{
		    	classname:$("#classname").val()
		    },
		    dataType:'text',//返回的数据格式:json/xml/html/script/jsonp/text
		    success:function(r){
            var s=r.split(",");
            for(var i=0;i<s.length-1;i++){
            	var ss="#s"+i;
            	
            	$(ss).val(s[i]);

            }
            $("#id11").val($("#classname").val());
            $("#f1").submit();

            //window.location.href="chart.jsp?shuju="+(s.length-1);
		    },
		    error:function(){
		    	alert('错误');
		    }
		})
	});
	
});