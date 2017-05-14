$(document).ready(function(){

			
		
		$("#updateButton").click(function(){
		
			$.post("../../ListUpdateServlet",
				{
				    name:$("#name").val(),
					num:$("#num").val(),
					sex: $("#sex").val(),
					age: $("#age").val(),
					cname: $("#cname").val(),

				},
				function (r) {
					if (r == "1") {
						
						location="list.jsp";
					}
				})

		});

});






