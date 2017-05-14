<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*" %>
<%@page import="com.neuedu.examonline.stufunc.anssheet.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>考试界面</title>
<!-- 包含头部信息用于适应不同设备 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 包含 bootstrap 样式表 -->
<link rel="stylesheet" href="../../bootstrap/bootstrap.min.css">
</head> 
<body>
	<%
		text to = new text();
		String id = null;
		id = request.getParameter("id");
		int time = to.gettotal_time(id);
		String exam_name=to.getexam_name(id);
		String ExamNum=to.getexamNum(id);
		
		//

%>
<div class="container"> 
<form id="f1" name="f1" method="post" action="Quiz_action.jsp">
<table class="table table-striped">
<div class="main-header">考试名称：<%=exam_name%>&nbsp;&nbsp;&nbsp;</div><div style="color: red;font-size: large;"  id="showTimes"></div>

<h2>选择题</h2>
	<%
QuestionBean qb = new QuestionBean();
List<Question> list=qb.getSelectQuestion(id);
List<Question> list2=qb.getAnswerQuestion(id);

int i=1;
for(Question q1:list)
{
	System.out.println("q1.getQuestions_id()--:"+q1.getId());
%>
<tr>
<input type="hidden" name="shitiid" value="<%=q1.getQuestions_id()%>">
<input type="hidden" name="typeid<%=q1.getQuestions_id()%>" value="1">
<div><%=i%>.&nbsp;<%=q1.getQuestiontext()%></div>
<div><%=q1.getA()%><input name="Quizradio<%=q1.getQuestions_id()%>" type="radio" value="A"></div>
<div><%=q1.getB()%><input name="Quizradio<%=q1.getQuestions_id()%>" type="radio" value="B"></div>
<div><%=q1.getC()%><input name="Quizradio<%=q1.getQuestions_id()%>" type="radio" value="C"></div>
<div><%=q1.getD()%><input name="Quizradio<%=q1.getQuestions_id()%>" type="radio" value="D"></div>
<div><%=q1.getE()%><input name="Quizradio<%=q1.getQuestions_id()%>" type="radio" value="E"></div>
</tr>
<%i++;}%>
<h2>简答题</h2>
	<%
	int j=1;
for(Question q2:list2)
{%>
<tr>
<input type="hidden" name="shitiid" value="<%=q2.getQuestions_id()%>">
<input type="hidden" name="typeid<%=q2.getQuestions_id()%>" value="2">
<div><%=j%>.&nbsp;<%=q2.getQuestiontext()%></div>
<textarea name="jdQuizradio<%=q2.getQuestions_id()%>" class="form-control" rows="20" id="updateContent"/></textarea>
</tr>
<%j++;} %>
<input type="hidden" name="shijuanid" value="<%=ExamNum%>">
<div class="hero-unit">  <h3>请确认答案后点击交卷</h3></div>
<div>
<input class="btn btn-primary" type="button" value="交卷" onclick="JavaScript:chk_search();"/>
</div>
</table>
</form>
</div>
	<script type="text/javascript">
	
	function chk_search(){
		if(confirm("是否确认交卷？")){
			document.f1.submit();
		}
	}
		var second =<%=time * 60%>;
		var timedown = function() {
			var s = second % 60; //秒
			var mi = (second - s) / 60 % 60; //分
			var h = ((second - s) / 60 - mi) / 60 % 24;
			return "考试剩余时间:" + h + "小时" + mi + "分钟" + s + "秒";

		}
		window.setInterval(function() {

			second--;
			 if (second == 0) {
		            document.getElementById("f1").submit()}


			document.getElementById("showTimes").innerHTML = timedown();
		}, 1000);//document.f1.submit()
	</script>


</body>
</html>
<script src="../../bootstrap/jquery.min.js"></script>
<script src="../../bootstrap/bootstrap.min.js"></script>