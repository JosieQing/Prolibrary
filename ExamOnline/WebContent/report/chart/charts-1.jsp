<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.neuedu.examonline.report.chart.*" %>
<%@page import="java.util.*"%>
<!DOCTYPE HTML>
<html>
<head>
</head>
<body>
<%
List abb=(List)session.getAttribute("lii2");
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
<div class="page-container">
	<div id="container" style="min-width:630px;height:320px"></div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="lib/hcharts/Highcharts/5.0.6/js/highcharts.js"></script>
<script type="text/javascript">
$(function () {
//	var ss0=eval($("#inp0").val());
//	var ss1=eval($("#inp1").val());
//	var ss2=eval($("#inp2").val());
//	var ss3=eval($("#inp3").val());
//	var ss4=eval($("#inp4").val());
//	var ss5=eval($("#inp5").val());
   Highcharts.chart('container', {
        title: {
            text: '成绩折线图',
            x: -20 //center
        },
        xAxis: {
            categories: [$("#inp0").val(),$("#inp1").val()]
        },
        yAxis: {
            title: {
                text: '分数'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            valueSuffix: '分'
        },
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        series: [{
            name: $("#inp2").val(),
            data: [eval($("#inp6").val()),eval($("#inp7").val())]
        }, {
            name: $("#inp3").val(),
            data: [eval($("#inp8").val()),eval($("#inp9").val())]
        }, {
            name: $("#inp4").val(),
            data: [eval($("#inp10").val()),eval($("#inp11").val())]
        }, {
            name: $("#inp5").val(),
            data: [eval($("#inp12").val()),eval($("#inp13").val())]
        }]
    });
});
</script>
</body>
</html>