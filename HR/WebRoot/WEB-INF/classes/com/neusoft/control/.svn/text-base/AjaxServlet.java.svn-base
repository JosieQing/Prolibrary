package com.neusoft.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.neusoft.bean.Department;
import com.neusoft.bean.Job;
import com.neusoft.service.AjaxService;
import com.neusoft.service.EmpEntryService;
import com.neusoft.service.impl.AjaxServiceImpl;


public class AjaxServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 4L;
	private int pageSize = 0;
	private ServletConfig config;

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");

		String statu = request.getParameter("s");
		if (statu.equals("ename")) {
			
			getEnameByEid(request, response, out);
		} else if (statu.equals("dep")) {
			
			getAllDname(request, response, out);
		}else if (statu.equals("job")) {
			
			getJobMessageById(request, response,out);
		}else if (statu.equals("getjname")) {
			
			getJnameByJobno(request, response,out);

		}else if (statu.equals("getName")) {		

			getNameByDeptno(request, response,out);
		}else if (statu.equals("pmid")) {
			
			getPmIdByEid(request, response,out);
		}else if(statu.equals("dname")){
			
 			getDname(request, response, out);
		}else if(statu.equals("jname")){
			
			getJname(request, response, out);
		}


	}
	
	/**
	 * 根据EID得到ENAME
	 * @param request
	 * @param response
	 * @param out
	 */
	public void getEnameByEid(HttpServletRequest request,
			HttpServletResponse response,PrintWriter out){
		
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("expire", 0);
		
		// 获取数据
		String eid1 = request.getParameter("eid");

		Integer eid = Integer.valueOf(eid1);
		
		AjaxService as = new AjaxServiceImpl();
		String ename = as.getEnameByEid(eid);
		if(!ename.equals("") && ename != null){
			out.print(ename);
		}else{
			out.print("0");
		}
		out.flush();
		out.close();
	}
	
	/**
	 * 根据EID得到PMID
	 * @param eid
	 * @return
	 */
	public void getPmIdByEid(HttpServletRequest request,
			HttpServletResponse response,PrintWriter out){
		
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("expire", 0);
		
		String eid1 = request.getParameter("eid");
		Integer eid = Integer.parseInt(eid1);
		AjaxService as = new AjaxServiceImpl();
		Integer pmid = as.getPmIdByEid(eid);
		if(pmid != null){
			out.print(pmid);
		}else{
			out.print("0");
		}
		out.flush();
		out.close();
		
	}
	
	
	/**
	 * 
	 */
