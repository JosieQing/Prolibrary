package com.neuedu.examonline.paper.select;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class makeServlet
 */
@WebServlet("/makeServlet")
public class makeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public makeServlet() {
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
		Tool to=new Tool();
		HttpSession session=request.getSession();
		//填写的要操作卷号
		String paperselect=null;
		paperselect=request.getParameter("paperselect");
		//试卷名
		String papername=null;
		papername=request.getParameter("papername");
		//设置的初始值
		if(papername==null)
		{
			papername="试卷"+paperselect;
		}
		if(papername=="")
		{
			papername="试卷"+paperselect;
		}		
		String papershow=null;
		papershow=request.getParameter("papershow");
		if(papershow.equals(paperselect))
		{
			to.makepaper( paperselect, papername);//试卷id和试卷名
			session.setAttribute("papername", papername);
		}else
		{
			papername=to.getpapername(paperselect);
			session.setAttribute("papername", papername);
		}		
		session.setAttribute("paperselect", paperselect);
		response.sendRedirect("newbuild.jsp");		
	}

}
