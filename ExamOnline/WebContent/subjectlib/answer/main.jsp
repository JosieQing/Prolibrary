<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>答案管理主页</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="../../bootstrap/bootstrap.min.css" rel="stylesheet"> 
<link rel="stylesheet" href="main.css">
</head>
<body style="background-color:aliceblue;">
<div class="center-block" >

<p class="text-center"><font style="color:red;font-size:35px;">答案主页</font></p><br/><br/><br/>

<button  type="button" class="btn btn-primary btn-block"  onclick="location='answerListKg.jsp'">客观题答案</button><br/><br/><br/>
<button  type="button" class="btn btn-primary btn-block" onclick="location='answerListZg.jsp'">主观题答案</button>

</div>
<script src="../../bootstrap/jquery.min.js"></script>
<script src="../../bootstrap/bootstrap.min.js"></script>
</body>
</html>