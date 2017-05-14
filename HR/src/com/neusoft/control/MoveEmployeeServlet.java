package com.neusoft.control;

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

import com.neusoft.mapping.MappingFactory;
import com.neusoft.service.formService;
import com.neusoft.service.impl.formServiceImpl;
import com.neusoft.util.Pagination;

public class MoveEmployeeServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	private int pageSize;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext context=config.getServletContext();
		pageSize=Integer.parseInt(context.getInitParameter("pageSize"));
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		PrintWriter out=response.getWriter();
		String fun=request.getParameter("fun");
		if(fun.equals("employee")){
			getFormMoveEmployee(request, response, out);
		}out.close();
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		PrintWriter out=response.getWriter();
		String fun=request.getParameter("fun");
		if(fun.equals("employee")){
			getFormMoveEmployee(request, response, out);
		}out.close();
	}
	
	//获取岗位调动报表
	protected void getFormMoveEmployee(HttpServletRequest request, HttpServletResponse response,PrintWriter out)
	throws ServletException, IOException {
		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		
		formService service= new formServiceImpl();
		int pageNumber;
		String paramName=new ParamEncoder("formemployee").encodeParameterName(TableTagParameters.PARAMETER_PAGE);
		try{
			pageNumber=Integer.parseInt(request.getParameter(paramName));
		}catch(Exception e){
			pageNumber=1;
		}
		String startdate=request.getParameter("startdate");
		String endDate=request.getParameter("endDate");
		Pagination page=service.getFormMoveEemployee(startdate, endDate, pageSize, pageNumber);
		MappingFactory mapping=MappingFactory.getMappingFactory();
		HttpSession session= request.getSession();
		session.setAttribute("list", page.getList(mapping.getMapping(MappingFactory.MoveEmployee_Mapping)));
		session.setAttribute("total", page.getMaxElements());
		request.getRequestDispatcher("/admin/secure/MoveEmployee.jsp").forward(request,response);
	}
}
