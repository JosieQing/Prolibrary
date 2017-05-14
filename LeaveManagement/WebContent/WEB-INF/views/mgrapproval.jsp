<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/table.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.grid.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<title>科长审批列表</title>
</head>
<style type="text/css">
th{
	font-weight:bold;
	font-size:15px;
}
</style>
<body>
<b><h2 align="center" style="font-size:35px">审批列表</h2></b>
	<c:if test="${listApproval ne null}"> 
		<table width="770" class="table table-hover" border="1" >
			<tr>
				<th width="60" align="center" >ID</th>
				<th width="75" align="center">用户名</th>
				<th width="200" align="center">起始时间</th>
				<th width="200" align="center">结束时间</th>
				<th width="200" align="center">请假类型</th>
				<th width="200" align="center">工作</th>
				<th width="200" align="center">审批状态</th>
				<th width="300" align="center">操作</th>
			</tr>
			<c:forEach items="${requestScope.listApproval}" var="leavePO">
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
						<c:if test="${leavePO.state=='科长审批通过'}">
							<a id="a4" href="mgrupdateState?lid=${leavePO.lid}&state=${leavePO.state}">送审</a>
						</c:if>
					</td>
				</tr>
				<br/>
			</c:forEach>
		</table>
 	</c:if>   
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/global.js"></script>
<script type="text/javascript" src="js/jquery.select.js"></script>
<script type="text/javascript" src="js/core.js"></script>
<script type="text/javascript" src="js/jquery.pagination.js"></script>
<script type="text/javascript" src="js/jquery.grid.js"></script>
<script type="text/javascript" src="js/WdatePicker.js"></script>
<script type="text/javascript">
/* $(document).ready(function(){ 
	window.location.href="listMgrApproval.action";

}); */

	   /* $.ajax({
		    url:'listMgrApproval.action',
		    type:'POST',
		    async:true,
		    
		    
		    dataType:'json',//返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){
			   

		    },
		    error:function(xhr,textStatus){
			    alert('错误');
		    }
		})  */
		


	
</script>
</html>