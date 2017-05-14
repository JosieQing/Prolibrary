<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.lang.*" %>
<%@ page import="com.neuedu.examonline.report.predict.*" %>
<%@ include file="../../../inc/theme.jsp" %>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="../../../hui/lib/html5shiv.js"></script>
<script type="text/javascript" src="../../../hui/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="../../../hui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="../../../hui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="../../../hui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="../../../hui/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="../../../hui/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="../../../hui/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>折线图</title>
</head>
<body>
<div class="page-container">
	<div id="container" style="min-width:700px;height:400px"></div>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="../../../hui/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="../../../hui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="../../../hui/static/h-ui/js/H-ui.min.js"></script> 
<script type="text/javascript" src="../../../hui/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="../../../hui/lib/hcharts/Highcharts/5.0.6/js/highcharts.js"></script>
<script type="text/javascript" src="../../../hui/lib/hcharts/Highcharts/5.0.6/js/modules/exporting.js"></script>
<script src="mancx.js"></script>
<script type="text/javascript">
<%
double[] sss=new double[100];
try{
for(int i=0;i<100;i++){
	if(request.getParameter("ss"+i)==""){
		
	}else
	{
	sss[i]=Double.parseDouble(request.getParameter("ss"+i));
	}
}
}
catch (Exception e) {
	e.printStackTrace();
}
int j=0;
for(j=0;j<100;j++){
	if(sss[j]==0){
		
		break;
	}
}
double[] brr=new double[j];
for(int i=0;i<j;i++){
	brr[i]=sss[i];
}
String cate="'1'";
for(int i=2;i<=j;i++){
	cate=cate+",'"+i+"'";
}
cate=cate+",'预测成绩'";
String date=""+brr[0];
for(int i=1;i<brr.length;i++){
	date=date+","+brr[i];
}
predict p1=new predict();
double[] crr=p1.sanx(brr);
String date2=""+crr[0];
for(int i=1;i<crr.length;i++){
	date2=date2+","+crr[i];
}
String id=request.getParameter("id111");

%>
$(function () {
	
	
     Highcharts.chart('container', {
        title: {
            text: '学号<%=id%>成绩预测表',
            x: -20 //center
        },

        xAxis: {
            categories: [<%=cate %>]
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
            name: '学号<%=id%>',
            data: [<%=date %>]
        },{
            name: '学号<%=id%>预测',
            data: [<%=date2 %>]
        }]
    });
});
</script>
</body>
</html>