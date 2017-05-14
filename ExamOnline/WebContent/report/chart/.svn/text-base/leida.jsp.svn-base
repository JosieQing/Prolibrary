<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.neuedu.examonline.report.chart.*" %>
<%@page import="java.util.*"%>
<!DOCTYPE HTML>
<html>
<head>
</head>
<body>
<%
List abb=(List)session.getAttribute("lii3");
  System.out.println(abb.size());
if (abb!=null){
Iterator it = abb.listIterator();
int i=0;
while(it.hasNext()){
     List acc=(List)it.next();
     Iterator it1 = acc.listIterator();
     String qa="[";
     while(it1.hasNext()){
    	 %>
    	 <input id="inp<%=i %>" type="hidden" value="<%=StringUtil.iSOToUtf8((String)it1.next())%>">
    	 <% 
   //qa=qa+(String)it1.next()+",";
    	 i++;
     }
    // qa=qa.substring(0,qa.length()-1)+"]";
}
}
%>
<input id="aaa" type="hidden"   value="<%=StringUtil.iSOToUtf8(request.getParameter("a"))%>">
<div class="page-container">
	<div id="container" style="min-width:300px;height:300px"></div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/hcharts/Highcharts/5.0.6/js/highcharts.js"></script>
<script src="js/highcharts-more.js"></script>
<script src="js/leida.js"></script>
</body>
</html>