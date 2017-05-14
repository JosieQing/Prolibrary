$(document).ready(function(){
	if(confirm("确认删除?")){
	$.ajax({
		url : '../../QuestionDeleteServlet',
		type : 'POST', // GET
		async : true, // 或false,是否异步
		data : {
			q_id : $("#q_id").val(),
		},
		timeout : 5000, // 超时时间
		dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
		success : function(data, textStatus, jqXHR) {
			if(data.result=="1"){
				location="exam_question.jsp"
			}
			if(data.result=="2"){
				alert("删除失败")
			}
		
		},
		error : function(xhr, textStatus) {
			alert('错误');
			// alert(xhr);
			// alert(textStatus);
		}
	})
	}else{
		location="exam_question.jsp"
	}
})