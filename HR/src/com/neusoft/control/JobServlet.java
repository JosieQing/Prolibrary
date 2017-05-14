package com.neusoft.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.neusoft.bean.Job;
import com.neusoft.service.JobService;
import com.neusoft.service.impl.JobServiceImpl;

public class JobServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		String state  = request.getParameter("s");
		if(state.equals("addJob")){
			addJobMessage(request,response, out);
			}
		else if(state.equals("delete")){
			deleteJobMessage(request,response,out);
		}else if(state.equals("modify")){
			modifyJobMessage(request,response, out);
		}else if(state.equals("message")){
			getJobMessage(request,response);
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
	 * ��Ӹ�λ��Ϣ
	 */
	protected void addJobMessage(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
		throws ServletException, IOException {
		JobService js=new JobServiceImpl();
		Job job=new Job();
		job.setJobno(Integer.valueOf(request.getParameter("jobno")));
		job.setJname(request.getParameter("jname"));
		job.setJobStyle(request.getParameter("jobStyle"));
		job.setJobCompile(Integer.valueOf(request.getParameter("jobCompile")));
		job.setDeptno(Integer.valueOf(request.getParameter("deptno")));

		try {
			boolean isRight=js.addJobMessage(job);
			if(isRight==true){
//				getJobMessage(request,response);
				String alert="<script>alert('��ӳɹ���');</script>";
				out.println(alert);	
			}else{
				String alert="<script>alert('���ʧ�ܣ�');</script>";
				out.println(alert);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
		}
	/**
	 * ��ȡ��λ��Ϣ
	 */
	protected void getJobMessage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		JobService js=new JobServiceImpl();
		String jobno=request.getParameter("jobno");
		String deptno=request.getParameter("deptno");
		String jname=request.getParameter("jname");
		try {
			List<Job> list=js.getJobMessage(jobno, deptno,jname);
			HttpSession session=request.getSession();
			session.setAttribute("list", list);
			request.getRequestDispatcher("/admin/secure/JobManager.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * ɾ����λ��Ϣ
	 */
	protected void deleteJobMessage(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
			throws ServletException, IOException{
				Integer jobno=Integer.valueOf(request.getParameter("jobno"));
				JobService js=new JobServiceImpl();
				boolean isRight;
				try {
					isRight = js.deleteJobMessage(jobno);
					if(isRight==true){
						getJobMessage(request,response);	
						String alert="<script>alert('ɾ���ɹ���');</script>";
						out.println(alert);	
					}else{
						String alert="<script>alert('ɾ��ʧ�ܣ�');</script>";
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
	 * �޸ĸ�λ��Ϣ
	 */
	protected void modifyJobMessage(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
			throws ServletException, IOException{
		Job job=new Job();
		Integer jobno = Integer.valueOf(request.getParameter("jobno"));
		job.setJobno(jobno);
		job.setJname(request.getParameter("jname"));
		job.setJobStyle(request.getParameter("jobStyle"));
		job.setJobCompile(Integer.valueOf(request.getParameter("jobCompile")));
		job.setDeptno(Integer.valueOf(request.getParameter("deptno")));
		JobService js=new JobServiceImpl();
		boolean isRight=false; 
		try {
			isRight=js.modifyJobMessage(job);
			if(isRight==true){
				String alert="<script>alert('�޸ĳɹ���');</script>";
				out.println(alert);						
				getJobMessage(request,response);		
			}else{
				String alert2="<script>alert('�޸�ʧ�ܣ�');</script>";
				out.println(alert2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}		
	}			
}
