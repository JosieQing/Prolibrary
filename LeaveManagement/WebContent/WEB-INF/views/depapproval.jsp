<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<title>处长审批列表</title>
</head>
<style type="text/css">
th {
	font-weight: bold;
	font-size: 15px;
}
</style>
<body>
	<b><h2 align="center" style="font-size: 35px">审批列表</h2></b>
	<c:if test="${listApproval ne null}">
		<table width="770" class="table table-hover" border="1">
			<tr>
				<th width="60" align="center">ID</th>
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
					<td><a id="a1" href="checkleave?lid=${leavePO.lid}">查看</a></td>
				</tr>
				<br />
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
	$('select').select();
	var head = [ {
		label : 'ID',
		width : 50,
		sortable : 'default',
		name : 'lid'
	}, {
		label : '用户名',
		width : 100,
		sortable : 'default',
		name : 'lname'
	}, {
		label : '起始时间',
		width : 100,
		name : 'start_time'
	}, {
		label : '结束时间',
		width : 100,
		name : 'end_time'
	}, {
		label : '请假事由',
		Width : 100,
		name : 'leave_reason'
	}, {
		label : '请假类型',
		width : 100,
		name : 'leave_type'
	}, {
		label : '工作',
		width : 100,
		name : 'job'
	}, {
		label : '审批状态',
		width : 100,
		name : 'state'
	} ];

	var oper = [ {
		label : '查看',
		onclick : function() {
			window.location = "checkleave";
		}
	}, {
		label : '送审',
		onclick : function() {
			$.ajax({
				url : 'songB.action',
				type : 'POST',
				async : true,

				dataType : 'json',//返回的数据格式：json/xml/html/script/jsonp/text
				success : function(data, textStatus, jqXHR) {
					$('.grid').Grid('setData', data, head);

				},
				error : function(xhr, textStatus) {
					alert('错误');
				}
			})
		}
	} ]
	var tbody = [
			[ "201301", "admin", "熊猫王子", "江苏南京", "南京林业大学", "1982-10-18", "已审核",
					oper ],
			[ "201302", "uimaker", "小牛", "山东济南", "山东大学", "1989-10-18", "已审核",
					oper ] ]

	$('.grid').Grid({
		thead : head,
		tbody : null,
		height : 400,
		checkbox : {
			single : true
		},
		operator : {
			type : "normal",
			width : 280
		},
		sortCallBack : function(name, index, type) {
			alert(name + "," + index + ',' + type);
		}

	});

	$('.grid').Grid('addLoading');

	// 模拟异步
	setTimeout(function() {
		$('.grid').Grid('setData', tbody, head);
	}, 2000)

	/*   $.ajax({
		    url:'list.action',
		    type:'POST',
		    async:true,
		    
		    
		    dataType:'json',//返回的数据格式：json/xml/html/script/jsonp/text
		    success:function(data,textStatus,jqXHR){
			    $('.grid').Grid('setData',data, head);

		    },
		    error:function(xhr,textStatus){
			    alert('错误');
		    }
		})  */

	$('.pagination').pagination(100, {
		callback : function(page) {
			alert(page);
		},
		display_msg : false
	});
</script>
</html>