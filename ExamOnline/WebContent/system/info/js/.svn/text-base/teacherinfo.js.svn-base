$(document).ready(function() {
	$.ajax({
		url : '../../TeacherInfoServlet',
		type : 'POST', // GET
		async : true, // 或false,是否异步
		data : {
			user_id : $("#user_id").val(),
		},
		timeout : 5000, // 超时时间
		dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
		success : function(data, textStatus, jqXHR) {
			// alert(data.result);
			$("#tno").val(data.tno);
			$("#tname").val(data.tname);
			$("#tage").val(data.tage);
			$("#tsex").val(data.tsex);
			$("#ttel").val(data.ttel);
			$("#hiredate").val(data.hiredate);
			$("#tremark").val(data.tremark);
			// alert(textStatus);
			// alert(jqXHR);
		},
		error : function(xhr, textStatus) {
			alert('错误');
			// alert(xhr);
			// alert(textStatus);
		}
	})
	$("#tupdatebutton").click(function() {
		var s = /^1[3|4|5|7|8][0-9]{9}$/;
		if(s.test($("#ttel").val())){
			$.ajax({
				url : '../../TeacherInfoUpdateServlet',
				type : 'POST', // GET
				async : true, // 或false,是否异步
				data : {
					user_id:$("#user_id").val(),
					tremark:$("#tremark").val(),
					ttel:$("#ttel").val()
				// alert(textStatus);
				},
				timeout : 5000, // 超时时间
				dataType : 'json', // 返回的数据格式：json/xml/html/script/jsonp/text
				success : function(data, textStatus, jqXHR) {
					// alert(data.result);
					if (data.result == 1) {
						location = "teacherinfo.jsp"
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
		}else{
			alert("手机号不合法")
		}
	})
	})
