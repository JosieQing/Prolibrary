$(document).ready(function() {

	$.ajax({
		url : "../../ProblemTypesServlet",
		type : "POST",
		async : true,
		data : {
			func : $("#func").val(),
			types_updateId : $("#types_updateId").val()
		},
		dataType : "json",
		success : function(data) {
			$("#types_updateName").val(data.types_name)
		},
		error : function(data) {
			alert("异常");
		}
	});
	$("#updateType").click(function() {
		$.ajax({
			url : "../../UpdateTypesServlet",
			type : "Post",
			async : true,
			data : {
				types_updateId : $("#types_updateId").val(),
				types_updateName : $("#types_updateName").val()
			},
			dataType : "text",
			success : function(r) {
				if (r == "1") {
					alert("修改成功！");
					location = "problemTypes_list.jsp";
				}
				/*
				 * if (r!="1") { alert("修改失败！"); }
				 */
			},
			error : function() {
				alert("浏览器异常");
			}
		});
	});
});
