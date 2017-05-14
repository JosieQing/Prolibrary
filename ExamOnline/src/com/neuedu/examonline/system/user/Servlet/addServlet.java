package com.neuedu.examonline.system.user.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addServlet
 */
@WebServlet("/addServlet")
public class addServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddBean ab = new AddBean();
		String add_login = request.getParameter("add_login");
		String add_pass = request.getParameter("add_pass");
		String add_select = request.getParameter("add_select");
		String add_role = request.getParameter("add_role");
		String add_remark = request.getParameter("add_remark");
		HttpSession session = request.getSession();
		String number = (String)session.getAttribute("number");
		String result = ab.addbean(add_login,add_pass,add_select,add_role,add_remark,number);
		
		if(result.equals("2")){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("{\"result\":\"2\"}");
			out.close();
		}
		if(result.equals("1")){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("{\"result\":\"1\"}");
			out.close();
		}
		if(result.equals("0")){
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("{\"result\":\"0\"}");
		out.close();
		}
		// TODO Auto-generated method stub
	}

}
