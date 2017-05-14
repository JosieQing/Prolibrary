package com.neuedu.examonline.base.classsys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.neuedu.examonline.base.classsys.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddTeacherServlet
 */
@WebServlet("/AddClass")
public class AddClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String cname = request.getParameter("cname");
		String speciality = request.getParameter("speciality");	
		String classnum = request.getParameter("classnum");
		String pnum = request.getParameter("pnum");
		String mentor = request.getParameter("mentor");
		String teacher = request.getParameter("teacher");
		String start_date = request.getParameter("start_date");
		String cno = request.getParameter("cno");
		int i=0;
		if(cno==null)
		{
		Class_control cc = new Class_control();
		cc.setCname(cname);
		cc.setSpeciality(speciality);
		cc.setClassnum(classnum);
		cc.setPnum(pnum);
		cc.setMentor(mentor);
		cc.setTeacher(teacher);
		cc.setStart_date(start_date);
		i = add.addc(cc);
		}else//修改
		{
			Class_control cc = new Class_control();
			cc.setCno(cno);
			cc.setCname(cname);		
			cc.setSpeciality(speciality);
			cc.setClassnum(classnum);
			cc.setPnum(pnum);
			cc.setMentor(mentor);
			cc.setTeacher(teacher);
			cc.setStart_date(start_date);
			i =update.updatec(cc);	
		}
		List<Class_control> list = select.sel("");
		
		HttpSession session = request.getSession(); 
		session.setAttribute("clist",list);

		
		out.print(i);
		out.flush();
		out.close();
	}

}
