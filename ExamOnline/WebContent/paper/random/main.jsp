<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../inc/head.jsp"%>


<%@ page import="java.sql.*"%>
<%@ page import="java.util.*" %>
<%@ page import="com.neuedu.examonline.paper.random.javabean.*" %>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="css/main.css" typr="text/css"> <!-- 引入css -->
</head>
<body>

<script>
$(document).ready(function(){

	
var arr1=new Array();var arr2=new Array();
var i=0;
var brr1=new Array();var brr2=new Array();
var j=0;
var k=0;
var l=0;

<%
suijibean sjb=new suijibean();
Map allxueke=new HashMap();
Map alltixing=new HashMap();
allxueke=sjb.allxueke();
alltixing=sjb.alltixing();
Set st1=allxueke.keySet();
Iterator<String> i1=st1.iterator();
while(i1.hasNext())
{
	String ss=i1.next();
	%>arr1[i]=<%="\""+ss+"\""%>;
	arr2[i]=<%="\""+allxueke.get(ss)+"\""%>;
	i++;<%
}
Set st2=alltixing.keySet();
Iterator<String> i2=st2.iterator();
while(i2.hasNext())
{
	String ss=i2.next();
	%>
	brr1[j]=<%="\""+ss+"\""%>;
	brr2[j]=<%="\""+alltixing.get(ss)+"\""%>;
	j++;<%
}
%>
var sss1=null;
for(var a=0;a<i;a++){sss1=sss1+"<option   value=\""+arr1[a]+"\">"+arr2[a]+"</option>";}
var sss2=null;
for(var b=0;b<j;b++){sss2=sss2+"<option  value=\""+brr1[b]+"\">"+brr2[b]+"</option>";}

var sss=null;
sss="<tr><td><select name=\"xueke\" >"+
sss1+"</select></td><td><select  name=\"tixing\">"+
sss2+"</select></td>"+
"<td>题数<input name=\"tishu\" class=\"shuzik\"   type=\"text\" value=\"0\"></td>"+
"<td>每题<input name=\"fenshu\" class=\"shuzik\"  type=\"text\" value=\"0\">分</td></tr>"



var crr1=new Array();
var crr2=new Array();
var drr1=new Array();
var drr2=new Array();

	$("#dabiao").append(sss);
	$("#jiahang").click(function(){ $("#dabiao").append(sss);});
	$("#jianhang").click(function(){$("#dabiao>tr:last").remove();});

	
	
	
	
	
	$("#wancheng").click(function(){
		
		
		$("[name='xueke']").each(function(){crr1.push($(this).val());});
		$("[name='tixing']").each(function(){crr2.push($(this).val());});
		$("[name='tishu']").each(function(){drr1.push($(this).val());});
		$("[name='fenshu']").each(function(){drr2.push($(this).val());});
		
		var cr1=crr1.join("-");
		var cr2=crr2.join("-");
		var dr1=drr1.join("-");
		var dr2=drr2.join("-");
		
		$.ajax({
				url:'../../chuanServlet',
				type:'POST',
				async:true,
			data:
			{
				shijuanming:$("#shijuanming").val(),
				xueke:cr1,
				tixing:cr2,
				tishu:dr1,
				fenshu:dr2
				
			},
			timeout:5000,
			dataType:'json',
			//traditional:true,
			success:function(data,textStatus,jqXHR)
			{
				
				if(data.result=="1"){alert("请填写试卷名");location="main.jsp";}
				if(data.result=="2"){alert("试题个数必须填写大于1的数字");location="main.jsp";}
				if(data.result=="3"){alert("分数必须填写大于1的数字");location="main.jsp";}
				if(data.result=="4"){alert("输入的问题个数不能大于已有的问题个数");location="main.jsp";}
				if(data.result=="5"){alert("题型和学科有重复，可以删掉一个");location="main.jsp";}
				if(data.result=="6"){alert("至少添加一个");location="main.jsp";}
				if(data.result=="10"){alert("添加成功");location="main.jsp";}
			},
		
			});
	});
})
</script>
<table class="table">
<tr><td>&nbsp;&nbsp;&nbsp;<input id="shijuanming" type="text" value="" ><span class="sjmc"><font size="5" >试卷名称</font></td></tr>
</table >
<table class="table" border="1" name="dabiao" id="dabiao">
</table>
<table><tr>
<td><input class="btn btn-primary" id="jiahang" type="button" value="增加别的学科和题型" ></td>
<td><input class="btn" id="jianhang" type="button" value="删除最后一行" ></td>
</tr></table>


	<input  class="btn btn-success" id="wancheng"  type="button" value="完成">
	
</body>
</html>

