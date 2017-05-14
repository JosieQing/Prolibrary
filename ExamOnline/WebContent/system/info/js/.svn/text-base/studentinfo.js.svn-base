$(document).ready(function() {
	$.ajax({
		url : '../../StudentInfoServlet',
		type : 'POST', // GET
		async : true, // 或false,是否异步
		data : {
			user_id : $("#user_id").val(),
		},
		timeout : 5000, // 超时时间
		dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
		success : function(data, textStatus, jqXHR) {
			// alert(data.result);
			$("#num").val(data.num);
			$("#name").val(data.name);
			$("#sex").val(data.sex);
			$("#age").val(data.age);
			$("#banji").val(data.banji);
			$("#cno").val(data.cno);
			// alert(textStatus);
			// alert(jqXHR);
		},
		error : function(xhr, textStatus) {
			alert('错误');
			// alert(xhr);
			// alert(textStatus);
		}
	})
	$("#supdatebutton").click(function() {
		if ($("#name").val() == "") {
			alert("姓名不能为空！");
		}  else {
			$.ajax({
				url : '../../StudentInfoUpdateServlet',
				type : 'POST', // GET
				async : true, // 或false,是否异步
				data : {
					name:$("#name").val(),
					sex:$("#sex").val(),
					age:$("#age").val(),
					banji:$("#banji").val(),
					user_id:$("#user_id").val()
				// alert(textStatus);
				},
				timeout : 5000, // 超时时间
				dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
				success : function(data, textStatus, jqXHR) {
					// alert(data.result);
					if (data.result == 1) {
						location = "studentinfo.jsp"
					} else {
						alert("wwwww");
					}
					// alert(textStatus);
					// alert(jqXHR);
				},
				error : function(xhr, textStatus) {
					alert('错误');
					// alert(xhr);
					// alert(textStatus);
				}
			})

		}

	})
		
});