$(document).ready(function(){
	$("#check").click(function(){
		$.ajax({
		    url:'../../../mancheck',
		    type:'POST',//GET
		    data:{
		    	id:$("#id").val()
		    },
		    dataType:'text',//返回的数据格式:json/xml/html/script/jsonp/text
		    success:function(r){
            var s=r.split(",");
            for(var i=0;i<s.length-1;i++){
            	var ss="#ss"+i;
            	
            	$(ss).val(s[i]);

            }
            $("#id111").val($("#id").val());

            $("#f2").submit();
            //window.location.href="chart.jsp?shuju="+(s.length-1);
		    },
		    error:function(){
		    	alert('错误');
		    }
		})
	});
});