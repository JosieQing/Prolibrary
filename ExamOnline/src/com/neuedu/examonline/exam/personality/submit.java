 package com.neuedu.examonline.exam.personality;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.examonline.exam.personality.*;

/**
 * Servlet implementation class submit
 */
@WebServlet("/submit")
public class submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public submit() {
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
		String servletStu_id=request.getParameter("stu_id");
		String servletZg_id=request.getParameter("exam_id");
		String servletScore=request.getParameter("score");
		String servletCurp=request.getParameter("curp");
		
		System.out.println(servletStu_id);
		System.out.println(servletZg_id);
		System.out.println(servletScore);

		
		
		panjuanObj po=new panjuanObj();
		po.setStu_id(servletStu_id);
		po.setZg_id(servletZg_id);
		po.setScore(servletScore);
		
		panjuanBean pb=new panjuanBean();
		pb.updateCj(po);
		
		HttpSession session = request.getSession();
		session.setAttribute("exam_id",servletZg_id );
		session.setAttribute("score",servletScore );
		session.setAttribute("stu_id",servletStu_id );
		
		response.sendRedirect("main.jsp?curp="+servletCurp);
		
		
		
		
	}

}
