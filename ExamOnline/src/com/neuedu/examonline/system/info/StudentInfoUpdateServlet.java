package com.neuedu.examonline.system.info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentInfoUpdateServlet
 */
@WebServlet("/StudentInfoUpdateServlet")
public class StudentInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInfoUpdateServlet() {
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
		StudentBean sb = new StudentBean();
		String id = request.getParameter("user_id");
		String num = sb.getNumById(id);
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String banji = request.getParameter("banji");
		StudentObj so = new StudentObj();
		so.setName(name);
		so.setAge(age);
		so.setSex(sex);
		so.setBanji(banji);
		so.setNum(num);
		PrintWriter out = response.getWriter();
		int result = sb.updateStudent(so);
		if(result==1){
		out.print("{\"result\":\"1\"}");
		}
		if(result==2){
			out.print("{\"result\":\"2\"}");
			}
	}

}
