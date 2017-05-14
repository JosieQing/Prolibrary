<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.neuedu.examonline.report.chart.*" %>
<%@page import="java.util.*"%>
<!DOCTYPE HTML>
<html>
<head>
</head>
<body>
<%
List abb=(List)session.getAttribute("lii1");
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
   	 <input id="inp<%=i %>" type="hidden" value="<%=String.valueOf(it1.next())%>">
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
	//var ss0=$("#inp0").val();
	//var ss01=eval(ss0);
	//var ss1=$("#inp1").val();
	//var ss11=eval(ss1);
	//var ss2=$("#inp2").val();
	//var ss21=eval(ss2);
	//var ss3=$("#inp3").val();
	//var ss31=eval(ss3);
	//var ss4=$("#inp4").val();
	//var ss41=eval(ss4);
	//var ss5=$("#inp5").val();
	//var ss51=eval(ss5);
	//var ss6=$("#inp6").val();
	//var ss61=eval(ss6);
	//var ss7=$("#inp7").val();
	//var ss71=eval(ss7);
	//var ss8=$("#inp8").val();
	//var ss81=eval(ss8);
	//var ss9=$("#inp9").val();
	//var ss91=eval(ss9);
//	var ss1=eval($("#inp1").val());
//	var ss2=eval($("#inp2").val());
//  var ss3=eval($("#inp3").val());
//	var ss4=eval($("#inp4").val());
//	var ss5=eval($("#inp5").val());
//	var ss6=eval($("#inp6").val());
//	var ss7=eval($("#inp7").val());
//	var ss8=eval($("#inp8").val());
//	var ss9=eval($("#inp9").val());
    $('#container').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: '考试成绩'
        },
        subtitle: {
            text: '柱形图'
        },
        xAxis: {
            categories: [$("#inp0").val(),$("#inp1").val(),$("#inp2").val(),$("#inp3").val(),$("#inp4").val(),$("#inp5").val(),$("#inp6").val(),$("#inp7").val(),]
        },
        yAxis: {
            min: 0,
            title: {
                text: '分数'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} 分</b></td></tr>',
            footerFormat: '</table>',
            shared: false,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.1,
                borderWidth: 0
            }
        },
        series: [{
            name: $("#inp40").val(),
            data: [eval($("#inp8").val()),eval($("#inp12").val()),eval($("#inp16").val()),eval($("#inp20").val()),eval($("#inp24").val()),eval($("#inp28").val()),eval($("#inp32").val()),eval($("#inp36").val())]

        }, {
            name: $("#inp41").val(),
            data: [eval($("#inp9").val()),eval($("#inp13").val()),eval($("#inp17").val()),eval($("#inp21").val()),eval($("#inp25").val()),eval($("#inp29").val()),eval($("#inp33").val()),eval($("#inp37").val())]

        }, {
            name: $("#inp42").val(),
            data: [eval($("#inp10").val()),eval($("#inp14").val()),eval($("#inp18").val()),eval($("#inp22").val()),eval($("#inp26").val()),eval($("#inp30").val()),eval($("#inp34").val()),eval($("#inp38").val())]

        }, {
            name: $("#inp43").val(),
            data: [eval($("#inp11").val()),eval($("#inp15").val()),eval($("#inp19").val()),eval($("#inp23").val()),eval($("#inp27").val()),eval($("#inp31").val()),eval($("#inp35").val()),eval($("#inp39").val())]

        }]
    });
});				
</script>
</body>
</html>