$(document).ready(function(){

			
		
		$("#addButton").click(function(){
			
			$.post("../../UserAddServlet",
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