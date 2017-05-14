package com.neuedu.examonline.system.info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfoActionServlet
 */
@WebServlet("/UserInfoActionServlet")
public class UserInfoActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("user_id");
		PrintWriter out = response.getWriter();
		UserBean ub = new UserBean();
		String s = ub.getRoleById(user_id);
		System.out.println("s"+s);
		if(s.equals("教师")){
			
			out.print("{\"result\":\"2\"}");
			
		}
		if(s.equals("学生")){
			out.print("{\"result\":\"1\"}");
			System.out.println("2222");
		}
		
		
		
	}

}
