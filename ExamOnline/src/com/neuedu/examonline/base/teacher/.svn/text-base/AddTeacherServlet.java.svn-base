package com.neuedu.examonline.base.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddTeacherServlet
 */
@WebServlet("/AddTeacherServlet")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddTeacherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String tname = request.getParameter("tname");
		String tsex = request.getParameter("tsex");
		String tage = request.getParameter("tage");
		String ttel = request.getParameter("ttel");
		String hiredate = request.getParameter("hiredate");
		String tremark = request.getParameter("tremark");
		String tno = request.getParameter("tno");
		int i = 0;
		if (tno == null) {
			Teacher ter = new Teacher();
			ter.setTname(tname);
			ter.setTsex(tsex);
			ter.setTage(tage);
			ter.setTtel(ttel);
			ter.setHiredate(hiredate);
			ter.setTremark(tremark);
			i = DoDatabase.ins(ter);
		} else// 修改
		{
			Teacher ter = new Teacher();
			ter.setTno(tno);
			ter.setTname(tname);
			ter.setTsex(tsex);
			ter.setTage(tage);
			ter.setTtel(ttel);
			ter.setHiredate(hiredate);
			ter.setTremark(tremark);
			i = DoDatabase.upd(ter);
		}
		List<Teacher> list = DoDatabase.sel("");
		
		HttpSession session = request.getSession(); 
		session.setAttribute("tlist",list);

		

		out.print(i);
		out.flush();
		out.close();
	}

}
