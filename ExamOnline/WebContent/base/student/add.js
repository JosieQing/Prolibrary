$(document).ready(function(){

			
		
		$("#addButton").click(function(){
		
			$.post("../../ListAddServlet",
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
