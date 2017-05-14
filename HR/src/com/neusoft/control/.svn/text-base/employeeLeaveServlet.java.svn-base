package com.neusoft.control;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.service.EmployeeLeaveService;
import com.neusoft.service.impl.EmployeeLeaveServiceImpl;

public class employeeLeaveServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
			PrintWriter out=response.getWriter();
			String fun=request.getParameter("fun");
			if(fun.equals("resign")){
				
			}out.close();
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		PrintWriter out=response.getWriter();
		String fun=request.getParameter("fun");
		if(fun.equals("resign")){
			getResignById(request, response, out);
		}out.close();
		
	}
	
	protected void getResignById(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		EmployeeLeaveService service=new EmployeeLeaveServiceImpl();
		
		Integer eid=Integer.valueOf(request.getParameter("eid"));
		String ename=request.getParameter("ename");
		String todate=request.getParameter("todate");
		String totype=request.getParameter("totype");
		String reason=request.getParameter("reason");
		
		//LoginServlet(jsp表不显示)
		//operator登录管理员
		//离职事由：<input type="submit" name="submit1" value="提交">
		HttpSession session= request.getSession();
		String operator=(String) session.getAttribute("username");
		boolean b=service.getResignById(eid, todate, totype, reason, operator, ename);
		String flashMessage = "";
		if (b) {
			flashMessage = "离职成功!";
		}
		else {
			flashMessage = "离职失败!" ;
		}
		out.print(flashMessage);
		request.getRequestDispatcher("/admin/secure/employeeLeaveMessage.jsp").forward(request, response);
	}


}
