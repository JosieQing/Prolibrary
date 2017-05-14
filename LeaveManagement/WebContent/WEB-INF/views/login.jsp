<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/skin_/login.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.select.js"></script>
<title>用户登录</title>
</head>

<body>
<div id="container">
    <div id="bd">
    	<div id="main">
        	<div class="login-box">
                <div id="logo"></div>
                <h1></h1>
         
                <div class="input username" id="username" style="left:160px;">
                    <label for="userName">用户名</label>
                    <span></span>
                    <input type="text" id="userName" name="userName" value="admin"/>
                </div>
                <div class="input psw" id="psw" style="left:160px;">
                    <label for="password">密&nbsp;&nbsp;&nbsp;&nbsp;码</label>
                    <span></span>
                    <input type="password" id="password" name="password" value="123"/>
                </div>
            
                <!-- 
                <div class="input validate" id="validate">
                    <label for="valiDate">验证码</label>
                    <input type="text" id="valiDate" />
                    <div class="value">X3D5</div>
                </div>
                 -->
               
                <div id="btn" class="loginButton" style="left:265px;">
                    <input type="button" class="button" value="登录" onclick="submit1()"/>
                </div>
        
            </div>
        </div>
        <div id="ft">CopyRight&nbsp;2017&nbsp;&nbsp;MC版权所有&nbsp;&nbsp;&nbsp;&nbsp;</div>
    </div>
   
</div>
</body>
<script type="text/javascript">
	//布局
	var height = $(window).height() > 445 ? $(window).height() : 445;
	$("#container").height(height);
	var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
	$('#bd').css('padding-top', bdheight);
	$(window).resize(function(e) {
        var height = $(window).height() > 445 ? $(window).height() : 445;
		$("#container").height(height);
		var bdheight = ($(window).height() - $('#bd').height()) / 2 - 20;
		$('#bd').css('padding-top', bdheight);
    });
	
	/*  function submit1(){
		var uname="";
		var passw="";
		uname=$("#userName").val();
		passw=$("#password").val();
		var register_uname=uname.match(/[^(A-Za-z0-9)]/g);
		var register_passw=passw.match(/[^(A-Za-z0-9)]/g);
		if(uname==""){
			alert("用户名不能为空");
		}
		else if(register_uname!=""){
			alert("用户名错误，请重新输入");
		}
		else if(passw==""){
			alert("用户名不能为空");
		}
		else if(register_passw!=""){
			alert("密码错误，请重新输入");
		} 
	
		document.form1.submit();
		
	}  */
	
	  $('.button').click(function(e) {

		 $.ajax({
			    url:'login.action',
			    type:'POST',//GET
			    async:true,//或false,是否异步
			    data:{
			    	loginName:$("#userName").val(),
			    	password:$("#password").val()
			    },
			    timeout:5000,    //超时时间
			    dataType:'text',    //返回的数据格式：json/xml/html/script/jsonp/text
			    success:function(data,textStatus,jqXHR){
				    //alert(data.result);
				    if(data=="0"){
				    	alert("用户名密码错误！");   	
				    }
				    if(data=="1"){
				    	location="main";//被拦截：/main
				    }

			    },
			    error:function(xhr,textStatus){
			   		 alert('错误');

			    }
			});


		}); 

</script>

</html>
