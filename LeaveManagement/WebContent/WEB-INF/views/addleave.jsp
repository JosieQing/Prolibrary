<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=emulateIE7" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/WdatePicker.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/skin_/form.css" />
<link href="<%=basePath%>umeditor/themes/default/_css/umeditor.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%=basePath%>js/jquery.js"></script>
<script type="text/javascript" src="<%=basePath%>js/global.js"></script>
<script type="text/javascript" src="<%=basePath%>js/jquery.select.js"></script>
<script type="text/javascript" src="<%=basePath%>js/WdatePicker.js"></script>
<script type="text/javascript">
window.UMEDITOR_HOME_URL = 'umeditor/';  // 请换成绝对路径
</script>
<script type="text/javascript" src="<%=basePath%>js/umeditor.config.js"></script>
<script type="text/javascript" src="<%=basePath%>js/editor_api.js"></script>
<script type="text/javascript" src="<%=basePath%>umeditor/lang/zh-cn/zh-cn.js"></script>
<title>添加请假单</title>
</head>

<body>
<div id="container">
	<div id="hd">
    </div>
    <div id="bd">
    <form id="addform" name="addform" action="add.action">
    	<div id="main">
            <h2 class="subfild">
            	<span>添加请假</span>
            </h2>
            <div class="subfild-content base-info">
            	<div class="kv-item ue-clear">
                	<label><span class="impInfo">*</span>填表日期</label>
                	<div class="kv-item-content">
                    	<input id="write_time" name="write_time" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="填表日期" autofocus />
                    </div>
                </div>
                <div class="kv-item ue-clear time">
                	<label><span class="impInfo">*</span>员工姓名</label>
                	<div class="kv-item-content">
                    	<input id="lname" name="lname" type="text" placeholder="员工姓名" style="width: 105px"  />
                    </div>
                    <label><span class="impInfo">*</span>职位</label>
                	<div class="kv-item-content">
                    	<input id="job" name="job" type="text" style="width: 105px" value="科员" readonly="readonly" style="color:blue"/>
                    </div>
                </div>
                
                 <div class="kv-item ue-clear time">
                	<label><span class="impInfo">*</span>开始时间</label>
                	<div class="kv-item-content">
                    	<input id="start_time" name="start_time" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="开始时间" style="width: 105px"  />
                        <i class="time-icon"></i>
                    </div>
                    <label><span class="impInfo">*</span>结束时间</label>
                	<div class="kv-item-content">
                    	<input id="end_time" name="end_time" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" placeholder="结束时间" style="width: 105px" />
                        <i class="time-icon"></i>
                    </div>
                </div>

					<div class="kv-item ue-clear">
						<label>请假类型:</label>
						<div class="kv-item-content">
							<select id="leave_type" name="leave_type">
								<option value="公假">公假</option>
								<option value="事假">事假</option>
								<option value="病假">病假</option>
								<option value="其他">其他</option>
							</select>
						</div>
					</div>
					
					<div class="kv-item ue-clear">
                		<label><span class="impInfo">*</span>审批状态</label>
                		<div class="kv-item-content">
                    		<input id="state" name="state" type="text" readonly="readonly" value="未审批" style="color:blue"/>
                    	</div>
                	</div>

            </div>
          </div>
            <h2 class="subfild">
            	<span>请假事由</span>
            </h2>
            
            <div class="subfild-content remarkes-info">
            	<div class="kv-item ue-clear">
                	<div class="kv-item-content">
                    	<textarea id="content" name="leave_reason" placeholder="请假事由" id="content" style="width:800px;height:280px;"></textarea>
                    </div>
                </div>
            
            	<div class="buttons">
                	<input class="button" type="button" value="返回" onclick="location='emplist'" />
                	<input class="button" type="submit" value="提交"  />
            	</div>
            </div>
            </form>
        </div>
    </div>
</body>


</html>