//	public void doCheck(HttpServletRequest request,
//			HttpServletResponse response,PrintWriter out){
//		
//		response.setHeader("Pragma", "No-cache");
//		response.setHeader("Cache-Control", "No-cache");
//		response.setDateHeader("expire", 0);
//		
//		// 获取数据
//		String eid1 = request.getParameter("eid");
//
//		Integer eid = Integer.valueOf(eid1);
//		EmpEntryService ees
//		AjaxService as = new AjaxServiceImpl();
//		EmpEntry ee = as.;
//		if(!ename.equals("") && ename != null){
//			out.print(ename);
//		}else{
//			out.print("0");
//		}
//		out.flush();
//		out.close();
//	}
	
	
	/**
	 * 根据eid获取DNAME
	 * @param request
	 * @param response
	 * @param out
	 */
	public void getDname(HttpServletRequest request,
			HttpServletResponse response,PrintWriter out){
		
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("expire", 0);
		
		String eid1 = request.getParameter("eid");
		Integer eid = Integer.parseInt(eid1);
		AjaxService as = new AjaxServiceImpl();
		String dname = as.getDnameByEid(eid);
		if(dname != null && !dname.equals("")){
			out.print(dname);
		}else{
			out.print("0");
		}
		out.flush();
		out.close();
	}
	/**
	 * 根据eid获取JNAME
	 * @param request
	 * @param response
	 * @param out
	 */
	public void getJname(HttpServletRequest request,
			HttpServletResponse response,PrintWriter out){
		
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "No-cache");
		response.setDateHeader("expire", 0);
		
		String eid1 = request.getParameter("eid");
		Integer eid = Integer.parseInt(eid1);
		AjaxService as = new AjaxServiceImpl();
		String jname = as.getJnameByEid(eid);
		if(jname != null && !jname.equals("")){
			out.print(jname);
		}else{
			out.print("0");
		}
		out.flush();
		out.close();
	}
	
	
	/**
	 * 根据JOBNO获取JOBNAME
	 */
	public void getJnameByJobno(HttpServletRequest request,
			HttpServletResponse response,PrintWriter out){
		String jobno1=request.getParameter("jobno");
		Integer jobno=Integer.valueOf(jobno1);
		AjaxService as = new AjaxServiceImpl();
		try {
			String jname=as.getJobNameByJobno(jobno);
			if(!jname.equals("")){
				out.print(jname);
			}else{
				request.setAttribute("q","岗位不存在！");
				try {
					request.getRequestDispatcher("/admin/secure/JobManager.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 根据DEPTNO获取dname
	 */
	public void getNameByDeptno(HttpServletRequest request,
			HttpServletResponse response,PrintWriter out){
		String deptno=request.getParameter("deptno");
		AjaxService as = new AjaxServiceImpl();
		try {
			String dname=as.getDnameByDeptno(deptno);
			String superDept=as.getSuperDnameByDeptno(deptno);
			if(!dname.equals("")&&!superDept.equals("")){
				out.print(dname+","+superDept);

			}else{
				request.setAttribute("q","部门不存在！");
				try {
					request.getRequestDispatcher("/admin/secure/DepartmentManager.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	/**
	 * 根据DEPTNO获取superDept
	 */
	public void getSuperDeptByDeptno(HttpServletRequest request,
			HttpServletResponse response,PrintWriter out){
		String deptno=request.getParameter("deptno");
		AjaxService as = new AjaxServiceImpl();
		try {
			String superDept=as.getSuperDnameByDeptno(deptno);
			if(!superDept.equals("")){
				out.print(superDept);
			}else{
				request.setAttribute("q","部门不存在！");
				try {
					request.getRequestDispatcher("/admin/secure/DepartmentManager.jsp").forward(request, response);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
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
	 * 获取所有部门名称
	 * @param request
	 * @param response
	 * @param out
	 */
	public void getAllDname(HttpServletRequest request,
			HttpServletResponse response,PrintWriter out){
		
		response.setContentType("text/html;charset=utf-8");
		
		AjaxService service = new AjaxServiceImpl();
		
		List<Department> l = service.getDeptMessage();
		StringBuilder s = new StringBuilder();
		s.append("<option value=\"0\" selected=\"selected\">不限</option>");
		for(Object o : l) {
			Department d = (Department)o;
			s.append("<option value=\"");
			s.append(d.getDeptno());
			s.append("\">");
			s.append(d.getDname());
			s.append("</option>");
			
		}
		out.flush();
		out.print(s);
	}
	
	/**
	 * 根据dname得到jname
	 * @param request
	 * @param response
	 * @param out
	 */
	public void getJobMessageById(HttpServletRequest request,
			HttpServletResponse response,PrintWriter out){
		
		String dname = request.getParameter("depId");
		response.setContentType("text/html;charset=utf-8");
		AjaxService service = new AjaxServiceImpl();
		List<Job> l;
		try {
			l = service.getJobMessageById(dname);
			
			StringBuilder s = new StringBuilder();
			for(Object o : l) {
				Job p = (Job)o;
				s.append("<option value=\"");
				s.append(p.getJobno());
				s.append("\">");
				s.append(p.getJname());
				s.append("</option>");
			}
			out.print(s);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}
	
	/**
	 * 根据STATE查询
	 * @param request
	 * @param response
	 * @param out
	 */
	public void getAllConnecteMessageByState(HttpServletRequest request,
			HttpServletResponse response,PrintWriter out){
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		ServletContext servletContext = config.getServletContext();
		pageSize = Integer.parseInt(servletContext.getInitParameter("pageSize"));
		
	}
	
}
