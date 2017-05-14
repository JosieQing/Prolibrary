package com.neusoft.control;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neusoft.bean.Department;
import com.neusoft.service.DepartmentService;
import com.neusoft.service.impl.DepartmentServiceImpl;
public class DepartmentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String state  = request.getParameter("s");		
		if(state.equals("addDept")){
			addDepartmentMessage(request,response, out);
			}
		else if(state.equals("delete")){
			deleteDepartmentMessage(request,response,out);
		}else if(state.equals("modify")){
			modifyDepartmentMessage(request,response, out);
		}else if(state.equals("message")){
			getDepartmentMessage(request,response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}
	/**
	 * 添加部门信息
	 */
	protected void addDepartmentMessage(HttpServletRequest request, HttpServletResponse response,PrintWriter out )
			throws ServletException, IOException{
		DepartmentService ds=new DepartmentServiceImpl();
		Department dept=new Department();
		dept.setDeptno(Integer.valueOf(request.getParameter("deptno")));
		dept.setDname(request.getParameter("dname"));
		dept.setDtype(request.getParameter("type"));
		dept.setPhone(request.getParameter("phone"));
		dept.setFax(request.getParameter("fax"));
		dept.setSuperDept(request.getParameter("superDept"));
		dept.setDescribe(request.getParameter("describe"));
		String startDay = request.getParameter("startDay");// 得到字符串形式的时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date ustime;
		try {
			ustime = format.parse(startDay);
			java.sql.Date stime = new java.sql.Date(ustime.getTime());
			dept.setStartDay(stime);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			boolean isRight=ds.addDeptMessage(dept);
			if(isRight==true){
 
				String alert="<script>alert('添加成功！');</script>";
				out.println(alert);	
			}else{
				String alert="<script>alert('添加失败！');</script>";
				out.println(alert);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 获取所有部门信息
	 */
	protected void getDepartmentMessage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		DepartmentService ds=new DepartmentServiceImpl();
		String deptno=request.getParameter("deptno");
		try {
			List<Department> list=ds.getDeptMessage(deptno);
			HttpSession session=request.getSession();
			session.setAttribute("list",list);
			request.getRequestDispatcher("/admin/secure/DepartmentManager.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
//	/**
//	 * 根据ID查询部门信息
//	 */
//	protected void getDepartmentMessageByDeptno(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
//	throws ServletException, IOException{
//		DepartmentService ds=new DepartmentServiceImpl();
//		Integer deptno = Integer.valueOf(request.getParameter("deptno"));
//		Department dept=new Department();
//		try {
//			dept=ds.getDeptMessageById(deptno);
//			List<Department> l=new ArrayList<Department>();
//			l.add(dept);//将一个对象加到集合中
//			HttpSession session=request.getSession();
//			session.setAttribute("list",l);
//			if(dept!=null){
//				request.getRequestDispatcher("/admin/secure/DepartmentManager.jsp").forward(request, response);
//			}
//			else{
//				String alert="<script>alert('没有这个部门！');</script>";
//				out.println(alert);	
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//
//	}
	/**
	 * 删除部门信息
	 */
	protected void deleteDepartmentMessage(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
	throws ServletException, IOException{
		Integer deptno=Integer.valueOf(request.getParameter("deptno"));
		DepartmentService ds=new DepartmentServiceImpl();
		boolean isRight;
		try {
			isRight = ds.deleteDeptMessage(deptno);
			if(isRight==true){
				getDepartmentMessage(request,response);	
				String alert="<script>alert('删除成功！');</script>";
				out.println(alert);	
			}else{
				String alert="<script>alert('删除失败！');</script>";
				out.println(alert);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	/**
	 * 修改部门信息
	 */
	protected void modifyDepartmentMessage(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
	throws ServletException, IOException{
		Department dept=new Department();
		Integer deptno = Integer.valueOf(request.getParameter("deptno"));
		dept.setDeptno(deptno);	
		dept.setDname(request.getParameter("dname"));
		dept.setDtype(request.getParameter("type"));
		dept.setPhone(request.getParameter("phone"));
		dept.setFax(request.getParameter("fax"));
		dept.setDescribe(request.getParameter("describe"));
		dept.setSuperDept(request.getParameter("superDept"));
		String startDay = request.getParameter("startDay");// 得到字符串形式的时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date ustime;
		try {
			ustime = format.parse(startDay);
			java.sql.Date stime = new java.sql.Date(ustime.getTime());
			dept.setStartDay(stime);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DepartmentService ds=new DepartmentServiceImpl();
		boolean isRight=false;
		try {
			isRight=ds.modifyDeptMessage(dept);
			if(isRight==true){	
				String alert="<script>alert('修改成功！');</script>";
				out.println(alert);						
				getDepartmentMessage(request,response);		
				//怎么让修改后返回的是一行？
			}else{
				String alert2="<script>alert('修改失败！');</script>";
				out.println(alert2);						
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}
	}
	
}
