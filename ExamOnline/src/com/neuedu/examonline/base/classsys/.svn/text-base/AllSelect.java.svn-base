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
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/AllSelect")
public class AllSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllSelect() {
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
		//PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		if(name==null)
		{
			name="";
		}

		List<Class_control> list = select.sel(name);
		
		HttpSession session = request.getSession(); 
		session.setAttribute("clist",list);

		response.sendRedirect("base/classsys/class_sys.jsp");
		
	}

}
