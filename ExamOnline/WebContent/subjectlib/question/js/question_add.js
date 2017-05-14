$(document).ready(function(){
	$("#btn1").click(function(){
		$.ajax({
		url : '../../QuestionAddServlet',
		type : 'POST', // GET
		async : true, // 或false,是否异步
		data : {
			questiontext : $("#questiontext").val(),
			A : $("#A").val(),
			B : $("#B").val(),
			C : $("#C").val(),
			D : $("#D").val(),
			E : $("#E").val(),
			c_id : $("#s1").val(),
			t_id : $("#s2").val(),
			user_id : $("#user_id").val(),
			remark : $("#remark").val()
		},
		timeout : 5000, // 超时时间
		dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
		success : function(data, textStatus, jqXHR) {
			if(data.result=="1"){
				location="exam_question.jsp"
			}
			if(data.result=="2"){
				alert("添加失败，请稍后重试")
			}
		
		},
		error : function(xhr, textStatus) {
			alert('错误');
			// alert(xhr);
			// alert(textStatus);
		}
	})
	})
})