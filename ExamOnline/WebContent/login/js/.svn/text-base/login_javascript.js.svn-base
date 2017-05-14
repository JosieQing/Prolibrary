function loadFun(){
	
	var array = document.getElementsByTagName("ul").item(0).childNodes;
	
	for(var i=0;i<array.length;i++)
	{
		var childnodes = array[i].childNodes;
		
		for(var j=0;j<childnodes.length;j++)
		{
			if(childnodes[j].tagName=="UL")
			{
				childnodes[j].style.display="none";
			}
			
		}
	}
	
}



var arrays = new Array("base","system","subjectlib","paper","exam","report","stufunc");

function show(tagid)
{
	for(var i=0;i<arrays.length;i++)
	{
		if(arrays[i]==tagid)
		{
			document.getElementById(arrays[i]).parentNode.style.backgroundColor="#b3d9ff";
			document.getElementById(arrays[i]).style.display="block";
			
		}else
		{
			document.getElementById(arrays[i]).parentNode.style.backgroundColor="#d0ffd0";
			document.getElementById(arrays[i]).style.display="none";
		}
		
	}




}





