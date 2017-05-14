<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/table.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.grid.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<title>科长请假列表</title>
</head>

<body>
	<div id="container">
		<div id="hd"></div>
		<div id="bd">
			<div id="main">
				<div class="search-box ue-clear">
					<div class="search-area">
					 <form id="listform" name="listform" action="mgrlist.action" > 
						<div class="kv-item ue-clear">
							<label>人员名称:</label>
							<div class="kv-item-content">
								<input id="lname" name="lname" type="text" placeholder="人员名称"
									style="width: 105px" />
							</div>
							
							<label>请假日期:</label>
							<div class="kv-item-content">
								<input id="start_time" name="start_time" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="请假日期" style="width: 105px">
							</div>
							
							<div class="search-button">
								&nbsp; <input id="check" name="check" class="button"
									type="submit" value="查询" />
							</div>
							
							<div class="search-button">
								&nbsp; <input id="add" name="add" class="button" type="button"
									value="添加" onclick="location='addmgrleave'" />
							</div>
						</div>
					 </form> 
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<%-- <c:if test="${list ne null}"> 
		<table width="770" class="table table-hover" border="1" >
			<tr>
				<th width="60" align="center" >ID</th>
				<th width="80" align="center">用户名</th>
				<th width="200" align="center">起始时间</th>
				<th width="200" align="center">结束时间</th>
				<th width="200" align="center">请假类型</th>
				<th width="200" align="center">工作</th>
				<th width="200" align="center">审批状态</th>
				<th width="300" align="center">操作</th>
			</tr>
			<c:forEach items="${requestScope.list}" var="leavePO">
				<tr id="tr">
					<td><c:out value="${leavePO.lid}"></c:out></td>
					<td><c:out value="${leavePO.lname}"></c:out></td>
					<td><c:out value="${leavePO.start_times}"></c:out></td>
					<td><c:out value="${leavePO.end_times}"></c:out></td>
					<td><c:out value="${leavePO.leave_type}"></c:out></td>
					<td><c:out value="${leavePO.job}"></c:out></td>
					<td id="state"><c:out value="${leavePO.state}"></c:out></td>
					<td>
						<a id="a1" href="checkleave?lid=${leavePO.lid}">查看</a>
						<c:if test="${leavePO.state=='未审批'}">
							<a id="a2" href="delete.action?lid=${leavePO.lid}" >删除</a>
							<a id="a3" href="updateMgrleave?lid=${leavePO.lid}">修改</a>
							<a id="a4" href="updateStateAction?lid=${leavePO.lid}&state=${leavePO.state}">送审</a>
						</c:if>
					</td>
				</tr>
				<br/>
			</c:forEach>
		</table>
 	</c:if>  --%>
 	
 	 <div id="divTable"></div> 
 	 
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.select.js"></script>
<script type="text/javascript" src="js/core.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript" src="js/jquery.grid.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript">

	   $.ajax({
		    url:'ajaxMgrlist.action',
		    type:'POST',
		    async:true,
		    
		     data:{
		    	 lname:$("lname").val(),
			     start_time:$("start_time").val()
		    }, 
		    
		    dataType:'json',//返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){
		    	 var html = "<table width='770' id='table1' class='table table-hover' border='1' >";
		    	  html+="<tr><th width='60' align='center' >ID</th><th width='80' align='center'>用户名</th><th width='200' align='center'>起始时间</th><th width='200' align='center'>结束时间</th><th width='200' align='center'>请假类型</th><th width='200' align='center'>工作</th><th width='200' align='center'>审批状态</th><th width='300' align='center'>操作</th></tr>";	
					
		            $.each(data, function (i, item) {
		                html += " <tr> " +
		                        " <td>" + item.lid + "</td> " +
		                        " <td>" + item.lname + "</td> " +
		                        " <td>" + item.start_times + "</td> " +
		                        " <td>" + item.end_times + "</td> " +
		                        " <td>" + item.leave_type + "</td> " +
		                        " <td>" + item.job + "</td> " +
		                        " <td>" + item.state + "</td> " +
		                        " <td>" + '<a id="a1" href="checkleave?lid='+item.lid+'">查看</a>'
					
								+'<a id="a2" href="delete.action?lid='+item.lid+'" >删除</a>'
								+'<a id="a3" href="updateMgrleave?lid='+item.lid+'">修改</a>'
								+'<a id="a4" href="updateMgrStateAction?lid='+item.lid+'&state='+item.state+'">送审</a>' + "</td> " 
							 + "</tr>";
		            })
					html+="</table>"
		            $("#divTable").html(html);

		    },
		    error:function(xhr,textStatus){
			    alert('错误');
		    }
		})  
		


</script>
</html>
