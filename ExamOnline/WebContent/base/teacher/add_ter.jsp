<!DOCTYPE html>   
<html>
<head>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>  
<%@ page import="com.neuedu.examonline.base.teacher.*"%>

<%@ include file="../../inc/theme.jsp" %>

<script src="js/teacher.js" type="text/javascript"></script>

</head>
<body>
<br/><br/>
<div class="page-container">
<form class="form form-horizontal">
	
	<div class="row cl">
		<label class="col-sm-2 form-label">姓名:</label>
		<div class="col-sm-6">
			<input id="tname" type="text" class="input-text"  />
		</div>
	</div>
	
	<div class="row cl">
		<label class="col-sm-2 form-label">性别:</label>
		<div class="col-sm-1">
		<input type="radio" name="tsex" value="男" class="tsex" checked="checked"/>男
		</div>
		<div class="col-sm-1">
		<input type="radio" name="tsex" value="女" class="tsex"/>女
		</div>
	</div>
	
	<div class="row cl">
		<label class="col-sm-2 form-label">年龄:</label>
		<div class="col-sm-6">
			<input id="tage" type="text"  class="input-text"  />
		</div>
	</div>
	
	<div class="row cl">
		<label class="col-sm-2 form-label">TEL:</label>
		<div class="col-sm-6">
			<input id="ttel" type="text" class="input-text"  />
		</div>
	</div>
	
	<div class="row cl">
		<label class="col-sm-2 form-label">入职日期:</label>
		<div class="col-sm-6">
			<input class="input-text Wdate"  id="hiredate"  type="text"  readonly="readonly"  onfocus="WdatePicker({ dateFmt:'yyyy-MM-dd'})"/>
		</div>
	</div>
	
	<div class="row cl">
		<label class="col-sm-2 form-label">备注信息:</label>
		<div class="col-sm-6">
			<input id="tremark" type="text"  class="input-text"   />
		</div>
	</div>
	
	<div class="row cl">
		<div class="col-sm-offset-2 col-sm-6">
			<input type="button" class="btn btn-default"  id="newinfo_btn" value="提交"/>
		</div>
	</div>
</form>

</div>
</body>
</html>	