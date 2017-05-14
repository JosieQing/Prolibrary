package com.neuedu.examonline.system.info;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TeacherInfoUpdateServlet
 */
@WebServlet("/TeacherInfoUpdateServlet")
public class TeacherInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherInfoUpdateServlet() {
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
		TeacherBean tb = new TeacherBean();
		String tremark = request.getParameter("tremark");
		String user_id = request.getParameter("user_id");
		String tno = tb.getTnoById(user_id);
		int servletid = Integer.valueOf(tno);
		String ttel = request.getParameter("ttel");
		TeacherObj to = new TeacherObj();
		to.setTremark(tremark);
		to.setTno(servletid);
		to.setTtel(ttel);
		PrintWriter out = response.getWriter();
		int result = tb.updateTeacher(to);
		if(result==1){
		out.print("{\"result\":\"1\"}");
		}
		if(result==2){
			out.print("{\"result\":\"2\"}");
			}
	}

}
