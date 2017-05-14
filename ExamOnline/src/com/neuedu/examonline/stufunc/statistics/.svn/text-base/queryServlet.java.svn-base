package com.neuedu.examonline.stufunc.statistics;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/queryServlet")
public class queryServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public queryServlet()
	{
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		session.setAttribute("student_id","1");
		response.sendRedirect("stufunc/statistics/queryScore.jsp");
	
	}
	
	

}
