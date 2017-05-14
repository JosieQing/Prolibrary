<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="row">
<div class="col-md-1"></div>
<div class="col-md-8 col-md-offset-1 " align="center">
<nav class="navbar navbar-default" role="navigation">
  <div class="navbar-header col-md-4 col-md-offset-1" >
    <a class="navbar-brand" href="#" style="font-size:18px;">人力资源管理系统</a>
  </div>
  <div class="collapse navbar-collapse navbar-ex1-collapse col-md-2 col-md-offset-1">
    <ul class="nav navbar-nav">
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">组织结构管理<b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="<%=basePath %>admin/secure/AddDepartmentMessage.jsp" >添加部门</a></li>
          <li><a href="<%=basePath %>admin/secure/DepartmentManager.jsp">部门信息管理</a></li>
          <li class="divider"></li>
           <li><a href="<%=basePath %>admin/secure/AddJobMessage.jsp">添加岗位</a></li>
          <li><a href="<%=basePath %>admin/secure/JobManager.jsp">岗位信息管理</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">人事信息管理<b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="<%=basePath %>admin/secure/AddEmployeeMessage.jsp">员工入职管理</a></li>
          <li><a href="<%=basePath %>admin/secure/EmployeeManager.jsp">员工信息管理</a></li>
          <li class="divider"></li>
          <li><a href="<%=basePath %>admin/secure/probationMan.jsp">员工试用期管理</a></li>
          <li><a href="<%=basePath %>admin/secure/probationManSel.jsp">试用期信息查询</a></li>
          <li class="divider"></li>
          <li><a href="<%=basePath %>admin/secure/transferMan.jsp">员工调动管理</a></li>
          <li><a href="<%=basePath %>admin/secure/transferManSel.jsp">调动信息查询</a></li>
          <li class="divider"></li>
          <li><a href="<%=basePath %>admin/secure/employeeLeave.jsp">员工离职处理</a></li>
          <li><a href="<%=basePath %>admin/secure/employeeLeaveMessage.jsp">员工离职管理</a></li>
        </ul>
      </li>
       <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">薪酬管理<b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
          <li class="divider"></li>
          <li><a href="#"></a></li>
          <li><a href="#"></a></li>
        </ul>
      </li>
       <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">报表管理<b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="<%=basePath %>admin/secure/formMoveDept.jsp">部门调动报表</a></li>
          <li><a href="<%=basePath %>admin/secure/formMoveEmployee.jsp">员工调动报表</a></li>
          <li><a href="<%=basePath %>admin/secure/formNewEmployee.jsp">新聘员工报表</a></li>
          <li><a href="<%=basePath %>admin/secure/formResignMessage.jsp">员工离职报表</a></li>
        </ul>
      </li>
        <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">${sessionScope.username }<b class="caret"></b></a>
        <ul class="dropdown-menu">
             <li><a href="<%=basePath %>admin/secure/modify.jsp">个人信息管理</a></li>
          <li><a href="<%=basePath %>admin/login.jsp">注销</a></li>
        </ul>
      </li>
    </ul>
  </div>
</div>
</nav>
</div>

