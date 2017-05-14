package com.neusoft.control;

import com.neusoft.mapping.MappingFactory;
import com.neusoft.service.*;
import com.neusoft.service.impl.formServiceImpl;
import com.neusoft.util.Pagination;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

public class formNewServlet extends HttpServlet{
	
	private int pageSize;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext page=config.getServletContext();
		pageSize=Integer.parseInt(page.getInitParameter("pageSize"));
	}

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		PrintWriter out=response.getWriter();
		String fun=request.getParameter("fun");
		if(fun.equals("new")){
			getFormNewEmployee(request, response, out);
		}out.close();
	}
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		PrintWriter out=response.getWriter();
		String fun=request.getParameter("fun");
		if(fun.equals("new")){
			getFormNewEmployee(request, response, out);
		}out.close();
	
	}
	
	
	//获取新聘员工所有信息报表
	protected void getFormNewEmployee(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		formService service=new formServiceImpl();
		int pageNumber=0;
		String paramName=new ParamEncoder("formnew").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
		try{
			pageNumber=Integer.parseInt(request.getParameter(paramName));
		}catch(Exception e){
			//如果没有获取到当前页码那么将当前页码设置为1
			pageNumber=1;
		}
		//页面上获取String——Dao层转为to_Date
		String dname=request.getParameter("dname");
		String workDay=request.getParameter("workDay");
		String formalDay=request.getParameter("formalDay");
		Pagination page=service.getFormNewEmployee(dname, workDay, formalDay, pageSize, pageNumber);
		//创建工厂类
		MappingFactory mapping=MappingFactory.getMappingFactory();
		
		HttpSession session=request.getSession();
		session.setAttribute("list", page.getList(mapping.getMapping(MappingFactory.FormNewEmployee_Mapping)));
		session.setAttribute("total", page.getMaxElements());
		request.getRequestDispatcher("/admin/secure/NewEmployee.jsp").forward(request, response);

	}
		
}
