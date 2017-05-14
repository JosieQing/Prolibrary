//格式化时间
function formatterdate(val, row) {
	if (val != null) {

		var date = new Date(val);
		
		return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() 
		+' '+ date.getHours() +':'+ date.getMinutes() +':'+ date.getSeconds();
	}
}