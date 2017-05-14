$(document).ready(function(){

			
		
		$("#updateButton").click(function(){
			
			$.post("../../UserUpdateServlet",
				{
					id:$("#id").val(),
					couse: $("#couse").val(),

				},
				function (r) {
					if (r == "1") {
						
						location="list.jsp";
					}
				})

		});

});