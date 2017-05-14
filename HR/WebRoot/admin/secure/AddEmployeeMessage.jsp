<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.neusoft.bean.EmpEntry"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>员工入职管理</title>
		<jsp:include page="../header.jsp"></jsp:include>
	</head>
	<body>
	<jsp:include page="../nav.jsp"></jsp:include>
	<div class="container" style="width:60%;margin:0,auto;position:relative;" >
	<form id="form1" name="form1"  onsubmit="return checkform();" method="post" action="servlet/empEntry">
	<label class="control-label" style="font-size:30px;margin:0,auto;position:relative;">员工入职管理</label>
		<input type="hidden" name="s" value="addEmp"  />
		<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							员工号
							<input type="text" name="eid" class="form-control" placeholder="员工号"/>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							姓名
							<input type="text" name="ename" class="form-control" placeholder="姓名"/>
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							性别
							<select name="sex" class="form-control" selected="selected">
								<option value="1">
									男
								</option>
								<option value="0">
									女
								</option>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 ">
						<div class="form-group">
							出生日期
							<input type="date" name="birthday" class="form-control" placeholder="出生日期" id="birthday"/>
						</div>
					</div>
					<div class="col-md-4 ">
						<div class="form-group">
							身份证号
							<input type="text" name="card" class="form-control" placeholder="身份证号"/>
						</div>
					</div>
					<div class="col-md-4 ">
						<div class="form-group">
							状态
							<select name="state" class="form-control" placeholder="状态">
							<option selected="selected" value="0">
									没有试用期
								</option>
								<option value="1">
									试用期
								</option >
								<option value="2">
									离职
								</option>
								<option value="3">
									转正
								</option>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							部门编号
						<input type="text" name="deptno" class="form-control" placeholder="部门编号"/>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							部门名称
						<input type="text" name="dname" class="form-control" placeholder="部门名称"/>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							岗位编号
						<input type="text" name="jobno" class="form-control" placeholder="岗位编号" />
						</div>
					</div> 
					<div class="col-md-3">
						<div class="form-group">
							岗位名称
						<input type="text" name="jname" class="form-control" placeholder="岗位名称" />
						</div>
					</div> 
				</div>
				<div class="row">
					<div class="col-md-6 ">
						<div class="form-group">
							参加工作日期
							<input type="date" name="workDay" class="form-control" placeholder="工作日期" id="workDay"/>
						</div>
					</div>
					<div class="col-md-6 ">
						<div class="form-group">
							用工形式
							<select name="empForm" class="form-control" placeholder="用工形式">
								<option selected="selected">
									正式员工
								</option>
								<option>
									临时员工
								</option>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3 ">
						<div class="form-group">
							人员来源
							<select name="personSource" class="form-control" placeholder="人员来源">
								<option selected="selected">
									校园招聘
								</option>
								<option>
									社会招聘
								</option>
								<option>
									其他
								</option>
							</select>
						</div>
					</div>
					<div class="col-md-3 ">
						<div class="form-group">
							政治面貌
							<select name="politicStatus" class="form-control" placeholder="政治面貌">
								<option selected="selected">
									党员
								</option>
								<option>
									预备党员
								</option>
								<option>
									团员
								</option>
								<option>
									其他
								</option>
							</select>
						</div>
					</div>
					<div class="col-md-3 ">
						<div class="form-group">
							民族
							<select name="nationalCity" id="national" class="form-control" placeholder="民族">
							</select>
						</div>
					</div>
					<div class="col-md-3 ">
						<div class="form-group">
							籍贯
							<input type="text" name="nativePlace" class="form-control" placeholder="籍贯"/>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 ">
						<div class="form-group">
							联系方式
							<input type="text" name="phone" class="form-control" placeholder="联系电话"/>
						</div>
					</div>
					<div class="col-md-6 ">
						<div class="form-group">
							电子邮件
							<input type="email" name="email" class="form-control" placeholder="电子邮件"/>
						</div>
				   </div>
			    </div>
			    <div class="row">
					<div class="col-md-4">
						<div class="form-group">
							身高
							<input type="text" name="height" class="form-control" placeholder="身高"/>
						</div>
					</div>
					<div class="col-md-4 ">
							<div class="form-group">
								血型
								<select name="bloodType" class="form-control">
									<option selected="selected">
										A
									</option>
									<option>
										B
									</option>
									<option>
										AB
									</option>
									<option>
										O
									</option>
									<option>
										其他
									</option>
								</select>
							</div>
						</div>
						<div class="col-md-4 ">
							<div class="form-group">
								婚姻状况
								<select name="marriage" class="form-control">
									<option selected="selected">
										未婚
									</option>
									<option>
										已婚
									</option>
									<option>
										丧偶
									</option>
									<option>
										离婚
									</option>
								</select>
							</div>
						</div>
				</div>
				<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								出生地
								<input type="text" name="birthPlace" class="form-control" placeholder="出生地"/>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								户口所在地
								<input type="text" name="residentPlace" class="form-control" />
							</div>
						</div>
				</div>
				<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								最高学历
								<select name="highestEducation" class="form-control">
									<option selected="selected">
										高中及以下
									</option>
									<option>
										大专
									</option>
									<option>
										本科
									</option>
									<option>
										研究生
									</option>
								</select>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								最高学位
								<select name="highestOffering" class="form-control">
									<option selected="selected">
										无学位
									</option>
									<option>
										学士
									</option>
									<option>
										双学士 
									</option>
									<option>
										硕士
									</option>
									<option>
										博士
									</option>
									<option>
										博士后
									</option>
								</select>
							</div>
						</div>
				</div>
				<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								毕业院校
								<input type="text" name="graduateSchool" class="form-control" placeholder="毕业院校"/>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								所学专业
								<input type="text" name="major" class="form-control" placeholder="所学专业"/>
							</div>
						</div>
				</div>
				<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								毕业日期
								<input type="date" name="graduateDay" class="form-control" placeholder="毕业日期"/>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								外语能力
								<select name="foreignLanguage" class="form-control">
									<option selected="selected">
										一般
									</option>
									<option>
										良好
									</option>
									<option>
										优秀 
									</option>
								</select>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								职业生涯
								<input type="text" name="career" class="form-control" placeholder="职业生涯"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								家庭关系
								<input type="text" name="familyRelationship" class="form-control" placeholder="家庭关系"/>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								社会关系
								<input type="text" name="socialRelationship" class="form-control" placeholder="社会关系"/>
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								登陆类型
								<input type="text" name="idStyle" class="form-control" placeholder="登陆类型"/>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								试用期
								<input type="date" name="formalDay" class="form-control" placeholder="试用期"/>
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								转正日期
								<input type="date" name="probationDay" class="form-control" placeholder="转正日期"/>
							</div>
						</div>
				</div>
					<div class="row">
						<div class="col-md-2 col-md-offset-3" >
							<div class="form-group">
								<button type="submit" class="btn btn-info btn-lg btn-block">保存</button>
							</div>
						</div>
						<div class="col-md-2 col-md-offset-1">
							<div class="form-group">
								<button type="submit" class="btn btn-default btn-lg btn-block">重置</button>
							</div>
						</div>
					</div>
		</form>
	</div>
			<script type="text/javascript">
		var national = [ "汉族", "壮族", "满族", "回族", "苗族", "维吾尔族", "土家族", "彝族", "蒙古族",
				"藏族", "布依族", "侗族", "瑶族", "朝鲜族", "白族", "哈尼族", "哈萨克族", "黎族", "傣族", "畲族",
				"傈僳族", "仡佬族", "东乡族", "高山族", "拉祜族", "水族", "佤族", "纳西族", "羌族", "土族",
				"仫佬族", "锡伯族", "柯尔克孜族", "达斡尔族", "景颇族", "毛南族", "撒拉族", "布朗族", "塔吉克族",
				"阿昌族", "普米族", "鄂温克族", "怒族", "京族", "基诺族", "德昂族", "保安族", "俄罗斯族", "裕固族",
				"乌孜别克族", "门巴族", "鄂伦春族", "独龙族", "塔塔尔族", "赫哲族", "珞巴族" ];
		window.onload = function() {
			var nat = document.getElementById("national");
			for ( var i = 0; i < national.length; i++) {
				var option = document.createElement('option');
				option.value = i;
				var txt = document.createTextNode(national[i]);
				option.appendChild(txt);
				nat.appendChild(option);
			}
		}
		   	function checkform() {
   		var birthday = Date.parse($("#birthday").val());
   		var workDay = Date.parse($("#workDay").val());
   		var today = new Date();
   		
   		if(!(birthDate < today && workDay< today)) {
   			alert("非法时间段");
   			return false;
   		}
   		return true;
   	}
		</script>
	   <jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
